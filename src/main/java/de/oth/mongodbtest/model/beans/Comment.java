package de.oth.mongodbtest.model.beans;


public class Comment {
    
    
    /**
     * date of entry
     */
    
    private java.util.Date date;

    public java.util.Date getDate () { return this.date; }

    public void setDate (java.util.Date date) {
        this.date = date;
    }

    
    
    /**
     * comment text
     */
    
    private String text;

    public String getText () { return this.text; }

    public void setText (String text) {
        this.text = text;
    }

    
    
    /**
     * who did this comment
     */
    
    private String user;

    public String getUser () { return this.user; }

    public void setUser (String user) {
        this.user = user;
    }

    
}
