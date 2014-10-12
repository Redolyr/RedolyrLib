package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ElementTagCompound extends DataBase
{
	private Map<String, DataBase> data = new HashMap<String, DataBase>();
	private boolean isVisibled = false;
	public ElementTagCompound() {}
	public ElementTagCompound(boolean isVisibled)
	{
		this.isVisibled = isVisibled;
	}
	private ElementTagCompound(Map<String, DataBase> data)
	{
		this.data = data;
	}
	void write(final Element par1) throws IOException
	{
		Iterator<String> it = this.data.keySet().iterator();
		while (it.hasNext())
		{
			String key = it.next();
			DataBase value = this.data.get(key);
            par1.setAttribute("id", value.getId() + "");
            par1.setAttribute("key", key);
			value.write(par1);
		}
        par1.setAttribute("id", "0");
	}
	void read(final Element par1) throws IOException
	{
		this.data.clear();
		byte id;
		while ((id = Byte.parseByte(par1.getAttribute("id"))) != 0)
		{
			String key = par1.getAttribute("key");
			DataBase value = DataBase.toTags(id);
			value.read(par1);
			this.data.put(key, value);
		}
	}
	public byte getId()
	{
		return 1;
	}
	public ElementTagCompound copy()
	{
		Map<String, DataBase> data = new HashMap<String, DataBase>();
		Iterator<String> it = this.data.keySet().iterator();
		while (it.hasNext())
		{
			String key = it.next();
			DataBase value = this.data.get(key);
			data.put(key, value);
		}
		return new ElementTagCompound(data);
	}
	public String toString()
	{
		return String.format("%s%s", isVisibled ? getSimpleClassName() + ":" : "", this.data.toString());
	}
	public Set<String> keySet()
	{
		return this.data.keySet();
	}
	public Iterator<String> itrator()
	{
		return this.data.keySet().iterator();
	}
	public void setTag(String key, DataBase value)
	{
		this.data.put(key, value);
	}
	public void setCompound(String key, ElementTagCompound value)
	{
		setTag(key, value);
	}
	public void setList(String key, ElementTagList value)
	{
		setTag(key, value);
	}
	public void setString(String key, String value)
	{
		setTag(key, new ElementTagString(value));
	}
	public void setChar(String key, char value)
	{
		setTag(key, new ElementTagCharacter(value));
	}
	public void setInteger(String key, int value)
	{
		setTag(key, new ElementTagInteger(value));
	}
	public void setShort(String key, short value)
	{
		setTag(key, new ElementTagShort(value));
	}
	public void setLong(String key, long value)
	{
		setTag(key, new ElementTagLong(value));
	}
	public void setByte(String key, byte value)
	{
		setTag(key, new ElementTagByte(value));
	}
	public void setDouble(String key, double value)
	{
		setTag(key, new ElementTagDouble(value));
	}
	public void setFloat(String key, float value)
	{
		setTag(key, new ElementTagFloat(value));
	}
	public void setBoolean(String key, boolean value)
	{
		setTag(key, new ElementTagBoolean(value));
	}
	public void setStringArray(String key, String[] value)
	{
		setTag(key, new ElementTagStringArray(value));
	}
	public void setCharArray(String key, char[] value)
	{
		setTag(key, new ElementTagCharacterArray(value));
	}
	public void setIntegerArray(String key, int[] value)
	{
		setTag(key, new ElementTagIntegerArray(value));
	}
	public void setShortArray(String key, short[] value)
	{
		setTag(key, new ElementTagShortArray(value));
	}
	public void setLongArray(String key, long[] value)
	{
		setTag(key, new ElementTagLongArray(value));
	}
	public void setByteArray(String key, byte[] value)
	{
		setTag(key, new ElementTagByteArray(value));
	}
	public void setDoubleArray(String key, double[] value)
	{
		setTag(key, new ElementTagDoubleArray(value));
	}
	public void setFloatArray(String key, float[] value)
	{
		setTag(key, new ElementTagFloatArray(value));
	}
	public void setBooleanArray(String key, boolean[] value)
	{
		setTag(key, new ElementTagBooleanArray(value));
	}
	public boolean hasKey(String key)
	{
		return this.data.containsKey(key);
	}
	public boolean hasKey(String key, int id)
	{
		DataBase base = hasKey(key) ? this.data.get(key) : null;
		return base != null ? (base.getId() == id) : false;
	}
	public DataBase getTag(String key)
	{
		return this.data.get(key);
	}
	public ElementTagCompound getCompound(String key)
	{
		try
		{
			return (ElementTagCompound) (hasKey(key, 1) ? getTag(key) : new ElementTagCompound());
		}
		catch (ClassCastException exception)
		{
			return new ElementTagCompound();
		}
	}
	public ElementTagList getList(String key)
	{
		try
		{
			return (ElementTagList) (hasKey(key, 2) ? getTag(key) : new ElementTagList());
		}
		catch (ClassCastException exception)
		{
			return new ElementTagList();
		}
	}
	public String getString(String key)
	{
		try
		{
			return (String) (hasKey(key, 3) ? getTag(key) + "": "");
		}
		catch (ClassCastException exception)
		{
			return "";
		}
	}
	public char getChar(String key)
	{
		try
		{
			return (char) (hasKey(key, 4) ? ((ElementTagCharacter) getTag(key)).getChar() : '\b');
		}
		catch (ClassCastException exception)
		{
			return '\b';
		}
	}
	
	public int getInteger(String key)
	{
		try
		{
			return (int) (hasKey(key, 5) ? ((ElementTagInteger) getTag(key)).toInteger() : 0);
		}
		catch (ClassCastException exception)
		{
			return 0;
		}
	}
	public short getShort(String key)
	{
		try
		{
			return (short) (hasKey(key, 6) ? ((ElementTagShort) getTag(key)).toShort() : 0);
		}
		catch (ClassCastException exception)
		{
			return 0;
		}
	}
	public long getLong(String key)
	{
		try
		{
			return (long) (hasKey(key, 7) ? ((ElementTagLong) getTag(key)).toLong() : 0L);
		}
		catch (ClassCastException exception)
		{
			return 0L;
		}
	}
	public byte getByte(String key)
	{
		try
		{
			return (byte) (hasKey(key, 8) ? ((ElementTagByte) getTag(key)).toByte() : 0);
		}
		catch (ClassCastException exception)
		{
			return 0;
		}
	}
	public double getDouble(String key)
	{
		try
		{
			return (double) (hasKey(key, 9) ? ((ElementTagDouble) getTag(key)).toDouble() : 0.0D);
		}
		catch (ClassCastException exception)
		{
			return 0.0D;
		}
	}
	public float getFloat(String key)
	{
		try
		{
			return (float) (hasKey(key, 10) ? ((ElementTagFloat) getTag(key)).toFloat() : 0.0F);
		}
		catch (ClassCastException exception)
		{
			return 0.0F;
		}
	}
	public boolean getBoolean(String key)
	{
		try
		{
			return (boolean) (hasKey(key, 11) ? (((ElementTagBoolean) getTag(key)).getBoolean() ? true : false) : false);
		}
		catch (ClassCastException exception)
		{
			return false;
		}
	}
	public String[] getStringArray(String key)
	{
		try
		{
			return (String[]) (hasKey(key, 12) ? ((ElementTagStringArray) getTag(key)).getStringArray() : new String[0]);
		}
		catch (ClassCastException exception)
		{
			return new String[0];
		}
	}
	public char[] getCharacterArray(String key)
	{
		try
		{
			return (char[]) (hasKey(key, 13) ? ((ElementTagCharacterArray) getTag(key)).getCharArray() : new char[0]);
		}
		catch (ClassCastException exception)
		{
			return new char[0];
		}
	}
	public int[] getIntegerArray(String key)
	{
		try
		{
			return (int[]) (hasKey(key, 14) ? ((ElementTagIntegerArray) getTag(key)).toIntegerArray() : new int[0]);
		}
		catch (ClassCastException exception)
		{
			return new int[0];
		}
	}
	public short[] getShortArray(String key)
	{
		try
		{
			return (short[]) (hasKey(key, 15) ? ((ElementTagShortArray) getTag(key)).toShortArray() : new short[0]);
		}
		catch (ClassCastException exception)
		{
			return new short[0];
		}
	}
	public long[] getLongArray(String key)
	{
		try
		{
			return (long[]) (hasKey(key, 16) ? ((ElementTagLongArray) getTag(key)).toLongArray() : new long[0]);
		}
		catch (ClassCastException exception)
		{
			return new long[0];
		}
	}
	public byte[] getByteArray(String key)
	{
		try
		{
			return (byte[]) (hasKey(key, 17) ? ((ElementTagByteArray) getTag(key)).toByteArray() : new byte[0]);
		}
		catch (ClassCastException exception)
		{
			return new byte[0];
		}
	}
	public double[] getDoubleArray(String key)
	{
		try
		{
			return (double[]) (hasKey(key, 18) ? ((ElementTagDoubleArray) getTag(key)).toDoubleArray() : new double[0]);
		}
		catch (ClassCastException exception)
		{
			return new double[0];
		}
	}
	public float[] getFloatArray(String key)
	{
		try
		{
			return (float[]) (hasKey(key, 19) ? ((ElementTagFloatArray) getTag(key)).toFloatArray() : new float[0]);
		}
		catch (ClassCastException exception)
		{
			return new float[0];
		}
	}
	public boolean[] getBooleanArray(String key)
	{
		try
		{
			return (boolean[]) (hasKey(key, 20) ? ((ElementTagBooleanArray) getTag(key)).getBooleanArray() : new boolean[0]);
		}
		catch (ClassCastException exception)
		{
			return new boolean[0];
		}
	}
	public boolean isEmpty()
	{
		return this.data.isEmpty();
	}
}
