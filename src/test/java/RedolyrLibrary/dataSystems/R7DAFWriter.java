package RedolyrLibrary.dataSystems;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Iterator;

/**
 * Created by redolyr on 2014/10/13.
 */
public class R7DAFWriter
{
    protected static Document document;
    public static void write(File file, DataTagCompound dataTagCompound) throws TransformerException, ParserConfigurationException
    {
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Element root = getDocument().createElement("root");
        root.appendChild(new Any().anyElement(dataTagCompound));
        document.appendChild(root);

        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(getDocument()), new StreamResult(file));
    }
    protected static Document getDocument() throws ParserConfigurationException
    {
        return document;
    }
    public String replace(int id)
    {
        String string = String.valueOf(id);
        char[] chars = string.toCharArray();
        for (int len = 0; len < chars.length; ++len)
        {
            switch (chars[len])
            {
                case '0':
                    chars[len] = 'a';
                    break;
                case '1':
                    chars[len] = 'b';
                    break;
                case '2':
                    chars[len] = 'c';
                    break;
                case '3':
                    chars[len] = 'd';
                    break;
                case '4':
                    chars[len] = 'e';
                    break;
                case '5':
                    chars[len] = 'f';
                    break;
                case '6':
                    chars[len] = 'g';
                    break;
                case '7':
                    chars[len] = 'h';
                    break;
                case '8':
                    chars[len] = 'i';
                    break;
                case '9':
                    chars[len] = 'j';
                    break;
            }
        }
        return string = new String(chars);
    }
}
class Any extends R7DAFWriter
{
    public Element anyElement(DataBase dataBase) throws ParserConfigurationException
    {
        Element element = null;
        if (dataBase.getId() != 1 || dataBase.getId() != 2)
        {
            element = this.getDocument().createElement("artifact");
            Element element1 = this.getDocument().createElement("artifact");
            element1.setAttribute("id", this.replace(dataBase.getId()));
            element1.appendChild(this.getDocument().createTextNode(dataBase.toString()));
            element.appendChild(element1);
        }
        else if (dataBase.getId() == 1) element.appendChild(new Compound().compoundElement((DataTagCompound) dataBase));
        else if (dataBase.getId() == 2) element.appendChild(new List().listElement((DataTagList) dataBase));
        return element;
    }
}
class Compound extends Any
{
    public Element compoundElement(DataTagCompound dataTagCompound) throws ParserConfigurationException
    {
        Element element = this.getDocument().createElement("artifactCompound");
        element.setAttribute("id", this.replace(dataTagCompound.getId()));
        int len = 0;
        Iterator<String> stringIterator = dataTagCompound.iterator();
        while (stringIterator.hasNext())
        {
            String key = stringIterator.next();
            Element element1 = this.anyElement(dataTagCompound.getTag(key));
            element1.setAttribute("key", key);
            element.appendChild(element1);
            len += 1;
        }
        element.setAttribute("length", this.replace(len));
        return element;
    }
}
class List extends Any
{
    public Element listElement(DataTagList dataTagList) throws ParserConfigurationException
    {
        Element element = this.getDocument().createElement("artifactList");
        element.setAttribute("id", this.replace(dataTagList.getId()));
        element.setAttribute("len", this.replace(dataTagList.count()));
        for (int len = 0; len < dataTagList.count(); ++len) element.appendChild(this.anyElement(dataTagList.getList(len)));
        return element;
    }
}