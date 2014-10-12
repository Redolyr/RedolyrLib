package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagString extends DataBase
{
	private String data;
	public ElementTagString() {}
	public ElementTagString(String par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(this.data + "");
    }
    void read(final Element par1) throws IOException
    {
        this.data = par1.getTextContent();
    }
	public byte getId()
	{
		return 3;
	}
	public ElementTagString copy()
	{
		String data = this.data;
		return new ElementTagString(data);
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
