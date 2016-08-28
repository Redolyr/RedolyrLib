package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagShortArray extends DataBasePrimitiveArray {

    private short[] data;

    protected DataTagShortArray() {
    }

    public DataTagShortArray(short[] par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.length);
        for (int len = 0; len < this.data.length; len++) par1.writeShort(this.data[len]);
    }

    void read(DataInput par1) throws IOException {
        int length = par1.readInt();
        this.data = new short[length];
        for (int len = 0; len < length; len++) this.data[len] = par1.readShort();
    }

    public byte getId() {
        return 15;
    }

    public DataTagShortArray copy() {
        short[] data = new short[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return new DataTagShortArray(data);
    }

    public int length() {
        return this.data.length;
    }

    public int[] toIntegerArray() {
        int[] data = new int[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public short[] toShortArray() {
        return this.data;
    }

    public long[] toLongArray() {
        long[] data = new long[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public byte[] toByteArray() {
        byte[] data = new byte[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (byte) (this.data[len] & 255);
        return data;
    }

    public double[] toDoubleArray() {
        double[] data = new double[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public float[] toFloatArray() {
        float[] data = new float[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagShortArray)) return false;
        return Arrays.equals(this.data, ((DataTagShortArray) o).data);
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < toShortArray().length; len++)
            tsb.append(toShortArray()[len]).append(len != toShortArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
