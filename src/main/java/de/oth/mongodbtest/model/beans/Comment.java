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

    

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if ( ! (obj instanceof Comment)) return false;

        Comment _typeInst = (Comment) obj;
    
        java.util.Date _date = _typeInst.getDate ();
        if (this.date == null && _date != null) return false;
        if (this.date != null) {
            if (!this.date.equals(_date)) return false;
        }
    
        String _text = _typeInst.getText ();
        if (this.text == null && _text != null) return false;
        if (this.text != null) {
            if (!this.text.equals(_text)) return false;
        }
    
        String _user = _typeInst.getUser ();
        if (this.user == null && _user != null) return false;
        if (this.user != null) {
            if (!this.user.equals(_user)) return false;
        }
    
        return true;
    }

}
