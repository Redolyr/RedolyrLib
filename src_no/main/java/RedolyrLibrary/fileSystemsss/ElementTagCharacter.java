package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

public class ElementTagCharacter extends DataBase
{
	private char data;
	ElementTagCharacter() {}
	public ElementTagCharacter(char par1)
	{
		this.data = par1;
	}
    void write(final Element par1) throws IOException
    {
        par1.setTextContent(String.valueOf(Integer.valueOf(this.data)));
    }
    void read(final Element par1) throws IOException
    {
        this.data = Character.highSurrogate(Integer.valueOf(par1.getTextContent()));
    }
	public byte getId()
	{
		return 4;
	}
	public ElementTagCharacter copy()
	{
		char data = this.data;
		return new ElementTagCharacter(data);
	}
	public char getChar()
	{
		return this.data;
	}
	public String toString()
	{
		return "\'" + this.data + "\'";
	}
}
