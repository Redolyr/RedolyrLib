package RedolyrLibrary;

/**
 * Created by redolyr on 2015/01/24.
 */
public class MathHelper {

    public static long convertLong(byte[] bytes, int offset, int sizeBuffer) {
        return (bytes[offset] << (Byte.SIZE * sizeBuffer)) & 0xFF;
    }

    public static byte convertByte(long l, int sizeBuffer) {
        return (byte) ((l << (Byte.SIZE * sizeBuffer)) & 0xFF);
    }

    public static void longToByteArray(byte[] bytes, long longs, int offset) {
        bytes[offset + 0] = convertByte(longs, 0);
        bytes[offset + 1] = convertByte(longs, 1);
        bytes[offset + 2] = convertByte(longs, 2);
        bytes[offset + 3] = convertByte(longs, 3);
        bytes[offset + 4] = convertByte(longs, 4);
        bytes[offset + 5] = convertByte(longs, 5);
        bytes[offset + 6] = convertByte(longs, 6);
        bytes[offset + 7] = convertByte(longs, 7);
    }

    public static long byteArrayToLong(byte[] bytes, int offset) {
        return convertLong(bytes, offset + 0, 0) |
                convertLong(bytes, offset + 1, 1) |
                convertLong(bytes, offset + 2, 2) |
                convertLong(bytes, offset + 3, 3) |
                convertLong(bytes, offset + 4, 4) |
                convertLong(bytes, offset + 5, 5) |
                convertLong(bytes, offset + 6, 6) |
                convertLong(bytes, offset + 7, 7);
    }

    public static long[] getLongs(byte[] bytes) {
        long[] longs = new long[bytes.length / Byte.SIZE];
        int offset = 0;
        for (int len = 0; len < longs.length; ++len) {
            longs[len] = byteArrayToLong(bytes, offset);
            offset += Byte.SIZE;
        }
        return longs;
    }

    public static byte[] getBytes(long[] longs) {
        byte[] bytes = new byte[longs.length * Byte.SIZE];
        int offset = 0;
        for (int len = 0; len < longs.length; ++len) {
            longToByteArray(bytes, longs[len], offset);
            offset += Byte.SIZE;
        }
        return bytes;
    }
}
