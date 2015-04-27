package RedolyrLibrary.documentSystems;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by redolyr on 2014/11/17.
 */
public class DocumentStream {
    public static void write(File file, DocumentTagCompound documentTagCompound) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement(file.getName());
        documentTagCompound.write(document, element);
        document.appendChild(element);
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
    }

    public static DocumentTagCompound read(File file) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        DocumentTagCompound documentTagCompound = new DocumentTagCompound();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        Element element = document.getDocumentElement();
        documentTagCompound.read(document, element);
        return documentTagCompound;
    }
}
