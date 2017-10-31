package de.oth.mongodbtest.mongodb;

import com.mongodb.client.MongoCollection;
import de.oth.mongodbtest.model.beans.Document;
import de.oth.mongodbtest.serialization.ISerializeConnection;
import de.oth.mongodbtest.serialization.SerializationException;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public abstract class MongoDbConnection<T> implements ISerializeConnection {
    private MongoCollection<T> getCollection() throws SerializationException {
        Class c = this.getClass();
        String cName = c.getSimpleName();
        return DbFactory.getInst().getDB().getCollection(cName,c);
    }
    /**
     * one object from the backend
     * @return
     * @throws SerializationException
     */
    public T getById(String id) throws SerializationException {
        try {
            MongoCollection<T> collection = getCollection();
            return collection.find(eq("gid", id)).first();
        }
        catch(Exception e) {
            throw new SerializationException(e);
        }
    }

    /**
     * TODO - add needed parameter
     * @return
     */
    public List<T> getList() throws SerializationException{
        try {
            MongoCollection<T> collection = getCollection();
            return collection.find().into(new ArrayList<T>());
        }
        catch(Exception e) {
            throw new SerializationException(e);
        }
    }

    public void save() throws SerializationException{
        if (getGid()==null) {
            java.util.UUID uuid = java.util.UUID.randomUUID();
            System.out.println("new UUID: "+uuid.toString());
            setGid(uuid.toString());
        }
        try {
            MongoCollection<T> collection = getCollection();
            collection.insertOne((T)this);
        }
        catch(Exception e) {
            throw new SerializationException(e);
        }
    }

    public void delete() throws SerializationException{
        try {
            String gid = getGid();
            if (gid==null) {
                throw new SerializationException("gid is null");
            }
            MongoCollection<T> collection = getCollection();
            collection.findOneAndDelete(eq("gid", gid.toString()));
        }
        catch(Exception e) {
            throw new SerializationException(e);
        }
    }

    public abstract String getGid();
    public abstract void setGid(String gid);

}
