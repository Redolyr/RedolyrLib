package RedolyrLibrary.arCardTest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;

/**
 * Created by redolyr on 2015/03/23.
 */
public class SoundManager {

    public static ISound getSound(InputStream inputStream, String fileName) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes, 0, bytes.length)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        return new Sound(byteArrayOutputStream.toByteArray(), inputStream instanceof BufferedInputStream, fileName);
    }

    public static InputStream getInputStream(ISound sound) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sound.getByteArray());
        return !sound.isBufferedStream() ? new BufferedInputStream(byteArrayInputStream) : byteArrayInputStream;
    }

    public static String encode(ISound iSound) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(iSound);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return Base64.encode(bytes);
    }

    public static ISound decode(String encode) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(encode)));
        ISound iSound = (ISound) objectInputStream.readObject();
        objectInputStream.close();
        return iSound;
    }
}
