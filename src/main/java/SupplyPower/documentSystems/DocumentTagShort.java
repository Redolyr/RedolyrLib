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
public class DocumentTagShort extends DocumentBasePrimitive {

    private short data;

    protected DocumentTagShort() {
    }

    public DocumentTagShort(short data) {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setTextContent(this.data + "");
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        this.data = Short.parseShort(par2.getTextContent());
    }

    public byte getId() {
        return 6;
    }

    public DocumentTagShort copy() {
        return new DocumentTagShort(this.data);
    }

    public int toInteger() {
        return (int) this.data;
    }

    public short toShort() {
        return this.data;
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

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagShort)) return false;

        return this.data == ((DocumentTagShort) o).data;
    }

    public String toString() {
        return String.valueOf(this.toShort());
    }
}
