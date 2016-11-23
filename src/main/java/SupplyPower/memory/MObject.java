package SupplyPower.memory;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by redolyr on 2016/08/28.
 */
public class MObject {

    public MType type;
    public Object object;

    protected MObject(MType type) {
        this.type = type;
    }

    protected MObject(MType type, Object object) {
        this.type = type;
        this.object = object;
    }

    public MObject(boolean data) {
        this.type = MType.BOOLEAN;
        this.object = data;
    }

    public MObject(char data) {
        this.type = MType.CHAR;
        this.object = data;
    }

    public MObject(byte data) {
        this.type = MType.BYTE;
        this.object = data;
    }

    public MObject(short data) {
        this.type = MType.SHORT;
        this.object = data;
    }

    public MObject(int data) {
        this.type = MType.INTEGER;
        this.object = data;
    }

    public MObject(long data) {
        this.type = MType.LONG;
        this.object = data;
    }

    public MObject(float data) {
        this.type = MType.FLOAT;
        this.object = data;
    }

    public MObject(double data) {
        this.type = MType.DOUBLE;
        this.object = data;
    }

    public MObject(String data) {
        this.type = MType.STRING;
        this.object = data;
    }

    public MObject(boolean[] data) {
        this.type = MType.BOOLEAN_ARRAY;
        this.object = data;
    }

    public MObject(char[] data) {
        this.type = MType.CHAR_ARRAY;
        this.object = data;
    }

    public MObject(byte[] data) {
        this.type = MType.BYTE_ARRAY;
        this.object = data;
    }

    public MObject(short[] data) {
        this.type = MType.SHORT_ARRAY;
        this.object = data;
    }

    public MObject(int[] data) {
        this.type = MType.INTEGER_ARRAY;
        this.object = data;
    }

    public MObject(long[] data) {
        this.type = MType.LONG_ARRAY;
        this.object = data;
    }

    public MObject(float[] data) {
        this.type = MType.FLOAT_ARRAY;
        this.object = data;
    }

    public MObject(double[] data) {
        this.type = MType.DOUBLE_ARRAY;
        this.object = data;
    }

    public MObject(String[] data) {
        this.type = MType.STRING_ARRAY;
        this.object = data;
    }

    /**
     *
     * @param type LIST or COMPOUND only
     */
    public MObject(MType.MWType type) {
        this.type = type.type;
        this.object = type.equals(MType.MWType.LIST) ? new ArrayList<MObject>() : type.equals(MType.MWType.COMPOUND) ? new HashMap<String, MObject>() : null;
    }

    final void readList(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {

        String entryName = this.type.docTag;

        int length = Integer.valueOf(par2.getAttribute("length"));
        List<MObject> data = (List<MObject>) (this.object = new ArrayList<MObject>());
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (!(node instanceof Element)) continue;
            Element element = (Element) node;
            if (!element.getNodeName().equals(entryName)) continue;
            NodeList nodeList1 = element.getChildNodes();
            for (int len1 = 0; len1 < length; ++len1) {
                Node node1 = nodeList1.item(len1);
                if (!(node1 instanceof Element)) continue;
                Element element1 = (Element) node1;
                if (!element1.getNodeName().equals(entryName + String.valueOf(len1))) continue;
                data.add(len1, new MObject(MType.fromID(Byte.parseByte(element1.getAttribute("id")))));
                data.get(len1).read(par1, element1);
            }
        }
    }

    final void writeList(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        List<MObject> data = (List<MObject>) this.object;
        String entryName = this.type.docTag;

        par2.setAttribute("length", String.valueOf(data.size()));
        Element element = par1.createElement(entryName);
        for (int len = 0; len < data.size(); ++len) {
            Element element1 = par1.createElement(entryName + String.valueOf(len));
            MObject documentBase = data.get(len);
            element1.setAttribute("index", String.valueOf(len));
            element1.setAttribute("id", String.valueOf(documentBase.getId()));
            documentBase.write(par1, element1);
            element.appendChild(element1);
        }
        par2.appendChild(element);
    }

    final void readCompound(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        Map<String, MObject> data = (Map<String, MObject>) (this.object = new HashMap<String, MObject>());
        NodeList nodeList = par2.getChildNodes();
        for (int len = 0; len < nodeList.getLength(); ++len) {
            Node node = nodeList.item(len);
            if (!(node instanceof Element)) continue;
            Element element = (Element) node;
            MObject value = new MObject(MType.fromID(Byte.valueOf(element.getAttribute("id"))));
            value.read(par1, element);
            data.put(element.getNodeName().replace("._", "/").replace("_.", "\\"), value);
        }
    }

    final void writeCompound(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        Map<String, MObject> data = (Map<String, MObject>) this.object;
        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            MObject value = data.get(key);
            Element element = par1.createElement(key.replace("/", "._").replace("\\", "_."));
            element.setAttribute("id", String.valueOf(value.getId()));
            value.write(par1, element);
            par2.appendChild(element);
        }
    }

    final void writeCompound(DataOutput par1) throws IOException {
        Map data = (Map) this.object;
        Iterator<String> it = data.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            MObject value = (MObject) data.get(key);
            par1.writeByte(value.getId());
            par1.writeUTF(key);
            value.write(par1);
        }
        par1.writeByte(0);
    }

    final void readCompound(DataInput par1) throws IOException {
        Map data = (Map) this.object;
        data.clear();
        byte id;
        while ((id = par1.readByte()) != 0) {
            String key = par1.readUTF();
            MObject value = new MObject(MType.fromID(id));
            value.read(par1);
            data.put(key, value);
        }
    }

    final void writeList(DataOutput par1) throws IOException {
        List data = (List) this.object;
        par1.writeInt(data.size());
        for (int len = 0; len < data.size(); ++len) {
            MObject var0 = (MObject) data.get(len);
            par1.writeByte(var0.getId());
            var0.write(par1);
        }
    }

    final void readList(DataInput par1) throws IOException {
        List data = (List) (this.object = new ArrayList());
        int length = par1.readInt();
        for (int len = 0; len < length; len++) {
            MObject keys = new MObject(MType.fromID(par1.readByte()));
            keys.read(par1);
            data.add(keys);
        }
    }

    void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        if (this.type.maType.isArray && !(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST))) {
            Object[] objects = this.array();
            par2.setAttribute("length", String.valueOf(objects.length));
            Element element = par1.createElement(this.type.docTag);
            for (int len = 0; len < objects.length; ++len) {
                Object data = objects[len];
                Element element1 = par1.createElement(this.type.docTag + String.valueOf(len));
                element1.setAttribute("index", String.valueOf(len));
                element1.setTextContent(String.valueOf(data));
                element.appendChild(element1);
            }
            par2.appendChild(element);
        } else if (!(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST)) && (this.type.equals(MType.BOOLEAN) || this.type.equals(MType.CHAR) || this.type.equals(MType.BYTE) || this.type.equals(MType.SHORT) || this.type.equals(MType.INTEGER) || this.type.equals(MType.LONG) || this.type.equals(MType.FLOAT) || this.type.equals(MType.DOUBLE) || this.type.equals(MType.STRING))) {
            par2.setTextContent(this.object + "");
        } else if (this.type.equals(MType.COMPOUND)) {
            this.writeCompound(par1, par2);
        } else if (this.type.equals(MType.LIST)) {
            this.writeList(par1, par2);
        }
    }

    void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException {
        if (this.type.maType.isArray) {
            this.type = MType.fromDocTag(par2.getTagName());
            int length = Integer.valueOf(par2.getAttribute("length"));
            String[] data = new String[length];
            NodeList nodeList = par2.getChildNodes();
            for (int len = 0; len < nodeList.getLength(); ++len) {
                Node node = nodeList.item(len);
                if (!(node instanceof Element && node.getNodeName().equals(this.type.docTag))) continue;
                NodeList nodeList1 = node.getChildNodes();
                for (int len1 = 0; len1 < length; ++len1) {
                    Node node1 = nodeList1.item(len1);
                    if (node1 instanceof Element && node1.getNodeName().equals(this.type.docTag + String.valueOf(len1)))
                        data[len1] = node1.getTextContent();
                }
            }
            if (this.type.equals(MType.BOOLEAN_ARRAY)) {
                boolean[] obj = new boolean[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = data[len].equals("true") ? true : false;
                }
                this.object = obj;
            } else if (this.type.equals(MType.CHAR_ARRAY)) {
                char[] obj = new char[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = data[len].charAt(0);
                }
                this.object = obj;
            } else if (this.type.equals(MType.BYTE_ARRAY)) {
                byte[] obj = new byte[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = Byte.valueOf(data[len]);
                }
                this.object = obj;
            } else if (this.type.equals(MType.SHORT_ARRAY)) {
                short[] obj = new short[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = Short.valueOf(data[len]);
                }
                this.object = obj;
            } else if (this.type.equals(MType.INTEGER_ARRAY)) {
                int[] obj = new int[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = Integer.valueOf(data[len]);
                }
                this.object = obj;
            } else if (this.type.equals(MType.LONG_ARRAY)) {
                long[] obj = new long[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = Long.valueOf(data[len]);
                }
                this.object = obj;
            } else if (this.type.equals(MType.FLOAT_ARRAY)) {
                float[] obj = new float[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = Float.valueOf(data[len]);
                }
                this.object = obj;
            } else if (this.type.equals(MType.DOUBLE_ARRAY)) {
                double[] obj = new double[data.length];
                for (int len = 0; len < obj.length; ++len) {
                    obj[len] = Double.valueOf(data[len]);
                }
                this.object = obj;
            } else if (this.type.equals(MType.STRING_ARRAY)) {
                this.object = data;
            }
        } else if (!this.type.maType.isArray && !(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST))) {
            if (this.type.equals(MType.BOOLEAN)) {
                this.object = Boolean.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.CHAR)) {
                this.object = Character.valueOf(par2.getTextContent().charAt(0));
            } else if (this.type.equals(MType.BYTE)) {
                this.object = Byte.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.SHORT)) {
                this.object = Short.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.INTEGER)) {
                this.object = Integer.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.LONG)) {
                this.object = Long.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.FLOAT)) {
                this.object = Float.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.DOUBLE)) {
                this.object = Double.valueOf(par2.getTextContent());
            } else if (this.type.equals(MType.STRING)) {
                this.object = par2.getTextContent();
            }
        } else if (this.type.equals(MType.COMPOUND)) {
            this.readCompound(par1, par2);
        } else if (this.type.equals(MType.LIST)) {
            this.readList(par1, par2);
        }
    }

    void write(DataOutput par1) throws IOException {
        if (this.type.maType.isArray && !(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST))) {
            Object[] objects = this.array();
            par1.writeInt(objects.length);
            for (int len = 0; len < objects.length; len++) {
                if (this.type.equals(MType.BOOLEAN_ARRAY)) {
                    par1.writeBoolean((Boolean) objects[len]);
                } else if (this.type.equals(MType.CHAR_ARRAY)) {
                    par1.writeChar((Character) objects[len]);
                } else if (this.type.equals(MType.BYTE_ARRAY)) {
                    par1.writeByte((Byte) objects[len]);
                } else if (this.type.equals(MType.SHORT_ARRAY)) {
                    par1.writeShort((Short) objects[len]);
                } else if (this.type.equals(MType.INTEGER_ARRAY)) {
                    par1.writeInt((Integer) objects[len]);
                } else if (this.type.equals(MType.LONG_ARRAY)) {
                    par1.writeLong((Long) objects[len]);
                } else if (this.type.equals(MType.FLOAT_ARRAY)) {
                    par1.writeFloat((Float) objects[len]);
                } else if (this.type.equals(MType.DOUBLE_ARRAY)) {
                    par1.writeDouble((Double) objects[len]);
                } else if (this.type.equals(MType.STRING_ARRAY)) {
                    par1.writeUTF((String) objects[len]);
                }
            }
        } else if (!this.type.maType.isArray && !(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST))) {
            if (this.type.equals(MType.BOOLEAN)) {
                par1.writeBoolean((Boolean) this.object);
            } else if (this.type.equals(MType.CHAR)) {
                par1.writeChar((Character) this.object);
            } else if (this.type.equals(MType.BYTE)) {
                par1.writeByte((Byte) this.object);
            } else if (this.type.equals(MType.SHORT)) {
                par1.writeShort((Short) this.object);
            } else if (this.type.equals(MType.INTEGER)) {
                par1.writeInt((Integer) this.object);
            } else if (this.type.equals(MType.LONG)) {
                par1.writeLong((Long) this.object);
            } else if (this.type.equals(MType.FLOAT)) {
                par1.writeFloat((Float) this.object);
            } else if (this.type.equals(MType.DOUBLE)) {
                par1.writeDouble((Double) this.object);
            } else if (this.type.equals(MType.STRING)) {
                par1.writeUTF((String) this.object);
            }
        } else if (this.type.equals(MType.COMPOUND)) {
            this.writeCompound(par1);
        } else if (this.type.equals(MType.LIST)) {
            this.writeList(par1);
        }
    }

    void read(DataInput par1) throws IOException {
        if (this.type.maType.isArray && !(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST))) {
            int length = par1.readInt();
            Object objects = null;
            if (this.type.equals(MType.BOOLEAN_ARRAY)) {
                objects = Array.newInstance(boolean.class, length);
            } else if (this.type.equals(MType.CHAR_ARRAY)) {
                objects = Array.newInstance(char.class, length);
            } else if (this.type.equals(MType.BYTE_ARRAY)) {
                objects = Array.newInstance(byte.class, length);
            } else if (this.type.equals(MType.SHORT_ARRAY)) {
                objects = Array.newInstance(short.class, length);
            } else if (this.type.equals(MType.INTEGER_ARRAY)) {
                objects = Array.newInstance(int.class, length);
            } else if (this.type.equals(MType.LONG_ARRAY)) {
                objects = Array.newInstance(long.class, length);
            } else if (this.type.equals(MType.FLOAT_ARRAY)) {
                objects = Array.newInstance(float.class, length);
            } else if (this.type.equals(MType.DOUBLE_ARRAY)) {
                objects = Array.newInstance(double.class, length);
            } else if (this.type.equals(MType.STRING_ARRAY)) {
                objects = Array.newInstance(String.class, length);
            }
            for (int len = 0; len < length; len++) {
                if (this.type.equals(MType.BOOLEAN_ARRAY)) {
                    Array.set(objects, len, par1.readBoolean());
                } else if (this.type.equals(MType.CHAR_ARRAY)) {
                    Array.set(objects, len, par1.readChar());
                } else if (this.type.equals(MType.BYTE_ARRAY)) {
                    Array.set(objects, len, par1.readByte());
                } else if (this.type.equals(MType.SHORT_ARRAY)) {
                    Array.set(objects, len, par1.readShort());
                } else if (this.type.equals(MType.INTEGER_ARRAY)) {
                    Array.set(objects, len, par1.readInt());
                } else if (this.type.equals(MType.LONG_ARRAY)) {
                    Array.set(objects, len, par1.readLong());
                } else if (this.type.equals(MType.FLOAT_ARRAY)) {
                    Array.set(objects, len, par1.readFloat());
                } else if (this.type.equals(MType.DOUBLE_ARRAY)) {
                    Array.set(objects, len, par1.readDouble());
                } else if (this.type.equals(MType.STRING_ARRAY)) {
                    Array.set(objects, len, par1.readUTF());
                }
            }
            this.object = objects;
        } else if (!this.type.maType.isArray && !(this.type.equals(MType.COMPOUND) || this.type.equals(MType.LIST))) {
            if (this.type.equals(MType.BOOLEAN)) {
                this.object = par1.readBoolean();
            } else if (this.type.equals(MType.CHAR)) {
                this.object = par1.readChar();
            } else if (this.type.equals(MType.BYTE)) {
                this.object = par1.readByte();
            } else if (this.type.equals(MType.SHORT)) {
                this.object = par1.readShort();
            } else if (this.type.equals(MType.INTEGER)) {
                this.object = par1.readInt();
            } else if (this.type.equals(MType.LONG)) {
                this.object = par1.readLong();
            } else if (this.type.equals(MType.FLOAT)) {
                this.object = par1.readFloat();
            } else if (this.type.equals(MType.DOUBLE)) {
                this.object = par1.readDouble();
            } else if (this.type.equals(MType.STRING)) {
                this.object = par1.readUTF();
            }
        } else if (this.type.equals(MType.COMPOUND)) {
            this.readCompound(par1);
        } else if (this.type.equals(MType.LIST)) {
            this.readList(par1);
        }
    }

    public byte getId() {
        return this.type.id;
    }

    public MObject copy() {
        return new MObject(this.type, this.object);
    }

    public char getChar() {
        if (!this.type.equals(MType.CHAR)) return 0;
        return Character.valueOf((Character) this.object);
    }

    public byte getByte() {
        if (!this.type.equals(MType.BYTE)) return 0;
        return Byte.valueOf((Byte) this.object);
    }

    public short getShort() {
        if (!this.type.equals(MType.SHORT)) return 0;
        return Short.valueOf((String) this.object);
    }

    public int getInt() {
        if (!this.type.equals(MType.INTEGER)) return 0;
        return Integer.valueOf((Integer) this.object);
    }

    public long getLong() {
        if (!this.type.equals(MType.LONG)) return 0;
        return Long.valueOf((String) this.object);
    }

    public float getFloat() {
        if (!this.type.equals(MType.FLOAT)) return 0;
        return Float.valueOf((Float) this.object);
    }

    public double getDouble() {
        if (!this.type.equals(MType.DOUBLE)) return 0;
        return Double.valueOf((Double) this.object);
    }

    public String getString() {
        if (!this.type.equals(MType.STRING)) return "";
        return String.valueOf(this.object);
    }

    public char[] getCharArray() {
        if (!this.type.equals(MType.CHAR_ARRAY)) return new char[0];
        return (char[]) this.object;
    }

    public byte[] getByteArray() {
        if (!this.type.equals(MType.BYTE_ARRAY)) return new byte[0];
        return (byte[]) this.object;
    }

    public short[] getShortArray() {
        if (!this.type.equals(MType.SHORT_ARRAY)) return new short[0];
        return (short[]) this.object;
    }

    public int[] getIntegerArray() {
        if (!this.type.equals(MType.INTEGER_ARRAY)) return new int[0];
        return (int[]) this.object;
    }

    public long[] getLongArray() {
        if (!this.type.equals(MType.LONG_ARRAY)) return new long[0];
        return (long[]) this.object;
    }

    public float[] getFloatArray() {
        if (!this.type.equals(MType.FLOAT_ARRAY)) return new float[0];
        return (float[]) this.object;
    }

    public double[] getDoubleArray() {
        if (!this.type.equals(MType.DOUBLE_ARRAY)) return new double[0];
        return (double[]) this.object;
    }

    public String[] getStringArray() {
        if (!this.type.equals(MType.STRING_ARRAY)) return new String[0];
        return (String[]) this.object;
    }

    public List<MObject> getMList() {
        if (!this.type.equals(MType.LIST)) return null;
        return (List<MObject>) this.object;
    }

    public Map<String, MObject> getMMap() {
        if (!this.type.equals(MType.COMPOUND)) return null;
        return (Map<String, MObject>) this.object;
    }

    public int getArrayLength() {
        return Array.getLength(this.object);
    }

    public Object[] array() {
        Object[] objects = null;
        if (this.type.equals(MType.BOOLEAN_ARRAY)) {
            boolean[] array = (boolean[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.CHAR_ARRAY)) {
            char[] array = (char[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.BYTE_ARRAY)) {
            byte[] array = (byte[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.INTEGER_ARRAY)) {
            int[] array = (int[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.LONG_ARRAY)) {
            long[] array = (long[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.FLOAT_ARRAY)) {
            float[] array = (float[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.DOUBLE_ARRAY)) {
            double[] array = (double[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        } else if (this.type.equals(MType.STRING_ARRAY)) {
            String[] array = (String[]) this.object;
            objects = new Object[array.length];
            for (int len = 0; len < array.length; ++len) {
                objects[len] = array[len];
            }
        }
        return objects;
    }

    public String toString() {
        if (this.type.maType.isArray) {
            return Arrays.toString(this.array());
        }
        return this.object.toString();
    }
}
