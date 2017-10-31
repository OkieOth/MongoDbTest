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
    
    
    public java.util.Date getCreated ();
    public void setCreated (java.util.Date created);
    
    
    public String getGid ();
    public void setGid (String gid);
    
    
    /**
     * Short text that describes the tag
     */
    
    public String getText ();
    public void setText (String text);
    
}
