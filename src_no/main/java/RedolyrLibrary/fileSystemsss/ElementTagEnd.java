package RedolyrLibrary.fileSystems;

import org.w3c.dom.Element;

import java.io.IOException;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ElementTagEnd extends DataBase
{
    void write(final Element par1) throws IOException {}

    void read(final Element par1) throws IOException {}

    public byte getId()
    {
        return 0;
    }

    public ElementTagEnd copy()
    {
        return new ElementTagEnd();
    }
}
