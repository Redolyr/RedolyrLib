package RedolyrLibrary;

import java.io.*;

/**
 * Created by redolyr on 2015/04/07.
 */
public class FileUtil {

    public static byte[] decode(File file) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(file);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return bytes;
    }

    public static File encode(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        File file = (File) objectInputStream.readObject();
        objectInputStream.close();
        return file;
    }
}
