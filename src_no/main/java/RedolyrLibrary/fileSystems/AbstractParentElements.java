package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public abstract class AbstractParentElements
{
    public abstract <T extends AbstractParentElements> T getParent();
    public abstract <T extends AbstractParentElements> T setParent(AbstractParentElements abstractParentElements);
    public abstract <T extends AbstractParentElements> T  getChild(String element);
    public abstract <T extends AbstractParentElements> T  addChild(AbstractParentElements element);
    public abstract <T extends AbstractParentElements> T  addChild(String element, String value);
}
