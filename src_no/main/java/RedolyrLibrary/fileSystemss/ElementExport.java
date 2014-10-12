package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public interface ElementExport
{
    public void write(Object object);
    public void writeString(String string);
    public void writeCharacter(char achar);
    public void writeInteger(int integer);
    public void writeShort(short ashort);
    public void writeLong(long along);
    public void writeByte(byte abyte);
    public void writeDouble(double adouble);
    public void writeFloat(float afloat);
    public void writeBoolean(boolean aboolean);
}
