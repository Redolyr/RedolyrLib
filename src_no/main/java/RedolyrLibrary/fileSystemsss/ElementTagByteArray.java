package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagByteArray extends ElementBasePrimitiveArray
{
	private byte[] data;
	ElementTagByteArray() {}
	public ElementTagByteArray(byte[] par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
        par1.setAttribute("length", this.data.length + "");
		for (int len = 0; len < this.data.length; len++)
        {
            par1.setTextContent(len + ":" + this.data[len]);
        }
	}
	void read(final Element par1) throws IOException
	{
		int length = Integer.parseInt(par1.getAttribute("length"));
		this.data = new byte[length];
		for (int len = 0; len < length; len++)
        {
            String[] split = par1.getTextContent().split(":");
            this.data[len] = Byte.parseByte(String.valueOf(split[0].equals(len) ? split[1] : 0 & 255));
        }
	}
	public byte getId()
	{
		return 17;
	}
	public ElementTagByteArray copy()
	{
		byte[] data = new byte[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new ElementTagByteArray(data);
	}
	public int[] toIntegerArray()
	{
		int[] data = new int[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return data;
	}
	public short[] toShortArray()
	{
		short[] data = new short[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
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
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
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
		for (int len = 0; len < toByteArray().length; len++) tsb.append(toByteArray()[len]).append(len != toByteArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
