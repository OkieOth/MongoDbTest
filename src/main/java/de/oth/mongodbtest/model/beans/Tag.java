package de.oth.mongodbtest.model.beans;



public class Tag extends de.oth.mongodbtest.mongodb.MongoDbConnection <Tag> {
    
    
    /**
     * color that marks this tag
     */
    
    private String color;

    public String getColor () { return this.color; }

    public void setColor (String color) {
        this.color = color;
    }

    
    
    /**
     * Comment to that tab
     */
    
    private String comment;

    public String getComment () { return this.comment; }

    public void setComment (String comment) {
        this.comment = comment;
    }

    
    
    private java.util.Date created;

    public java.util.Date getCreated () { return this.created; }

    public void setCreated (java.util.Date created) {
        this.created = created;
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
        if ( ! (obj instanceof Tag)) return false;

        Tag _typeInst = (Tag) obj;
    
        String _color = _typeInst.getColor ();
        if (this.color == null && _color != null) return false;
        if (this.color != null) {
            if (!this.color.equals(_color)) return false;
        }
    
        String _comment = _typeInst.getComment ();
        if (this.comment == null && _comment != null) return false;
        if (this.comment != null) {
            if (!this.comment.equals(_comment)) return false;
        }
    
        java.util.Date _created = _typeInst.getCreated ();
        if (this.created == null && _created != null) return false;
        if (this.created != null) {
            if (!this.created.equals(_created)) return false;
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
