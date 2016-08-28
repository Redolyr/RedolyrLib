package SupplyPower.documentSystems;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DocumentTagCompound extends DocumentBase {

    private Map<String, DocumentBase> data = new HashMap<String, DocumentBase>();

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        Iterator<String> iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            DocumentBase value = this.data.get(key);
            byte id = value.getId();
            Element element = par1.createElement(key.replace("/", "._").replace("\\", "_."));
            element.setAttribute("id", String.valueOf(id));
            value.write(par1, element);
            par2.appendChild(element);
        }
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (node instanceof Element) {
                Element element = (Element) node;
                String key = element.getNodeName().replace("._", "/").replace("_.", "\\");
                byte id = Byte.valueOf(element.getAttribute("id"));
                DocumentBase value = DocumentBase.toTags(id);
                value.read(par1, element);
                this.data.put(key, value);
            }
        }
    }

    public byte getId() {
        return 1;
    }

    public DocumentTagCompound copy() {
        DocumentTagCompound documentTagCompound = new DocumentTagCompound();
        Iterator<String> iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            DocumentBase value = this.data.get(key);
            documentTagCompound.data.put(key, value);
        }
        return documentTagCompound;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentTagCompound)) return false;
        if (this.data.size() != ((DocumentTagCompound) o).data.size()) return false;

        Iterator<String> dataBaseIterator = this.iterator();
        while (dataBaseIterator.hasNext()) {
            String key = dataBaseIterator.next();
            if (!((DocumentTagCompound) o).hasKey(key)) return false;
            if (!this.data.get(key).equals(((DocumentTagCompound) o).data.get(key))) return false;
        }
        return true;
    }

    public String toString() {
        return this.data.toString();
    }

    public Set<String> keySet() {
        return this.data.keySet();
    }

    public Iterator<String> iterator() {
        return this.data.keySet().iterator();
    }

    public void setTag(String key, DocumentBase value) {
        this.data.put(key, value);
    }

    public void setCompound(String key, DocumentTagCompound value) {
        this.setTag(key, value);
    }

    public void setList(String key, DocumentTagList value) {
        this.setTag(key, value);
    }

    public void setString(String key, String value) {
        this.setTag(key, new DocumentTagString(value));
    }

    public void setChar(String key, char value) {
        this.setTag(key, new DocumentTagCharacter(value));
    }

    public void setInteger(String key, int value) {
        this.setTag(key, new DocumentTagInteger(value));
    }

    public void setShort(String key, short value) {
        this.setTag(key, new DocumentTagShort(value));
    }

    public void setLong(String key, long value) {
        this.setTag(key, new DocumentTagLong(value));
    }

    public void setByte(String key, byte value) {
        this.setTag(key, new DocumentTagByte(value));
    }

    public void setDouble(String key, double value) {
        this.setTag(key, new DocumentTagDouble(value));
    }

    public void setFloat(String key, float value) {
        this.setTag(key, new DocumentTagFloat(value));
    }

    public void setBoolean(String key, boolean value) {
        this.setTag(key, new DocumentTagBoolean(value));
    }

    public void setStringArray(String key, String[] value) {
        this.setTag(key, new DocumentTagStringArray(value));
    }

    public void setCharArray(String key, char[] value) {
        this.setTag(key, new DocumentTagCharacterArray(value));
    }

    public void setIntegerArray(String key, int[] value) {
        this.setTag(key, new DocumentTagIntegerArray(value));
    }

    public void setShortArray(String key, short[] value) {
        this.setTag(key, new DocumentTagShortArray(value));
    }

    public void setLongArray(String key, long[] value) {
        this.setTag(key, new DocumentTagLongArray(value));
    }

    public void setByteArray(String key, byte[] value) {
        this.setTag(key, new DocumentTagByteArray(value));
    }

    public void setDoubleArray(String key, double[] value) {
        this.setTag(key, new DocumentTagDoubleArray(value));
    }

    public void setFloatArray(String key, float[] value) {
        this.setTag(key, new DocumentTagFloatArray(value));
    }

    public void setBooleanArray(String key, boolean[] value) {
        this.setTag(key, new DocumentTagBooleanArray(value));
    }

    public boolean hasKey(String key) {
        return this.data.containsKey(key);
    }

    public boolean hasKey(String key, int id) {
        DocumentBase base = hasKey(key) ? this.data.get(key) : null;
        return base != null ? (base.getId() == id) : false;
    }

    public DocumentBase getTag(String key) {
        return this.data.get(key);
    }

    public <T> T getTag(String key, int id, T cast) {
        try {
            Object object = this.getTag(key);
            if (!this.hasKey(key, id)) return cast;
            switch (id) {
                case 3:
                    object = ((DocumentTagString) this.getTag(key)).getString();
                    break;
                case 4:
                    object = ((DocumentTagCharacter) this.getTag(key)).getChar();
                    break;
                case 5:
                    object = ((DocumentTagInteger) this.getTag(key)).toInteger();
                    break;
                case 6:
                    object = ((DocumentTagShort) this.getTag(key)).toShort();
                    break;
                case 7:
                    object = ((DocumentTagLong) this.getTag(key)).toLong();
                    break;
                case 8:
                    object = ((DocumentTagByte) this.getTag(key)).toByte();
                    break;
                case 9:
                    object = ((DocumentTagDouble) this.getTag(key)).toDouble();
                    break;
                case 10:
                    object = ((DocumentTagFloat) this.getTag(key)).toFloat();
                    break;
                case 11:
                    object = ((DocumentTagBoolean) this.getTag(key)).getBoolean();
                    break;
                case 12:
                    object = ((DocumentTagStringArray) this.getTag(key)).getStringArray();
                    break;
                case 13:
                    object = ((DocumentTagCharacterArray) this.getTag(key)).getCharArray();
                    break;
                case 14:
                    object = ((DocumentTagIntegerArray) this.getTag(key)).toIntegerArray();
                    break;
                case 15:
                    object = ((DocumentTagShortArray) this.getTag(key)).toShortArray();
                    break;
                case 16:
                    object = ((DocumentTagLongArray) this.getTag(key)).toLongArray();
                    break;
                case 17:
                    object = ((DocumentTagByteArray) this.getTag(key)).toByteArray();
                    break;
                case 18:
                    object = ((DocumentTagDoubleArray) this.getTag(key)).toDoubleArray();
                    break;
                case 19:
                    object = ((DocumentTagFloatArray) this.getTag(key)).toFloatArray();
                    break;
                case 20:
                    object = ((DocumentTagBooleanArray) this.getTag(key)).getBooleanArray();
                    break;
            }
            return (T) (hasKey(key, id) ? object : cast);
        } catch (ClassCastException exception) {
            return cast;
        }
    }

    public DocumentTagCompound getCompound(String key) {
        return this.getTag(key, 1, new DocumentTagCompound());
    }

    public DocumentTagList getList(String key) {
        return this.getTag(key, 2, new DocumentTagList());
    }

    public String getString(String key) {
        return this.getTag(key, 3, "");
    }

    public char getCharacter(String key) {
        return this.getTag(key, 4, '\u0020');
    }

    public int getInteger(String key) {
        return this.getTag(key, 5, 0);
    }

    public short getShort(String key) {
        return this.getTag(key, 6, (short) (0 & 32767));
    }

    public long getLong(String key) {
        return this.getTag(key, 7, 0L);
    }

    public byte getByte(String key) {
        return this.getTag(key, 8, (byte) (0 & 127));
    }

    public double getDouble(String key) {
        return this.getTag(key, 9, 0);
    }

    public float getFloat(String key) {
        return this.getTag(key, 10, 0);
    }

    public boolean getBoolean(String key) {
        return this.getTag(key, 11, false);
    }

    public String[] getStringArray(String key) {
        return this.getTag(key, 12, new String[0]);
    }

    public char[] getCharacterArray(String key) {
        return this.getTag(key, 13, new char[0]);
    }

    public int[] getIntegerArray(String key) {
        return this.getTag(key, 14, new int[0]);
    }

    public short[] getShortArray(String key) {
        return this.getTag(key, 15, new short[0]);
    }

    public long[] getLongArray(String key) {
        return this.getTag(key, 16, new long[0]);
    }

    public byte[] getByteArray(String key) {
        return this.getTag(key, 17, new byte[0]);
    }

    public double[] getDoubleArray(String key) {
        return this.getTag(key, 18, new double[0]);
    }

    public float[] getFloatArray(String key) {
        return this.getTag(key, 19, new float[0]);
    }

    public boolean[] getBooleanArray(String key) {
        return this.getTag(key, 20, new boolean[0]);
    }

    public void removeTag(String key) {
        if (this.hasKey(key)) this.data.remove(key);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
