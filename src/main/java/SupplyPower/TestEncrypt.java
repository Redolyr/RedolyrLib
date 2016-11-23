package SupplyPower;

import java.util.Arrays;

/**
 * Created by redolyr on 2016/11/15.
 */
public class TestEncrypt {

    private static void encode0(byte[] dest, byte[] src, int[] uses) {
        byte stack;
        byte[] bytes = src;
        int length = 0;
        for (int pos = 0; pos < uses.length; ++pos) {
            int zero = uses[(pos + 0) % uses.length];
            int one = uses[(pos + 1) % uses.length];
            int count = uses[(pos + 2) % uses.length];
            for (int len = 0; len < count; ++len) {
                int modZero = len * zero % src.length;
                int modOne = len * one % src.length;
                stack = bytes[modZero];
                bytes[modZero] = bytes[modOne];
                bytes[modOne] = stack;
                ++length;
            }
        }
        System.out.println(length + ", " + Arrays.toString(uses));
        System.arraycopy(bytes, 0, dest, 0, bytes.length);
    }

    private static void decode0(byte[] dest, byte[] src, int[] uses) {
        byte stack;
        byte[] bytes = src;
        int length = 0;
        for (int pos = 0; pos < uses.length; ++pos) {
            int zero = uses[(pos + 0) % uses.length];
            int one = uses[(pos + 1) % uses.length];
            int count = uses[(pos + 2) % uses.length];
            for (int len = count - 1; len >= 0; --len) {
                int modZero = len * zero % bytes.length;
                int modOne = len * one % bytes.length;
                stack = bytes[modZero];
                bytes[modZero] = bytes[modOne];
                bytes[modOne] = stack;
                ++length;
            }
        }
        System.out.println(length + ", " + Arrays.toString(uses));
        System.arraycopy(bytes, 0, dest, 0, bytes.length);
    }

    public static void coding(byte[] dest, byte[] src, int[] uses) {
        encode0(dest, src, uses);
        decode0(dest, src, uses);
    }
}
