package RedolyrLibrary.viewFrame;

import java.util.Arrays;

/**
 * Created by redolyr on 2015/01/27.
 */
public class Draw implements StopEvent {

    private int textureCoord;
    private Texture[] textures;
    private int[] texturePointer;

    public final int texturePointerMaxSize = 3;

    public static final int TRANSLATE_X_START = 0;
    public static final int TRANSLATE_Y_START = 1;
    public static final int COLOR_START = 2;

    public static final int TRANSLATE_X_END = 3;
    public static final int TRANSLATE_Y_END = 2;
    public static final int COLOR_END = 1;

    private int translatedX;
    private int translatedY;

    private int color = 0x000000;

    public Draw() {
    }

    public Draw(int textureCoord, Texture[] textures, int[] texturePointer, boolean isAppend) {
        if (isAppend) {
            this.addTexturePointer(textureCoord, textures, texturePointer);
        } else {
            this.setTexturePointer(textureCoord, textures, texturePointer);
        }
    }

    public void addTexturePointer(int textureCoord, Texture[] textures, int[] texturePointer) {

        if (this.textures == null) this.textures = new Texture[textureCoord];
        else {
            if (textureCoord != 0) {
                System.arraycopy(this.textures, this.textureCoord, this.textureCoord, this.textureCoord + 1, this.textureCoord + textureCoord);
            }
        }

        if (this.texturePointer == null) this.texturePointer = new int[textureCoord * texturePointerMaxSize];
        else {
            if (textureCoord != 0) {
                System.arraycopy(this.texturePointer, this.textureCoord * this.texturePointerMaxSize, this.textureCoord, (this.textureCoord * this.texturePointerMaxSize) + 1, (this.textureCoord * this.texturePointerMaxSize) + (textureCoord * this.texturePointerMaxSize));
            }
        }

        for (int len = this.textureCoord; len < this.textureCoord + textureCoord; ++len) {
            this.textures[len] = textures[-(this.textureCoord - len)];
        }

        for (int len = this.textureCoord * this.texturePointerMaxSize; len < (this.textureCoord * this.texturePointerMaxSize) + (textureCoord * this.texturePointerMaxSize); ++len) {
            this.texturePointer[len] = texturePointer[-(this.textureCoord - len)];
        }

        this.textureCoord = textureCoord;
    }

    public void setTexturePointer(int textureCoord, Texture[] textures, int[] texturePointer) {
        this.textureCoord = textureCoord;
        this.textures = textures;
        this.texturePointer = texturePointer;
    }

    public void addTexture(Texture texture) {
        if (this.textures == null) this.textures = new Texture[1];
        else this.textures = Arrays.copyOf(this.textures, this.textureCoord + 1);

        if (this.texturePointer == null) this.texturePointer = new int[this.texturePointerMaxSize];
        else this.texturePointer = Arrays.copyOf(this.texturePointer, this.textureCoord + this.texturePointerMaxSize);

        this.textures[this.textureCoord] = texture;
        this.texturePointer[this.textureCoord + this.TRANSLATE_X_START] = this.translatedX;
        this.texturePointer[this.textureCoord + this.TRANSLATE_Y_START] = this.translatedY;
        this.texturePointer[this.textureCoord + this.COLOR_START] = this.color;

        ++this.textureCoord;
    }

    public Texture getStartTexture() {
        return this.textures != null && this.textureCoord != 0 ? this.textures[0] : null;
    }

    public Texture getEndTexture() {
        return this.textures != null && this.textureCoord != 0 ? this.textures[this.textureCoord - 1] : null;
    }

    public void removeStartTexture() {
        if (this.textures != null && this.textureCoord != 0) {
            this.textures[this.textureCoord - 1] = null;

            System.arraycopy(this.textures, 0, this.textures, 1, this.textureCoord - 1);
            System.arraycopy(this.texturePointer, 0, this.texturePointer, this.texturePointerMaxSize, (this.textureCoord * this.texturePointerMaxSize) - this.texturePointerMaxSize);

            this.textureCoord -= 1;
        }
    }

    public void removeEndTexture() {
        if (this.textures != null && this.textureCoord != 0) {
            this.textures[this.textureCoord - 1] = null;
            this.texturePointer[this.textureCoord - 2] = 0;
            this.texturePointer[this.textureCoord - 1] = 0;

            System.arraycopy(this.textures, this.textureCoord - 1, this.textures, this.textureCoord, this.textureCoord - 1);
            System.arraycopy(this.texturePointer, (this.textureCoord * this.texturePointerMaxSize) - this.texturePointerMaxSize, this.texturePointer, (this.textureCoord * this.texturePointerMaxSize), (this.textureCoord * this.texturePointerMaxSize) - this.texturePointerMaxSize);

            this.textureCoord -= 1;
        }
    }

    public Texture[] getTextures() {
        return this.textures != null ? Arrays.copyOf(this.textures, this.textureCoord) : new Texture[0];
    }

    public int[] getTexturePointer() {
        return this.texturePointer != null ? Arrays.copyOf(this.texturePointer, this.textureCoord * this.texturePointerMaxSize) : new int[0];
    }

    public int getTranslatedX() {
        return this.translatedX;
    }

    public void setTranslatedX(int translatedX) {
        this.translatedX = translatedX;
    }

    public int getTranslatedY() {
        return this.translatedY;
    }

    public void setTranslatedY(int translatedY) {
        this.translatedY = translatedY;
    }

    public void translated(int translatedX, int translatedY) {
        this.translatedX = translatedX;
        this.translatedY = translatedY;
    }

    public int getStartTranslatedX() {
        return this.texturePointer[this.TRANSLATE_X_START];
    }

    public int getStartTranslatedY() {
        return this.texturePointer[this.TRANSLATE_Y_START];
    }

    public int getStartColor() {
        return this.texturePointer[this.COLOR_START];
    }

    public int getEndTranslatedX() {
        return this.texturePointer[(this.textureCoord * this.texturePointerMaxSize) - this.TRANSLATE_X_END];
    }

    public int getEndTranslatedY() {
        return this.texturePointer[(this.textureCoord * this.texturePointerMaxSize) - this.TRANSLATE_Y_END];
    }

    public int getEndColor() {
        return this.texturePointer[(this.textureCoord * this.texturePointerMaxSize) - this.COLOR_END];
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int red, int green, int blue) {
        this.color = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
    }

    public void drawClear() {
        this.textures = null;
        this.textureCoord = 0;
        this.texturePointer = null;
    }

    public void stop() {
        this.drawClear();
        this.translatedX = 0;
        this.translatedY = 0;
        this.color = 0x000000;
    }

    public String toString() {
        return "Draw{" +
                "textureCoord=" + textureCoord +
                ", textures=" + Arrays.toString(textures) +
                ", texturePointer=" + Arrays.toString(texturePointer) +
                ", translatedX=" + translatedX +
                ", translatedY=" + translatedY +
                '}';
    }
}
