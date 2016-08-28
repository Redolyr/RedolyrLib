package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagLong extends DataBasePrimitive {

    private long data;

    protected DataTagLong() {
    }

    public DataTagLong(long par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeLong(this.data);
    }

    void read(DataInput par1) throws IOException {
        this.data = par1.readLong();
    }

    public byte getId() {
        return 7;
    }

    public DataTagLong copy() {
        long data = this.data;
        return new DataTagLong(data);
    }

    public int toInteger() {
        return (int) (this.data & -1L);
    }

    public short toShort() {
        return (short) (this.data & 65535L);
    }

    public long toLong() {
        return this.data;
    }

    public byte toByte() {
        return (byte) (this.data & 255L);
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagLong)) return false;
        return this.data == ((DataTagLong) o).data;
    }

    public String toString() {
        return String.valueOf(this.toLong());
    }
}
