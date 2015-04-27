package RedolyrLibrary.dataSystems;

import java.io.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/10/13.
 */
public class R7DAFDataInput implements DataInput {
    private Object[] rawBuffer;
    private int rawBufferLength;
    private int rawBufferIndex;

    public R7DAFDataInput(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (this.rawBuffer == null) this.rawBuffer = new Object[1];
            else this.rawBuffer = Arrays.copyOf(this.rawBuffer, this.rawBufferLength + 1);
            this.rawBuffer[this.rawBufferLength] = line;
            this.rawBufferLength += 1;
        }
        bufferedReader.close();
    }

    public Object readNext() {
        Object object = this.rawBuffer[this.rawBufferIndex];
        if (this.rawBufferIndex < this.rawBufferLength) this.rawBufferIndex += 1;
        return object;
    }

    public boolean hasNext() {
        return this.rawBufferIndex < this.rawBufferLength;
    }

    public void skip(int len) {
        for (int skip = 0; skip < len; ++skip) if (!(skip < this.rawBufferLength)) this.readNext();
    }

    @Deprecated
    public void readFully(byte[] b) throws IOException {
    }

    @Deprecated
    public void readFully(byte[] b, int off, int len) throws IOException {
    }

    @Deprecated
    public int skipBytes(int n) throws IOException {
        return 0;
    }

    public boolean readBoolean() throws IOException {
        return Boolean.valueOf(String.valueOf(this.readNext()));
    }

    public byte readByte() throws IOException {
        return Byte.parseByte(String.valueOf(this.readNext()));
    }

    public int readUnsignedByte() throws IOException {
        return Integer.parseInt(String.valueOf(this.readNext()));
    }

    public short readShort() throws IOException {
        return Short.parseShort(String.valueOf(this.readNext()));
    }

    public int readUnsignedShort() throws IOException {
        return Integer.parseInt(String.valueOf(this.readNext()));
    }

    public char readChar() throws IOException {
        return Character.highSurrogate(Integer.valueOf(String.valueOf(this.readNext())));
    }

    public int readInt() throws IOException {
        return Integer.parseInt(String.valueOf(this.readNext()));
    }

    public long readLong() throws IOException {
        return Long.parseLong(String.valueOf(this.readNext()));
    }

    public float readFloat() throws IOException {
        return Float.parseFloat(String.valueOf(this.readNext()));
    }

    public double readDouble() throws IOException {
        return Double.parseDouble(String.valueOf(this.readNext()));
    }

    public String readLine() throws IOException {
        return String.valueOf(this.readNext());
    }

    public String readUTF() throws IOException {
        return String.valueOf(this.readNext());
    }
}
