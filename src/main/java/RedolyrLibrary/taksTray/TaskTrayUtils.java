package RedolyrLibrary.taksTray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuComponent;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import RedolyrLibrary.imageIcons.ImageIconBackgroundNone;

public class TaskTrayUtils
{
	private final SystemTray taskTray = SystemTray.getSystemTray();
	private TrayIcon trayIcon;
	private final List<MenuComponent> menuComponents;
	private static TaskTrayUtils Instance = new TaskTrayUtils(new ArrayList<MenuComponent>());
	private TaskTrayUtils(List<MenuComponent> menuComponents)
	{
		this.menuComponents = menuComponents;
	}
	public List<MenuComponent> getMenuComponentsList()
	{
		return menuComponents;
	}
	public void createTaskTray(String title, Image image, final ITaskTrayEvent event) throws AWTException
	{
		PopupMenu menu = new PopupMenu();
		event.menuItems(menuComponents);
		if (event.synchronizedExitVisibled())
		{
			MenuItem exit = new MenuItem("Exit");
			exit.addActionListener(new ActionListener()
			{
	            public void actionPerformed(ActionEvent e)
	            {
	            	event.synchronizedExitEvent();
	            }
	        });
			menu.add(exit);
		}
        if (!SystemTray.isSupported()) return;
        if (image == null) image = ImageIconBackgroundNone.getNoneItem().getImage();
        for (final MenuComponent component : menuComponents)
        	if (component instanceof MenuItem)
        	{
        		menu.add((MenuItem) component);
        		((MenuItem) component).addActionListener(new ActionListener()
        		{
					public void actionPerformed(ActionEvent arg0)
					{
						event.runnableMenuItemEvent(component);
					}
        		});
        	}
        trayIcon = new TrayIcon(image, title, menu);
        trayIcon.setImageAutoSize(true);
        if (event != null)
            trayIcon.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    if (SwingUtilities.isLeftMouseButton(e)) event.runnableEvent();
                }
            });
		taskTray.add(trayIcon);
	}
	public static TaskTrayUtils runnableTaskTray(String title, Image image, final ITaskTrayEvent event)
	{
		try
		{
			Instance.createTaskTray(title, image, event);
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}
		return Instance;
	}
	public static TaskTrayUtils Instance()
	{
		return Instance;
	}
}
//ITaskTrayEvent