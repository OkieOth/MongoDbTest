package de.oth.mongodbtest.mongodb

import com.mongodb.BasicDBObject
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import de.oth.mongodbtest.model.beans.Comment
import de.oth.mongodbtest.model.beans.Document
import de.oth.mongodbtest.model.beans.Document_type
import de.oth.mongodbtest.serialization.SerializationException
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import de.oth.mongodbtest.model.beans.Tag

import static com.mongodb.client.model.Filters.exists
import static junit.framework.Assert.assertTrue
import static junit.framework.TestCase.assertEquals
import static junit.framework.TestCase.assertFalse
import static junit.framework.TestCase.assertNotNull
import static junit.framework.TestCase.assertNull

class Test_MongoCon {
    private static dockerStarted=false;

    private static String executeCommand(List<String> cmd) {
        def sout = new StringBuilder(), serr = new StringBuilder()
        def proc = cmd.execute()
        proc.consumeProcessOutput(sout, serr)
        proc.waitForOrKill(10000)
        if (serr.size()>0) {
            println "err> $serr"
        }
        return sout.toString()
    }

    @BeforeClass
    public static void beforeClass() {
        println("Looking for local mongo")
        // curl http://localhost:27017
        //
        def existingResponse='It looks like you are trying'
        def command = ['curl','http://localhost:27017']
        def retStr = executeCommand(command)
        if (retStr.startsWith(existingResponse)) {
            println 'mongo-db already up'
        }
        else {
            // check existing directory for mounted volume.
            // if the volume isn't present, then mongodb doesn't open the network port!
            def v = new File('data')
            if (!v.exists()) {
                v.mkdirs()
            }
            def startDockerCmd = ['docker','stack', 'deploy', '-c', 'docker/test_mongo.yml', 'mongo-db-test']
            executeCommand(startDockerCmd)
            dockerStarted = true;
            int count=0
            int maxCount=100
            while (count<maxCount) {
                if (executeCommand(command).startsWith(existingResponse)) {
                    println 'mongo-db docker stack is up'
                    break
                }
                else {
                    count++
                    sleep(1000)
                }
            }
            if (count==maxCount) {
                throw Exception('error while start mongo db stack')
            }
        }
    }

    @AfterClass
    public static void afterClass() {
        println("afterClass stuff")
        if (dockerStarted) {
            def startDockerCmd = ['docker','stack', 'rm', 'mongo-db-test']
            executeCommand(startDockerCmd)
            dockerStarted = false;
        }
    }

    @Test
    public void test_getDb() throws SerializationException {
        DbFactory.setConfigFile("src/test/resources/local-mongo.properties");
        DbFactory factory = DbFactory.getInst();
        MongoDatabase mongoDatabase = factory.getDB();
        assertNotNull(mongoDatabase);
        System.out.println("test: testInit");
    }

    @Test
    public void test_insertDocument() throws SerializationException {
        DbFactory.setConfigFile("src/test/resources/local-mongo.properties");
        DbFactory factory = DbFactory.getInst();
        MongoDatabase mongoDatabase = factory.getDB();
        assertNotNull(mongoDatabase);
        println (Document.class.getSimpleName())
        MongoCollection<Document> collection = mongoDatabase.getCollection(Document.class.getSimpleName(),Document.class);
        collection.drop()
        Document dummy = new Document()
        List<Document> docList = dummy.getList()
        assertEquals(0,docList.size())
        // insert new Document
        Document doc = new Document();
        doc.setDate(new Date())
        doc.setIcon('TestIcon')
        doc.setPath('c:\\mydocs\test.jpg')
        doc.setPreview('TestPreview')
        Document_type docType = new Document_type()
        docType.setText("TestDocType")
        docType.setActive(true)
        docType.setGid(UUID.randomUUID().toString())
        doc.setType(docType)
        
        Comment comment1 = new Comment()
        comment1.setText('I am a first comment')
        comment1.setDate(new Date())
        comment1.setUser("Batman")

        Comment comment2 = new Comment()
        comment2.setText('I contain a Ä')
        comment2.setDate(new Date())
        comment2.setUser("Robin")

        List<Comment> commentList = []
        commentList.add(comment1)
        commentList.add(comment2)
        doc.setComments(commentList);

        List<String> tagList = ['tag1', 'tag2', 'tag3']
        doc.setTags(tagList)
        doc.save()
        assertNotNull(doc.getGid())
        // read now a new list
        docList = dummy.getList()
        assertEquals(1,docList.size())

        Document doc2 = docList.get(0)
        assertEquals(doc.getDate(),doc2.getDate());
        assertEquals(doc.getIcon(),doc2.getIcon());
        assertEquals(doc.getPath(),doc2.getPath());
        assertEquals(doc.getPreview(),doc2.getPreview());
        assertEquals(2,doc2.getComments().size())
        assertEquals(3,doc2.getTags().size())

        assertTrue(doc.equals(doc2))
        doc2.setPath(null)
        assertFalse(doc.equals(doc2))
    }

        @Test
    public void test_insertTag() throws SerializationException {
        DbFactory.setConfigFile("src/test/resources/local-mongo.properties");
        DbFactory factory = DbFactory.getInst();
        MongoDatabase mongoDatabase = factory.getDB();
        assertNotNull(mongoDatabase);
        MongoCollection<Tag> collection = mongoDatabase.getCollection(Tag.class.getSimpleName(),Tag.class);
        collection.drop()
        Tag dummy = new Tag()
        // read an empty list
        List<Tag> tagList = dummy.getList()
        assertEquals(0,tagList.size())
        // insert new Tag
        Tag tag = new Tag();
        tag.setCreated(new Date())
        tag.setColor('dedede')
        tag.setComment('this is my first insert')
        tag.setText('Test-Tag')
        assertNull(tag.getGid())
        tag.save()
        assertNotNull(tag.getGid())
        // read now a new list
        tagList = dummy.getList()
        assertEquals(1,tagList.size())
        
        Tag tag2 = tagList.get(0)
        assertEquals(tag.getGid(),tag2.getGid())
        assertEquals(tag.getColor(),tag2.getColor())
        assertEquals(tag.getComment(),tag2.getComment())
        assertEquals(tag.getText(),tag2.getText())
        assertEquals(tag.getCreated(),tag2.getCreated())

        // read the value by id
        Tag tagById = dummy.getById(tag.getGid().toString())
        assertNotNull(tagById)
        assertEquals(tag.getGid(),tagById.getGid())
        assertEquals(tag.getColor(),tagById.getColor())
        assertEquals(tag.getComment(),tagById.getComment())
        assertEquals(tag.getText(),tagById.getText())
        assertEquals(tag.getCreated(),tagById.getCreated())

        tagById.delete()
        Tag tagById2 = dummy.getById(tag.getGid().toString())
        assertNull(tagById2)

        tagList = dummy.getList()
        assertEquals(0,tagList.size())
    }
}
