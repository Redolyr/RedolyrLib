package RedolyrLibrary.viewFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * Created by redolyr on 2015/01/27.
 */
public class DrawGraphics {

    public static void paint(Graphics graphics, Draw draw, ImageObserver imageObserver) {
        Texture[] textures = draw.getTextures();

        for (int len = 0; len < textures.length; ++len) {
            Texture texture = textures[len];
            int[] texturePointer = draw.getTexturePointer();
            int translateX;
            int translateY;
            int color;

            try {
                translateX = texturePointer.length > 0 ? texturePointer[(len * draw.texturePointerMaxSize) - Draw.TRANSLATE_X_END] : 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                translateX = 0;
            }

            try {
                translateY = texturePointer.length > 0 ? texturePointer[(len * draw.texturePointerMaxSize) - Draw.TRANSLATE_Y_END] : 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                translateY = 0;
            }

            try {
                color = texturePointer.length > 0 ? texturePointer[(len * draw.texturePointerMaxSize) - Draw.COLOR_END] : 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                color = 0;
            }

            translateX += draw.getTranslatedX();
            translateY += draw.getTranslatedY();

            ImageIcon imageIcon = null;
            try {
                imageIcon = TextureManager.getTexture(texture);
            } catch (IOException e) {
            }
            graphics.setColor(new Color(color));
            if (imageIcon != null) graphics.drawImage(imageIcon.getImage(), translateX, translateY, imageObserver);
        }
    }
}
