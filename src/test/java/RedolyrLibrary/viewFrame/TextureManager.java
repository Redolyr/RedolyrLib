package RedolyrLibrary.viewFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by redolyr on 2015/01/26.
 */
public class TextureManager {

    private static BufferedImage getImageFromInputStream(InputStream inputStream) throws IOException {
        return ImageIO.read(inputStream);
    }

    public static Texture getTexture(int minWidth, int maxWidth, int minHeight, int maxHeight, byte[] bytes) {
        return new TextureView(minWidth, maxWidth, minHeight, maxHeight, bytes);
    }

    public static Texture getTexture(int width, int height, byte[] bytes) {
        return getTexture(0, width, 0, height, bytes);
    }

    public static Texture getTexture(BufferedImage bufferedImage) throws IOException {
        int minWidth = 0;
        int minHeight = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        byte[] bytes = new byte[0];
        if (bufferedImage != null) {
            minWidth = bufferedImage.getMinX();
            minHeight = bufferedImage.getMinY();
            maxWidth = bufferedImage.getWidth();
            maxHeight = bufferedImage.getHeight();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "PNG", byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();
        }
        return getTexture(minWidth, maxWidth, minHeight, maxHeight, bytes);
    }

    public static Texture getTexture(InputStream inputStream) throws IOException {
        return getTexture(getImageFromInputStream(inputStream));
    }

    public static BufferedImage getTextureCoord(Texture texture) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(texture.getTexture()));
    }

    public static ImageIcon getTexture(Texture texture) throws IOException {
        return new ImageIcon(getTextureCoord(texture));
    }
}
