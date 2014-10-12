package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagByte extends ElementBasePrimitive
{
	private byte data;
	ElementTagByte() {}
	public ElementTagByte(byte par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(this.data + "");
    }
	void read(final Element par1) throws IOException
	{
		this.data = Byte.parseByte(par1.getTextContent());
	}
	public byte getId()
	{
		return 8;
	}
	public ElementTagByte copy()
	{
		byte data = this.data;
		return new ElementTagByte(data);
	}
	public int toInteger()
	{
		return this.data;
	}
	public short toShort()
	{
		return (short) this.data;
	}
	public long toLong()
	{
		return (long) this.data;
	}
	public byte toByte()
	{
		return (byte) this.data;
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
		return String.valueOf(toByte());
	}
}
