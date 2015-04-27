package RedolyrLibrary.testSystem;

import java.util.ArrayList;

/**
 * Created by redolyr on 2014/12/14.
 */
public class TestTags extends TestBase {

    private final byte id;
    private final Object tagsValue;

    public TestTags(byte id, Object tagsValue) {
        this.id = id;
        this.tagsValue = tagsValue;
    }

    public void readFromTest(ArrayList<TestTagUtil> testTagUtilArrayList) {
    }

    public void writeToTest(ArrayList<TestTagUtil> testTagUtilArrayList) {
    }

    public byte getId() {
        return this.id;
    }

    public Object getTagsValue() {
        return this.tagsValue;
    }

    public String toString() {
        return String.valueOf(this.tagsValue);
    }
}
