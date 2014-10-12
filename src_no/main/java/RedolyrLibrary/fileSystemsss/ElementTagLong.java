package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagLong extends ElementBasePrimitive
{
	private long data;
	ElementTagLong() {}
	public ElementTagLong(long par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(this.data + "");
    }
    void read(final Element par1) throws IOException
    {
        this.data = Long.parseLong(par1.getTextContent());
    }
	public byte getId()
	{
		return 7;
	}
	public ElementTagLong copy()
	{
		long data = this.data;
		return new ElementTagLong(data);
	}
	public int toInteger()
	{
		return (int) (this.data & -1L);
	}
	public short toShort()
	{
		return (short) (this.data & 65535L);
	}
	public long toLong()
	{
		return (long) this.data;
	}
	public byte toByte()
	{
		return (byte) (this.data & 255L);
	}
	public double toDouble()
	{
		return (double) this.data;
	}
	public float toFloat()
	{
		return (float) this.data;
	}
	public String toString()
	{
		return String.valueOf(toLong());
	}
}
