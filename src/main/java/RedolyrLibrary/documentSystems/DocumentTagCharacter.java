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
public class DocumentTagCharacter extends DocumentBase
{
    private char data;

    DocumentTagCharacter() {}

    public DocumentTagCharacter(char data)
    {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException
    {
        par2.setTextContent(this.data + "");
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException
    {
        this.data = par2.getTextContent().charAt(0);
    }

    public byte getId()
    {
        return 4;
    }

    public DocumentTagCharacter copy()
    {
        return new DocumentTagCharacter(this.data);
    }

    public char getChar()
    {
        return this.data;
    }

    public String toString()
    {
        return "'" + this.data + "'";
    }
}
