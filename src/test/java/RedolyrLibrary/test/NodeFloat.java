package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeFloat extends NodeObject<Float> {

    public NodeFloat(float par1) {
        super(Float.class, new Float(par1), 6, Float.SIZE);
    }
}
