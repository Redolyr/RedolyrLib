package SupplyPower.memory;

/**
 * Created by redolyr on 2016/08/28.
 */
public enum MType {

    END((byte) 0, "endElement", MAType.NOT_ARRAY),
    BOOLEAN((byte) 1, "booleanElement", MAType.NOT_ARRAY),
    CHAR((byte) 2, "charElement", MAType.NOT_ARRAY),
    BYTE((byte) 3, "byteElement", MAType.NOT_ARRAY),
    SHORT((byte) 4, "shortElement", MAType.NOT_ARRAY),
    INTEGER((byte) 5, "integerElement", MAType.NOT_ARRAY),
    LONG((byte) 6, "longElement", MAType.NOT_ARRAY),
    FLOAT((byte) 7, "floatElement", MAType.NOT_ARRAY),
    DOUBLE((byte) 8, "doubleElement", MAType.NOT_ARRAY),
    STRING((byte) 9, "stringElement", MAType.NOT_ARRAY),
    BOOLEAN_ARRAY((byte) 10, "booleanArrayElement", MAType.ARRAY),
    CHAR_ARRAY((byte) 11, "charArrayElement", MAType.ARRAY),
    BYTE_ARRAY((byte) 12, "byteArrayElement", MAType.ARRAY),
    SHORT_ARRAY((byte) 13, "shortArrayElement", MAType.ARRAY),
    INTEGER_ARRAY((byte) 14, "integerArrayElement", MAType.ARRAY),
    LONG_ARRAY((byte) 15, "longArrayElement", MAType.ARRAY),
    FLOAT_ARRAY((byte) 16, "floatArrayElement", MAType.ARRAY),
    DOUBLE_ARRAY((byte) 17, "doubleArrayElement", MAType.ARRAY),
    STRING_ARRAY((byte) 18, "stringArrayElement", MAType.ARRAY),
    LIST((byte) 19, "listElement", MAType.NOT_ARRAY),
    COMPOUND((byte) 20, "compoundElement", MAType.NOT_ARRAY);

    public final byte id;
    public final String docTag;
    public final MAType maType;

    MType(byte id, String docTag, MAType maType) {
        this.id = id;
        this.docTag = docTag;
        this.maType = maType;
    }

    public static MType fromID(byte id) {
        MType[] mTypes = values();
        for (int len = 0; len < mTypes.length; ++len) {
            if (mTypes[len].id == id) {
                return mTypes[len];
            }
        }
        return END;
    }

    public static MType fromDocTag(String docTag) {
        MType[] mTypes = values();
        for (int len = 0; len < mTypes.length; ++len) {
            if (mTypes[len].docTag == docTag) {
                return mTypes[len];
            }
        }
        return END;
    }

    public enum MWType {
        LIST(MType.LIST),
        COMPOUND(MType.COMPOUND);

        public final MType type;

        MWType(MType type) {
            this.type = type;
        }
    }

    public enum MAType {

        NOT_ARRAY(false),
        ARRAY(true);

        public final boolean isArray;

        MAType(boolean isArray) {
            this.isArray = isArray;
        }
    }
}
