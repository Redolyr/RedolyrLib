package RedolyrLibrary.io;

import java.io.ByteArrayInputStream;

/**
 * Created by redolyr on 2014/12/17.
 */
public class StringInputStream extends ByteArrayInputStream {

    public StringInputStream(String buf) {
        super(buf.getBytes());
    }

    public StringInputStream(String buf, int offset, int length) {
        super(buf.getBytes(), offset, length);
    }

    public String readUTF() {
        return new String(this.buf);
    }
}
