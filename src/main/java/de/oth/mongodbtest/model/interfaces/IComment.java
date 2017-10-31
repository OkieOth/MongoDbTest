package de.oth.mongodbtest.model.interfaces;


public interface IComment {
    
    
    /**
     * date of entry
     */
    
    public java.util.Date getDate ();
    public void setDate (java.util.Date date);
    
    
    /**
     * comment text
     */
    
    public String getText ();
    public void setText (String text);
    
    
    /**
     * who did this comment
     */
    
    public String getUser ();
    public void setUser (String user);
    
}
