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
public class DocumentTagFloat extends DocumentBasePrimitive {
    private float data;

    DocumentTagFloat() {
    }

    public DocumentTagFloat(float data) {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setTextContent(this.data + "");
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        this.data = Float.parseFloat(par2.getTextContent());
    }

    public byte getId() {
        return 10;
    }

    public DocumentTagFloat copy() {
        return new DocumentTagFloat(this.data);
    }

    public int toInteger() {
        return this.data < (float) ((int) this.data) ? (int) this.data - 1 : (int) this.data;
    }

    public short toShort() {
        return (short) (toInteger() & 65535);
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) (toInteger() & 255);
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return (float) this.data;
    }

    public String toString() {
        return String.valueOf(toFloat());
    }
}
