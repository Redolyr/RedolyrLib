package RedolyrLibrary.blender;

/**
 * Created by redolyr on 2015/02/28.
 */
public class Rotation implements RotationWriter, RotationReader {

    private double x;
    private double y;
    private double z;

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
