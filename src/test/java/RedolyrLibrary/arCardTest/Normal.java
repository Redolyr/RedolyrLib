package RedolyrLibrary.arCardTest;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/20.
 */
public class Normal implements Serializable {

    private static final long serialVersionUID = 4836999227084380591L;

    public double redChannel;
    public double blueChannel;
    public double greenChannel;

    public Normal(double redChannel, double greenChannel, double blueChannel) {
        this.redChannel = redChannel;
        this.greenChannel = greenChannel;
        this.blueChannel = blueChannel;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Normal)) return false;

        Normal normal = (Normal) o;

        if (Double.compare(normal.blueChannel, this.blueChannel) != 0) return false;
        if (Double.compare(normal.greenChannel, this.greenChannel) != 0) return false;
        if (Double.compare(normal.redChannel, this.redChannel) != 0) return false;

        return true;
    }

    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(this.redChannel);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.blueChannel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.greenChannel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString() {
        return String.format("'Normal': {'redChannel': %.3f, 'greenChannel': %.3f, 'blueChannel': %.3f}", this.redChannel, this.greenChannel, this.blueChannel).replace('\'', '"');
    }
}
