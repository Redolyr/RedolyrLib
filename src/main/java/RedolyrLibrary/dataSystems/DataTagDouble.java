package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagDouble extends DataBasePrimitive {
    private double data;

    DataTagDouble() {
    }

    public DataTagDouble(double par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeDouble(this.data);
    }

    void read(DataInput par1) throws IOException {
        this.data = par1.readDouble();
    }

    public byte getId() {
        return 9;
    }

    public DataTagDouble copy() {
        double data = this.data;
        return new DataTagDouble(data);
    }

    public int toInteger() {
        return this.data < (double) ((int) this.data) ? (int) this.data - 1 : (int) this.data;
    }

    public short toShort() {
        return (short) (toInteger() & 65535);
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) (toInteger() & 255);
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public String toString() {
        return String.valueOf(toDouble());
    }
}
