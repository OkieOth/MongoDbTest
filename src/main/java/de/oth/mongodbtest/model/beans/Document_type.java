package de.oth.mongodbtest.model.beans;
import de.oth.mongodbtest.model.interfaces.*;
public class Document_type implements IDocument_type {
    /**
     * is the entry currently active
     */
    private Boolean active;
    public Boolean getActive () { return this.active; }
    public void setActive (Boolean active) {
        this.active = active;
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