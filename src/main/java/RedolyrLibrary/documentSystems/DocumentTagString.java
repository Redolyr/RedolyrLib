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
public class DocumentTagString extends DocumentBase
{
    private String data;

    DocumentTagString() {}

    public DocumentTagString(String data)
    {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException
    {
        par2.setTextContent(this.data);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException
    {
        this.data = par2.getTextContent();
    }

    public byte getId()
    {
        return 3;
    }

    public DocumentTagString copy()
    {
        return new DocumentTagString(this.data);
    }

    public String getString()
    {
        return this.data;
    }

    public String toString()
    {
        return "\"" + this.data + "\"";
    }
}
