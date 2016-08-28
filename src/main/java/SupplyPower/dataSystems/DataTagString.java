package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagString extends DataBase {

	private String data;

	protected DataTagString() {
	}

	public DataTagString(String par1) {
		this.data = par1;
	}

	void write(DataOutput par1) throws IOException {
		par1.writeUTF(this.data);
	}

	void read(DataInput par1) throws IOException {
		this.data = par1.readUTF();
	}

	public byte getId() {
		return 3;
	}

	public DataTagString copy() {
		String data = this.data;
		return new DataTagString(data);
	}

	public String getString() {
		return this.data;
	}

	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof DataTagStringArray)) return false;
		return this.data.equals(((DataTagString) o).data);
	}

	public String toString() {
		return "\"" + data + "\"";
	}
}
