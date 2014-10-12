package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public abstract class AbstractAttribute extends AbstractParentElements
{
    public abstract String getAttribute();
    public abstract <T extends AbstractAttribute> T setAttribute(String attribute);
    public abstract String getValue();
    public abstract <T extends AbstractAttribute> T  setValue(String value);
}
