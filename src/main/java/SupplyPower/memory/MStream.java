package SupplyPower.memory;

import SupplyPower.io.GThreeDataInputStream;
import SupplyPower.io.GThreeDataOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by redolyr on 2016/08/28.
 */
public class MStream {

    public static void writeDoc(File file, MObject mObject) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        writeDoc(new FileOutputStream(file), file.getName(), mObject);
    }

    public static MObject readDoc(File file) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        MObject mObject = new MObject(MType.MWType.COMPOUND);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        mObject.read(document, document.getDocumentElement());
        return mObject;
    }

    public static void writeDoc(OutputStream outputStream, String elementName, MObject mObject) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement(elementName);
        mObject.write(document, element);
        document.appendChild(element);
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(outputStream));
    }

    public static MObject readDoc(InputStream inputStream) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        MObject mObject = new MObject(MType.MWType.COMPOUND);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        mObject.read(document, document.getDocumentElement());
        return mObject;
    }

    public static void writeData(File par1File, MObject par2MObject) throws IOException {
        writeData(new GThreeDataOutputStream(par1File), par2MObject);
    }

    public static MObject readData(File par1File) throws IOException {
        return readData(new GThreeDataInputStream(par1File));
    }

    public static void writeData(OutputStream par1OutputStream, MObject par2MObject) throws IOException {
        DataOutputStream dataOutputStream = par1OutputStream instanceof DataOutputStream ? (DataOutputStream) par1OutputStream : new DataOutputStream(par1OutputStream);
        par2MObject.write(dataOutputStream);
        dataOutputStream.close();
    }

    public static MObject readData(InputStream par1InputStream) throws IOException {
        MObject mObject = new MObject(MType.MWType.COMPOUND);
        DataInputStream dataInputStream = par1InputStream instanceof DataInputStream ? (DataInputStream) par1InputStream : new DataInputStream(par1InputStream);
        mObject.read(dataInputStream);
        dataInputStream.close();
        return mObject;
    }
}
