package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ParentElement
{
    public <T extends AbstractParentElements> T getChild(String element)
    {
        return null;
    }
    public <T extends AbstractParentElements> T addChild(AbstractParentElements element)
    {
        return null;
    }
    public <T extends AbstractParentElements> T addChild(String element, String value)
    {
        return null;
    }
    public StringBuilder build()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Root:");
        return stringBuilder;
    }
}
