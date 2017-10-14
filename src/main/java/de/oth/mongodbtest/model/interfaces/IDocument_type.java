package de.oth.mongodbtest.model.interfaces;
public interface IDocument_type {
    /**
     * is the entry currently active
     */
    public Boolean getActive ();
    public void setActive (Boolean active);
    /**
     * Comment to that tab
     */
    public String getComment ();
    public void setComment (String comment);
    public java.util.UUID getGid ();
    public void setGid (java.util.UUID gid);
    /**
     * Short text that describes the tag
     */
    public String getText ();
    public void setText (String text);
}
