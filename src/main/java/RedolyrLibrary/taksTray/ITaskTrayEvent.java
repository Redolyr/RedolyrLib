package RedolyrLibrary.taksTray;

import java.awt.MenuComponent;
import java.util.List;

public interface ITaskTrayEvent
{
	/**
	 * @return TaskTray Left Clicked Event
	 */
	public void runnableEvent();
	/**
	 * @return TaskTray MenuItems Clicked Event
	 */
	public void runnableMenuItemEvent(MenuComponent par1MenuComponent);
	/**
	 * @return TaskTray ExitButton Clicked Event
	 */
	public void synchronizedExitEvent();
	/**
	 * @return TaskTray ExitButton isVisibled
	 */
	public boolean synchronizedExitVisibled();
	/**
	 * 
	 * @param par1List
	 */
	public void menuItems(List<MenuComponent> par1List);
}
