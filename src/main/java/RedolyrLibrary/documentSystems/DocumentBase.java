package RedolyrLibrary.documentSystems;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by redolyr on 2014/11/17.
 */
public abstract class DocumentBase {
    public static final String[] toTagsNames = new String[]{"End", "Compound", "List", "String", "Character", "Integer", "Short", "Long", "Byte", "Double", "Float", "Boolean", "StringArray", "CharacterArray", "IntegerArray", "ShortArray", "LongArray", "ByteArray", "DoubleArray", "FloatArray", "BooleanArray"};
    public static final byte[] toTagsIds = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    abstract void write(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException;

    abstract void read(Document par1, Element par2) throws ParserConfigurationException, TransformerException, SAXException, DOMException;

    public abstract byte getId();

    public abstract <T extends DocumentBase> T copy();

    public String getSimpleClassName() {
        return this.getClass().getSimpleName();
    }

    public static DocumentBase toTags(byte id) {
        switch (id) {
            case 0:
                return new DocumentTagEnd();
            case 1:
                return new DocumentTagCompound();
            case 2:
                return new DocumentTagList();
            case 3:
                return new DocumentTagString();
            case 4:
                return new DocumentTagCharacter();
            case 5:
                return new DocumentTagInteger();
            case 6:
                return new DocumentTagShort();
            case 7:
                return new DocumentTagLong();
            case 8:
                return new DocumentTagByte();
            case 9:
                return new DocumentTagDouble();
            case 10:
                return new DocumentTagFloat();
            case 11:
                return new DocumentTagBoolean();
            case 12:
                return new DocumentTagStringArray();
            case 13:
                return new DocumentTagCharacterArray();
            case 14:
                return new DocumentTagIntegerArray();
            case 15:
                return new DocumentTagShortArray();
            case 16:
                return new DocumentTagLongArray();
            case 17:
                return new DocumentTagByteArray();
            case 18:
                return new DocumentTagDoubleArray();
            case 19:
                return new DocumentTagFloatArray();
            case 20:
                return new DocumentTagBooleanArray();
            default:
                return null;
        }
    }

    public static String toTagNames(byte id) {
        return toTags(id).getSimpleClassName();
    }
}
