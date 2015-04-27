package RedolyrLibrary.viewFrame;

import java.util.Arrays;

/**
 * Created by redolyr on 2015/01/26.
 */
public class TextureView implements Texture {

    private final int minWidth;
    private final int maxWidth;
    private final int minHeight;
    private final int maxHeight;
    private final byte[] bytes;

    public TextureView(int minWidth, int maxWidth, int minHeight, int maxHeight, byte[] bytes) {
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.bytes = bytes;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public byte[] getTexture() {
        return this.bytes;
    }

    public String toString() {
        return "TextureView{" +
                "minWidth=" + this.minWidth +
                ", maxWidth=" + this.maxWidth +
                ", minHeight=" + this.minHeight +
                ", maxHeight=" + this.maxHeight +
                ", bytes=" + Arrays.toString(this.bytes) +
                '}';
    }
}
