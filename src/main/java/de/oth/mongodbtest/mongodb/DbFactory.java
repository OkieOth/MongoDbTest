package de.oth.mongodbtest.mongodb;


import com.mongodb.DB;

// TODO - connection to MongoDb isn't established
public class DbFactory {
    String address;
    int port;
    String user;
    String pwd;

    private static DbFactory inst;

    private DbFactory() {
    }

    public DB getDB() {
        return null; // TODO
    }

    public static DbFactory getInst() {
        if (inst==null) {
            inst = new DbFactory();
        }
        return inst;
    }
}
