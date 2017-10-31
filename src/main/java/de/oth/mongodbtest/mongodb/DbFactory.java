package de.oth.mongodbtest.mongodb;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import de.oth.mongodbtest.serialization.SerializationException;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DbFactory {
    private String databaseName;
    private String address;
    private int port;
    private String user;
    private String pwd;

    private static String configFile;

    private MongoDatabase database;

    private static DbFactory inst;

    private DbFactory() throws SerializationException {
        initFromConfiguration();
    }

    public MongoDatabase getDB() {
        if (this.database==null) {
            ServerAddress serverAddress = new ServerAddress(address,port);
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClient mongoClient = new MongoClient(serverAddress, MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
            this.database = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);

        }
        return this.database;
    }

    public static DbFactory getInst() throws SerializationException {
        if (inst==null) {
            inst = new DbFactory();
        }
        return inst;
    }

    private void initFromConfiguration() throws SerializationException {
        String cfgFile = configFile!=null ? configFile : System.getenv("CONFIG_FILE");
        if (cfgFile==null) throw new SerializationException("environment variable CONFIG_FILE not set");
        File file = new File(cfgFile);
        if (!file.exists()) throw new SerializationException ("can't find config file: " + cfgFile);
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(file));
        }
        catch(IOException e) {
            throw new SerializationException(e);
        }
        this.address = props.getProperty("db.address","localhost");
        this.databaseName = props.getProperty("db.name","test-mongo");
        String portStr = props.getProperty("db.port","27017");
        this.port = Integer.parseInt(portStr);
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public static String getConfigFile() {
        return configFile;
    }

    public static void setConfigFile(String configFile) {
        DbFactory.configFile = configFile;
    }
}
