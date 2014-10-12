package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagShort extends ElementBasePrimitive
{
	private short data;
	ElementTagShort() {}
	public ElementTagShort(short par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(this.data + "");
    }
    void read(final Element par1) throws IOException
    {
        this.data = Short.parseShort(par1.getTextContent());
    }
	public byte getId()
	{
		return 6;
	}
	public ElementTagShort copy()
	{
		short data = this.data;
		return new ElementTagShort(data);
	}
	public int toInteger()
	{
		return (int) this.data;
	}
	public short toShort()
	{
		return this.data;
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
		return String.valueOf(toShort());
	}
}
