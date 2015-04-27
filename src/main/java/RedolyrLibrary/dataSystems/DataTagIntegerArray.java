package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagIntegerArray extends DataBasePrimitiveArray {
    private int[] data;

    DataTagIntegerArray() {
    }

    public DataTagIntegerArray(int[] par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.length);
        for (int len = 0; len < this.data.length; len++) par1.writeInt(this.data[len]);
    }

    void read(DataInput par1) throws IOException {
        int length = par1.readInt();
        this.data = new int[length];
        for (int len = 0; len < length; len++) this.data[len] = par1.readInt();
    }

    public byte getId() {
        return 14;
    }

    public DataTagIntegerArray copy() {
        int[] data = new int[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return new DataTagIntegerArray(data);
    }

    public int length() {
        return this.data.length;
    }

    public int[] toIntegerArray() {
        return this.data;
    }

    public short[] toShortArray() {
        short[] data = new short[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (short) (this.data[len] & 65535);
        return data;
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

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < toIntegerArray().length; len++)
            tsb.append(toIntegerArray()[len]).append(len != toIntegerArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
