package RedolyrLibrary.arCardTest;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/20.
 */
public class Vertex implements Serializable {

    private static final long serialVersionUID = 4836999227084380591L;

    public double x;
    public double y;
    public double z;

    public TextureCoord textureCoord = new TextureCoord(0, 0);

    public Color color = new Color(0, 0, 0, 255);

    public Normal normal = new Normal(0, 0, 0);

    private Vertices vertices;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vertex setTextureCoord(double u, double v) {
        this.textureCoord = new TextureCoord(u, v);
        return this;
    }

    public Vertex setColor(double red, double green, double blue, double alpha) {
        this.color = new Color(red, green, blue, alpha);
        return this;
    }

    public Vertex setNormal(double redChannel, double greenChannel, double blueChannel) {
        this.normal = new Normal(redChannel, greenChannel, blueChannel);
        return this;
    }

    public Vertices getVertices() {
        return this.vertices;
    }

    public void setVertices(Vertices vertices) {
        this.vertices = vertices;
    }

    public boolean equalToVertex(double x, double y, double z) {
        return this.x == x && this.y == y && this.z == z;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex vertex = (Vertex) o;

        if (Double.compare(vertex.x, this.x) != 0) return false;
        if (Double.compare(vertex.y, this.y) != 0) return false;
        if (Double.compare(vertex.z, this.z) != 0) return false;
        if (color != null ? !color.equals(vertex.color) : vertex.color != null) return false;
        if (normal != null ? !normal.equals(vertex.normal) : vertex.normal != null) return false;
        if (textureCoord != null ? !textureCoord.equals(vertex.textureCoord) : vertex.textureCoord != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(this.x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (this.textureCoord != null ? this.textureCoord.hashCode() : 0);
        result = 31 * result + (this.color != null ? this.color.hashCode() : 0);
        result = 31 * result + (this.normal != null ? this.normal.hashCode() : 0);
        return result;
    }

    public String toString() {
        return String.format("'Vertex': {'x': %.3f, 'y': %.3f, 'z': %.3f, 'tag': {%s, %s, %s}}", this.x, this.y, this.z, this.textureCoord, this.color, this.normal).replace('\'', '"');
    }
}
