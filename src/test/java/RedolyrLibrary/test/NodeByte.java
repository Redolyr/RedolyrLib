package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeByte extends NodeObject<Byte> {

    public NodeByte(byte par1) {
        super(Byte.class, new Byte(par1), 4, Byte.SIZE);
    }
}
