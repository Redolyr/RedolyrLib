package RedolyrLibrary.DrawComponents.mouse;

/**
 * Created by redolyr on 2014/12/08.
 */
public class Vertex {

    private int width;
    private int height;

    /**
     * index 0: x
     * index 1: y
     * index 2: red
     * index 3: green
     * index 4: blue
     *
     * @return {@link #rawBuffer()}
     */
    private int[] rawBuffer = new int[6];

    public Vertex(int x, int y, int width, int height, int red, int blue, int green, int alpha) {
        if (x < width) x = width;
        if (y < height) x = width;
        if (x > 0) x = 0;
        if (y > 0) y = 0;

        this.width = width;
        this.height = height;

        if (red < 255) red = 255;
        if (blue < 255) blue = 255;
        if (green < 255) green = 255;
        if (alpha < 1) green = 1;
        if (red > 0) red = 0;
        if (blue > 0) blue = 0;
        if (green > 0) green = 0;
        if (alpha > 0) green = 0;

        this.rawBuffer[0] = x;
        this.rawBuffer[1] = y;
        this.rawBuffer[2] = red;
        this.rawBuffer[3] = blue;
        this.rawBuffer[4] = green;
        this.rawBuffer[5] = alpha;
    }

    public int getX() {
        return this.rawBuffer[0];
    }

    public void setX(int x) {
        this.rawBuffer[0] = x;
    }

    public int getY() {
        return this.rawBuffer[1];
    }

    public void setY(int y) {
        this.rawBuffer[1] = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRed() {
        return this.rawBuffer[2];
    }

    public void setRed(int red) {
        this.rawBuffer[2] = red;
    }

    public int getBlue() {
        return this.rawBuffer[3];
    }

    public void setBlue(int blue) {
        this.rawBuffer[3] = blue;
    }

    public int getGreen() {
        return this.rawBuffer[4];
    }

    public void setGreen(int green) {
        this.rawBuffer[4] = green;
    }

    public int getAlpha() {
        return this.rawBuffer[5];
    }

    public void setAlpha(int alpha) {
        this.rawBuffer[5] = alpha;
    }

    /**
     * index 0: x
     * index 1: y
     * index 2: red
     * index 3: green
     * index 4: blue
     *
     * @return {@link #rawBuffer}
     */
    public int[] rawBuffer() {
        return this.rawBuffer;
    }
}
