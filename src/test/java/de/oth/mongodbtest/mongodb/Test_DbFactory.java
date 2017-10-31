package de.oth.mongodbtest.mongodb;

import com.mongodb.client.MongoDatabase;
import de.oth.mongodbtest.serialization.SerializationException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class Test_DbFactory {
    @Test
    public void testInit() throws SerializationException {
        DbFactory.setConfigFile("src/test/resources/test.properties");
        DbFactory factory = DbFactory.getInst();
        assertEquals("192.168.0.1",factory.getAddress());
        assertEquals(5000,factory.getPort());
        assertEquals("my-first",factory.getDatabaseName());
        System.out.println("test: testInit");
    }

    @Test
    public void printUUID() {
        java.util.UUID uuid = java.util.UUID.randomUUID();
    }
}
