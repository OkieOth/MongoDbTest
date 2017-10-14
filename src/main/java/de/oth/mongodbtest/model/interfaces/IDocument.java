package de.oth.mongodbtest.model.interfaces;
public interface IDocument {
    public java.util.List<IComment> getComments ();
    public void setComments (java.util.List<IComment> comments);
    public String getDate ();
    public void setDate (String date);
    public java.util.UUID getGid ();
    public void setGid (java.util.UUID gid);
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
    public java.util.List<java.util.UUID> getTags ();
    public void setTags (java.util.List<java.util.UUID> tags);
    public IDocument_type getType ();
    public void setType (IDocument_type type);
}
