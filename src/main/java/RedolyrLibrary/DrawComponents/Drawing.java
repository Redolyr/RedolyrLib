package RedolyrLibrary.DrawComponents;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/08.
 */
public class Drawing {

    public static final int DRAW_COLOR_4D = 0;
    public static final int DRAW_COLOR_3D = 1;
    public static final int DRAW_QUADS = 2;
    public static final int DRAW_LINE = 3;

    private int[][] rawBuffer;
    private int vertex;

    public void addVertexPointer(int[] vertexPointer) {
        if (this.rawBuffer == null) this.rawBuffer = new int[1][];
        else this.rawBuffer = Arrays.copyOf(this.rawBuffer, this.vertex + 1);

        this.rawBuffer[this.vertex] = vertexPointer;

        ++this.vertex;
    }

    public void addVertex(int id, int[] vertexPointer) {
        int[] vertex = new int[1 + vertexPointer.length];
        vertex[0] = id;
        for (int len = 0; len < vertexPointer.length; ++len) vertex[len + 1] = vertexPointer[len];
        this.addVertexPointer(vertexPointer);
    }

    public void setColor4d(int red, int green, int blue, int alpha) {
        this.addVertex(this.DRAW_COLOR_4D, new int[]{red, green, blue, alpha});
    }

    public void setColor3d(int red, int green, int blue) {
        this.addVertex(this.DRAW_COLOR_3D, new int[]{red, green, blue});
    }

    public void addQuads(int x, int y, int w, int h) {
        this.addVertexPointer(new int[]{this.DRAW_QUADS, x, y, w, h});
    }

    public void addLine(int x, int y, int x2, int y2) {
        this.addVertex(this.DRAW_LINE, new int[]{x, y, x2, y2});
    }

    public int[][] rawBuffer() {
        return this.rawBuffer;
    }

    public int getVertex() {
        return this.vertex;
    }
}
