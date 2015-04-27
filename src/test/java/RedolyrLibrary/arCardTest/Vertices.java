package RedolyrLibrary.arCardTest;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/03/20.
 */
public class Vertices implements Serializable {

    private static final long serialVersionUID = 1250564408433427329L;

    private Vertex[] vertexes = null;
    private int vertices;

    private final int drawMode;

    private DrawComponent drawComponent;

    public Vertices(int drawMode) {
        this.drawMode = drawMode;
    }

    public Vertex addVertex(Vertex vertex) {
        if (vertex != null) {
            if (this.vertexes == null) this.vertexes = new Vertex[1];
            else this.vertexes = Arrays.copyOf(this.vertexes,  this.vertices + 1);
            this.vertexes[this.vertices] = vertex;
            this.vertexes[this.vertices].setVertices(this);
            ++this.vertices;
        }
        return vertex;
    }

    public Vertex addVertex(double x, double y, double z) {
        return this.addVertex(new Vertex(x, y, z));
    }

    public Vertex[] getVertexes() {
        return Arrays.copyOf(this.vertexes, this.vertices);
    }

    public Vertices copy() {
        Vertices vertices = new Vertices(this.drawMode);
        vertices.vertexes = this.getVertexes();
        return vertices;
    }

    public DrawComponent getDrawComponent() {
        return this.drawComponent;
    }

    public void setDrawComponent(DrawComponent drawComponent) {
        this.drawComponent = drawComponent;
    }

    public Vertex getVertex(double x, double y, double z) {
        return this.vertexes[Arrays.binarySearch(this.vertexes, new Vertex(x, y, z))];
    }

    public boolean equalToVertex(double x, double y, double z) {
        boolean isEquals = false;
        for (int len = 0; len < this.vertices; ++len) {
            Vertex vertex1 = this.vertexes[len];
            if (vertex1.equalToVertex(x, y, z)) {
                isEquals = true;
                break;
            }
        }
        return isEquals;
    }

    public boolean equalToVertex(Vertex vertex) {
        if (vertex == null) return false;
        return this.equalToVertex(vertex.x, vertex.y, vertex.z);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertices)) return false;

        Vertices vertices1 = (Vertices) o;

        if (this.vertices != vertices1.vertices) return false;
        if (!Arrays.equals(this.vertexes, vertices1.vertexes)) return false;

        return true;
    }

    public int hashCode() {
        int result = this.vertexes != null ? Arrays.hashCode(this.vertexes) : 0;
        result = 31 * result + vertices;
        return result;
    }

    public String toString() {
        String out = "{'drawMode': %d, 'vertices': {";
        for (int len = 0; len < this.vertices; ++len) {
            Vertex vertex = this.vertexes[len];
            out += vertex.toString().replace("'vertex': ".replace('\'', '"'), String.format("'vertex%d': ", len).replace('\'', '"'));
            if (len != this.vertices - 1) out += ", ";
            else out += "}}";
        }
//        return Arrays.toString(this.vertexes).replace("[", String.format("{'drawMode': %d, ", this.drawMode).replace('\'', '"')).replace(']', '}');
        return String.format(out, this.drawMode).replace('\'', '"');
    }
}
