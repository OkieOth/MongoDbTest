package de.oth.mongodbtest.model.beans;



public class Document extends de.oth.mongodbtest.mongodb.MongoDbConnection <Document> {
    
    
    private java.util.List<Comment> comments;

    public java.util.List<Comment> getComments () { return this.comments; }

    public void setComments (java.util.List<Comment> comments) {
        this.comments = comments;
    }

    
    
    private java.util.Date date;

    public java.util.Date getDate () { return this.date; }

    public void setDate (java.util.Date date) {
        this.date = date;
    }

    
    
    private String gid;

    public String getGid () { return this.gid; }

    public void setGid (String gid) {
        this.gid = gid;
    }

    
    
    /**
     * icon preview for the document
     */
    
    private String icon;

    public String getIcon () { return this.icon; }

    public void setIcon (String icon) {
        this.icon = icon;
    }

    
    
    /**
     * where is the document located
     */
    
    private String path;

    public String getPath () { return this.path; }

    public void setPath (String path) {
        this.path = path;
    }

    
    
    /**
     * where is the document preview located
     */
    
    private String preview;

    public String getPreview () { return this.preview; }

    public void setPreview (String preview) {
        this.preview = preview;
    }

    
    
    private java.util.List<String> tags;

    public java.util.List<String> getTags () { return this.tags; }

    public void setTags (java.util.List<String> tags) {
        this.tags = tags;
    }

    
    
    private Document_type type;

    public Document_type getType () { return this.type; }

    public void setType (Document_type type) {
        this.type = type;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if ( ! (obj instanceof Document)) return false;

        Document _typeInst = (Document) obj;
    
        java.util.List<Comment> _comments = _typeInst.getComments ();
        if (this.comments == null && _comments != null) return false;
        if (this.comments != null) {
            if (!this.comments.equals(_comments)) return false;
        }
    
        java.util.Date _date = _typeInst.getDate ();
        if (this.date == null && _date != null) return false;
        if (this.date != null) {
            if (!this.date.equals(_date)) return false;
        }
    
        String _gid = _typeInst.getGid ();
        if (this.gid == null && _gid != null) return false;
        if (this.gid != null) {
            if (!this.gid.equals(_gid)) return false;
        }
    
        String _icon = _typeInst.getIcon ();
        if (this.icon == null && _icon != null) return false;
        if (this.icon != null) {
            if (!this.icon.equals(_icon)) return false;
        }
    
        String _path = _typeInst.getPath ();
        if (this.path == null && _path != null) return false;
        if (this.path != null) {
            if (!this.path.equals(_path)) return false;
        }
    
        String _preview = _typeInst.getPreview ();
        if (this.preview == null && _preview != null) return false;
        if (this.preview != null) {
            if (!this.preview.equals(_preview)) return false;
        }
    
        java.util.List<String> _tags = _typeInst.getTags ();
        if (this.tags == null && _tags != null) return false;
        if (this.tags != null) {
            if (!this.tags.equals(_tags)) return false;
        }
    
        Document_type _type = _typeInst.getType ();
        if (this.type == null && _type != null) return false;
        if (this.type != null) {
            if (!this.type.equals(_type)) return false;
        }
    
        return true;
    }
}
