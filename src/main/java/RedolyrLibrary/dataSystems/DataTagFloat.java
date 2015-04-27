package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagFloat extends DataBasePrimitive {
    private float data;

    DataTagFloat() {
    }

    public DataTagFloat(float par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeFloat(this.data);
    }

    void read(DataInput par1) throws IOException {
        this.data = par1.readFloat();
    }

    public byte getId() {
        return 10;
    }

    public DataTagFloat copy() {
        float data = this.data;
        return new DataTagFloat(data);
    }

    public int toInteger() {
        return this.data < (float) ((int) this.data) ? (int) this.data - 1 : (int) this.data;
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
        return String.valueOf(toFloat());
    }
}
