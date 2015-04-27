package RedolyrLibrary.documentSystems;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by redolyr on 2014/11/17.
 */
public class DocumentTagEnd extends DocumentBase
{
    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {}

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {}

    public byte getId()
    {
        return 0;
    }

    public DocumentTagEnd copy()
    {
        return new DocumentTagEnd();
    }
}
