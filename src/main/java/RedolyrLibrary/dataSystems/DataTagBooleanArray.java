package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagBooleanArray extends DataBase
{
	private boolean data[];
	DataTagBooleanArray() {}
	public DataTagBooleanArray(boolean[] par1)
	{
		this.data = par1;
	}
	void write(DataOutput par1) throws IOException
	{
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeBoolean(this.data[len]);
	}
	void read(DataInput par1) throws IOException
	{
		for (int len = 0; len < par1.readInt(); len++) this.data[len] = par1.readBoolean();
	}
	public byte getId()
	{
		return 20;
	}
	public DataTagBooleanArray copy()
	{
		boolean[] data = new boolean[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new DataTagBooleanArray(data);
	}
    public int length()
    {
        return this.data.length;
    }
	public boolean[] getBooleanArray()
	{
		return this.data;
	}
	public String toString()
	{
		StringBuilder tsb = new StringBuilder();
		for (int len = 0; len < getBooleanArray().length; len++) tsb.append(getBooleanArray()[len]).append(len != getBooleanArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
