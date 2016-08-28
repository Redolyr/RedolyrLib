package SupplyPower.taskTray;

import java.awt.MenuComponent;
import java.util.List;

/**
 * Created by redolyr on 2016/08/10.
 */
public interface ITaskTrayEvent {
    /**
     * @return TaskTray Left Clicked Event
     */
    void runnableEvent();

    /**
     * @return TaskTray MenuItems Clicked Event
     */
    void runnableMenuItemEvent(MenuComponent var0);

    /**
     * @return TaskTray ExitButton Clicked Event
     */
    void synchronizedExitEvent();

    /**
     * @return TaskTray ExitButton isVisibled
     */
    boolean synchronizedExitVisibled();

    void menuItems(List<MenuComponent> var0);
}
