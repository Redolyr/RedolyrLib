package RedolyrLibrary.oldDrawComponents;

import java.awt.event.WindowEvent;

public interface IWindowsClosedEvent {
    public boolean isWindowClose();

    public void addWindowEvent(WindowEvent windowEvent, int id);
}
