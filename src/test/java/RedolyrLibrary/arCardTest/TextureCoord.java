package RedolyrLibrary.arCardTest;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/20.
 */
public class TextureCoord implements Serializable {

    private static final long serialVersionUID = 4836999227084380591L;

    public final double u;
    public final double v;

    public TextureCoord(double u, double v) {
        this.u = u;
        this.v = v;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextureCoord)) return false;

        TextureCoord that = (TextureCoord) o;

        if (Double.compare(that.u, this.u) != 0) return false;
        if (Double.compare(that.v, this.v) != 0) return false;

        return true;
    }

    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(this.u);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.v);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString() {
        return String.format("'TextureCoord': {'u': %.3f, 'v': %.3f}", this.u, this.v).replace('\'', '"');
    }
}
