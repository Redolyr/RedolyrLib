package RedolyrLibrary.DrawComponents.mouse;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/08.
 */
@Deprecated
public class MouseCursor {

    private Vertex[] vertexes;
    private int length;

    private int width;
    private int height;

    public MouseCursor(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addVertex(Vertex vertex) {
        if (this.vertexes == null) this.vertexes = new Vertex[1];
        else this.vertexes = Arrays.copyOf(this.vertexes, this.length + 1);

        this.vertexes[this.length] = vertex;

        ++this.length;
    }

    public void setRGBA(int x, int y, int red, int blue, int green, int alpha) {
        this.addVertex(new Vertex(x, y, this.width, this.height, red, blue, green, alpha));
    }

    public void setRGB(int x, int y, int red, int blue, int green) {
        this.addVertex(new Vertex(x, y, this.width, this.height, red, blue, green, 1));
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Vertex[] vertexes() {
        return this.vertexes;
    }

    public int length() {
        return this.length;
    }
}
