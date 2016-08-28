package SupplyPower.documentSystems;

/**
 * Created by redolyr on 2016/08/10.
 */
public abstract class DocumentBasePrimitiveArray extends DocumentBaseArray {

    public abstract int[] toIntegerArray();

    public abstract short[] toShortArray();

    public abstract long[] toLongArray();

    public abstract byte[] toByteArray();

    public abstract double[] toDoubleArray();

    public abstract float[] toFloatArray();
}
