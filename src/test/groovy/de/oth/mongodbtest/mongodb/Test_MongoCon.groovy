package de.oth.mongodbtest.mongodb

import com.mongodb.BasicDBObject
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import de.oth.mongodbtest.serialization.SerializationException
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import de.oth.mongodbtest.model.beans.Tag

import static com.mongodb.client.model.Filters.exists
import static junit.framework.TestCase.assertEquals
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
    public void test_insertTag() throws SerializationException {
        DbFactory.setConfigFile("src/test/resources/local-mongo.properties");
        DbFactory factory = DbFactory.getInst();
        MongoDatabase mongoDatabase = factory.getDB();
        assertNotNull(mongoDatabase);
        MongoCollection<Tag> collection = mongoDatabase.getCollection(Tag.getClass().getName(),Tag.class);
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
        
        // read the value by id
        Tag tagById = dummy.getById(tag.getGid().toString())
        assertNotNull(tagById)
        assertEquals(tag.getGid(),tagById.getGid())
        assertEquals(tag.getColor(),tagById.getColor())
        assertEquals(tag.getComment(),tagById.getComment())
        assertEquals(tag.getText(),tagById.getText())

        tagById.delete()
        Tag tagById2 = dummy.getById(tag.getGid().toString())
        assertNull(tagById2)

        tagList = dummy.getList()
        assertEquals(0,tagList.size())
    }
}
