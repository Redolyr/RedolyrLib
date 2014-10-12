package RedolyrLibrary.dataSystems;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by redolyr on 2014/10/13.
 */
public class R7DAFReader
{
    protected static Document document;
    public static void read(File file) throws ParserConfigurationException, IOException, SAXException
    {
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        NodeList nodeList = document.getElementsByTagName("root");
        for (int len = 0; len < nodeList.getLength(); ++len)
        {
            NodeList nodeList1 = nodeList.item(len).getChildNodes();
            for (int len2 = 0; len2 < nodeList1.getLength(); ++len2)
            {
                System.out.println(replace(nodeList1.item(len).getAttributes().getNamedItem("id").getNodeValue()));
            }
        }
    }
    public static int replace(String buffer)
    {
        int id = 0;
        char[] chars = buffer.toCharArray();
        for (int len = 0; len < chars.length; ++len)
        {
            switch (chars[len])
            {
                case 'a':
                    chars[len] = '0';
                    break;
                case 'b':
                    chars[len] = '1';
                    break;
                case 'c':
                    chars[len] = '2';
                    break;
                case 'd':
                    chars[len] = '3';
                    break;
                case 'e':
                    chars[len] = '4';
                    break;
                case 'f':
                    chars[len] = '5';
                    break;
                case 'g':
                    chars[len] = '6';
                    break;
                case 'h':
                    chars[len] = '7';
                    break;
                case 'i':
                    chars[len] = '8';
                    break;
                case 'j':
                    chars[len] = '9';
                    break;
            }
        }
        return id = Integer.valueOf(new String(chars));
    }
}
