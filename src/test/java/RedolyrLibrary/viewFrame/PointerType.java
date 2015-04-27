package RedolyrLibrary.viewFrame;

/**
 * Created by redolyr on 2015/02/10.
 */
public enum PointerType {

    POINTER_BYTE(byte.class, 1, "byte"),

    POINTER_INT(int.class, 2, "int"),

    POINTER_SHORT(short.class, 3, "short"),

    POINTER_LONG(long.class, 4, "long"),

    POINTER_DOUBLE(double.class, 5, "double"),

    POINTER_FLOAT(float.class, 6, "float");

    public final Class typeClass;

    public final int typeID;

    public final String typeName;

    private PointerType(Class<?> typeClass, int typeID, String typeName) {
        this.typeClass = typeClass;
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public String toString() {
        return "{\"typeClass\":\"" + this.typeClass + "\", \"typeID\":\"" + this.typeID + "\", \"typeName\":\"" + this.typeName + "\"}";
    }
}
