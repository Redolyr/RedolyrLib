package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public abstract class ElementBasePrimitive extends ElementBase
{
    public abstract int toInteger();
    public abstract short toShort();
    public abstract long toLong();
    public abstract byte toByte();
    public abstract double toDouble();
    public abstract float toFloat();
}
