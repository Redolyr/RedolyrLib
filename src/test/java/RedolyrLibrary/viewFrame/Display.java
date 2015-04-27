package RedolyrLibrary.viewFrame;

import java.awt.*;

/**
 * Created by redolyr on 2015/01/27.
 */
public class Display implements StopEvent, UpdateHandler {

    private Viewport viewport = new ViewportCreate();
    public final Keyboard keyboard = new Keyboard();
    public final Mouse mouse = new Mouse();
    private EventListener eventListener = new EventAdaptar(viewport, mouse, keyboard);
    private Frame frame = new Frame(viewport, eventListener);

    public final int displayID;

    public Display() {
        this.displayID = Displays.addDisplay(this);
    }

    public String getTitle() {
        return this.viewport.getTitle();
    }

    public void setTitle(String title) {
        this.viewport.setTitle(title);
    }

    public int getScreenX() {
        return this.viewport.getScreenX();
    }

    public void setScreenX(int screenX) {
        this.viewport.setScreenX(screenX);
    }

    public int getScreenY() {
        return this.viewport.getScreenY();
    }

    public void setScreenY(int screenY) {
        this.viewport.setScreenY(screenY);
    }

    public int getWidth() {
        return this.viewport.getWidth();
    }

    public void setWidth(int width) {
        this.viewport.setWidth(width);
    }

    public int getHeight() {
        return this.viewport.getHeight();
    }

    public void setHeight(int height) {
        this.viewport.setHeight(height);
    }

    public Texture getIcon() {
        return this.viewport.getIcon();
    }

    public void setIcon(Texture texture) {
        this.viewport.setIcon(texture);
    }

    public boolean isResizable() {
        return this.viewport.isResizable();
    }

    public void setResizable(boolean resizable) {
        this.viewport.setResizable(resizable);
    }

    public boolean isUndecorated() {
        return this.viewport.isUndecorated();
    }

    public void setUndecorated(boolean undecorated) {
        this.viewport.setUndecorated(undecorated);
    }

    public boolean isClosedRequest() {
        return this.viewport.isClosedRequest();
    }

    public boolean isActivated() {
        return this.viewport.isActivated();
    }

    public void create() throws Exception {
        this.viewport.setFrame(this.frame);
        this.viewport.create(this);
    }

    public Draw getDraw() {
        return this.viewport.getDraw();
    }

    public void setEventThread(EventThread eventThread) {
        this.viewport.setEventThread(eventThread);
    }

    public void drawClear() {
        this.viewport.drawClear();
    }

    public void drawRepaint() {
        this.viewport.drawRepaint();
    }

    public Graphics getGraphics() {
        return this.viewport.getGraphics();
    }

    public StopEvent[] getStopEvents() {
        return this.getStopEvents();
    }

    public void setStopEvents(StopEvent[] stopEvents) {
        this.setStopEvents(stopEvents);
    }

    public void addStopEvent(StopEvent stopEvent) {
        this.viewport.addStopEvent(stopEvent);
    }

    public void stop() {
        this.viewport.stop();
    }

    public void update() {
        this.viewport.update();
        this.keyboard.update();
        this.mouse.update();
    }
}
