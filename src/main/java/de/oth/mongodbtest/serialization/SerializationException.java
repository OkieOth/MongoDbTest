package de.oth.mongodbtest.serialization;

public class SerializationException extends Exception {
    public SerializationException() {
        super();
    }

    public SerializationException(String msg) {
        super(msg);
    }

    public SerializationException(Throwable t) {
        super(t);
    }
}
