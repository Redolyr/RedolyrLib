package RedolyrLibrary.testSystem;

import java.util.*;

/**
 * Created by redolyr on 2014/12/14.
 */
public class TestTagCompound extends TestBase {

    public static final byte TAG_UNKNOWN = -1;

    public static final byte TAG_STRING = 0;
    public static final byte TAG_CHARACTER = 1;
    public static final byte TAG_INTEGER = 2;
    public static final byte TAG_SHORT = 4;
    public static final byte TAG_LONG = 8;
    public static final byte TAG_BYTE = 16;
    public static final byte TAG_DOUBLE = 32;
    public static final byte TAG_FLOAT = (byte) 64;
    public static final byte TAG_BOOLEAN = (byte) 128;

    public static final byte TAG_ARRAY_STRING = (byte) 256;
    public static final byte TAG_ARRAY_CHARACTER = (byte) 512;
    public static final byte TAG_ARRAY_INTEGER = (byte) 1024;
    public static final byte TAG_ARRAY_SHORT = (byte) 2048;
    public static final byte TAG_ARRAY_LONG = (byte) 4092;
    public static final byte TAG_ARRAY_BYTE = (byte) 8192;
    public static final byte TAG_ARRAY_DOUBLE = (byte) 16384;
    public static final byte TAG_ARRAY_FLOAT = (byte) 32768;
    public static final byte TAG_ARRAY_BOOLEAN = (byte) 65536;

    public static final byte TAG_NATIVE_SIZE = (byte) 65536;

    private Map<String, TestBase> data = new HashMap<String, TestBase>();

    public void readFromTest(ArrayList<TestTagUtil> testTagUtilArrayList) {

        Iterator<String> iterator = this.data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            TestBase value = this.data.get(key);
            byte id = value.getId();
            testTagUtilArrayList.add(new TestTagUtil(key, id, value));
        }
    }

    public void writeToTest(ArrayList<TestTagUtil> testTagUtilArrayList) {
    }

    public byte getId() {
        return -1;
    }

    public Set<String> keySet() {
        return this.data.keySet();
    }

    public Iterator<String> iterator() {
        return this.data.keySet().iterator();
    }

    public TestBase getTag(String key) {
        return this.data.get(key);
    }

    public void setTag(String key, byte id, Object value) {
        if (id < this.TAG_NATIVE_SIZE) throw new ArrayIndexOutOfBoundsException();
        else this.data.put(key, new TestTags(id, value));
    }

    public boolean hasKey(String key) {
        return this.data.get(key) != null;
    }

    public boolean hasKey(String key, byte id) {
        TestBase testBase = this.data.get(key);
        return testBase != null ? testBase.getId() == id : false;
    }
}
