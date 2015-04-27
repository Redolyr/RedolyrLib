package RedolyrLibrary.documentSystems;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by redolyr on 2014/11/18.
 */
public class DocumentTagShortArray extends DocumentBasePrimitiveArray {
    private short[] data;
    private final String entryName = "shortsEntry";
    private final String entriesName = "shortsEntries";

    DocumentTagShortArray() {
    }

    public DocumentTagShortArray(short[] data) {
        this.data = data;
    }

    public int length() {
        return this.data.length;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setAttribute("length", String.valueOf(this.data.length));
        Element element = par1.createElement(entriesName);
        for (int len = 0; len < this.data.length; ++len) {
            short data = this.data[len];
            Element element1 = par1.createElement(entryName + String.valueOf(len));
            element1.setAttribute("index", String.valueOf(len));
            element1.setTextContent(String.valueOf(data));
            element.appendChild(element1);
        }
        par2.appendChild(element);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        int length = Integer.valueOf(par2.getAttribute("length"));
        this.data = new short[length];
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (node instanceof Element) {
                Element element = (Element) node;
                if (element.getNodeName().equals(entriesName)) ;
                {
                    NodeList nodeList1 = element.getChildNodes();
                    for (int len1 = 0; len1 < length; ++len1) {
                        Node node1 = nodeList1.item(len1);
                        if (node1 instanceof Element) {
                            Element element1 = (Element) node1;
                            if (element1.getNodeName().equals(entryName + String.valueOf(len1)))
                                this.data[len1] = Short.parseShort(element1.getTextContent());
                        }
                    }
                }
            }
        }
    }

    public byte getId() {
        return 15;
    }

    public DocumentTagShortArray copy() {
        return new DocumentTagShortArray(this.data);
    }

    public int[] toIntegerArray() {
        int[] data = new int[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public short[] toShortArray() {
        return this.data;
    }

    public long[] toLongArray() {
        long[] data = new long[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public byte[] toByteArray() {
        byte[] data = new byte[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (byte) (this.data[len] & 255);
        return data;
    }

    public double[] toDoubleArray() {
        double[] data = new double[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public float[] toFloatArray() {
        float[] data = new float[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < toShortArray().length; len++)
            tsb.append(toShortArray()[len]).append(len != toShortArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
