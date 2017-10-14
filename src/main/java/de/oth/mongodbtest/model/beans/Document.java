package de.oth.mongodbtest.model.beans;


import de.oth.mongodbtest.model.interfaces.*;




public class Document implements IDocument {
    
    
    private java.util.List<IComment> comments;

    public java.util.List<IComment> getComments () { return this.comments; }

    public void setComments (java.util.List<IComment> comments) {
        this.comments = comments;
    }

    
    
    private String date;

    public String getDate () { return this.date; }

    public void setDate (String date) {
        this.date = date;
    }

    
    
    private java.util.UUID gid;

    public java.util.UUID getGid () { return this.gid; }

    public void setGid (java.util.UUID gid) {
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

    
    
    private java.util.List<java.util.UUID> tags;

    public java.util.List<java.util.UUID> getTags () { return this.tags; }

    public void setTags (java.util.List<java.util.UUID> tags) {
        this.tags = tags;
    }

    
    
    private IDocument_type type;

    public IDocument_type getType () { return this.type; }

    public void setType (IDocument_type type) {
        this.type = type;
    }

    
}
