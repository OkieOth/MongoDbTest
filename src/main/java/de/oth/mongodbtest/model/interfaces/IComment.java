package de.oth.mongodbtest.model.interfaces;


public interface IComment {
    
    
    /**
     * date of entry
     */
    
    public String getDate ();
    public void setDate (String date);
    
    
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
