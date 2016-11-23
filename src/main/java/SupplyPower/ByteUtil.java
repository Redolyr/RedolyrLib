package SupplyPower;

/**
 * Created by redolyr on 2016/09/04.
 */
public class ByteUtil {

    public static short getShortB(byte par1, byte par2) {
        return (short) (par1 << 8 | par2 << 0);
    }

    public static short getShortL(byte par1, byte par2) {
        return (short) (par1 << 0 | par2 << 8);
    }

    public static byte[] setShortB(short value) {
        return new byte[] {(byte) (value >> 8 & 0xFF), (byte) (value >> 0 & 0xFF)};
    }

    public static byte[] setShortL(short value) {
        return new byte[] {(byte) (value >> 0 & 0xFF), (byte) (value >> 8 & 0xFF)};
    }

    public static int getIntB(byte par1, byte par2, byte par3, byte par4) {
        return par1 << 24 | par2 << 16 | par3  << 8 | par4 << 0;
    }

    public static int getIntL(byte par1, byte par2, byte par3, byte par4) {
        return par1 << 0 | par2 << 8 | par3  << 16 | par4 << 24;
    }

    public static byte[] setIntB(int value) {
        return new byte[] {(byte) (value >> 24 & 0xFF), (byte) (value >> 16 & 0xFF), (byte) (value >> 8 & 0xFF), (byte) (value >> 0 & 0xFF)};
    }

    public static byte[] setIntL(int value) {
        return new byte[] {(byte) (value >> 0 & 0xFF), (byte) (value >> 8 & 0xFF), (byte) (value >> 16 & 0xFF), (byte) (value >> 24 & 0xFF)};
    }

    public static long getLongB(byte par1, byte par2, byte par3, byte par4, byte par5, byte par6, byte par7, byte par8) {
        return par1 << 56 | par2 << 48 | par3  << 40 | par4 << 32 | par5 << 24 | par6 << 16 | par7  << 8 | par8 << 0;
    }

    public static long getLongL(byte par1, byte par2, byte par3, byte par4, byte par5, byte par6, byte par7, byte par8) {
        return par1 << 0 | par2 << 8 | par3  << 16 | par4 << 24 | par5 << 32 | par6 << 40 | par7  << 48 | par8 << 56;
    }

    public static byte[] setLongB(long value) {
        return new byte[] {(byte) (value >> 56 & 0xFF), (byte) (value >> 48 & 0xFF), (byte) (value >> 40 & 0xFF), (byte) (value >> 32 & 0xFF), (byte) (value >> 24 & 0xFF), (byte) (value >> 16 & 0xFF), (byte) (value >> 8 & 0xFF), (byte) (value >> 0 & 0xFF)};
    }

    public static byte[] setLongL(long value) {
        return new byte[] {(byte) (value >> 0 & 0xFF), (byte) (value >> 8 & 0xFF), (byte) (value >> 16 & 0xFF), (byte) (value >> 24 & 0xFF), (byte) (value >> 32 & 0xFF), (byte) (value >> 40 & 0xFF), (byte) (value >> 48 & 0xFF), (byte) (value >> 56 & 0xFF)};
    }

    public static float getFloatB(byte par1, byte par2, byte par3, byte par4) {
        return Float.intBitsToFloat(getIntB(par1, par2, par3, par4));
    }

    public static float getFloatL(byte par1, byte par2, byte par3, byte par4) {
        return Float.intBitsToFloat(getIntL(par1, par2, par3, par4));
    }

    public static byte[] setFloatB(float value) {
        return setIntB(Float.floatToIntBits(value));
    }

    public static byte[] setFloatL(float value) {
        return setIntL(Float.floatToIntBits(value));
    }

    public static double getDoubleB(byte par1, byte par2, byte par3, byte par4, byte par5, byte par6, byte par7, byte par8) {
        return Double.longBitsToDouble(getLongB(par1, par2, par3, par4, par5, par6, par7, par8));
    }

    public static double getDoubleL(byte par1, byte par2, byte par3, byte par4, byte par5, byte par6, byte par7, byte par8) {
        return Double.longBitsToDouble(getLongL(par1, par2, par3, par4, par5, par6, par7, par8));
    }

    public static byte[] setDoubleB(double value) {
        return setLongB(Double.doubleToLongBits(value));
    }

    public static byte[] setDoubleL(double value) {
        return setLongL(Double.doubleToLongBits(value));
    }
}
