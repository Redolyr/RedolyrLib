package RedolyrLibrary.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by redolyr on 2014/12/17.
 */
public class StringOutputStream extends ByteArrayOutputStream {

    public void write(String buf) throws IOException {
        super.write(buf.getBytes());
    }

    public void write(String buf, int off, int len) {
        super.write(buf.getBytes(), off, len);
    }
}
