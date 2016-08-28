package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagEnd extends DataBase {

    void write(DataOutput par1) throws IOException {
    }

    void read(DataInput par1) throws IOException {
    }

    public byte getId() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagBoolean)) return false;
        return super.equals(o);
    }

    public DataTagEnd copy() {
        return new DataTagEnd();
    }
}
