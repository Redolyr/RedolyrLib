package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagStringArray extends DataBase
{
	private String[] data;
	public ElementTagStringArray() {}
	public ElementTagStringArray(String[] par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeUTF(this.data[len]);
	}
	void read(final Element par1) throws IOException
	{
		for (int len = 0; len < par1.readInt(); len++) this.data[len] = par1.readUTF();
	}
	public byte getId()
	{
		return 12;
	}
	public ElementTagStringArray copy()
	{
		String[] data = new String[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new ElementTagStringArray(data);
	}
	public String[] getStringArray()
	{
		return this.data;
	}
	public String toString()
	{
		StringBuilder tsb = new StringBuilder();
		for (int len = 0; len < getStringArray().length; len++) tsb.append(getStringArray()[len]).append(len != getStringArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
