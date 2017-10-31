package de.oth.mongodbtest.model.interfaces;


public interface IDocument {
    
    
    public java.util.List<IComment> getComments ();
    public void setComments (java.util.List<IComment> comments);
    
    
    public java.util.Date getDate ();
    public void setDate (java.util.Date date);
    
    
    public String getGid ();
    public void setGid (String gid);
    
    
    /**
     * icon preview for the document
     */
    
    public String getIcon ();
    public void setIcon (String icon);
    
    
    /**
     * where is the document located
     */
    
    public String getPath ();
    public void setPath (String path);
    
    
    /**
     * where is the document preview located
     */
    
    public String getPreview ();
    public void setPreview (String preview);
    
    
    public java.util.List<String> getTags ();
    public void setTags (java.util.List<String> tags);
    
    
    public IDocument_type getType ();
    public void setType (IDocument_type type);
    
}
