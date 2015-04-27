package RedolyrLibrary.arCardTest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;

/**
 * Created by redolyr on 2015/03/23.
 */
public class TextureManager {

    public String encode(Texture texture) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(texture);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return Base64.encode(bytes);
    }

    public Texture decode(String encode) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(encode));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Texture) objectInputStream.readObject();
    }
}
