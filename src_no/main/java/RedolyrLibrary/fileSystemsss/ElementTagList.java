package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElementTagList extends DataBase
{
	private List<DataBase> data = new ArrayList<DataBase>();;
    private byte dataType = 0;
	private boolean isVisibled = false;
	public ElementTagList() {}
	public ElementTagList(boolean isVisibled)
	{
		this.isVisibled = isVisibled;
	}
	private ElementTagList(List<DataBase> data)
	{
		this.data = data;
	}
	void write(final Element par1) throws IOException
	{
        if (!this.data.isEmpty()) this.dataType = this.data.get(0).getId();
        else this.dataType = 0;
        par1.writeByte(this.dataType);
        par1.writeInt(this.data.size());
        for (DataBase base : this.data) base.write(par1);
	}
	void read(final Element par1) throws IOException
	{
		this.dataType = par1.readByte();
		int size = par1.readInt();
        this.data = new ArrayList();
        for (int len = 0; len < size; len++)
        {
			DataBase keys = DataBase.toTags(this.dataType);
			keys.read(par1);
			this.data.add(keys);
        }
	}
	public byte getId()
	{
		return 2;
	}
	public ElementTagList copy()
	{
		List<DataBase> data = new ArrayList<DataBase>();
		for (DataBase datas : this.data) data.add(datas);
		return new ElementTagList(data);
	}
	public String toString()
	{
		return String.format("%s%s", isVisibled ? getSimpleClassName() + ":" : "", this.data.toString());
	}
	public boolean hasKey(int len)
	{
		return this.data.contains(len);
	}
	public boolean hasKey(int len, int id)
	{
		DataBase base = hasKey(len) ? this.data.get(len) : null;
		return base != null ? (base.getId() == id) : false;
	}
	public void appendTag(DataBase par1)
	{
        if (this.dataType == 0) this.dataType = par1.getId();
        else if (this.dataType != par1.getId()) return;
        this.data.add(par1);
	}
	public void appendString(String par1)
	{
		appendTag(new ElementTagString(par1));
	}
	public void appendChar(char value)
	{
		appendTag(new ElementTagCharacter(value));
	}
	public void appendInteger(int value)
	{
		appendTag(new ElementTagInteger(value));
	}
	public void appendShort(short value)
	{
		appendTag(new ElementTagShort(value));
	}
	public void appendLong(long value)
	{
		appendTag(new ElementTagLong(value));
	}
	public void appendByte(byte value)
	{
		appendTag(new ElementTagByte(value));
	}
	public void appendDouble(double value)
	{
		appendTag(new ElementTagDouble(value));
	}
	public void appendFloat(float value)
	{
		appendTag(new ElementTagFloat(value));
	}
	public void appendBoolean(boolean value)
	{
		appendTag(new ElementTagBoolean(value));
	}
	public void appendStringArray(String[] par1)
	{
		appendTag(new ElementTagStringArray(par1));
	}
	public void appendCharArray(char[] value)
	{
		appendTag(new ElementTagCharacterArray(value));
	}
	public void appendIntegerArray(int[] value)
	{
		appendTag(new ElementTagIntegerArray(value));
	}
	public void appendShortArray(short[] value)
	{
		appendTag(new ElementTagShortArray(value));
	}
	public void appendLongArray(long[] value)
	{
		appendTag(new ElementTagLongArray(value));
	}
	public void appendByteArray(byte[] value)
	{
		appendTag(new ElementTagByteArray(value));
	}
	public void appendDoubleArray(double[] value)
	{
		appendTag(new ElementTagDoubleArray(value));
	}
	public void appendFloatArray(float[] value)
	{
		appendTag(new ElementTagFloatArray(value));
	}
	public void appendBooleanArray(boolean[] value)
	{
		appendTag(new ElementTagBooleanArray(value));
	}
	public DataBase getTag(int len)
	{
		return this.data.get(len);
	}
	public <T> T getTag(int len, int id, Object dataBase)
	{
		try
		{
			return (T) (len >= 0 && len < this.data.size() ? (hasKey(len, id) ? getTag(len) : dataBase) : dataBase);
		}
		catch (ClassCastException exception)
		{
			return (T) dataBase;
		}
	}
	public ElementTagCompound getCompound(int len)
	{
		return getTag(len, 1, new ElementTagCompound());
	}
	public ElementTagList getList(int len)
	{
		return getTag(len, 2, new ElementTagList());
	}
	public String getString(int len)
	{
		return ((ElementTagString) getTag(len, 3, "")).getString();
	}
	public char getChar(int len)
	{
		return ((ElementTagCharacter) getTag(len, 4, '\b')).getChar();
	}
	public int getInteger(int len)
	{
		return ((ElementTagInteger) getTag(len, 5, 0)).toInteger();
	}
	public short getShort(int len)
	{
		return ((ElementTagShort) getTag(len, 6, 0)).toShort();
	}
	public long getLong(int len)
	{
		return ((ElementTagLong) getTag(len, 7, 0L)).toLong();
	}
	public byte getByte(int len)
	{
		return ((ElementTagByte) getTag(len, 8, 0)).toByte();
	}
	public double getDouble(int len)
	{
		return ((ElementTagDouble) getTag(len, 9, 0.0D)).toDouble();
	}
	public float getFloat(int len)
	{
		return ((ElementTagFloat) getTag(len, 10, 0.0F)).toFloat();
	}
	public boolean getBoolean(int len)
	{
		return ((ElementTagBoolean) getTag(len, 11, false)).getBoolean();
	}
	
	public String[] getStringArray(int len)
	{
		return ((ElementTagStringArray) getTag(len, 12, new String[0])).getStringArray();
	}
	public char[] getCharacterArray(int len)
	{
		return ((ElementTagCharacterArray) getTag(len, 13, new char[0])).getCharArray();
	}
	public int[] getIntegerArray(int len)
	{
		return ((ElementTagIntegerArray) getTag(len, 14, new int[0])).toIntegerArray();
	}
	public short[] getShortArray(int len)
	{
		return ((ElementTagShortArray) getTag(len, 15, new short[0])).toShortArray();
	}
	public long[] getLongArray(int len)
	{
		return ((ElementTagLongArray) getTag(len, 16, new long[0])).toLongArray();
	}
	public byte[] getByteArray(int len)
	{
		return ((ElementTagByteArray) getTag(len, 17, new byte[0])).toByteArray();
	}
	public double[] getDoubleArray(int len)
	{
		return ((ElementTagDoubleArray) getTag(len, 18, new double[0])).toDoubleArray();
	}
	public float[] getFloatArray(int len)
	{
		return ((ElementTagFloatArray) getTag(len, 19, new float[0])).toFloatArray();
	}
	public boolean[] getBooleanArray(int len)
	{
		return ((ElementTagBooleanArray) getTag(len, 20, new boolean[0])).getBooleanArray();
	}
	public void remove(int len)
	{
		this.data.remove(len);
	}
	public int count()
	{
		return this.data.size();
	}
}
