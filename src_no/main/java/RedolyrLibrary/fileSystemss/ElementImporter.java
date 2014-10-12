package RedolyrLibrary.fileSystems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/10/08.
 */
public class ElementImporter implements ElementImport
{
    protected BufferedReader bufferedReader;
    protected ElementIEPort[] elementIEPorts;
    protected int elementIEPortsLength;
    
    public ElementImporter(File file) throws IOException
    {
        this.bufferedReader = new BufferedReader(new FileReader(file));
    }

    public ElementIEPort next()
    {
        ElementIEPort elementIEPort = null;
        if (this.elementIEPorts == null) this.elementIEPorts = new ElementIEPort[1];
        else this.elementIEPorts = Arrays.copyOf(this.elementIEPorts, this.elementIEPortsLength + 1);
        elementIEPort = (this.elementIEPorts[this.elementIEPortsLength] == null ? (this.elementIEPorts[this.elementIEPortsLength] = new ElementIEPort()) : this.elementIEPorts[this.elementIEPortsLength]);
        this.elementIEPortsLength += 1;
        return elementIEPort;
    }
    
    public Object read()
    {
        return this.next().read();
    }

    public String readString()
    {
        return this.next().readString();
    }

    public char readCharacter()
    {
        return this.next().readCharacter();
    }

    public int readInteger()
    {
        return this.next().readInteger();
    }

    public short readShort()
    {
        return this.next().readShort();
    }

    public long readLong()
    {
        return this.next().readLong();
    }

    public byte readByte()
    {
        return this.next().readByte();
    }

    public double readDouble()
    {
        return this.next().readDouble();
    }

    public float readFloat()
    {
        return this.next().readFloat();
    }

    public boolean readBoolean()
    {
        return this.next().readBoolean();
    }

    public void close() throws IOException
    {
        String lines = System.getProperty("line.separator");
        String line;
        while ((line = this.bufferedReader.readLine()) != null) this.next().write(line + lines);
        this.bufferedReader.close();
        this.elementIEPortsLength = 0;
    }
}
