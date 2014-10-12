package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataTagCharacter extends DataBase
{
	private char data;
	DataTagCharacter() {}
	public DataTagCharacter(char par1)
	{
		this.data = par1;
	}
	void write(DataOutput par1) throws IOException
	{
		par1.writeChar(this.data);
	}
	void read(DataInput par1) throws IOException
	{
		this.data = par1.readChar();
	}
	public byte getId()
	{
		return 4;
	}
	public DataTagCharacter copy()
	{
		char data = this.data;
		return new DataTagCharacter(data);
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
