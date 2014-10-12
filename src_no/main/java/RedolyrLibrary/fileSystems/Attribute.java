package RedolyrLibrary.fileSystems;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/10/07.
 */
public class Attribute extends AbstractAttribute
{
    private AbstractParentElements abstractParentElements;
    private String attribute;
    private String value;

    private AbstractElement[] elements;
    private int elementsLength;

    public AbstractParentElements getParent()
    {
        return abstractParentElements;
    }

    public Attribute setParent(AbstractParentElements abstractParentElements)
    {
        this.abstractParentElements = abstractParentElements;
        return this;
    }

    public String getAttribute()
    {
        return attribute;
    }

    public Attribute setAttribute(String attribute)
    {
        this.attribute = attribute;
        return this;
    }

    public String getValue()
    {
        return value;
    }

    public Attribute setValue(String value)
    {
        this.value = value;
        return this;
    }

    public AbstractElement getChild(String elementName)
    {
        AbstractElement abstractElement = null;
        for (AbstractElement abstractElement1 : this.elements)
        {
            abstractElement = abstractElement1;
            if (abstractElement1.getParent().equals(elementName)) break;
        }
        return abstractElement;
    }

    public AbstractAttribute addChild(AbstractParentElements abstractElement)
    {
        if (this.elements == null) this.elements = new AbstractElement[1];
        else this.elements = Arrays.copyOf(this.elements, this.elementsLength + 1);

        this.elements[elementsLength] = abstractElement.setParent(this);

        this.elementsLength += 1;
        return this;
    }

    public AbstractAttribute addChild(String elementName, String value)
    {
        return this.addChild(new Element().setElementName(elementName).setValue(value));
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;

        Attribute attribute1 = (Attribute) o;

        if (elementsLength != attribute1.elementsLength) return false;
        if (abstractParentElements != null ? !abstractParentElements.equals(attribute1.abstractParentElements) : attribute1.abstractParentElements != null)
            return false;
        if (attribute != null ? !attribute.equals(attribute1.attribute) : attribute1.attribute != null) return false;
        if (!Arrays.equals(elements, attribute1.elements)) return false;
        if (value != null ? !value.equals(attribute1.value) : attribute1.value != null) return false;

        return true;
    }

    public int hashCode()
    {
        int result = abstractParentElements != null ? abstractParentElements.hashCode() : 0;
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (elements != null ? Arrays.hashCode(elements) : 0);
        result = 31 * result + elementsLength;
        return result;
    }

    public String toString()
    {
        return "Attribute{" +
                "attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
