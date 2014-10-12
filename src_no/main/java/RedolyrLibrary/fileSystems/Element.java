package RedolyrLibrary.fileSystems;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/10/07.
 */
public class Element extends AbstractElement
{
    private AbstractParentElements abstractParentElements;

    private String elementName;
    private String value;

    private AbstractAttribute[] attributes;
    private int attributesLength;

    private AbstractElement[] elements;
    private int elementsLength;

    public String getElementName()
    {
        return this.elementName;
    }

    public Element setElementName(String elementName)
    {
        this.elementName = elementName;
        return this;
    }

    public String getValue()
    {
        return this.value;
    }

    public Element setValue(String value)
    {
        this.value = value;
        return this;
    }

    public AbstractParentElements getParent()
    {
        return abstractParentElements;
    }

    public Element setParent(AbstractParentElements abstractParentElements)
    {
        this.abstractParentElements = abstractParentElements;
        return this;
    }

    public AbstractAttribute getAttribute(String attribute)
    {
        AbstractAttribute abstractAttribute = null;
        for (AbstractAttribute abstractAttribute1 : this.attributes)
        {
            abstractAttribute = abstractAttribute1;
            if (abstractAttribute.getAttribute().equals(attribute)) break;
        }
        return abstractAttribute;
    }

    public AbstractElement addAttribute(AbstractAttribute attribute)
    {
        if (this.attributes == null) this.attributes = new AbstractAttribute[1];
        else this.attributes = Arrays.copyOf(this.attributes, this.attributesLength + 1);

        this.attributes[attributesLength] = attribute.setParent(this);

        this.attributesLength += 1;
        return this;
    }

    public AbstractElement addAttribute(String attribute, String value)
    {
        this.addAttribute(new Attribute().setAttribute(attribute).setValue(value));
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

    public AbstractElement addChild(AbstractParentElements abstractElement)
    {
        if (this.elements == null) this.elements = new AbstractElement[1];
        else this.elements = Arrays.copyOf(this.elements, this.elementsLength + 1);

        this.elements[elementsLength] = abstractElement.setParent(this);

        this.elementsLength += 1;
        return this;
    }

    public AbstractElement addChild(String elementName, String value)
    {
        return this.addChild(new Element().setElementName(elementName).setValue(value));
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;

        Element element = (Element) o;

        if (attributesLength != element.attributesLength) return false;
        if (elementsLength != element.elementsLength) return false;
        if (abstractParentElements != null ? !abstractParentElements.equals(element.abstractParentElements) : element.abstractParentElements != null)
            return false;
        if (!Arrays.equals(attributes, element.attributes)) return false;
        if (elementName != null ? !elementName.equals(element.elementName) : element.elementName != null) return false;
        if (!Arrays.equals(elements, element.elements)) return false;

        return true;
    }

    public int hashCode()
    {
        int result = abstractParentElements != null ? abstractParentElements.hashCode() : 0;
        result = 31 * result + (elementName != null ? elementName.hashCode() : 0);
        result = 31 * result + (attributes != null ? Arrays.hashCode(attributes) : 0);
        result = 31 * result + attributesLength;
        result = 31 * result + (elements != null ? Arrays.hashCode(elements) : 0);
        result = 31 * result + elementsLength;
        return result;
    }

    public String toString()
    {
        return "Element{" +
                "value='" + value + '\'' +
                ", elementName='" + elementName + '\'' +
                '}';
    }
}
