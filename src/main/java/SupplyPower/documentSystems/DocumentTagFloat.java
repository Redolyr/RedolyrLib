package SupplyPower.documentSystems;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DocumentTagFloat extends DocumentBasePrimitive {

    private float data;

    protected DocumentTagFloat() {
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
        return (short) (this.toInteger() & 65535);
    }

    public long toLong() {
        return (long) this.data;
    }

    public byte toByte() {
        return (byte) (this.toInteger() & 255);
    }

    public double toDouble() {
        return (double) this.data;
    }

    public float toFloat() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagFloat)) return false;

        return this.data == ((DocumentTagFloat) o).data;
    }

    public String toString() {
        return String.valueOf(this.toFloat());
    }
}
