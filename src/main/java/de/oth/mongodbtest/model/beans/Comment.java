package de.oth.mongodbtest.model.beans;
import de.oth.mongodbtest.model.interfaces.*;
public class Comment implements IComment {
    /**
     * date of entry
     */
    private String date;
    public String getDate () { return this.date; }
    public void setDate (String date) {
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
