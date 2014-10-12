package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagInteger extends ElementBasePrimitive
{
	private int data;
	ElementTagInteger() {}
	public ElementTagInteger(int par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(this.data + "");
    }
    void read(final Element par1) throws IOException
    {
        this.data = Integer.parseInt(par1.getTextContent());
    }
	public byte getId()
	{
		return 5;
	}
	public ElementTagInteger copy()
	{
		int data = this.data;
		return new ElementTagInteger(data);
	}
	public int toInteger()
	{
		return this.data;
	}
	public short toShort()
	{
		return (short) (this.data & 65535);
	}
	public long toLong()
	{
		return (long) this.data;
	}
	public byte toByte()
	{
		return (byte) (this.data & 255);
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
		return String.valueOf(toInteger());
	}
}
