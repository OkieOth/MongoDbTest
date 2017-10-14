package de.oth.mongodbtest.model.beans;


import de.oth.mongodbtest.model.interfaces.*;




public class Tag implements ITag {
    
    
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

    
    
    private java.util.UUID gid;

    public java.util.UUID getGid () { return this.gid; }

    public void setGid (java.util.UUID gid) {
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
