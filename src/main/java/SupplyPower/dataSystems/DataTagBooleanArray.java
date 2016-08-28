package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagBooleanArray extends DataBaseArray {

    private boolean data[];

    protected DataTagBooleanArray() {
    }

    public DataTagBooleanArray(boolean[] par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.length);
        for (int len = 0; len < this.data.length; len++) par1.writeBoolean(this.data[len]);
    }

    void read(DataInput par1) throws IOException {
        int length = par1.readInt();
        this.data = new boolean[length];
        for (int len = 0; len < length; len++) this.data[len] = par1.readBoolean();
    }

    public byte getId() {
        return 20;
    }

    public DataTagBooleanArray copy() {
        boolean[] data = new boolean[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return new DataTagBooleanArray(data);
    }

    public int length() {
        return this.data.length;
    }

    public boolean[] getBooleanArray() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagBooleanArray)) return false;
        return Arrays.equals(this.data, ((DataTagBooleanArray) o).data);
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < getBooleanArray().length; len++)
            tsb.append(getBooleanArray()[len]).append(len != getBooleanArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
