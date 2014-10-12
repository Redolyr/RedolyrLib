package RedolyrLibrary.fileSystems;

/**
 * Created by redolyr on 2014/10/07.
 */
public abstract class AbstractElement extends AbstractParentElements
{
    public abstract String getElementName();
    public abstract <T extends AbstractElement> T setElementName(String elementName);
    public abstract String getValue();
    public abstract <T extends AbstractElement> T  setValue(String value);
    public abstract AbstractAttribute getAttribute(String attribute);
    public abstract AbstractElement addAttribute(AbstractAttribute attribute);
    public abstract AbstractElement addAttribute(String attribute, String value);
}