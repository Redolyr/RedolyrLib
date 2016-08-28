package SupplyPower.documentSystems;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DocumentTagStringArray extends DocumentBaseArray {

    private String[] data;
    private final String entryName = "stringsEntry";
    private final String entriesName = "stringsEntries";

    protected DocumentTagStringArray() {
    }

    public DocumentTagStringArray(String[] data) {
        this.data = data;
    }

    public int length() {
        return this.data.length;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setAttribute("length", String.valueOf(this.data.length));
        Element element = par1.createElement(this.entriesName);
        for (int len = 0; len < this.data.length; ++len) {
            String data = this.data[len];
            Element element1 = par1.createElement(this.entryName + String.valueOf(len));
            element1.setAttribute("index", String.valueOf(len));
            element1.setTextContent(data);
            element.appendChild(element1);
        }
        par2.appendChild(element);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        int length = Integer.valueOf(par2.getAttribute("length"));
        this.data = new String[length];
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (!(node instanceof Element && node.getNodeName().equals(this.entriesName))) continue;
            NodeList nodeList1 = node.getChildNodes();
            for (int len1 = 0; len1 < length; ++len1) {
                Node node1 = nodeList1.item(len1);
                if (node1 instanceof Element && node1.getNodeName().equals(this.entryName + String.valueOf(len1)))
                    this.data[len1] = node1.getTextContent();
            }
        }
    }

    public byte getId() {
        return 12;
    }

    public DocumentTagStringArray copy() {
        return new DocumentTagStringArray(this.data);
    }

    public String[] getStringArray() {
        return this.data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagStringArray)) return false;

        return Arrays.equals(this.data, ((DocumentTagStringArray) o).data);
    }

    public String toString() {
        return Arrays.toString(this.data);
    }
}
