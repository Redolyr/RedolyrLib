package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagFloat extends ElementBasePrimitive
{
	private float data;
	ElementTagFloat() {}
	public ElementTagFloat(float par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(this.data + "");
    }
	void read(final Element par1) throws IOException
	{
		this.data = Float.parseFloat(par1.getTextContent());
	}
	public byte getId()
	{
		return 10;
	}
	public ElementTagFloat copy()
	{
		float data = this.data;
		return new ElementTagFloat(data);
	}
	public int toInteger()
	{
		return this.data < (float)((int) this.data) ? (int) this.data - 1 : (int) this.data;
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
		return String.valueOf(toFloat());
	}
}
