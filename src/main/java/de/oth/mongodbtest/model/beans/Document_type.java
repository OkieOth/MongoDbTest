package de.oth.mongodbtest.model.beans;



public class Document_type extends de.oth.mongodbtest.mongodb.MongoDbConnection <Document_type> {
    
    
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

    
    
    private String gid;

    public String getGid () { return this.gid; }

    public void setGid (String gid) {
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

    
    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if ( ! (obj instanceof Document_type)) return false;

        Document_type _typeInst = (Document_type) obj;
    
        Boolean _active = _typeInst.getActive ();
        if (this.active == null && _active != null) return false;
        if (this.active != null) {
            if (!this.active.equals(_active)) return false;
        }
    
        String _comment = _typeInst.getComment ();
        if (this.comment == null && _comment != null) return false;
        if (this.comment != null) {
            if (!this.comment.equals(_comment)) return false;
        }
    
        String _gid = _typeInst.getGid ();
        if (this.gid == null && _gid != null) return false;
        if (this.gid != null) {
            if (!this.gid.equals(_gid)) return false;
        }
    
        String _text = _typeInst.getText ();
        if (this.text == null && _text != null) return false;
        if (this.text != null) {
            if (!this.text.equals(_text)) return false;
        }
    
        return true;
    }
}
