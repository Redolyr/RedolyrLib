package RedolyrLibrary.viewFrame;

import java.nio.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/02/08.
 */
public class VertexPointer {

    private ByteBuffer byteBuffer = ByteBuffer.allocateDirect(0x20000 * 4).order(ByteOrder.nativeOrder());
    private IntBuffer intBuffer = byteBuffer.asIntBuffer();
    private ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
    private LongBuffer longBuffer = byteBuffer.asLongBuffer();
    private DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
    private FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();

    public static final int QUADS = -0x1;

    public static final int[] values = new int[] {QUADS};

    private int begin;
    private int beginPosition;

    private int[] begins;
    private int[] beginPositions;
    private int beginLength;

    private void beginCheck() {
        if (this.begin == 0) throw new IllegalArgumentException("Please BEGIN!");
    }

    private void endCheck() {
        if (this.begin != 0) throw new IllegalArgumentException("Please END!");
    }

    public void begin(int begin) {
        if (this.begin != 0) throw new IllegalArgumentException("Please END!");

        this.begin = begin;
    }

    public void end() {

        if (this.begin == 0) throw new IllegalArgumentException("Please BEGIN!");

        if (this.begins == null) this.begins = new int[1];
        else this.begins = Arrays.copyOf(this.begins, this.beginLength);

        if (this.beginPositions == null) this.beginPositions = new int[1];
        else this.beginPositions = Arrays.copyOf(this.beginPositions, this.beginLength);

        this.begins[this.beginLength] = this.begin;
        this.beginPositions[this.beginLength] = this.beginPosition;

        ++this.beginLength;

        this.begin = 0;
        this.beginPosition = 0;
    }

    public int[][] get() {
        return new int[][] {{this.begin, this.beginPosition, this.beginLength}, this.begins, this.beginPositions};
    }

    private void vertexUpdate() {
        this.beginCheck();
        ++this.beginPosition;
    }

    public void vertex(byte b) {
        this.byteBuffer.put(b);
        this.vertexUpdate();
    }

    public void vertex(int i) {
        this.intBuffer.put(i);
        this.vertexUpdate();
    }

    public void vertex(short s) {
        this.shortBuffer.put(s);
        this.vertexUpdate();
    }

    public void vertex(long l) {
        this.longBuffer.put(l);
        this.vertexUpdate();
    }

    public void vertex(double d) {
        this.doubleBuffer.put(d);
        this.vertexUpdate();
    }

    public void vertex(float f) {
        this.floatBuffer.put(f);
        this.vertexUpdate();
    }

    public void vertex2(byte b, byte b1) {
        this.vertex(b);
        this.vertex(b1);
    }

    public void vertex2(int i, int i1) {
        this.vertex(i);
        this.vertex(i1);
    }

    public void vertex2(short s, short s1) {
        this.vertex(s);
        this.vertex(s1);
    }

    public void vertex2(long l, long l1) {
        this.vertex(l);
        this.vertex(l1);
    }

    public void vertex2(double d, double d1) {
        this.vertex(d);
        this.vertex(d1);
    }

    public void vertex2(float f, float f1) {
        this.vertex(f);
        this.vertex(f1);
    }

    public void vertex3(byte b, byte b1, byte b2) {
        this.vertex(b);
        this.vertex(b1);
        this.vertex(b2);
    }

    public void vertex3(int i, int i1, int i2) {
        this.vertex(i);
        this.vertex(i1);
        this.vertex(i2);
    }

    public void vertex3(short s, short s1, short s2) {
        this.vertex(s);
        this.vertex(s1);
        this.vertex(s2);
    }

    public void vertex3(long l, long l1, long l2) {
        this.vertex(l);
        this.vertex(l1);
        this.vertex(l2);
    }

    public void vertex3(double d, double d1, double d2) {
        this.vertex(d);
        this.vertex(d1);
        this.vertex(d2);
    }

    public void vertex3(float f, float f1, float f2) {
        this.vertex(f);
        this.vertex(f1);
        this.vertex(f2);
    }

    public void vertex4(byte b, byte b1, byte b2, byte b3) {
        this.vertex(b);
        this.vertex(b1);
        this.vertex(b2);
        this.vertex(b3);
    }

    public void vertex4(int i, int i1, int i2, int i3) {
        this.vertex(i);
        this.vertex(i1);
        this.vertex(i2);
        this.vertex(i3);
    }

    public void vertex4(short s, short s1, short s2, short s3) {
        this.vertex(s);
        this.vertex(s1);
        this.vertex(s2);
        this.vertex(s3);
    }

    public void vertex4(long l, long l1, long l2, long l3) {
        this.vertex(l);
        this.vertex(l1);
        this.vertex(l2);
        this.vertex(l3);
    }

    public void vertex4(double d, double d1, double d2, double d3) {
        this.vertex(d);
        this.vertex(d1);
        this.vertex(d2);
        this.vertex(d3);
    }

    public void vertex4(float f, float f1, float f2, float f3) {
        this.vertex(f);
        this.vertex(f1);
        this.vertex(f2);
        this.vertex(f3);
    }

    public ByteBuffer getByteBuffer() {
        this.endCheck();
        return this.byteBuffer;
    }
}
