package RedolyrLibrary.viewFrame;

import java.awt.event.*;

/**
 * Created by redolyr on 2015/01/27.
 */
public class Mouse implements MouseListener, MouseWheelListener, MouseMotionListener, UpdateHandler {

    public int x;
    public int y;
    public int mouseWheel;
    public boolean isClick;
    public boolean isPres;
    public boolean isDrag;
    public int mouseID;
    public int clickCount = 0;

    public void mouseClicked(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        this.mouseID = e.getButton();
        this.clickCount = e.getClickCount();
        this.isClick = true;
        this.mouseWheel = 0;
    }

    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        this.mouseID = e.getButton();
        this.clickCount = e.getClickCount();
        this.isPres = true;
        this.mouseWheel = 0;
    }

    public void mouseReleased(MouseEvent e) {
        this.isClick = false;
        this.isPres = false;
        this.isDrag = false;
        this.mouseID = -1;
        this.mouseWheel = 0;
    }

    public void mouseEntered(MouseEvent e) {
        this.isClick = false;
        this.isPres = false;
        this.isDrag = false;
        this.mouseID = -1;
        this.mouseWheel = 0;
    }

    public void mouseExited(MouseEvent e) {
        this.isClick = false;
        this.isPres = false;
        this.isDrag = false;
        this.mouseID = -1;
        this.mouseWheel = 0;
    }

    public void mouseDragged(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        this.mouseID = e.getButton();
        this.clickCount = e.getClickCount();
        this.isDrag = true;
        this.mouseWheel = 0;
    }

    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        this.mouseWheel = 0;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotate = e.getWheelRotation();
        this.mouseWheel = rotate < 0 ? 1 : rotate > 0 ? -1 : 0;
    }

    public void update() {
        this.isClick = false;
        this.isPres = false;
        this.isDrag = false;
        this.mouseID = -1;
        this.mouseWheel = 0;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "x=" + x +
                ", y=" + y +
                ", mouseWheel=" + mouseWheel +
                ", isClick=" + isClick +
                ", isDrag=" + isDrag +
                ", mouseID=" + mouseID +
                ", clickCount=" + clickCount +
                '}';
    }
}
