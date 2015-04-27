package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeString extends NodeObject<String> {

    public NodeString(String par1) {
        super(String.class, new String(par1), 8, par1.length());
    }
}
