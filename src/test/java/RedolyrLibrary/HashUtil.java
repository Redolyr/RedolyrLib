package RedolyrLibrary;

import java.util.Arrays;

/**
 * Created by redolyr on 2015/04/07.
 */
public class HashUtil {

    public static String hashEncode(byte[] bytes) {
        String encode = "";
        for (byte b : bytes) {
            boolean isMinus = String.valueOf(b).startsWith("-");
            encode += String.format("%s%s", isMinus ? "" : "", String.format("%20x", b).replace(" ", ""));
        }
        return encode;
    }

    public static byte[] hashDecode(String hash) {
        int start = 0;
        int end = 3;
        byte[] bytes = new byte[hash.length()];
        for (int len = 0; len < bytes.length; ++len) {
            String startwith = hash.substring(start, end);
            if (startwith.startsWith("-")) {
                start += 1;
                String hash1 = hash.substring(start, end);
                bytes[len] = (byte) -Integer.parseInt(hash1, 16);
                start += 2;
            } else {
                end += 2;
                String hash1 = hash.substring(start, end);
                if (!(hash1.startsWith("-") || hash1.endsWith("-"))) {
                    bytes[len] = (byte) Integer.parseInt(hash1, 16);
                }
                start += 2;
            }
            System.out.println(bytes[len] + ", " + Arrays.toString(bytes));
        }
        return bytes;
    }
}
