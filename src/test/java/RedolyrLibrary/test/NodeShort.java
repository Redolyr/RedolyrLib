package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeShort extends NodeObject<Short> {

    public NodeShort(short par1) {
        super(Short.class, new Short(par1), 2, Short.SIZE);
    }
}
