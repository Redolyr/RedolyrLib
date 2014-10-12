package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagString extends DataBase
{
	private String data;
	public DataTagString() {}
	public DataTagString(String par1)
	{
		this.data = par1;
	}
	void write(DataOutput par1) throws IOException
	{
		par1.writeUTF(this.data);
	}
	void read(DataInput par1) throws IOException
	{
		this.data = par1.readUTF();
	}
	public byte getId()
	{
		return 3;
	}
	public DataTagString copy()
	{
		String data = this.data;
		return new DataTagString(data);
	}
	public String getString()
	{
		return this.data;
	}
	public String toString()
	{
		return "\"" + data + "\"";
	}
}
