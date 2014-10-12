package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public abstract class ElementBase
{
    abstract void read(ElementImport elementImport);
    abstract void write(ElementExport elementExport);
    public abstract byte getId();
    public abstract <T extends ElementBase> T copy();
    public String getSimpleClassName()
    {
        return this.getClass().getSimpleName();
    }
    public static ElementBase toTags(byte id)
    {
        switch (id)
        {
            case 1:
                return new ElementTagCompound();
            case 3:
                return new ElementTagString();
            case 4:
                return new ElementTagCharacter();
            case 5:
                return new ElementTagInteger();
            default:
                return null;
        }
    }
    public static String toTagNames(byte id)
    {
        return toTags(id).getSimpleClassName();
    }
}
