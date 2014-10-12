package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagCharacterArray extends DataBase
{
	private char[] data;
	ElementTagCharacterArray() {}
	public ElementTagCharacterArray(char[] par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeChar(this.data[len]);
	}
	void read(final Element par1) throws IOException
	{
		for (int len = 0; len < par1.readInt(); len++) this.data[len] = par1.readChar();
	}
	public byte getId()
	{
		return 13;
	}
	public ElementTagCharacterArray copy()
	{
		char[] data = new char[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new ElementTagCharacterArray(data);
	}
	public char[] getCharArray()
	{
		return this.data;
	}
	public String toString()
	{
		StringBuilder tsb = new StringBuilder();
		for (int len = 0; len < getCharArray().length; len++) tsb.append(getCharArray()[len]).append(len != getCharArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
