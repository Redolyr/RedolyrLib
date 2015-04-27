package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeLong extends NodeObject<Long> {

    public NodeLong(long par1) {
        super(Long.class, new Long(par1), 3, Long.SIZE);
    }
}
