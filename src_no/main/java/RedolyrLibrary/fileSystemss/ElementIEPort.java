package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public final class ElementIEPort implements ElementExport, ElementImport
{
    private Object object;

    public void write(Object object)
    {
        this.object = object;
    }

    public void writeString(String string)
    {
        this.write(string);
    }

    public void writeCharacter(char achar)
    {
        this.write(achar);
    }

    public void writeInteger(int integer)
    {
        this.write(integer);
    }

    public void writeShort(short ashort)
    {
        this.write(ashort);
    }

    public void writeLong(long along)
    {
        this.write(along);
    }

    public void writeByte(byte abyte)
    {
        this.write(abyte);
    }

    public void writeDouble(double adouble)
    {
        this.write(adouble);
    }

    public void writeFloat(float afloat)
    {
        this.write(afloat);
    }

    public void writeBoolean(boolean aboolean)
    {
        this.write(aboolean);
    }

    public Object read()
    {
        return this.object;
    }

    public String readString()
    {
        return String.valueOf(read());
    }

    public char readCharacter()
    {
        return Character.highSurrogate(Integer.valueOf(this.readString()));
    }

    public int readInteger()
    {
        return Integer.valueOf((Integer) this.read());
    }

    public short readShort()
    {
        return Short.valueOf((Short) this.read());
    }

    public long readLong()
    {
        return Long.valueOf((Long) this.read());
    }

    public byte readByte()
    {
        return Byte.valueOf((Byte) this.read());
    }

    public double readDouble()
    {
        return Double.valueOf((Double) this.read());
    }

    public float readFloat()
    {
        return Float.valueOf((Float) this.read());
    }

    public boolean readBoolean()
    {
        return Boolean.valueOf((Boolean) this.read());
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof ElementIEPort)) return false;

        ElementIEPort that = (ElementIEPort) o;

        if (object != null ? !object.equals(that.object) : that.object != null) return false;

        return true;
    }

    public int hashCode()
    {
        return object != null ? object.hashCode() : 0;
    }

    public String toString()
    {
        return "ElementIEPort{" +
                "object=" + object +
                '}';
    }
}
