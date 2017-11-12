package de.oth.mongodbtest.model.beans.meta;

import java.util.ArrayList;
import java.util.List;
import de.oth.mongodbtest.model.beans.meta.base.MetaEntry;

public class Meta_Comment {
    private MetaEntry dateMeta;
    private MetaEntry userMeta;
    private MetaEntry textMeta;

    private final static String DATE_FIELD = "date";
    private final static String USER_FIELD = "user";
    private final static String TEXT_FIELD = "text";

    public boolean isFieldVisible(String name) {
        return false; // TODO
    }

    public MetaEntry getMetaEntry (String name) {
        if (name==null) throw new NullPointerException();
        switch(name) {
            case DATE_FIELD:
                return dateMeta;
            case USER_FIELD:
                return userMeta;
            case TEXT_FIELD:
                return textMeta;
            default:
                return null;
        }
    }

    public List<MetaEntry> getVisibleEntries() {
        ArrayList<MetaEntry> ret = new ArrayList<MetaEntry>();
        if (dateMeta.isVisible()) ret.add(dateMeta);
        if (userMeta.isVisible()) ret.add(userMeta);
        if (textMeta.isVisible()) ret.add(textMeta);
        return ret;
    }

    public MetaEntry getDateMeta() {
        return dateMeta;
    }

    public void setDateMeta(MetaEntry dateMeta) {
        this.dateMeta = dateMeta;
    }

    public MetaEntry getUserMeta() {
        return userMeta;
    }

    public void setUserMeta(MetaEntry userMeta) {
        this.userMeta = userMeta;
    }

    public MetaEntry getTextMeta() {
        return textMeta;
    }

    public void setTextMeta(MetaEntry textMeta) {
        this.textMeta = textMeta;
    }
}
