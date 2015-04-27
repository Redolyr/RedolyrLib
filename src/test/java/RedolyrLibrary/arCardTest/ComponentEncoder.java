package RedolyrLibrary.arCardTest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by redolyr on 2015/03/21.
 */
public class ComponentEncoder {

    public static DrawComponent drawComponentDecoder(String encoder) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(encoder)));
        DrawComponent drawComponent = (DrawComponent) objectInputStream.readObject();
        objectInputStream.close();
        return drawComponent;
    }

    public static String drawComponentEncoder(DrawComponent drawComponent) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(drawComponent);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return Base64.encode(bytes);
    }
}
