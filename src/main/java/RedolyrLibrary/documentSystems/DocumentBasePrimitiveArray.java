package RedolyrLibrary.documentSystems;

/**
 * Created by redolyr on 2014/12/08.
 */
public abstract class DocumentBasePrimitiveArray extends DocumentBaseArray {
    public abstract int[] toIntegerArray();

    public abstract short[] toShortArray();

    public abstract long[] toLongArray();

    public abstract byte[] toByteArray();

    public abstract double[] toDoubleArray();

    public abstract float[] toFloatArray();
}
