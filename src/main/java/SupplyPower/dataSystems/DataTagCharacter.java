package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagCharacter extends DataBase {

	private char data;

	protected DataTagCharacter() {
	}

	public DataTagCharacter(char par1) {
		this.data = par1;
	}

	void write(DataOutput par1) throws IOException {
		par1.writeChar(this.data);
	}

	void read(DataInput par1) throws IOException {
		this.data = par1.readChar();
	}

	public byte getId() {
		return 4;
	}

	public DataTagCharacter copy() {
		char data = this.data;
		return new DataTagCharacter(data);
	}

	public char getChar() {
		return this.data;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof DataTagCharacter)) return false;
		return this.data == ((DataTagCharacter) o).data;
	}

	public String toString() {
		return "\'" + this.data + "\'";
	}
}
