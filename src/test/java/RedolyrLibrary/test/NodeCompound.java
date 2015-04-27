package RedolyrLibrary.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by redolyr on 2015/02/15.
 */
public class NodeCompound extends NodeObject<Map> {

    private Map<String, NodeObject> map = new HashMap<String, NodeObject>();

    public NodeCompound() {
        super(Map.class, new HashMap<String, NodeObject>(), 10, 1);
        this.map = this.getObject();
    }

    public void put(String key, NodeObject nodeObject) {
        this.map.put(key, nodeObject);
    }

    public NodeObject get(String key) {
        return this.map.get(key);
    }

    public NodeObject remove(String key) {
        return this.remove(key);
    }
}
