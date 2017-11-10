package de.oth.mongodbtest.model.beans.meta;

import de.oth.mongodbtest.meta.MetaEntry;

import java.util.ArrayList;
import java.util.List;

public class Meta_Comment {
    private MetaEntry date_entry;
    private MetaEntry user_entry;
    private MetaEntry text_entry;

    public boolean isFieldVisible(String name) {
        return false; // TODO
    }

    public MetaEntry getMetaEntry (String name) {
        if (name==null) throw new NullPointerException();
        switch(name) {

        }
        return false; // TODO
    }

    public List<MetaEntry> getVisibleEntries() {
        ArrayList<MetaEntry> ret = new ArrayList<MetaEntry>();
        if (date_entry.isVisible()) ret.add(date_entry);
        if (user_entry.isVisible()) ret.add(user_entry);
        if (text_entry.isVisible()) ret.add(text_entry);
        return ret;
    }

}
