package RedolyrLibrary.arCardTest;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/20.
 */
public class Color implements Serializable {

    private static final long serialVersionUID = 4836999227084380591L;

    public double r;
    public double g;
    public double b;
    public double a;

    public Color(double r, double g, double b, double a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Color)) return false;

        Color color = (Color) o;

        if (Double.compare(color.a, this.a) != 0) return false;
        if (Double.compare(color.b, this.b) != 0) return false;
        if (Double.compare(color.g, this.g) != 0) return false;
        if (Double.compare(color.r, this.r) != 0) return false;

        return true;
    }

    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(this.r);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.g);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString() {
        return String.format("'Color': {'red': %.3f, 'green': %.3f, 'blue': %.3f, 'alpha': %.3f}", this.r, this.g, this.b, this.a).replace('\'', '"');
    }
}
