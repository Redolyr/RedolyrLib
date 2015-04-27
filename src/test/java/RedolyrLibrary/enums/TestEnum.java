package RedolyrLibrary.enums;

/**
 * Created by redolyr on 2015/02/03.
 */
public enum TestEnum {

    ;

    private Object object;
    private int anInt;
    private short aShort;
    private long aLong;
    private byte aByte;
    private double aDouble;
    private float aFloat;
    private boolean aBoolean;
    private String string;

    private TestEnum(Object object, int anInt, short aShort, long aLong, byte aByte, double aDouble, float aFloat, boolean aBoolean, String string) {
        this.object = object;
        this.anInt = anInt;
        this.aShort = aShort;
        this.aLong = aLong;
        this.aByte = aByte;
        this.aDouble = aDouble;
        this.aFloat = aFloat;
        this.aBoolean = aBoolean;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public int getAnInt() {
        return anInt;
    }

    public short getaShort() {
        return aShort;
    }

    public long getaLong() {
        return aLong;
    }

    public byte getaByte() {
        return aByte;
    }

    public double getaDouble() {
        return aDouble;
    }

    public float getaFloat() {
        return aFloat;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "TestEnum{" +
                "object=" + object +
                ", anInt=" + anInt +
                ", aShort=" + aShort +
                ", aLong=" + aLong +
                ", aByte=" + aByte +
                ", aDouble=" + aDouble +
                ", aFloat=" + aFloat +
                ", aBoolean=" + aBoolean +
                ", string='" + string + '\'' +
                '}';
    }
}
