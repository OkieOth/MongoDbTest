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

    
}
