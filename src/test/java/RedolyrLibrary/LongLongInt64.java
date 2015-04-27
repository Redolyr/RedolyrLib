package RedolyrLibrary;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/24.
 */
public class LongLongInt64 extends Number implements Serializable {

    private long aLong = 0;
    private long aLong1 = 0;
    private int anInt32 = 0;
    private int anInt321 = 0;

    public static final int SIZE = 128;

    public LongLongInt64(long aLong, long aLong1, int anInt32, int anInt321) {
        this.aLong = aLong;
        this.aLong1 = aLong1;
        this.anInt32 = anInt32;
        this.anInt321 = anInt321;
    }

    public int intValue() {
        return (int) (((this.aLong / Long.SIZE) - (this.aLong1 / Long.SIZE)) + (this.anInt32 / Integer.SIZE) + (this.anInt321 / Integer.SIZE)) / (Integer.SIZE / this.SIZE);
    }

    public long longValue() {
        return (((this.aLong / Long.SIZE) - (this.aLong1 / Long.SIZE)) + (this.anInt32 / Integer.SIZE) + (this.anInt321 / Integer.SIZE)) / (Long.SIZE / this.SIZE);
    }

    public float floatValue() {
        return (((this.aLong / Long.SIZE) - (this.aLong1 / Long.SIZE)) + (this.anInt32 / Integer.SIZE) + (this.anInt321 / Integer.SIZE)) / (Float.SIZE / this.SIZE);
    }

    public double doubleValue() {
        return (((this.aLong / Long.SIZE) - (this.aLong1 / Long.SIZE)) + (this.anInt32 / Integer.SIZE) + (this.anInt321 / Integer.SIZE)) / (Double.SIZE / this.SIZE);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongLongInt64)) return false;

        LongLongInt64 that = (LongLongInt64) o;

        if (this.aLong != that.aLong) return false;
        if (this.aLong1 != that.aLong1) return false;
        if (this.anInt32 != that.anInt32) return false;
        if (this.anInt321 != that.anInt321) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.aLong ^ (this.aLong >>> 32));
        result = 31 * result + (int) (this.aLong1 ^ (this.aLong1 >>> 32));
        result = 31 * result + this.anInt32;
        result = 31 * result + this.anInt321;
        return result;
    }

    public String toString() {
        return String.valueOf(this.intValue());
    }
}
