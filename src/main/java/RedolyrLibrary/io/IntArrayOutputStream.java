package RedolyrLibrary.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/01.
 */
public class IntArrayOutputStream extends OutputStream {

    protected int[] buf;
    private byte[] bytes;
    protected int count;

    public IntArrayOutputStream() {
        this(32);
    }

    public IntArrayOutputStream(int size) {
        if (size < 0) throw new IllegalArgumentException("Negative initial size: " + size);
        this.buf = new int[size];

        ByteBuffer byteBuffer = ByteBuffer.allocate(this.buf.length * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(this.buf);
        this.bytes = byteBuffer.array();
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - this.buf.length > 0) this.grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.buf.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity - minCapacity < 0) newCapacity = minCapacity;
        if (newCapacity < 0) {
            if (minCapacity < 0) throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        this.buf = Arrays.copyOf(this.buf, newCapacity);
    }

    public synchronized void write(int b) {
        ensureCapacity(this.count + 1);
        this.buf[this.count] = (int) b;
        this.count += 1;
    }

    public synchronized void write(int b[], int off, int len) {
        if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) - b.length > 0))
            throw new IndexOutOfBoundsException();
        ensureCapacity(this.count + len);
        System.arraycopy(b, off, this.buf, this.count, len);
        this.count += len;
    }

    public synchronized void writeTo(OutputStream out) throws IOException {
        out.write(this.bytes, 0, this.count);
    }

    public synchronized void reset() {
        this.count = 0;
    }

    public synchronized int toIntArray()[] {
        return Arrays.copyOf(this.buf, this.count);
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized String toString() {
        return new String(this.buf, 0, this.count);
    }

    public synchronized String toString(String charsetName)
            throws UnsupportedEncodingException {
        return new String(this.bytes, 0, this.count, charsetName);
    }

    @Deprecated
    public synchronized String toString(int hiint) {
        return new String(this.bytes, hiint, 0, this.count);
    }

    public void close() throws IOException {
    }

}
