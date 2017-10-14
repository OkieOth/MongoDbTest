package de.oth.mongodbtest.model.interfaces;


public interface ITag {
    
    
    /**
     * color that marks this tag
     */
    
    public String getColor ();
    public void setColor (String color);
    
    
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
