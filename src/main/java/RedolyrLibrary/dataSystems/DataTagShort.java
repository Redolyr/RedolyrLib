package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagShort extends DataBasePrimitive {
    private short data;

    DataTagShort() {
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

    public String toString() {
        return String.valueOf(toShort());
    }
}
