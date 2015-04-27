package RedolyrLibrary.viewFrame;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowEvent;

/**
 * Created by redolyr on 2015/01/27.
 */
public class EventAdaptar implements EventListener {

    private Viewport viewport;
    private Mouse mouse;
    private Keyboard keyboard;

    public EventAdaptar(Viewport viewport, Mouse mouse, Keyboard keyboard) {
        this.viewport = viewport;
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public void keyTyped(KeyEvent e) {
        this.keyboard.keyTyped(e);
        this.viewport.drawRepaint();
    }

    public void keyPressed(KeyEvent e) {
        this.keyboard.keyPressed(e);
        this.viewport.drawRepaint();
    }

    public void keyReleased(KeyEvent e) {
        this.keyboard.keyReleased(e);
        this.viewport.drawRepaint();
    }

    public void mouseClicked(MouseEvent e) {
        this.mouse.mouseClicked(e);
        this.viewport.drawRepaint();
    }

    public void mousePressed(MouseEvent e) {
        this.mouse.mousePressed(e);
        this.viewport.drawRepaint();
    }

    public void mouseReleased(MouseEvent e) {
        this.mouse.mouseReleased(e);
        this.viewport.drawRepaint();
    }

    public void mouseEntered(MouseEvent e) {
        this.mouse.mouseEntered(e);
        this.viewport.drawRepaint();
    }

    public void mouseExited(MouseEvent e) {
        this.mouse.mouseExited(e);
        this.viewport.drawRepaint();
    }

    public void mouseDragged(MouseEvent e) {
        this.mouse.mouseDragged(e);
        this.viewport.drawRepaint();
    }

    public void mouseMoved(MouseEvent e) {
        this.mouse.mouseMoved(e);
        this.viewport.drawRepaint();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        this.mouse.mouseWheelMoved(e);
        this.viewport.drawRepaint();
    }

    public void windowGainedFocus(WindowEvent e) {
        this.viewport.drawRepaint();
    }

    public void windowLostFocus(WindowEvent e) {
        this.viewport.drawRepaint();
    }

    public void windowOpened(WindowEvent e) {
        this.viewport.drawRepaint();
    }

    public void windowClosing(WindowEvent e) {
        this.viewport.setClosedRequest(true);
        this.viewport.drawRepaint();
    }

    public void windowClosed(WindowEvent e) {
        this.viewport.setClosedRequest(true);
        this.viewport.drawRepaint();
    }

    public void windowIconified(WindowEvent e) {
        this.viewport.drawRepaint();
    }

    public void windowDeiconified(WindowEvent e) {
        this.viewport.drawRepaint();
    }

    public void windowActivated(WindowEvent e) {
        this.viewport.setActivated(true);
        this.viewport.drawRepaint();
    }

    public void windowDeactivated(WindowEvent e) {
        this.viewport.setActivated(false);
        this.viewport.drawRepaint();
    }

    public void windowStateChanged(WindowEvent e) {
        this.viewport.drawRepaint();
    }
}
