package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public interface ElementImport
{
    public Object read();
    public String readString();
    public char readCharacter();
    public int readInteger();
    public short readShort();
    public long readLong();
    public byte readByte();
    public double readDouble();
    public float readFloat();
    public boolean readBoolean();
}
