package SupplyPower.documentSystems;

/**
 * Created by redolyr on 2016/08/10.
 */
public abstract class DocumentBasePrimitive extends DocumentBase {

    public abstract int toInteger();

    public abstract short toShort();

    public abstract long toLong();

    public abstract byte toByte();

    public abstract double toDouble();

    public abstract float toFloat();
}