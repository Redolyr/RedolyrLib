package RedolyrLibrary.DrawComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.IOException;

/**
 * Created by redolyr on 2014/12/01.
 */
public class DrawLabel extends Label {

    private ImageIcon imageIcon;

    public DrawLabel() {
    }

    public DrawLabel(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public DrawLabel(Image image) {
        this.imageIcon = new ImageIcon();
        this.imageIcon.setImage(image);
    }

    public DrawLabel(String fileName) {
        this.imageIcon = new ImageIcon(fileName);
    }

    public DrawLabel(String fileName, String description) {
        this.imageIcon = new ImageIcon(fileName, description);
    }

    public ImageIcon getIcon() {
        return this.imageIcon;
    }

    public void setIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (this.imageIcon != null) this.imageIcon.paintIcon(this, g, 0, 0);
    }

    public void rawBuffer(int[] rawBuffer) throws IOException {
        int w = rawBuffer[0];
        int h = rawBuffer[1];
        int[] pixels = new int[w * h];
        this.imageIcon = new ImageIcon();

        for (int len = 0; len < pixels.length; ++len) pixels[len] = rawBuffer[len + 2];

        if (pixels != null)
            this.imageIcon.setImage(Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(w, h, ColorModel.getRGBdefault(), pixels, 0, w)));
    }

    public int[] rawBuffer() throws IOException, ClassNotFoundException {
        Image image = this.imageIcon.getImage();

        int w = this.imageIcon.getIconWidth();
        int h = this.imageIcon.getIconHeight();
        int[] pixels = new int[w * h];

        if (image != null) {
            try {
                PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
                pg.grabPixels();
                if ((pg.getStatus() & ImageObserver.ABORT) != 0) throw new IOException("failed to load image contents");
            } catch (InterruptedException e) {
                throw new IOException("image load interrupted");
            }
        }
        int[] rawBuffer = new int[pixels.length + 2];
        rawBuffer[0] = w;
        rawBuffer[1] = h;
        for (int len = 0; len < pixels.length; ++len) rawBuffer[len + 2] = pixels[len];
        return rawBuffer;
    }
}
