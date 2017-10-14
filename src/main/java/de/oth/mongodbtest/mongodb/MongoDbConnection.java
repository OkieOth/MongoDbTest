package de.oth.mongodbtest.mongodb;

import de.oth.mongodbtest.serialization.ISerializeConnection;
import de.oth.mongodbtest.serialization.SerializationException;

import java.util.List;

public class MongoDbConnection<T> implements ISerializeConnection {
    public T getById(String id) throws SerializationException {
        return null; // TODO
    }

    /**
     * TODO - add needed parameter
     * @return
     */
    public List<T> getList() throws SerializationException{
        return null; // TODO
    }

    public T save() throws SerializationException{
        return null; // TODO
    }

    public void delete() throws SerializationException{
        // TODO
    }

}
