package RedolyrLibrary.blender;

/**
 * Created by redolyr on 2015/02/28.
 */
public class UVField implements TextureCoordWriter, TextureCoordReader {

    public double u;
    public double v;

    public double getU() {
        return this.u;
    }

    public double getV() {
        return this.v;
    }

    public void setU(double u) {
        this.u = u;
    }

    public void setV(double v) {
        this.v = v;
    }
}
