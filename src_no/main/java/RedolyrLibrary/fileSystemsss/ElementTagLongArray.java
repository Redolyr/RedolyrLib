package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagLongArray extends ElementBasePrimitiveArray
{
	private long[] data;
	ElementTagLongArray() {}
	public ElementTagLongArray(long[] par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeLong(this.data[len]);
	}
	void read(final Element par1) throws IOException
	{
		int length = par1.readInt();
		this.data = new long[length];
		for (int len = 0; len < length; len++) this.data[len] = par1.readLong();
	}
	public byte getId()
	{
		return 16;
	}
	public ElementTagLongArray copy()
	{
		long[] data = new long[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new ElementTagLongArray(data);
	}
	public int[] toIntegerArray()
	{
		int[] data = new int[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (int) (this.data[len] & -1L);
		return data;
	}
	public short[] toShortArray()
	{
		short[] data = new short[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (short) (this.data[len] & 65535L);
		return data;
	}
	public long[] toLongArray()
	{
		long[] data = new long[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return data;
	}
	public byte[] toByteArray()
	{
		byte[] data = new byte[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = (byte) (this.data[len] & 255L);
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
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return data;
	}
	public String toString()
	{
		StringBuilder tsb = new StringBuilder();
		for (int len = 0; len < toLongArray().length; len++) tsb.append(toLongArray()[len]).append(len != toLongArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
