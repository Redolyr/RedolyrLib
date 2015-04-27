package RedolyrLibrary.viewFrame;

import java.awt.*;

/**
 * Created by redolyr on 2015/01/27.
 */
public interface Viewport extends StopEvent, UpdateHandler {

    public String getTitle();

    public void setTitle(String title);

    public int getScreenX();

    public void setScreenX(int screenX);

    public int getScreenY();

    public void setScreenY(int screenY);

    public int getWidth();

    public void setWidth(int width);

    public int getHeight();

    public void setHeight(int height);

    public Texture getIcon();

    public void setIcon(Texture texture);

    public boolean isResizable();

    public void setResizable(boolean resizable);

    public boolean isUndecorated();

    public void setUndecorated(boolean undecorated);

    public boolean isClosedRequest();

    public void setClosedRequest(boolean closedRequest);

    public boolean isActivated();

    public void setActivated(boolean activated);

    public void create(Display display) throws Exception;

    public Draw getDraw();

    public void setFrame(Frame frame);

    public EventThread getEventThread();

    public void setEventThread(EventThread eventThread);

    public void drawClear();

    public void drawRepaint();

    public Graphics getGraphics();

    public StopEvent[] getStopEvents();

    public void setStopEvents(StopEvent[] stopEvents);

    public void addStopEvent(StopEvent stopEvent);
}
