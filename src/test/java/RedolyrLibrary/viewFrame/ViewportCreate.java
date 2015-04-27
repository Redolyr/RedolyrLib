package RedolyrLibrary.viewFrame;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/01/27.
 */
public class ViewportCreate implements Viewport {

    private String title;
    private int screenX;
    private int screenY;
    private int width;
    private int height;
    private Texture texture;
    private boolean resizable;
    private boolean undecorated;
    private boolean closedRequest;
    private boolean activated;

    private Frame frame;
    
    private EventThread eventThread;

    private Draw draw;

    private int stopEventId;
    private StopEvent[] stopEvents;

    public ViewportCreate(String title, int screenX, int screenY, int width, int height, Texture texture, boolean resizable, boolean closedRequest, boolean activated, Frame frame, Draw draw) {
        this.title = title;
        this.screenX = screenX;
        this.screenY = screenY;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.resizable = resizable;
        this.closedRequest = closedRequest;
        this.activated = activated;
        this.frame = frame;
        this.draw = draw;
    }

    public ViewportCreate() {
        this.draw = new Draw();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScreenX() {
        return this.screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public int getScreenY() {
        return this.screenY;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
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

    public Texture getIcon() {
        return this.texture;
    }

    public void setIcon(Texture texture) {
        this.texture = texture;
    }

    public boolean isResizable() {
        return this.resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isUndecorated() {
        return this.undecorated;
    }

    public void setUndecorated(boolean undecorated) {
        this.undecorated = undecorated;
    }

    public boolean isClosedRequest() {
        return this.closedRequest;
    }

    public void setClosedRequest(boolean closedRequest) {
        this.closedRequest = closedRequest;
    }

    public boolean isActivated() {
        return this.activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void create(Display display) throws Exception {
        this.frame.start(display);
    }

    public Draw getDraw() {
        return this.draw;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public EventThread getEventThread() {
        return this.eventThread;
    }

    public void setEventThread(EventThread eventThread) {
        this.eventThread = eventThread;
    }

    public void drawClear() {
        this.draw.drawClear();
    }

    public void drawRepaint() {
        this.frame.repaint();
    }

    public Graphics getGraphics() {
        return this.frame.getGraphics();
    }

    public StopEvent[] getStopEvents() {
        return this.stopEvents == null ? new StopEvent[0] : this.stopEvents;
    }

    public void setStopEvents(StopEvent[] stopEvents) {
        this.stopEvents = stopEvents;
        this.stopEventId = stopEvents.length;
    }

    public void addStopEvent(StopEvent stopEvent) {
        if (this.stopEvents == null) this.stopEvents = new StopEvent[1];
        else this.stopEvents = Arrays.copyOf(this.stopEvents, this.stopEventId + 1);

        this.stopEvents[this.stopEventId] = stopEvent;

        ++this.stopEventId;
    }

    public void stop() {
        if (this.stopEvents != null) {
            for (StopEvent stopEvent : this.stopEvents) {
                stopEvent.stop();
            }
        }
    }

    public void update() {
        this.frame.isUpdate = true;
    }

    @Override
    public String toString() {
        return "ViewportCreate{" +
                "title='" + title + '\'' +
                ", screenX=" + screenX +
                ", screenY=" + screenY +
                ", width=" + width +
                ", height=" + height +
                ", texture=" + texture +
                ", resizable=" + resizable +
                ", closedRequest=" + closedRequest +
                ", activated=" + activated +
                ", frame=" + frame +
                ", eventThread=" + eventThread +
                '}';
    }
}
