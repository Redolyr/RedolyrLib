package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagDoubleArray extends DataBasePrimitiveArray {

    private double[] data;

    protected DataTagDoubleArray() {
    }

    public DataTagDoubleArray(double[] par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.length);
        for (int len = 0; len < this.data.length; len++) par1.writeDouble(this.data[len]);
    }

    void read(DataInput par1) throws IOException {
        int length = par1.readInt();
        this.data = new double[length];
        for (int len = 0; len < length; len++) this.data[len] = par1.readDouble();
    }

    public byte getId() {
        return 18;
    }

    public DataTagDoubleArray copy() {
        double[] data = new double[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return new DataTagDoubleArray(data);
    }

    public int length() {
        return this.data.length;
    }

    public int[] toIntegerArray() {
        int[] data = new int[this.data.length];
        for (int len = 0; len < this.data.length; len++)
            data[len] = (this.data[len] < (float) ((int) this.data[len]) ? (int) this.data[len] - 1 : (int) this.data[len]);
        return data;
    }

    public short[] toShortArray() {
        short[] data = new short[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (short) (toIntegerArray()[len] & 65535);
        return data;
    }

    public long[] toLongArray() {
        long[] data = new long[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (long) this.data[len];
        return data;
    }

    public byte[] toByteArray() {
        byte[] data = new byte[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (byte) (toIntegerArray()[len] & 255);
        return data;
    }

    public double[] toDoubleArray() {
        double[] data = new double[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public float[] toFloatArray() {
        float[] data = new float[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (float) this.data[len];
        return data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagDoubleArray)) return false;
        return Arrays.equals(this.data, ((DataTagDoubleArray) o).data);
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < toDoubleArray().length; len++)
            tsb.append(toDoubleArray()[len]).append(len != toDoubleArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
