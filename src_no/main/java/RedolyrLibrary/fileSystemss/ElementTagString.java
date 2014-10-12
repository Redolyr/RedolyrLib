package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ElementTagString extends ElementBase
{
    private String data;

    ElementTagString() {}
    public ElementTagString(String data)
    {
        this.data = data;
    }

    void read(ElementImport elementImport)
    {
        this.data = elementImport.readString();
    }

    void write(ElementExport elementExport)
    {
        elementExport.writeString(this.data);
    }

    public byte getId()
    {
        return 3;
    }

    public ElementTagString copy()
    {
        return new ElementTagString(this.data);
    }

    public String getString()
    {
        return this.data;
    }

    public String toString()
    {
        return "ElementTagString{" +
                "data='" + data + '\'' +
                '}';
    }
}
