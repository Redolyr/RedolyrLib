package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagFloatArray extends DataBasePrimitiveArray {
    private float[] data;

    DataTagFloatArray() {
    }

    public DataTagFloatArray(float[] par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.length);
        for (int len = 0; len < this.data.length; len++) par1.writeFloat(this.data[len]);
    }

    void read(DataInput par1) throws IOException {
        int length = par1.readInt();
        this.data = new float[length];
        for (int len = 0; len < length; len++) this.data[len] = par1.readFloat();
    }

    public byte getId() {
        return 19;
    }

    public DataTagFloatArray copy() {
        float[] data = new float[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return new DataTagFloatArray(data);
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
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < toFloatArray().length; len++)
            tsb.append(toFloatArray()[len]).append(len != toFloatArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
