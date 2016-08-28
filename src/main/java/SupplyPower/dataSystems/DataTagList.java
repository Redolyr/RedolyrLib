package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataTagList extends DataBase {

    private List<DataBase> data = new ArrayList<DataBase>();

    private boolean isVisibled = false;

    public DataTagList() {
    }

    public DataTagList(boolean isVisibled) {
        this.isVisibled = isVisibled;
    }

    private DataTagList(List<DataBase> data) {
        this.data = data;
    }

    void write(DataOutput par1) throws IOException {
        par1.writeInt(this.data.size());
        for (DataBase base : this.data) {
            par1.writeByte(base.getId());
            base.write(par1);
        }
    }

    void read(DataInput par1) throws IOException {
        this.data = new ArrayList();
        int size = par1.readInt();
        for (int len = 0; len < size; len++) {
            DataBase keys = DataBase.toTags(par1.readByte());
            keys.read(par1);
            this.data.add(keys);
        }
    }

    public byte getId() {
        return 2;
    }

    public DataTagList copy() {
        List<DataBase> data = new ArrayList<DataBase>();
        for (DataBase datas : this.data) data.add(datas);
        return new DataTagList(data);
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagList)) return false;
        if (this.data.size() != ((DataTagList) o).data.size()) return false;

        for (int len = 0; len < this.data.size(); ++len) {
            if (!this.data.get(len).equals(((DataTagList) o).data.get(len))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return String.format("%s%s", this.isVisibled ? getSimpleClassName() + ":" : "", this.data.toString());
    }

    public boolean hasKey(int len) {
        return this.data.contains(len);
    }

    public boolean hasKey(int len, int id) {
        DataBase base = hasKey(len) ? this.data.get(len) : null;
        return base != null ? (base.getId() == id) : false;
    }

    public void appendTag(DataBase par1) {
        this.data.add(par1);
    }

    public void appendString(String par1) {
        this.appendTag(new DataTagString(par1));
    }

    public void appendChar(char value) {
        this.appendTag(new DataTagCharacter(value));
    }

    public void appendInteger(int value) {
        this.appendTag(new DataTagInteger(value));
    }

    public void appendShort(short value) {
        this.appendTag(new DataTagShort(value));
    }

    public void appendLong(long value) {
        this.appendTag(new DataTagLong(value));
    }

    public void appendByte(byte value) {
        this.appendTag(new DataTagByte(value));
    }

    public void appendDouble(double value) {
        this.appendTag(new DataTagDouble(value));
    }

    public void appendFloat(float value) {
        this.appendTag(new DataTagFloat(value));
    }

    public void appendBoolean(boolean value) {
        this.appendTag(new DataTagBoolean(value));
    }

    public void appendStringArray(String[] par1) {
        this.appendTag(new DataTagStringArray(par1));
    }

    public void appendCharArray(char[] value) {
        this.appendTag(new DataTagCharacterArray(value));
    }

    public void appendIntegerArray(int[] value) {
        this.appendTag(new DataTagIntegerArray(value));
    }

    public void appendShortArray(short[] value) {
        this.appendTag(new DataTagShortArray(value));
    }

    public void appendLongArray(long[] value) {
        this.appendTag(new DataTagLongArray(value));
    }

    public void appendByteArray(byte[] value) {
        this.appendTag(new DataTagByteArray(value));
    }

    public void appendDoubleArray(double[] value) {
        this.appendTag(new DataTagDoubleArray(value));
    }

    public void appendFloatArray(float[] value) {
        this.appendTag(new DataTagFloatArray(value));
    }

    public void appendBooleanArray(boolean[] value) {
        this.appendTag(new DataTagBooleanArray(value));
    }

    public DataBase getTag(int len) {
        return this.data.get(len);
    }

    public <T> T getTag(int len, int id, Object dataBase) {
        try {
            return (T) (len >= 0 && len < this.data.size() ? (hasKey(len, id) ? this.getTag(len) : dataBase) : dataBase);
        } catch (ClassCastException exception) {
            return (T) dataBase;
        }
    }

    public DataTagCompound getCompound(int len) {
        return this.getTag(len, 1, new DataTagCompound());
    }

    public DataTagList getList(int len) {
        return this.getTag(len, 2, new DataTagList());
    }

    public String getString(int len) {
        return ((DataTagString) this.getTag(len, 3, "")).getString();
    }

    public char getChar(int len) {
        return ((DataTagCharacter) this.getTag(len, 4, '\b')).getChar();
    }

    public int getInteger(int len) {
        return ((DataTagInteger) this.getTag(len, 5, 0)).toInteger();
    }

    public short getShort(int len) {
        return ((DataTagShort) this.getTag(len, 6, 0)).toShort();
    }

    public long getLong(int len) {
        return ((DataTagLong) this.getTag(len, 7, 0L)).toLong();
    }

    public byte getByte(int len) {
        return ((DataTagByte) this.getTag(len, 8, 0)).toByte();
    }

    public double getDouble(int len) {
        return ((DataTagDouble) this.getTag(len, 9, 0.0D)).toDouble();
    }

    public float getFloat(int len) {
        return ((DataTagFloat) this.getTag(len, 10, 0.0F)).toFloat();
    }

    public boolean getBoolean(int len) {
        return ((DataTagBoolean) this.getTag(len, 11, false)).getBoolean();
    }

    public String[] getStringArray(int len) {
        return ((DataTagStringArray) this.getTag(len, 12, new String[0])).getStringArray();
    }

    public char[] getCharacterArray(int len) {
        return ((DataTagCharacterArray) this.getTag(len, 13, new char[0])).getCharArray();
    }

    public int[] getIntegerArray(int len) {
        return ((DataTagIntegerArray) this.getTag(len, 14, new int[0])).toIntegerArray();
    }

    public short[] getShortArray(int len) {
        return ((DataTagShortArray) this.getTag(len, 15, new short[0])).toShortArray();
    }

    public long[] getLongArray(int len) {
        return ((DataTagLongArray) this.getTag(len, 16, new long[0])).toLongArray();
    }

    public byte[] getByteArray(int len) {
        return ((DataTagByteArray) this.getTag(len, 17, new byte[0])).toByteArray();
    }

    public double[] getDoubleArray(int len) {
        return ((DataTagDoubleArray) this.getTag(len, 18, new double[0])).toDoubleArray();
    }

    public float[] getFloatArray(int len) {
        return ((DataTagFloatArray) this.getTag(len, 19, new float[0])).toFloatArray();
    }

    public boolean[] getBooleanArray(int len) {
        return ((DataTagBooleanArray) this.getTag(len, 20, new boolean[0])).getBooleanArray();
    }

    public void remove(int len) {
        this.data.remove(len);
    }

    public int count() {
        return this.data.size();
    }
}
