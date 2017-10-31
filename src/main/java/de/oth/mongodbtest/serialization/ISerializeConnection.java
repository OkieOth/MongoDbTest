package de.oth.mongodbtest.serialization;

import java.util.List;

public interface ISerializeConnection<T> {
    /**
     * one object from the backend
     * @return
     * @throws SerializationException
     */
    public T getById(String id) throws SerializationException;

    /**
     * reads a list of objects from the backend
     * @return
     * @throws SerializationException
     */
    public List<T> getList() throws SerializationException;

    /**
     * save the object to the backend. If it is a new object it is inserted, if the object already exists, then
     * it is updated in the backend
     * @return
     * @throws SerializationException
     */
    public void save() throws SerializationException;

    /**
     * deletes the object from the backend
     * @throws SerializationException
     */
    public void delete() throws SerializationException;
}
