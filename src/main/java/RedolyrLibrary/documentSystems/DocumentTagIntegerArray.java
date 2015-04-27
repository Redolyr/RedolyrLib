package RedolyrLibrary.documentSystems;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by redolyr on 2014/11/18.
 */
public class DocumentTagIntegerArray extends DocumentBasePrimitiveArray {
    private int[] data;
    private final String entryName = "integersEntry";
    private final String entriesName = "integersEntries";

    DocumentTagIntegerArray() {
    }

    public DocumentTagIntegerArray(int[] data) {
        this.data = data;
    }

    public int length() {
        return this.data.length;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setAttribute("length", String.valueOf(this.data.length));
        Element element = par1.createElement(entriesName);
        for (int len = 0; len < this.data.length; ++len) {
            int data = this.data[len];
            Element element1 = par1.createElement(entryName + String.valueOf(len));
            element1.setAttribute("index", String.valueOf(len));
            element1.setTextContent(String.valueOf(data));
            element.appendChild(element1);
        }
        par2.appendChild(element);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        int length = Integer.valueOf(par2.getAttribute("length"));
        this.data = new int[length];
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
                                this.data[len1] = Integer.parseInt(element1.getTextContent());
                        }
                    }
                }
            }
        }
    }

    public byte getId() {
        return 14;
    }

    public DocumentTagIntegerArray copy() {
        return new DocumentTagIntegerArray(this.data);
    }

    public int[] toIntegerArray() {
        return this.data;
    }

    public short[] toShortArray() {
        short[] data = new short[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (short) (this.data[len] & 65535);
        return data;
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
        for (int len = 0; len < toIntegerArray().length; len++)
            tsb.append(toIntegerArray()[len]).append(len != toIntegerArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}
