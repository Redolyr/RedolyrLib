package RedolyrLibrary.repository;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by redolyr on 2014/12/10.
 */
public class RepositoryWriter {

    private OutputStream outputStream;

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(Repository repository) throws IOException {
        this.outputStream.write(repository.getKeyName().getBytes());
        this.outputStream.write(repository.getValueName().getBytes());
    }

    public void write(Repository[] repositories) throws IOException {
        String[] write = new String[0];
        int length = 0;
        int index = 0;
        for (int len = 0; len < repositories.length; ++len) {
            write = new String[length + 2];
            Repository repository = repositories[len];
            write[length + 0] = repository.getKeyName();
            write[length + 1] = repository.getValueName();
            length += 2;
            ++index;
        }
        this.outputStream.write("{".getBytes());
        for (int len = 0; len < index; ++len) {
            String key = write[len + 0];
            String value = write[len + 1];
        }
        this.outputStream.write("}".getBytes());
    }

    public void flush() throws IOException {
        this.outputStream.flush();
    }

    public void close() throws IOException {
        this.outputStream.close();
    }
}
