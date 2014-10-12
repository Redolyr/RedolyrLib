package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagInteger extends DataBasePrimitive
{
	private int data;
	DataTagInteger() {}
	public DataTagInteger(int par1)
	{
		this.data = par1;
	}
	void write(DataOutput par1) throws IOException
	{
		par1.writeInt(this.data);
	}
	void read(DataInput par1) throws IOException
	{
		this.data = par1.readInt();
	}
	public byte getId()
	{
		return 5;
	}
	public DataTagInteger copy()
	{
		int data = this.data;
		return new DataTagInteger(data);
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
