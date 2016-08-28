package SupplyPower;

import java.util.Arrays;

/**
 * Created by hyres on 2016/08/27.
 */
public class BuffLocate {

    private static volatile byte[] bytes = new byte[0];
    private static volatile int[] poses = new int[0];
    private static volatile int[] lengths = new int[0];
    private static volatile int pos;

    public static int createBuffer(int byteSize) {
        bytes = Arrays.copyOf(bytes, bytes.length + byteSize);
        poses = Arrays.copyOf(poses, poses.length + 1);
        lengths = Arrays.copyOf(lengths, lengths.length + 1);

        int newPos = pos;
        poses[newPos] = bytes.length - byteSize;
        lengths[newPos] = byteSize;
        ++pos;
        return newPos;
    }

    public static int getBufferLength(int buffer) {
        return lengths[buffer];
    }

    public static void free(int buffer) {
        int bufferPos = poses[buffer];
        int bufferLength = lengths[buffer];
        int index = bufferPos + bufferLength;
        int bytesLength = bytes.length;

        int move = 0;
        if (lengths.length > 0 && lengths.length < buffer + 1) {
            move = lengths[buffer + 1];
        }

        if (index - 1 < bytes.length) {
            System.arraycopy(bytes, index, bytes, bufferPos, move);
        }
        bytes = Arrays.copyOf(bytes, bytesLength - bufferLength);
        poses[buffer] = 0;
        lengths[buffer] = 0;

        if (bytes.length == bytesLength) {
            bytes = Arrays.copyOf(bytes, bytes.length - bufferLength);
        }

        if (poses.length - 1 == buffer) {
            poses = Arrays.copyOf(poses, poses.length - 1);
        }

        if (lengths.length - 1 == buffer) {
            lengths = Arrays.copyOf(lengths, lengths.length - 1);
        }

        if (bytes.length == 0) {
            if (poses.length > 0) {
                poses = new int[0];
            }
            if (lengths.length > 0) {
                lengths = new int[0];
            }
        }
        --pos;
    }

    public static void setByte(int buffer, int pos, byte value) {
        if (pos > lengths[buffer]) throw new ArrayIndexOutOfBoundsException(pos);
        bytes[poses[buffer] + pos] = value;
    }

    public static byte getByte(int buffer, int pos) {
        if (pos > lengths[buffer]) throw new ArrayIndexOutOfBoundsException(pos);
        return bytes[poses[buffer] + pos];
    }

    public static void setBytes(int buffer, byte[] inBytes, int pos, int length) {
        int bufferLength = lengths[buffer];
        if (pos > bufferLength || bufferLength < length) throw new ArrayIndexOutOfBoundsException(pos);
        System.arraycopy(inBytes, pos, bytes, poses[buffer], length);
    }

    public static void getBytes(int buffer, byte[] inBytes, int pos, int length) {
        int bufferLength = lengths[buffer];
        if (pos > bufferLength || bufferLength < length) throw new ArrayIndexOutOfBoundsException(pos);
        System.arraycopy(bytes, poses[buffer], inBytes, pos, length);
    }

    public static void resize(int buffer, int newByteSize) {

        if (newByteSize < 0) throw new NegativeArraySizeException();
        int buffPos = poses[buffer];
        int buffLength = lengths[buffer];
        lengths[buffer] = newByteSize;
        if (buffLength < newByteSize) {
            bytes = Arrays.copyOf(bytes, bytes.length + (newByteSize - buffLength));
        }
        int backLength = 0;
        for (int len = buffer + 1; len < lengths.length; ++len) {
            backLength += lengths[len];
        }
        for (int len = buffer + 1; len < poses.length; ++len) {
            poses[len] += newByteSize - buffLength;
        }
        System.arraycopy(bytes, buffPos + buffLength, bytes, buffPos + newByteSize, backLength);
        if (buffLength > newByteSize) {
            bytes = Arrays.copyOf(bytes, bytes.length + (buffLength - newByteSize));
        }
        System.out.println(bytes.length + ", " + (buffLength < newByteSize ? newByteSize - buffLength : buffLength - newByteSize));
        int length = (buffLength < newByteSize ? newByteSize - buffLength : buffLength - newByteSize);
        for (int len = 0; len < length; ++len) {
            bytes[buffPos + buffLength+ len] = 0;
        }
    }

    public static void fill(int buffer, byte value) {
        byte[] fillBytes = new byte[lengths[buffer]];
        Arrays.fill(fillBytes, value);
        System.arraycopy(fillBytes, 0, bytes, poses[buffer], fillBytes.length);
    }

    public static void clear(int buffer) {
        byte[] fillBytes = new byte[lengths[buffer]];
        System.arraycopy(fillBytes, 0, bytes, poses[buffer], fillBytes.length);
    }

    public static void allReset() {
        bytes = new byte[0];
        poses = new int[0];
        lengths = new int[0];
        pos = 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        allReset();
    }
}
