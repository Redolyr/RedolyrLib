package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ElementTagInteger extends ElementBasePrimitive
{
    private int data;

    ElementTagInteger() {}
    public ElementTagInteger(int data)
    {
        this.data = data;
    }

    void read(ElementImport elementImport)
    {
        this.data = elementImport.readInteger();
    }

    void write(ElementExport elementExport)
    {
        elementExport.writeInteger(this.data);
    }

    public byte getId()
    {
        return 5;
    }

    public ElementTagInteger copy()
    {
        return new ElementTagInteger(this.data);
    }

    public int toInteger()
    {
        return this.data;
    }

    public short toShort()
    {
        return (short) (this.data & 65535);
    }

    public long toLong()
    {
        return this.data;
    }

    public byte toByte()
    {
        return (byte) (this.data & 255);
    }

    public double toDouble()
    {
        return this.data;
    }

    public float toFloat()
    {
        return this.data;
    }


    public String toString()
    {
        return "ElementTagInteger{" +
                "data=" + data +
                '}';
    }
}
