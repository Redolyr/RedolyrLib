package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagBoolean extends DataBase
{
	private boolean data;
	ElementTagBoolean() {}
	public ElementTagBoolean(boolean par1)
	{
		this.data = par1;
	}
	void write(final Element par1) throws IOException
	{
        par1.setTextContent(this.data + "");
	}
	void read(final Element par1) throws IOException
	{
		this.data = Boolean.parseBoolean(par1.getTextContent());
	}
	public byte getId()
	{
		return 11;
	}
	public ElementTagBoolean copy()
	{
		boolean data = this.data ? true : false;
		return new ElementTagBoolean(data);
	}
	public boolean getBoolean()
	{
		return this.data;
	}
	public String toString()
	{
		return String.valueOf(this.data);
	}
}
