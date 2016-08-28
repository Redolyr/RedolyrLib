package SupplyPower;

/**
 * Created by hyres on 2016/08/28.
 */
public class BuffLocateInit {

    private int buffer;

    public BuffLocateInit(int byteSize) {
        this.buffer = BuffLocate.createBuffer(byteSize);
    }

    public byte getByte(int pos) {
        return BuffLocate.getByte(this.buffer, pos);
    }

    public void setByte(int pos, byte value) {
        BuffLocate.setByte(this.buffer, pos, value);
    }

    public void getBytes(byte[] bytes, int pos, int length) {
        BuffLocate.getBytes(this.buffer, bytes, pos, length);
    }

    public void setBytes(byte[] bytes, int pos, int length) {
        BuffLocate.setBytes(this.buffer, bytes, pos, length);
    }

    protected void finalize() throws Throwable {
        BuffLocate.free(this.buffer);
    }

    public int length() {
        return BuffLocate.getBufferLength(this.buffer);
    }

    public void fill(byte value) {
        BuffLocate.fill(this.buffer, value);
    }

    public void resize(int newByteSize) {
        BuffLocate.resize(this.buffer, newByteSize);
    }

    public int buffer() {
        return this.buffer;
    }

    public char getChar(int pos) {
        return (char) this.getByte(pos);
    }

    public void setChar(int pos, char value) {
        this.setByte(pos, (byte) value);
    }

    public short getShortB(int pos) {
        return (short) (this.getByte(pos * 2 + 0) << 8 | this.getByte(pos * 2 + 1) << 0);
    }

    public short getShortL(int pos) {
        return (short) (this.getByte(pos * 2 + 1) << 8 | this.getByte(pos * 2 + 0) << 0);
    }

    public void setShortB(int pos, short value) {
        this.setByte(pos * 2 + 0, (byte) (value >> 8 & 0xFF));
        this.setByte(pos * 2 + 1, (byte) (value >> 0 & 0xFF));
    }

    public void setShortL(int pos, short value) {
        this.setByte(pos * 2 + 1, (byte) (value >> 8 & 0xFF));
        this.setByte(pos * 2 + 0, (byte) (value >> 0 & 0xFF));
    }

    public int getIntB(int pos) {
        return this.getByte(pos * 4 + 0) << 24 | this.getByte(pos * 4 + 1) << 16 | this.getByte(pos * 4 + 2) << 8 | this.getByte(pos * 4 + 3) << 0;
    }

    public int getIntL(int pos) {
        return this.getByte(pos * 4 + 3) << 24 | this.getByte(pos * 4 + 2) << 16 | this.getByte(pos * 4 + 1) << 8 | this.getByte(pos * 4 + 0) << 0;
    }

    public void setIntB(int pos, int value) {
        this.setByte(pos * 4 + 0, (byte) (value >> 24 & 0xFF));
        this.setByte(pos * 4 + 1, (byte) (value >> 16 & 0xFF));
        this.setByte(pos * 4 + 2, (byte) (value >> 8 & 0xFF));
        this.setByte(pos * 4 + 3, (byte) (value >> 0 & 0xFF));
    }

    public void setIntL(int pos, int value) {
        this.setByte(pos * 4 + 3, (byte) (value >> 24 & 0xFF));
        this.setByte(pos * 4 + 2, (byte) (value >> 16 & 0xFF));
        this.setByte(pos * 4 + 1, (byte) (value >> 8 & 0xFF));
        this.setByte(pos * 4 + 0, (byte) (value >> 0 & 0xFF));
    }

    public long getLongB(int pos) {
        return this.getByte(pos * 8 + 0) << 56 | this.getByte(pos * 8 + 1) << 48 | this.getByte(pos * 8 + 2) << 40 | this.getByte(pos * 8 + 3) << 32 | this.getByte(pos * 8 + 4) << 24 | this.getByte(pos * 8 + 5) << 16 | this.getByte(pos * 8 + 6) << 8 | this.getByte(pos * 8 + 7) << 0;
    }

    public long getLongL(int pos) {
        return this.getByte(pos * 8 + 7) << 56 | this.getByte(pos * 8 + 6) << 48 | this.getByte(pos * 8 + 5) << 40 | this.getByte(pos * 8 + 4) << 32 | this.getByte(pos * 8 + 3) << 24 | this.getByte(pos * 8 + 2) << 16 | this.getByte(pos * 8 + 1) << 8 | this.getByte(pos * 8 + 0) << 0;
    }

    public void setLongB(int pos, long value) {
        this.setByte(pos * 8 + 0, (byte) (value >> 56 & 0xFF));
        this.setByte(pos * 8 + 1, (byte) (value >> 48 & 0xFF));
        this.setByte(pos * 8 + 2, (byte) (value >> 40 & 0xFF));
        this.setByte(pos * 8 + 3, (byte) (value >> 32 & 0xFF));
        this.setByte(pos * 8 + 4, (byte) (value >> 24 & 0xFF));
        this.setByte(pos * 8 + 5, (byte) (value >> 16 & 0xFF));
        this.setByte(pos * 8 + 6, (byte) (value >> 8 & 0xFF));
        this.setByte(pos * 8 + 7, (byte) (value >> 0 & 0xFF));
    }

    public void setLongL(int pos, long value) {
        this.setByte(pos * 8 + 7, (byte) (value >> 56 & 0xFF));
        this.setByte(pos * 8 + 6, (byte) (value >> 48 & 0xFF));
        this.setByte(pos * 8 + 5, (byte) (value >> 40 & 0xFF));
        this.setByte(pos * 8 + 4, (byte) (value >> 32 & 0xFF));
        this.setByte(pos * 8 + 3, (byte) (value >> 24 & 0xFF));
        this.setByte(pos * 8 + 2, (byte) (value >> 16 & 0xFF));
        this.setByte(pos * 8 + 1, (byte) (value >> 8 & 0xFF));
        this.setByte(pos * 8 + 0, (byte) (value >> 0 & 0xFF));
    }

    public float getFloatB(int pos) {
        return Float.intBitsToFloat(this.getIntB(pos));
    }

    public float getFloatL(int pos) {
        return Float.intBitsToFloat(this.getIntL(pos));
    }

    public void setFloatB(int pos, float value) {
        this.setIntB(pos, Float.floatToIntBits(value));
    }

    public void setFloatL(int pos, float value) {
        this.setIntL(pos, Float.floatToIntBits(value));
    }

    public double getDoubleB(int pos) {
        return Double.longBitsToDouble(this.getLongB(pos));
    }

    public double getDoubleL(int pos) {
        return Double.longBitsToDouble(this.getLongL(pos));
    }

    public void setDoubleB(int pos, double value) {
        this.setLongB(pos, Double.doubleToLongBits(value));
    }

    public void setDoubleL(int pos, double value) {
        this.setLongL(pos, Double.doubleToLongBits(value));
    }

    public int hashCode() {
        byte[] bytes = new byte[this.length()];
        this.getBytes(bytes, 0, bytes.length);
        return bytes.hashCode();
    }

    public boolean equals(Object object) {
        byte[] bytes = new byte[this.length()];
        this.getBytes(bytes, 0, bytes.length);
        return bytes.equals(object);
    }
}
