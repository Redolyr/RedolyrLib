package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataTagBoolean extends DataBase {

    private boolean data;

    protected DataTagBoolean() {
    }

    public DataTagBoolean(boolean par1) {
        this.data = par1;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeBoolean(this.data);
    }

    void read(DataInput par1) throws IOException {
        this.data = par1.readBoolean();
    }

    public byte getId() {
        return 11;
    }

    public DataTagBoolean copy() {
        boolean data = this.data ? true : false;
        return new DataTagBoolean(data);
    }

    public boolean getBoolean() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagBoolean)) return false;
        return this.data == ((DataTagBoolean) o).data;
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}
