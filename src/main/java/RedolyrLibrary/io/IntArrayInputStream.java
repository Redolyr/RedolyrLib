package RedolyrLibrary.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by redolyr on 2014/12/01.
 */
public class IntArrayInputStream extends InputStream {

    protected int[] buf;
    protected int pos;
    protected int mark = 0;
    protected int count;

    public IntArrayInputStream(int buf[]) {
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }

    public IntArrayInputStream(int buf[], int offset, int length) {
        this.buf = buf;
        this.pos = offset;
        this.count = Math.min(offset + length, buf.length);
        this.mark = offset;
    }

    public synchronized int read() {
        return (this.pos < this.count) ? (this.buf[this.pos++] & 0xff) : -1;
    }

    public synchronized int read(int b[], int off, int len) {
        if (b == null) throw new NullPointerException();
        else if (off < 0 || len < 0 || len > b.length - off) throw new IndexOutOfBoundsException();

        if (this.pos >= this.count) return -1;

        int avail = this.count - this.pos;
        if (len > avail) len = avail;
        if (len <= 0) return 0;
        System.arraycopy(this.buf, this.pos, b, off, len);
        this.pos += len;
        return len;
    }

    public synchronized long skip(long n) {
        long k = this.count - this.pos;
        if (n < k) k = n < 0 ? 0 : n;

        this.pos += k;
        return k;
    }

    public synchronized int available() {
        return this.count - this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int readAheadLimit) {
        this.mark = this.pos;
    }

    public synchronized void reset() {
        this.pos = this.mark;
    }

    public void close() throws IOException {
    }

}
