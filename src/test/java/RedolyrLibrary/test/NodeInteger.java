package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeInteger extends NodeObject<Integer> {

    public NodeInteger(int par1) {
        super(Integer.class, new Integer(par1), 1, Integer.SIZE);
    }
}
