package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagDoubleArray extends ElementBasePrimitiveArray
{
	private double[] data;
	ElementTagDoubleArray() {}
	public ElementTagDoubleArray(double[] par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeDouble(this.data[len]);
	}
	void read(final Element par1) throws IOException
	{
		int length = par1.readInt();
		this.data = new double[length];
		for (int len = 0; len < length; len++) this.data[len] = par1.readDouble();
	}
	public byte getId()
	{
		return 18;
	}
	public ElementTagDoubleArray copy()
	{
		double[] data = new double[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new ElementTagDoubleArray(data);
	}
	public int[] toIntegerArray()
	{
		int[] data = new int[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (this.data[len] < (float)((int) this.data[len]) ? (int) this.data[len] - 1 : (int) this.data[len]);
		return data;
	}
	public short[] toShortArray()
	{
		short[] data = new short[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (short) (toIntegerArray()[len] & 65535);
		return data;
	}
	public long[] toLongArray()
	{
		long[] data = new long[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (long) this.data[len];
		return data;
	}
	public byte[] toByteArray()
	{
		byte[] data = new byte[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (byte) (toIntegerArray()[len] & 255);
		return data;
	}
	public double[] toDoubleArray()
	{
		double[] data = new double[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return data;
	}
	public float[] toFloatArray()
	{
		float[] data = new float[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (float) this.data[len];
		return data;
	}
	public String toString()
	{
		StringBuilder tsb = new StringBuilder();
		for (int len = 0; len < toDoubleArray().length; len++) tsb.append(toDoubleArray()[len]).append(len != toDoubleArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
