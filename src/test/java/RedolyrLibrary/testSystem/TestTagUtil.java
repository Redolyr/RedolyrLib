package RedolyrLibrary.testSystem;

/**
 * Created by redolyr on 2014/12/14.
 */
public class TestTagUtil {

    private String key;
    private int id;
    private Object value;

    public TestTagUtil() {
    }

    public TestTagUtil(String key, int id, Object value) {
        this.key = key;
        this.id = id;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
