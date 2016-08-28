package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagShort extends DataBasePrimitive {

    private short data;

    protected DataTagShort() {
    }

    public DataTagShort(short par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeShort(this.data);
    }

    void read(DataInput par1) throws IOException {
        this.data = par1.readShort();
    }

    public byte getId() {
        return 6;
    }

    public DataTagShort copy() {
        short data = this.data;
        return new DataTagShort(data);
    }

    public int toInteger() {
        return (int) this.data;
    }

    public short toShort() {
        return this.data;
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) (this.data & 255);
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagShort)) return false;
        return this.data == ((DataTagShort) o).data;
    }

    public String toString() {
        return String.valueOf(this.toShort());
    }
}
