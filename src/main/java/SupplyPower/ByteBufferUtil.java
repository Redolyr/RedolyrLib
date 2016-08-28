package SupplyPower;

import java.nio.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2016/08/10.
 */
public class ByteBufferUtil {

    public static final int INT_SIZE = 2 << 2;
    public static final int SHORT_SIZE = 2 << 1;
    public static final int LONG_SIZE = 2 << 3;
    public static final int BYTE_SIZE = 2 << 3;
    public static final int DOUBLE_SIZE = 2 << 5;
    public static final int FLOAT_SIZE = 2 << 5;
    public static final int CHAR_SIZE = 2 << 4;

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

    public static ByteBuffer createWrapByteBufferFromByteArray(byte[] bytes, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BYTE_SIZE * (length - offset));
        byteBuffer.put(bytes, offset, length);
        byteBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer createWrapByteBufferFromIntArray(int[] ints, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(INT_SIZE * (length - offset));
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(ints, offset, length);
        intBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer createWrapByteBufferFromShortArray(short[] shorts, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(SHORT_SIZE * (length - offset));
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer.put(shorts, offset, length);
        shortBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer createWrapByteBufferFromLongArray(long[] longs, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(LONG_SIZE * (length - offset));
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        longBuffer.put(longs, offset, length);
        longBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer createWrapByteBufferFromDoubleArray(double[] doubles, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(DOUBLE_SIZE * (length - offset));
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        doubleBuffer.put(doubles, offset, length);
        doubleBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer createWrapByteBufferFromFloatArray(float[] floats, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(FLOAT_SIZE * (length - offset));
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(floats, offset, length);
        floatBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer createWrapByteBufferFromCharArray(char[] chars, int offset, int length) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(CHAR_SIZE * (length - offset));
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(chars, offset, length);
        charBuffer.flip();
        return byteBuffer;
    }

    public static int[] createAndGetIntArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return createAndGetIntArray(byteBuffer.asIntBuffer());
    }

    public static short[] createAndGetShortArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return createAndGetShortArray(byteBuffer.asShortBuffer());
    }

    public static long[] createAndGetLongArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return createAndGetLongArray(byteBuffer.asLongBuffer());
    }

    public static double[] createAndGetDoubleArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return createAndGetDoubleArray(byteBuffer.asDoubleBuffer());
    }

    public static float[] createAndGetFloatArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return createAndGetFloatArray(byteBuffer.asFloatBuffer());
    }

    public static char[] createAndGetCharArrayFromByteBuffer(ByteBuffer byteBuffer) {
        return createAndGetCharArray(byteBuffer.asCharBuffer());
    }

    public static String toString(ByteBuffer byteBuffer) {
        return Arrays.toString(createAndGetByteArray(byteBuffer));
    }

    public static String toString(IntBuffer intBuffer) {
        return Arrays.toString(createAndGetIntArray(intBuffer));
    }

    public static String toString(ShortBuffer shortBuffer) {
        return Arrays.toString(createAndGetShortArray(shortBuffer));
    }

    public static String toString(LongBuffer longBuffer) {
        return Arrays.toString(createAndGetLongArray(longBuffer));
    }

    public static String toString(DoubleBuffer doubleBuffer) {
        return Arrays.toString(createAndGetDoubleArray(doubleBuffer));
    }

    public static String toString(FloatBuffer floatBuffer) {
        return Arrays.toString(createAndGetFloatArray(floatBuffer));
    }

    public static String toString(CharBuffer charBuffer) {
        return Arrays.toString(createAndGetCharArray(charBuffer));
    }
}
