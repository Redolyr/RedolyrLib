package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeDouble extends NodeObject<Double> {

    public NodeDouble(double par1) {
        super(Double.class, new Double(par1), 5, Double.SIZE);
    }
}
