package RedolyrLibrary.DrawComponents;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by redolyr on 2014/12/02.
 */
public class TitleBarAdapter implements MouseMotionListener {

    private final Frame frame;
    private int mouseX = 0;
    private int mouseY = 0;

    public TitleBarAdapter(Frame frame) {
        this.frame = frame;
    }

    public void mouseDragged(MouseEvent arg0) {
        int x = arg0.getXOnScreen();
        int y = arg0.getYOnScreen();
        int movedX = x - (this.mouseX < this.frame.getWidth() ? this.mouseX : 0);
        int movedY = y - (this.mouseY < this.frame.getHeight() ? this.mouseY : 0);
        this.frame.setLocation(movedX, movedY);
    }

    public void mouseMoved(MouseEvent arg0) {
        this.mouseX = arg0.getX();
        this.mouseY = arg0.getY();
    }
}
