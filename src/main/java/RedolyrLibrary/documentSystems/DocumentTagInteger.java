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
public class DocumentTagInteger extends DocumentBasePrimitive {
    private int data;

    DocumentTagInteger() {
    }

    public DocumentTagInteger(int data) {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setTextContent(this.data + "");
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        this.data = Integer.parseInt(par2.getTextContent());
    }

    public byte getId() {
        return 5;
    }

    public DocumentTagInteger copy() {
        return new DocumentTagInteger(this.data);
    }

    public int toInteger() {
        return this.data;
    }

    public short toShort() {
        return (short) (this.data & 65535);
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) (this.data & 255);
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public String toString() {
        return String.valueOf(toInteger());
    }
}
