package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagBooleanArray extends DataBase
{
	private boolean data[];
	ElementTagBooleanArray() {}
	public ElementTagBooleanArray(boolean[] par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeBoolean(this.data[len]);
	}
	void read(final Element par1) throws IOException
	{
		for (int len = 0; len < par1.readInt(); len++) this.data[len] = par1.readBoolean();
	}
	public byte getId()
	{
		return 20;
	}
	public ElementTagBooleanArray copy()
	{
		boolean[] data = new boolean[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new ElementTagBooleanArray(data);
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
