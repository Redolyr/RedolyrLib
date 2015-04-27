package RedolyrLibrary.testFrame2;

import java.nio.*;

/**
 * Created by redolyr on 2014/12/23.
 */
public final class Draw {

    public static final int BEGIN = -0x01;
    public static final int END = -0x02;
    public static final int VERTEX = -0x03;

    public static final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(0x20000 * 4).order(ByteOrder.nativeOrder());
    public static final IntBuffer intBuffer = byteBuffer.asIntBuffer();
    public static final DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
    public static final FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();

    private static boolean isBegin;
    private static int beginFlip;
    private static int vertexFlip;
    private static int vertexLength;

    public static void putVertex(byte par1, byte par2) {
        if (isBegin) {
            byteBuffer.put(new byte[]{VERTEX, par1, par2});
            ++vertexFlip;
            if (vertexFlip == 4) {
                vertexFlip = 0;
                ++vertexLength;
            }
        } else throw new IllegalArgumentException("have not started");
    }

    public static void putVertex(int par1, int par2) {
        if (isBegin) {
            intBuffer.put(new int[]{VERTEX, par1, par2});
            ++vertexFlip;
            if (vertexFlip == 4) {
                vertexFlip = 0;
                ++vertexLength;
            }
        } else throw new IllegalArgumentException("have not started");
    }

    public static void putVertex(double par1, double par2) {
        if (isBegin) {
            doubleBuffer.put(new double[]{VERTEX, par1, par2});
            ++vertexFlip;
            if (vertexFlip == 4) {
                vertexFlip = 0;
                ++vertexLength;
            }
        } else throw new IllegalArgumentException("have not started");
    }

    public static void putVertex(float par1, float par2) {
        if (isBegin) {
            floatBuffer.put(new float[]{VERTEX, par1, par2});
            ++vertexFlip;
            if (vertexFlip == 4) {
                vertexFlip = 0;
                ++vertexLength;
            }
        } else throw new IllegalArgumentException("have not started");
    }

    public static void putBegin() {
        if (!isBegin) {
            byteBuffer.put(new byte[]{BEGIN, 1, END, 0});
            isBegin = true;
            ++beginFlip;
        } else throw new IllegalArgumentException("have already started");
    }

    public static void putEnd() {
        if (isBegin) {
            byteBuffer.put(new byte[]{BEGIN, 0, END, 1});
            isBegin = false;
        } else throw new IllegalArgumentException("have not started");
    }

    public static void clearVertex() {
        vertexFlip = 0;
        vertexLength = 0;
    }

    public static byte[] getByteBufferArray() {
        byteBuffer.position(0);
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        byteBuffer.flip();

        return bytes;
    }

    public static int getVertexFlip() {
        return vertexLength;
    }

    public static boolean isBegin() {
        return isBegin;
    }

    public static int getBeginLength() {
        return beginFlip;
    }

    static {
        byteBuffer.clear();
        intBuffer.clear();
        doubleBuffer.clear();
        floatBuffer.clear();
    }
}
