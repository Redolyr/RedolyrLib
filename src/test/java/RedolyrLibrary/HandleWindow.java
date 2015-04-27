package RedolyrLibrary;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/04/27.
 */
public class HandleWindow implements Serializable {

    private static final long serialVersionUID = 1L;

    public transient int x;
    public transient int y;
    public transient int width;
    public transient int height;
    public transient String title = "";

    public long[] hwnd;

    public ByteBuffer toByteBuffer() {
        int handleSize = (4 << 2) + (this.title.length() * 4);
        ByteBuffer byteBuffer = ByteBufferUtil.createByteBuffer(handleSize);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.position(8);
        charBuffer.put(this.title);
        charBuffer.flip();
        intBuffer.position(0);
        intBuffer.put(new int[]{this.x, this.y, this.width, this.height});
        intBuffer.flip();
        return byteBuffer;
    }

    public static void fromByteBuffer(HandleWindow handleWindow, ByteBuffer byteBuffer) {
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.position(8);
        char[] chars = ByteBufferUtil.createAndGetCharArray(charBuffer);
        intBuffer.position(0);
        int[] ints = ByteBufferUtil.createAndGetIntArray(intBuffer);
        handleWindow.x = ints[0];
        handleWindow.y = ints[1];
        handleWindow.width = ints[2];
        handleWindow.height = ints[3];
        handleWindow.title = new String(chars);
    }

    public static void fromLongArray(HandleWindow handleWindow, long[] hwnd) {
        ByteBuffer byteBuffer = ByteBufferUtil.createByteBuffer(hwnd.length << 3);
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        longBuffer.put(hwnd);
        longBuffer.flip();
        fromByteBuffer(handleWindow, byteBuffer);
    }

    public HandleWindow fromByteBuffer(ByteBuffer byteBuffer) {
        this.fromByteBuffer(this, byteBuffer);
        return this;
    }

    public HandleWindow fromLongArray(long[] hwnd) {
        this.fromLongArray(this, hwnd);
        return this;
    }

    public HandleWindow flip() {
        ByteBuffer byteBuffer = this.toByteBuffer();
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        this.hwnd = ByteBufferUtil.createAndGetLongArray(longBuffer);
        return this;
    }

    public String toString() {
        return Arrays.toString(this.hwnd).replace('[', ']').replace("]", "");
    }
}
