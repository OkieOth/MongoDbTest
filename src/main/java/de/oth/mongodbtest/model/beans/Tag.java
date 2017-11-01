package de.oth.mongodbtest.model.beans;



public class Tag extends de.oth.mongodbtest.mongodb.MongoDbConnection <Tag> {
    
    
    /**
     * color that marks this tag
     */
    
    private String color;

    public String getColor () { return this.color; }

    public void setColor (String color) {
        this.color = color;
    }

    
    
    /**
     * Comment to that tab
     */
    
    private String comment;

    public String getComment () { return this.comment; }

    public void setComment (String comment) {
        this.comment = comment;
    }

    
    
    private java.util.Date created;

    public java.util.Date getCreated () { return this.created; }

    public void setCreated (java.util.Date created) {
        this.created = created;
    }

    
    
    private String gid;

    public String getGid () { return this.gid; }

    public void setGid (String gid) {
        this.gid = gid;
    }

    
    
    /**
     * Short text that describes the tag
     */
    
    private String text;

    public String getText () { return this.text; }

    public void setText (String text) {
        this.text = text;
    }

    
}
