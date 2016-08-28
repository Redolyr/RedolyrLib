package SupplyPower.documentSystems;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DocumentTagDoubleArray extends DocumentBasePrimitiveArray {

    private double[] data;
    private final String entryName = "doublesEntry";
    private final String entriesName = "doublesEntries";

    protected DocumentTagDoubleArray() {
    }

    public DocumentTagDoubleArray(double[] data) {
        this.data = data;
    }

    public int length() {
        return this.data.length;
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setAttribute("length", String.valueOf(this.data.length));
        Element element = par1.createElement(this.entriesName);
        for (int len = 0; len < this.data.length; ++len) {
            double data = this.data[len];
            Element element1 = par1.createElement(this.entryName + String.valueOf(len));
            element1.setAttribute("index", String.valueOf(len));
            element1.setTextContent(String.valueOf(data));
            element.appendChild(element1);
        }
        par2.appendChild(element);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        int length = Integer.valueOf(par2.getAttribute("length"));
        this.data = new double[length];
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (!(node instanceof Element && node.getNodeName().equals(this.entriesName))) continue;
            NodeList nodeList1 = node.getChildNodes();
            for (int len1 = 0; len1 < length; ++len1) {
                Node node1 = nodeList1.item(len1);
                if (node1 instanceof Element && node1.getNodeName().equals(this.entryName + String.valueOf(len1)))
                    this.data[len1] = Double.parseDouble(node1.getTextContent());
            }
        }
    }

    public byte getId() {
        return 18;
    }

    public DocumentTagDoubleArray copy() {
        return new DocumentTagDoubleArray(this.data);
    }

    public int[] toIntegerArray() {
        int[] data = new int[this.data.length];
        for (int len = 0; len < this.data.length; len++)
            data[len] = (this.data[len] < (float) ((int) this.data[len]) ? (int) this.data[len] - 1 : (int) this.data[len]);
        return data;
    }

    public short[] toShortArray() {
        short[] data = new short[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (short) (toIntegerArray()[len] & 65535);
        return data;
    }

    public long[] toLongArray() {
        long[] data = new long[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (long) this.data[len];
        return data;
    }

    public byte[] toByteArray() {
        byte[] data = new byte[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (byte) (toIntegerArray()[len] & 255);
        return data;
    }

    public double[] toDoubleArray() {
        double[] data = new double[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = this.data[len];
        return data;
    }

    public float[] toFloatArray() {
        float[] data = new float[this.data.length];
        for (int len = 0; len < this.data.length; len++) data[len] = (float) this.data[len];
        return data;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagDoubleArray)) return false;

        return Arrays.equals(this.data, ((DocumentTagDoubleArray) o).data);
    }

    public String toString() {
        StringBuilder tsb = new StringBuilder();
        for (int len = 0; len < toDoubleArray().length; len++)
            tsb.append(toDoubleArray()[len]).append(len != toDoubleArray().length - 1 ? ", " : "");
        return "[" + tsb + "]";
    }
}