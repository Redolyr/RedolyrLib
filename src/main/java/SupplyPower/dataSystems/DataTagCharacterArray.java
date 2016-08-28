package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagCharacterArray extends DataBase {

	private char[] data;

	protected DataTagCharacterArray() {
	}

	public DataTagCharacterArray(char[] par1) {
		this.data = par1;
	}

	void write(DataOutput par1) throws IOException {
		par1.writeInt(this.data.length);
		for (int len = 0; len < this.data.length; len++) par1.writeChar(this.data[len]);
	}

	void read(DataInput par1) throws IOException {
		int length = par1.readInt();
		this.data = new char[length];
		for (int len = 0; len < length; len++) this.data[len] = par1.readChar();
	}

	public byte getId() {
		return 13;
	}

	public DataTagCharacterArray copy() {
		char[] data = new char[this.data.length];
		for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
		return new DataTagCharacterArray(data);
	}

	public int length() {
		return this.data.length;
	}

	public char[] getCharArray() {
		return this.data;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof DataTagCharacterArray)) return false;
		return Arrays.equals(this.data, ((DataTagCharacterArray) o).data);
	}

	public String toString() {
		StringBuilder tsb = new StringBuilder();
		for (int len = 0; len < getCharArray().length; len++)
			tsb.append(getCharArray()[len]).append(len != getCharArray().length - 1 ? ", " : "");
		return "[" + tsb + "]";
	}
}
