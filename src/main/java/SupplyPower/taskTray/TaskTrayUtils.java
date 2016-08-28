package SupplyPower.taskTray;

import javax.swing.*;
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

/**
 * Created by redolyr on 2016/08/10.
 */
public class TaskTrayUtils {

    private final SystemTray taskTray = SystemTray.getSystemTray();
    private TrayIcon trayIcon;
    private final List<MenuComponent> menuComponents;

    private TaskTrayUtils(List<MenuComponent> menuComponents) {
        this.menuComponents = menuComponents;
    }

    public List<MenuComponent> getMenuComponentsList() {
        return this.menuComponents;
    }

    public void createTaskTray(String title, Image image, final ITaskTrayEvent event) throws AWTException {
        if (!SystemTray.isSupported() && event != null) return;

        PopupMenu menu = new PopupMenu();
        if (event.synchronizedExitVisibled()) {
            MenuItem exit = new MenuItem("Exit");
            exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    event.synchronizedExitEvent();
                }
            });
            menu.add(exit);
        }

        event.menuItems(this.menuComponents);
        for (final MenuComponent component : this.menuComponents)
            if (component instanceof MenuItem) {
                menu.add((MenuItem) component);
                ((MenuItem) component).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        event.runnableMenuItemEvent(component);
                    }
                });
            }

        this.trayIcon = new TrayIcon(image != null ? image : ImageIconBackgroundNone.getNoneItem().getImage(), title, menu);
        this.trayIcon.setImageAutoSize(true);
        this.trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) event.runnableEvent();
            }
        });
        this.taskTray.add(this.trayIcon);
    }

    public static TaskTrayUtils runnableTaskTray(String title, Image image, final ITaskTrayEvent event) {
        TaskTrayUtils taskTrayUtils = new TaskTrayUtils(new ArrayList<MenuComponent>());
        try {
            taskTrayUtils.createTaskTray(title, image, event);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return taskTrayUtils;
    }
}