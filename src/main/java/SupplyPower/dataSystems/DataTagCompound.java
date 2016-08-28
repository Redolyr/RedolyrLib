package SupplyPower.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataTagCompound extends DataBase {

    private Map<String, DataBase> data = new HashMap<String, DataBase>();
    private boolean isVisible = false;

    public DataTagCompound() {
    }

    public DataTagCompound(boolean isVisible) {
        this.isVisible = isVisible;
    }

    private DataTagCompound(Map<String, DataBase> data) {
        this.data = data;
    }

    void write(DataOutput par1) throws IOException {
        Iterator<String> it = this.data.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            DataBase value = this.data.get(key);
            par1.writeByte(value.getId());
            par1.writeUTF(key);
            value.write(par1);
        }
        par1.writeByte(0);
    }

    void read(DataInput par1) throws IOException {
        this.data.clear();
        byte id;
        while ((id = par1.readByte()) != 0) {
            String key = par1.readUTF();
            DataBase value = DataBase.toTags(id);
            value.read(par1);
            this.data.put(key, value);
        }
    }

    public byte getId() {
        return 1;
    }

    public DataTagCompound copy() {
        Map<String, DataBase> data = new HashMap<String, DataBase>();
        Iterator<String> it = this.data.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            DataBase value = this.data.get(key);
            data.put(key, value);
        }
        return new DataTagCompound(data);
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DataTagCompound)) return false;
        if (this.data.size() != ((DataTagCompound) o).data.size()) return false;

        Iterator<String> dataBaseIterator = this.iterator();
        while (dataBaseIterator.hasNext()) {
            String key = dataBaseIterator.next();
            if (!((DataTagCompound) o).hasKey(key)) return false;
            if (!this.data.get(key).equals(((DataTagCompound) o).data.get(key))) return false;
        }
        return true;
    }

    public String toString() {
        return String.format("%s%s", isVisible ? getSimpleClassName() + ":" : "", this.data.toString());
    }

    public Set<String> keySet() {
        return this.data.keySet();
    }

    public Iterator<String> iterator() {
        return this.data.keySet().iterator();
    }

    public void setTag(String key, DataBase value) {
        this.data.put(key, value);
    }

    public void setCompound(String key, DataTagCompound value) {
        this.setTag(key, value);
    }

    public void setList(String key, DataTagList value) {
        this.setTag(key, value);
    }

    public void setString(String key, String value) {
        this.setTag(key, new DataTagString(value));
    }

    public void setChar(String key, char value) {
        this.setTag(key, new DataTagCharacter(value));
    }

    public void setInteger(String key, int value) {
        this.setTag(key, new DataTagInteger(value));
    }

    public void setShort(String key, short value) {
        this.setTag(key, new DataTagShort(value));
    }

    public void setLong(String key, long value) {
        this.setTag(key, new DataTagLong(value));
    }

    public void setByte(String key, byte value) {
        this.setTag(key, new DataTagByte(value));
    }

    public void setDouble(String key, double value) {
        this.setTag(key, new DataTagDouble(value));
    }

    public void setFloat(String key, float value) {
        this.setTag(key, new DataTagFloat(value));
    }

    public void setBoolean(String key, boolean value) {
        this.setTag(key, new DataTagBoolean(value));
    }

    public void setStringArray(String key, String[] value) {
        this.setTag(key, new DataTagStringArray(value));
    }

    public void setCharArray(String key, char[] value) {
        this.setTag(key, new DataTagCharacterArray(value));
    }

    public void setIntegerArray(String key, int[] value) {
        this.setTag(key, new DataTagIntegerArray(value));
    }

    public void setShortArray(String key, short[] value) {
        this.setTag(key, new DataTagShortArray(value));
    }

    public void setLongArray(String key, long[] value) {
        this.setTag(key, new DataTagLongArray(value));
    }

    public void setByteArray(String key, byte[] value) {
        this.setTag(key, new DataTagByteArray(value));
    }

    public void setDoubleArray(String key, double[] value) {
        this.setTag(key, new DataTagDoubleArray(value));
    }

    public void setFloatArray(String key, float[] value) {
        this.setTag(key, new DataTagFloatArray(value));
    }

    public void setBooleanArray(String key, boolean[] value) {
        this.setTag(key, new DataTagBooleanArray(value));
    }

    public boolean hasKey(String key) {
        return this.data.containsKey(key);
    }

    public boolean hasKey(String key, int id) {
        DataBase base = hasKey(key) ? this.data.get(key) : null;
        return base != null ? (base.getId() == id) : false;
    }

    public DataBase getTag(String key) {
        return this.data.get(key);
    }

    public <T> T getTag(String key, int id, T cast) {
        try {
            Object object = this.getTag(key);
            switch (id) {
                case 3:
                    object = ((DataTagString) this.getTag(key)).getString();
                    break;
                case 4:
                    object = ((DataTagCharacter) this.getTag(key)).getChar();
                    break;
                case 5:
                    object = ((DataTagInteger) this.getTag(key)).toInteger();
                    break;
                case 6:
                    object = ((DataTagShort) this.getTag(key)).toShort();
                    break;
                case 7:
                    object = ((DataTagLong) this.getTag(key)).toLong();
                    break;
                case 8:
                    object = ((DataTagByte) this.getTag(key)).toByte();
                    break;
                case 9:
                    object = ((DataTagDouble) this.getTag(key)).toDouble();
                    break;
                case 10:
                    object = ((DataTagFloat) this.getTag(key)).toFloat();
                    break;
                case 11:
                    object = ((DataTagBoolean) this.getTag(key)).getBoolean();
                    break;

                case 12:
                    object = ((DataTagStringArray) this.getTag(key)).getStringArray();
                    break;
                case 13:
                    object = ((DataTagCharacterArray) this.getTag(key)).getCharArray();
                    break;
                case 14:
                    object = ((DataTagIntegerArray) this.getTag(key)).toIntegerArray();
                    break;
                case 15:
                    object = ((DataTagShortArray) this.getTag(key)).toShortArray();
                    break;
                case 16:
                    object = ((DataTagLongArray) this.getTag(key)).toLongArray();
                    break;
                case 17:
                    object = ((DataTagByteArray) this.getTag(key)).toByteArray();
                    break;
                case 18:
                    object = ((DataTagDoubleArray) this.getTag(key)).toDoubleArray();
                    break;
                case 19:
                    object = ((DataTagFloatArray) this.getTag(key)).toFloatArray();
                    break;
                case 20:
                    object = ((DataTagBooleanArray) this.getTag(key)).getBooleanArray();
                    break;
            }
            return (T) (hasKey(key, id) ? object : cast);
        } catch (ClassCastException exception) {
            return cast;
        } catch (NullPointerException exception) {
            return cast;
        }
    }

    public DataTagCompound getCompound(String key) {
        return this.getTag(key, 1, new DataTagCompound());
    }

    public DataTagList getList(String key) {
        return this.getTag(key, 2, new DataTagList());
    }

    public String getString(String key) {
        return this.getTag(key, 3, "");
    }

    public char getCharacter(String key) {
        return this.getTag(key, 4, '\u0020');
    }

    public int getInteger(String key) {
        return this.getTag(key, 5, 0);
    }

    public short getShort(String key) {
        return this.getTag(key, 6, (short) (0 & 32767));
    }

    public long getLong(String key) {
        return this.getTag(key, 7, 0L);
    }

    public byte getByte(String key) {
        return this.getTag(key, 8, (byte) (0 & 127));
    }

    public double getDouble(String key) {
        return this.getTag(key, 9, 0D);
    }

    public float getFloat(String key) {
        return this.getTag(key, 10, 0);
    }

    public boolean getBoolean(String key) {
        return this.getTag(key, 11, false);
    }

    public String[] getStringArray(String key) {
        return this.getTag(key, 12, new String[0]);
    }

    public char[] getCharacterArray(String key) {
        return this.getTag(key, 13, new char[0]);
    }

    public int[] getIntegerArray(String key) {
        return this.getTag(key, 14, new int[0]);
    }

    public short[] getShortArray(String key) {
        return this.getTag(key, 15, new short[0]);
    }

    public long[] getLongArray(String key) {
        return this.getTag(key, 16, new long[0]);
    }

    public byte[] getByteArray(String key) {
        return this.getTag(key, 17, new byte[0]);
    }

    public double[] getDoubleArray(String key) {
        return this.getTag(key, 18, new double[0]);
    }

    public float[] getFloatArray(String key) {
        return this.getTag(key, 19, new float[0]);
    }

    public boolean[] getBooleanArray(String key) {
        return this.getTag(key, 20, new boolean[0]);
    }

    public void removeTag(String key) {
        if (this.hasKey(key)) this.data.remove(key);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
