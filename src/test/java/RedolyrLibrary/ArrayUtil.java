package RedolyrLibrary;

import java.util.Arrays;

/**
 * Created by redolyr on 2015/02/06.
 */
public class ArrayUtil {

    /**
     * @param regex         default array object
     * @param nullLength    isNull
     * @param currentLength current using length
     * @param plusLength    adding new size
     * @param <T>           regex too
     * @return new length
     */
    public static <T> int arrayCopy(T[] regex, int nullLength, int currentLength, int plusLength) {
        int length = regex != null ? currentLength + plusLength : nullLength;
        if (regex == null) regex = (T[]) new Object[nullLength];
        else regex = Arrays.copyOf(regex, length);
        return length;
    }

    public static <T> int[] arrayCopy(T[][] regex, int[] nullLengths, int[] currentLengths, int[] plusLength, int usingRegexLength) {
        int[] result = new int[usingRegexLength];
        for (int len = 0; len < usingRegexLength; ++len) {
            result[len] = arrayCopy(regex[len], nullLengths[len], currentLengths[len], plusLength[len]);
        }
        return result;
    }

    public static <T> int arrayCopy(T[][] regex, int nullLength, int currentLength, int plusLength, int usingRegexLength) {
        int newLength = currentLength + plusLength;
        int[] nullLengths = new int[usingRegexLength];
        int[] currentLengths = new int[usingRegexLength];
        int[] plusLengths = new int[usingRegexLength];
        for (int len = 0; len < usingRegexLength; ++len) {
            nullLengths[len] = nullLength;
            currentLengths[len] = currentLength;
            plusLengths[len] = plusLength;
        }
        arrayCopy(regex, nullLengths, currentLengths, plusLengths, usingRegexLength);
        return newLength;
    }
}
