package SupplyPower.io;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.*;

/**
 * Created by redolyr on 2016/08/10.
 */
public class BufferOutputStream extends OutputStream implements DataOutput {

    private ByteBuffer byteBuffer;
    private IntBuffer intBuffer;
    private ShortBuffer shortBuffer;
    private LongBuffer longBuffer;
    private DoubleBuffer doubleBuffer;
    private FloatBuffer floatBuffer;
    private CharBuffer charBuffer;

    public BufferOutputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.intBuffer = byteBuffer.asIntBuffer();
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.longBuffer = byteBuffer.asLongBuffer();
        this.doubleBuffer = byteBuffer.asDoubleBuffer();
        this.floatBuffer = byteBuffer.asFloatBuffer();
        this.charBuffer = byteBuffer.asCharBuffer();
    }

    public void write(int b) throws IOException {
        this.byteBuffer.put((byte) b);
    }

    public void writeBoolean(boolean v) throws IOException {
        this.writeByte(v ? 1 : 0);
    }

    public void writeByte(int v) throws IOException {
        this.byteBuffer.put((byte) v);
    }

    public void writeShort(int v) throws IOException {
        this.shortBuffer.put((short) v);
    }

    public void writeChar(int v) throws IOException {
        this.charBuffer.put((char) v);
    }

    public void writeInt(int v) throws IOException {
        this.intBuffer.put(v);
    }

    public void writeLong(long v) throws IOException {
        this.longBuffer.put(v);
    }

    public void writeFloat(float v) throws IOException {
        this.floatBuffer.put(v);
    }

    public void writeDouble(double v) throws IOException {
        this.doubleBuffer.put(v);
    }

    public void writeBytes(String s) throws IOException {
        this.byteBuffer.put(s.getBytes());
    }

    public void writeChars(String s) throws IOException {
        this.charBuffer.put(s.toCharArray());
    }

    public void writeUTF(String s) throws IOException {
        this.charBuffer.put(s);
    }
}
