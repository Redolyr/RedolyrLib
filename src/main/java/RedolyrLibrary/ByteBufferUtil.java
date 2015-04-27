package RedolyrLibrary;

import java.nio.*;

/**
 * Created by redolyr on 2015/01/22.
 */
public class ByteBufferUtil {

    public static final ByteOrder currentSupportedNativeOrder() {
        return ByteOrder.nativeOrder();
    }

    public static final ByteBuffer createByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity).order(currentSupportedNativeOrder());
    }

    public static final ByteBuffer createWrapByteBuffer(byte[] bytes, int offset, int length) {
        return ByteBuffer.wrap(bytes, offset, length).order(currentSupportedNativeOrder());
    }

    public static final ByteBuffer createWrapByteBuffer(byte[] bytes) {
        return createWrapByteBuffer(bytes, 0, bytes.length);
    }

    public static final byte[] getByteArrayFromByteBuffer(ByteBuffer byteBuffer, int byteArrayCapacity, int byteArrayPosition) {
        byte[] bytes = new byte[byteArrayCapacity - byteArrayPosition];
        byteBuffer.get(bytes, 0, bytes.length);
        return bytes;
    }

    public static final byte[] getByteArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return getByteArrayFromByteBuffer(byteBuffer, byteBuffer.capacity(), byteBuffer.position());
    }

    public static final long readLongFromByteArray(byte[] bytes) {
        ByteBuffer byteBuffer = createWrapByteBuffer(bytes);
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        return longBuffer.get();
    }

    public static final byte[] writeLongToByteArray(long l) {
        byte[] bytes = new byte[Long.SIZE * Byte.SIZE];
        ByteBuffer byteBuffer = createWrapByteBuffer(bytes);
        byteBuffer.asLongBuffer().put(l);
        return bytes;
    }

    public static final int readIntFromByteArray(byte[] bytes) {
        ByteBuffer byteBuffer = createWrapByteBuffer(bytes);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        return intBuffer.get();
    }

    public static final byte[] writeIntToByteArray(int l) {
        byte[] bytes = new byte[Integer.SIZE / Byte.SIZE];
        ByteBuffer byteBuffer = createWrapByteBuffer(bytes);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(l);
        return bytes;
    }

    public static final int getSize(Class<? extends Buffer> bufferClass, boolean isAllocateMode) {
        int size;
        if (bufferClass == IntBuffer.class) size = Integer.SIZE;
        else if (bufferClass == ShortBuffer.class) size = Short.SIZE;
        else if (bufferClass == LongBuffer.class) size = Long.SIZE;
        else if (bufferClass == ByteBuffer.class) size = Byte.SIZE;
        else if (bufferClass == DoubleBuffer.class) size = Double.SIZE;
        else if (bufferClass == FloatBuffer.class) size = Float.SIZE;
        else size = 0;

        if (isAllocateMode) size /= (Byte.SIZE / 2);

        return size;
    }

    public static final int busCaluc(int bufBus) {
        return 8 * bufBus;
    }

    public static final byte putLongBusCaluc(long value, int bufBus) {
        return (byte) ((value >> busCaluc(bufBus)) & 0xFF);
    }

    public static final void putLong(long value, byte[] bytes, int offset) {
        for (int len = 0; len < 8; ++len) {
            bytes[offset + len] = putLongBusCaluc(value, len + 1);
        }
    }

    public static final String blankReplaces(String regex) {
        return regex.replaceAll(", ", ". ").replaceAll("0. 0.", ", ,").replaceAll(", ", "").replaceAll(". ", ", ").replaceAll(", ,", "]");
    }

    public static byte[] createAndGetByteArray(ByteBuffer byteBuffer) {
        byte[] bytes = new byte[byteBuffer.limit() - byteBuffer.position()];
        byteBuffer.get(bytes);
        return bytes;
    }

    public static int[] createAndGetIntArray(IntBuffer intBuffer) {
        int[] ints = new int[intBuffer.limit() - intBuffer.position()];
        intBuffer.get(ints);
        return ints;
    }

    public static short[] createAndGetShortArray(ShortBuffer shortBuffer) {
        short[] shorts = new short[shortBuffer.limit() - shortBuffer.position()];
        shortBuffer.get(shorts);
        return shorts;
    }

    public static long[] createAndGetLongArray(LongBuffer longBuffer) {
        long[] longs = new long[longBuffer.limit() - longBuffer.position()];
        longBuffer.get(longs);
        return longs;
    }

    public static double[] createAndGetDoubleArray(DoubleBuffer doubleBuffer) {
        double[] doubles = new double[doubleBuffer.limit() - doubleBuffer.position()];
        doubleBuffer.get(doubles);
        return doubles;
    }

    public static float[] createAndGetFloatArray(FloatBuffer floatBuffer) {
        float[] floats = new float[floatBuffer.limit() - floatBuffer.position()];
        floatBuffer.get(floats);
        return floats;
    }

    public static char[] createAndGetCharArray(CharBuffer charBuffer) {
        char[] chars = new char[charBuffer.limit() - charBuffer.position()];
        charBuffer.get(chars);
        return chars;
    }

    public static long[] getLongFromString(String par1String) {
        ByteBuffer byteBuffer = createByteBuffer(par1String.getBytes().length * getSize(ByteBuffer.class, true));
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        byteBuffer.position(0);
        byteBuffer.put(par1String.getBytes());
        return createAndGetLongArray(longBuffer);
    }

    public static String getStringFromLong(long[] longs) {
        ByteBuffer byteBuffer = createByteBuffer(longs.length * getSize(LongBuffer.class, true));
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        longBuffer.position(0);
        longBuffer.put(longs);
        return new String(createAndGetByteArray(byteBuffer));
    }
}
