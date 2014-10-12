package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagDouble extends ElementBasePrimitive
{
	private double data;
	ElementTagDouble() {}
	public ElementTagDouble(double par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.appendChild(this.document.createTextNode(this.data + ""));
    }
    void read(final Element par1) throws IOException
    {
        this.data = Double.parseDouble(par1.getTextContent());
    }
	public byte getId()
	{
		return 9;
	}
	public ElementTagDouble copy()
	{
		double data = this.data;
		return new ElementTagDouble(data);
	}
	public int toInteger()
	{
		return this.data < (double)((int) this.data) ? (int) this.data - 1 : (int) this.data;
	}
	public short toShort()
	{
		return (short) (toInteger() & 65535);
	}
	public long toLong()
	{
		return (long) this.data;
	}
	public byte toByte()
	{
		return (byte) (toInteger() & 255);
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
		return String.valueOf(toDouble());
	}
}
