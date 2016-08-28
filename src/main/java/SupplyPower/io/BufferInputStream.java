package SupplyPower.io;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.nio.*;

/**
 * Created by redolyr on 2016/08/10.
 */
public class BufferInputStream extends InputStream implements DataInput {

    private ByteBuffer byteBuffer;
    private IntBuffer intBuffer;
    private ShortBuffer shortBuffer;
    private LongBuffer longBuffer;
    private DoubleBuffer doubleBuffer;
    private FloatBuffer floatBuffer;
    private CharBuffer charBuffer;

    public BufferInputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.intBuffer = byteBuffer.asIntBuffer();
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.longBuffer = byteBuffer.asLongBuffer();
        this.doubleBuffer = byteBuffer.asDoubleBuffer();
        this.floatBuffer = byteBuffer.asFloatBuffer();
        this.charBuffer = byteBuffer.asCharBuffer();
    }

    public void readFully(byte[] b) throws IOException {
        this.byteBuffer.get(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        this.byteBuffer.get(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        int position = this.byteBuffer.position();
        this.byteBuffer.position(n);
        return position;
    }

    public boolean readBoolean() throws IOException {
        return this.readByte() == 1 ? true : false;
    }

    public byte readByte() throws IOException {
        return this.byteBuffer.get();
    }

    public int readUnsignedByte() throws IOException {
        return this.readByte() & 0xFF;
    }

    public short readShort() throws IOException {
        return this.shortBuffer.get();
    }

    public int readUnsignedShort() throws IOException {
        return this.readShort() & 0xFF;
    }

    public char readChar() throws IOException {
        return this.charBuffer.get();
    }

    public int readInt() throws IOException {
        return this.intBuffer.get();
    }

    public long readLong() throws IOException {
        return this.longBuffer.get();
    }

    public float readFloat() throws IOException {
        return this.floatBuffer.get();
    }

    public double readDouble() throws IOException {
        return this.doubleBuffer.get();
    }

    public String readLine() throws IOException {
        byte[] bytes = new byte[this.byteBuffer.limit() - this.byteBuffer.position()];
        this.byteBuffer.get(bytes);
        return new String(bytes);
    }

    public String readUTF() throws IOException {
        char[] chars = new char[this.charBuffer.limit() - this.charBuffer.position()];
        this.charBuffer.get(chars);
        return new String(chars);
    }

    public int read() throws IOException {
        return this.byteBuffer.get();
    }
}
