package RedolyrLibrary.test2System;

import RedolyrLibrary.dataSystems.DataBase;
import RedolyrLibrary.dataSystems.DataTagCompound;
import RedolyrLibrary.documentSystems.DocumentBase;
import RedolyrLibrary.documentSystems.DocumentTagCompound;

/**
 * Created by redolyr on 2014/12/18.
 */
public class TestBase {

    private DataTagCompound dataTagCompound;
    private DocumentTagCompound documentTagCompound;

    public TestBase() {
        this.dataTagCompound = new DataTagCompound();
        this.documentTagCompound = new DocumentTagCompound();
    }

    public Object getTag(String key, int type) {
        return type == 0 ? this.dataTagCompound.getTag(key) : type == 1 ? this.documentTagCompound.getTag(key) : null;
    }

    public void setTag(String key, Object value) {
        if (value instanceof DataBase) this.dataTagCompound.setTag(key, (DataBase) value);
        else if (value instanceof DocumentBase) this.documentTagCompound.setTag(key, (DocumentBase) value);
        else throw new IllegalArgumentException("Did not managing that Type");
    }

    public DataTagCompound toDataTagCompound() {
        return this.dataTagCompound;
    }

    public DocumentTagCompound toDocumentTagCompound() {
        return this.documentTagCompound;
    }
}
