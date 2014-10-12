package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ElementTagCharacter extends ElementBase
{
    private char data;

    ElementTagCharacter() {}
    public ElementTagCharacter(char data)
    {
        this.data = data;
    }

    void read(ElementImport elementImport)
    {
        this.data = elementImport.readCharacter();
    }

    void write(ElementExport elementExport)
    {
        elementExport.writeCharacter(this.data);
    }

    public byte getId()
    {
        return 4;
    }

    public ElementTagCharacter copy()
    {
        return new ElementTagCharacter(this.data);
    }

    public char getChar()
    {
        return this.data;
    }

    public String toString()
    {
        return "ElementTagCharacter{" +
                "data=" + data +
                '}';
    }
}
