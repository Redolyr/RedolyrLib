package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagByte extends DataBasePrimitive {

    private byte data;

    protected DataTagByte() {
    }

    public DataTagByte(byte par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeByte(this.data);
    }

    void read(DataInput par1) throws IOException {
        this.data = par1.readByte();
    }

    public byte getId() {
        return 8;
    }

    public DataTagByte copy() {
        byte data = this.data;
        return new DataTagByte(data);
    }

    public int toInteger() {
        return this.data;
    }

    public short toShort() {
        return (short) this.data;
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) this.data;
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagByte)) return false;
        return this.data == ((DataTagByte) o).data;
    }

    public String toString() {
        return String.valueOf(this.toByte());
    }
}
