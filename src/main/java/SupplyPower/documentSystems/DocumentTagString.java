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
public class DocumentTagString extends DocumentBase {

    private String data;

    protected DocumentTagString() {
    }

    public DocumentTagString(String data) {
        this.data = data;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setTextContent(this.data);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        this.data = par2.getTextContent();
    }

    public byte getId() {
        return 3;
    }

    public DocumentTagString copy() {
        return new DocumentTagString(this.data);
    }

    public String getString() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagString)) return false;

        return this.data.equals(((DocumentTagString) o).data);
    }

    public String toString() {
        return "\"" + this.data + "\"";
    }
}
