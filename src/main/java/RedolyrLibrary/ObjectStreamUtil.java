package RedolyrLibrary;

import java.io.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/04/27.
 */
public class ObjectStreamUtil {

    public static void write(OutputStream outputStream, boolean isNotClosing, Object... objects) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        for (int len = 0; len < objects.length; ++len) {
            Object o = objects[len];
            if (o instanceof Integer) {
                objectOutputStream.writeInt((Integer) o);
            } else if (o instanceof Short) {
                objectOutputStream.writeShort((Short) o);
            } else if (o instanceof Long) {
                objectOutputStream.writeLong((Long) o);
            } else if (o instanceof Byte) {
                objectOutputStream.writeByte((Byte) o);
            } else if (o instanceof Double) {
                objectOutputStream.writeDouble((Double) o);
            } else if (o instanceof Float) {
                objectOutputStream.writeFloat((Float) o);
            } else if (o instanceof Boolean) {
                objectOutputStream.writeBoolean((Boolean) o);
            } else if (o instanceof String) {
                objectOutputStream.writeUTF((String) o);
            } else if (o instanceof Character) {
                objectOutputStream.writeChar((Character) o);
            } else {
                objectOutputStream.writeObject(o);
            }
        }
        if (!isNotClosing) objectOutputStream.close();
    }

    public static Object[] read(InputStream inputStream, boolean isNotClosing, Class... usingClass) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object[] objects = null;
        for (int len = 0; len < usingClass.length; ++len) {
            Class c = usingClass[len];
            Object o;
            if (c == Integer.TYPE) {
                o = objectInputStream.readInt();
            } else if (c == Short.TYPE) {
                o = objectInputStream.readShort();
            } else if (c == Long.TYPE) {
                o = objectInputStream.readLong();
            } else if (c == Byte.TYPE) {
                o = objectInputStream.readByte();
            } else if (c == Double.TYPE) {
                o = objectInputStream.readDouble();
            } else if (c == Float.TYPE) {
                o = objectInputStream.readFloat();
            } else if (c == Boolean.TYPE) {
                o = objectInputStream.readBoolean();
            } else if (c == String.class) {
                o = objectInputStream.readUTF();
            } else if (c == Character.TYPE) {
                o = objectInputStream.readChar();
            } else {
                o = objectInputStream.readObject();
            }
            if (objects == null) objects = new Object[1];
            else objects = Arrays.copyOf(objects, objects.length + 1);
            objects[objects.length - 1] = o;
        }
        if (!isNotClosing) objectInputStream.close();
        return objects;
    }
}
