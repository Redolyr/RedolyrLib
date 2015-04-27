package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class DataBase {
    public static final String[] toTagsNames = new String[]{"End", "Compound", "List", "String", "Character", "Integer", "Short", "Long", "Byte", "Double", "Float", "Boolean", "StringArray", "CharacterArray", "IntegerArray", "ShortArray", "LongArray", "ByteArray", "DoubleArray", "FloatArray", "BooleanArray"};
    public static final byte[] toTagsIds = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    abstract void write(DataOutput par1) throws IOException;

    abstract void read(DataInput par1) throws IOException;

    public abstract byte getId();

    public abstract <T extends DataBase> T copy();

    public String getSimpleClassName() {
        return this.getClass().getSimpleName();
    }

    public static DataBase toTags(byte id) {
        switch (id) {
            case 0:
                return new DataTagEnd();
            case 1:
                return new DataTagCompound();
            case 2:
                return new DataTagList();
            case 3:
                return new DataTagString();
            case 4:
                return new DataTagCharacter();
            case 5:
                return new DataTagInteger();
            case 6:
                return new DataTagShort();
            case 7:
                return new DataTagLong();
            case 8:
                return new DataTagByte();
            case 9:
                return new DataTagDouble();
            case 10:
                return new DataTagFloat();
            case 11:
                return new DataTagBoolean();
            case 12:
                return new DataTagStringArray();
            case 13:
                return new DataTagCharacterArray();
            case 14:
                return new DataTagIntegerArray();
            case 15:
                return new DataTagShortArray();
            case 16:
                return new DataTagLongArray();
            case 17:
                return new DataTagByteArray();
            case 18:
                return new DataTagDoubleArray();
            case 19:
                return new DataTagFloatArray();
            case 20:
                return new DataTagBooleanArray();
            default:
                return null;
        }
    }

    public static String toTagNames(byte id) {
        return toTags(id).getSimpleClassName();
    }
}
