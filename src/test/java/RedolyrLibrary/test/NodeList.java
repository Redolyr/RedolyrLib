package RedolyrLibrary.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by redolyr on 2015/02/15.
 */
public class NodeList extends NodeObject<List> {

    private int index;
    private int removeIndex;
    private List<NodeObject> list = new ArrayList<NodeObject>();

    public NodeList() {
        super(List.class, new ArrayList(), 11, 1);
        this.list = this.getObject();
    }

    public void add(NodeObject nodeObject) {
        this.list.add(nodeObject);
    }

    public NodeObject get() {
        return this.list.get(this.index++);
    }

    public NodeObject remove() {
        return this.list.remove(this.removeIndex++);
    }

    public NodeObject[] gets() {
        return this.list.toArray(new NodeObject[0]);
    }

    public int setGetPosition(int position) {
        int old = this.index;
        this.index = position;
        return old;
    }

    public int setRemovePosition(int position) {
        int old = this.removeIndex;
        this.removeIndex = position;
        return old;
    }
}
