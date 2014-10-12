package RedolyrLibrary.fileSystems;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ElementExporter implements ElementExport
{
    protected File file;
    protected ElementIEPort[] elementIEPorts;
    protected int elementIEPortsLength;
    protected final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    protected final DocumentBuilder documentBuilder;
    protected final Document document;
    protected final Element root;

    public ElementExporter(File file) throws IOException, ParserConfigurationException
    {
        this.file = file;
        this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
        this.document = this.documentBuilder.newDocument();
        this.root = this.document.createElement("Root");
        this.document.appendChild(this.root);
    }

    public ElementIEPort next()
    {
        ElementIEPort elementIEPort = null;
        if (this.elementIEPorts == null) this.elementIEPorts = new ElementIEPort[1];
        else this.elementIEPorts = Arrays.copyOf(this.elementIEPorts, this.elementIEPortsLength + 1);
        elementIEPort = (this.elementIEPorts[this.elementIEPortsLength] = new ElementIEPort());
        this.elementIEPortsLength += 1;
        return elementIEPort;
    }

    public void write(Object object)
    {
        this.next().write(object);
    }

    public void writeString(String string)
    {
        this.next().writeString(string);
    }

    public void writeCharacter(char achar)
    {
        this.next().writeCharacter(achar);
    }

    public void writeInteger(int integer)
    {
        this.next().writeInteger(integer);
    }

    public void writeShort(short ashort)
    {
        this.next().writeShort(ashort);
    }

    public void writeLong(long along)
    {
        this.next().writeLong(along);
    }

    public void writeByte(byte abyte)
    {
        this.next().writeByte(abyte);
    }

    public void writeDouble(double adouble)
    {
        this.next().writeDouble(adouble);
    }

    public void writeFloat(float afloat)
    {
        this.next().writeFloat(afloat);
    }

    public void writeBoolean(boolean aboolean)
    {
        this.next().writeBoolean(aboolean);
    }

    public void close() throws TransformerException
    {
        for (ElementIEPort elementIEPort : this.elementIEPorts)
        {
            this.document
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(this.document);
        StreamResult result = new StreamResult(this.file);
        transformer.transform(source, result);

//        this.bufferedWriter.write("ROOT:");
//        for (ElementIEPort elementIEPort : this.elementIEPorts) this.bufferedWriter.write(String.valueOf(elementIEPort.read()));
//        this.bufferedWriter.close();
    }
}
