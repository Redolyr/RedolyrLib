package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public abstract class AbstractElementList extends AbstractParentElements
{
    public abstract <T extends AbstractElementList> T addElement();
}
