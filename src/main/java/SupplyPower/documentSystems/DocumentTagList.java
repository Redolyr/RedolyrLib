package SupplyPower.documentSystems;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DocumentTagList extends DocumentBase {
    
    private List<DocumentBase> data = new ArrayList<DocumentBase>();
    private final String entryName = "listEntry";
    private final String entriesName = "listEntries";

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        par2.setAttribute("length", String.valueOf(this.data.size()));
        Element element = par1.createElement(this.entriesName);
        for (int len = 0; len < this.data.size(); ++len) {
            Element element1 = par1.createElement(this.entryName + String.valueOf(len));
            element1.setAttribute("index", String.valueOf(len));
            DocumentBase documentBase = this.data.get(len);
            element1.setAttribute("id", String.valueOf(documentBase.getId()));
            documentBase.write(par1, element1);
            element.appendChild(element1);
        }
        par2.appendChild(element);
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        int length = Integer.valueOf(par2.getAttribute("length"));
        this.data = new ArrayList<DocumentBase>();
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (node instanceof Element) {
                Element element = (Element) node;
                if (element.getNodeName().equals(this.entriesName)) {
                    NodeList nodeList1 = element.getChildNodes();
                    for (int len1 = 0; len1 < length; ++len1) {
                        Node node1 = nodeList1.item(len1);
                        if (node1 instanceof Element) {
                            Element element1 = (Element) node1;
                            if (element1.getNodeName().equals(this.entryName + String.valueOf(len1))) {
                                this.data.add(len1, DocumentBase.toTags(Byte.parseByte(element1.getAttribute("id"))));
                                this.data.get(len1).read(par1, element1);
                            }
                        }
                    }
                }
            }
        }
    }

    public byte getId() {
        return 2;
    }

    public DocumentTagList copy() {
        DocumentTagList documentTagList = new DocumentTagList();
        for (DocumentBase documentBase : this.data) documentTagList.data.add(documentBase);
        return documentTagList;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagList)) return false;
        if (this.data.size() != ((DocumentTagList) o).data.size()) return false;

        for (int len = 0; len < this.data.size(); ++len) {
            if (!this.data.get(len).equals(((DocumentTagList) o).data.get(len))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return this.data.toString();
    }

    public boolean hasKey(int par1) {
        return this.data.contains(par1);
    }

    public boolean hasKey(int par1, int par2) {
        boolean haskey = this.hasKey(par1) && this.data.get(par1).getId() == par2;
        return haskey;
    }

    public void appendTag(DocumentBase par1) {
        this.data.add(par1);
    }

    public void appendString(String par1) {
        appendTag(new DocumentTagString(par1));
    }

    public void appendChar(char value) {
        appendTag(new DocumentTagCharacter(value));
    }

    public void appendInteger(int value) {
        appendTag(new DocumentTagInteger(value));
    }

    public void appendShort(short value) {
        appendTag(new DocumentTagShort(value));
    }

    public void appendLong(long value) {
        appendTag(new DocumentTagLong(value));
    }

    public void appendByte(byte value) {
        appendTag(new DocumentTagByte(value));
    }

    public void appendDouble(double value) {
        appendTag(new DocumentTagDouble(value));
    }

    public void appendFloat(float value) {
        appendTag(new DocumentTagFloat(value));
    }

    public void appendBoolean(boolean value) {
        appendTag(new DocumentTagBoolean(value));
    }

    public void appendStringArray(String[] par1) {
        appendTag(new DocumentTagStringArray(par1));
    }

    public void appendCharArray(char[] value) {
        appendTag(new DocumentTagCharacterArray(value));
    }

    public void appendIntegerArray(int[] value) {
        appendTag(new DocumentTagIntegerArray(value));
    }

    public void appendShortArray(short[] value) {
        appendTag(new DocumentTagShortArray(value));
    }

    public void appendLongArray(long[] value) {
        appendTag(new DocumentTagLongArray(value));
    }

    public void appendByteArray(byte[] value) {
        appendTag(new DocumentTagByteArray(value));
    }

    public void appendDoubleArray(double[] value) {
        appendTag(new DocumentTagDoubleArray(value));
    }

    public void appendFloatArray(float[] value) {
        appendTag(new DocumentTagFloatArray(value));
    }

    public void appendBooleanArray(boolean[] value) {
        appendTag(new DocumentTagBooleanArray(value));
    }

    public DocumentBase getTag(int par1) {
        return this.data.get(par1);
    }

    public <T> T getTag(int len, int id, Object dataBase) {
        try {
            return (T) (len >= 0 && len < this.data.size() ? (hasKey(len, id) ? getTag(len) : dataBase) : dataBase);
        } catch (ClassCastException exception) {
            return (T) dataBase;
        }
    }

    public DocumentTagCompound getCompound(int len) {
        return getTag(len, 1, new DocumentTagCompound());
    }

    public DocumentTagList getList(int len) {
        return getTag(len, 2, new DocumentTagList());
    }

    public String getString(int len) {
        return ((DocumentTagString) getTag(len, 3, "")).getString();
    }

    public char getChar(int len) {
        return ((DocumentTagCharacter) getTag(len, 4, '\b')).getChar();
    }

    public int getInteger(int len) {
        return ((DocumentTagInteger) getTag(len, 5, 0)).toInteger();
    }

    public short getShort(int len) {
        return ((DocumentTagShort) getTag(len, 6, 0)).toShort();
    }

    public long getLong(int len) {
        return ((DocumentTagLong) getTag(len, 7, 0L)).toLong();
    }

    public byte getByte(int len) {
        return ((DocumentTagByte) getTag(len, 8, 0)).toByte();
    }

    public double getDouble(int len) {
        return ((DocumentTagDouble) getTag(len, 9, 0.0D)).toDouble();
    }

    public float getFloat(int len) {
        return ((DocumentTagFloat) getTag(len, 10, 0.0F)).toFloat();
    }

    public boolean getBoolean(int len) {
        return ((DocumentTagBoolean) getTag(len, 11, false)).getBoolean();
    }

    public String[] getStringArray(int len) {
        return ((DocumentTagStringArray) getTag(len, 12, new String[0])).getStringArray();
    }

    public char[] getCharacterArray(int len) {
        return ((DocumentTagCharacterArray) getTag(len, 13, new char[0])).getCharArray();
    }

    public int[] getIntegerArray(int len) {
        return ((DocumentTagIntegerArray) getTag(len, 14, new int[0])).toIntegerArray();
    }

    public short[] getShortArray(int len) {
        return ((DocumentTagShortArray) getTag(len, 15, new short[0])).toShortArray();
    }

    public long[] getLongArray(int len) {
        return ((DocumentTagLongArray) getTag(len, 16, new long[0])).toLongArray();
    }

    public byte[] getByteArray(int len) {
        return ((DocumentTagByteArray) getTag(len, 17, new byte[0])).toByteArray();
    }

    public double[] getDoubleArray(int len) {
        return ((DocumentTagDoubleArray) getTag(len, 18, new double[0])).toDoubleArray();
    }

    public float[] getFloatArray(int len) {
        return ((DocumentTagFloatArray) getTag(len, 19, new float[0])).toFloatArray();
    }

    public boolean[] getBooleanArray(int len) {
        return ((DocumentTagBooleanArray) getTag(len, 20, new boolean[0])).getBooleanArray();
    }

    public void removeTag(int par1) {
        this.data.remove(par1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public Iterator<DocumentBase> iterator() {
        return this.data.iterator();
    }

    public int count() {
        return this.data.size();
    }
}
