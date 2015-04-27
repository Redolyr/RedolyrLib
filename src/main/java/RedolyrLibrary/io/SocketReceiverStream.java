package RedolyrLibrary.io;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by redolyr on 2015/02/06.
 */
public class SocketReceiverStream {

    private Socket socket;
//    private DataTagCompound dataTagCompound;

    private int length;

    private int readTime;

    public SocketReceiverStream(Socket socket) throws SocketException {
        this.socket = socket;
    }

    public void close() throws IOException {
        this.socket.close();
    }
}
