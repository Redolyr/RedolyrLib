package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/15.
 */
public enum EnumNodeType {

    INTEGER(NodeInteger.class),
    SHORT(NodeShort.class),
    LONG(NodeLong.class),
    BYTE(NodeByte.class),
    DOUBLE(NodeDouble.class),
    FLOAT(NodeFloat.class),
    BOOLEAN(NodeBoolean.class),
    STRING(NodeString.class),
    CHARACTER(NodeCharacter.class);

    public final Class<? extends NodeObject> classNodeObject;

    private EnumNodeType(Class<? extends NodeObject> classNodeObject) {
        this.classNodeObject = classNodeObject;
    }
}
