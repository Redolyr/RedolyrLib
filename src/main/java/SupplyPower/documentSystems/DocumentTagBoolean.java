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
public class DocumentTagBoolean extends DocumentBase {

    private boolean data;

    protected DocumentTagBoolean() {
    }

    public DocumentTagBoolean(boolean data) {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setTextContent(this.data + "");
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        this.data = Boolean.parseBoolean(par2.getTextContent());
    }

    public byte getId() {
        return 11;
    }

    public DocumentTagBoolean copy() {
        return new DocumentTagBoolean(this.data);
    }

    public boolean getBoolean() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagBoolean)) return false;

        return this.data == ((DocumentTagBoolean) o).data;
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}
