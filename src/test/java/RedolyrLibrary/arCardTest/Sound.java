package RedolyrLibrary.arCardTest;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/23.
 */
public class Sound implements ISound, Serializable {

    private static final long serialVersionUID = 43L;

    private final byte[] bytes;

    private final boolean isBufferedStream;

    private final String fileName;

    public Sound(byte[] bytes, boolean isBufferedStream, String fileName) {
        this.bytes = bytes;
        this.isBufferedStream = isBufferedStream;
        this.fileName = fileName;
    }

    public byte[] getByteArray() {
        return this.bytes;
    }

    public boolean isBufferedStream() {
        return true;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String toString() {
        return String.format("{'isBufferedStream': %s, 'fileName': '%s'}", this.isBufferedStream, this.fileName).replace('\'', '"');
    }
}
