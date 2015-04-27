package RedolyrLibrary.oldDrawComponents;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class DrawFrame implements Runnable, WindowListener {
    private static Frame mainFrame;
    public final List<DrawButton> drawButtons = new ArrayList<DrawButton>();
    public final List<DrawPanel> drawPanels = new ArrayList<DrawPanel>();
    public final List<IWindowsClosedEvent> drawingPanelsClosingEvent = new ArrayList<IWindowsClosedEvent>();
    private final List<Integer> windowLabels = new ArrayList<Integer>();
    private final DrawPanel drawPanel = new DrawPanel(-1);

    private final boolean isUndecorated;

    private Applet applet;
    private final boolean isApplet;

    private final int id, width, height;
    private final String title;
    private final boolean visible;

    public DrawFrame(int id, String title, int width, int height, boolean isVisible, boolean isApplet, Applet applet, boolean isUndecorated) {
        EventQueue.invokeLater(this);
        this.id = id;
        this.title = title;
        this.width = width;
        this.height = height;
        this.visible = isVisible;
        this.isApplet = isApplet;
        if (isApplet) this.applet = applet;
        this.isUndecorated = isUndecorated;
    }

    public DrawFrame(int id, String title, int width, int height, boolean isVisible, boolean isApplet, Applet applet) {
        this(id, title, width, height, isVisible, isApplet, applet, false);
    }

    public DrawFrame(int id, String title, int width, int height, boolean isVisible, Color backgroundColor) {
        this(id, title, width, height, isVisible, false, null);
        setBackgroundColor(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue());
    }

    public DrawFrame(int id, String title, int width, int height, boolean isVisible, int backgroundColor) {
        this(id, title, width, height, isVisible, new Color(getR(backgroundColor), getG(backgroundColor), getB(backgroundColor)));
    }

    public DrawFrame(String title, int width, int height, boolean isVisible, boolean isUndecorated) {
        this(0, title, width, height, isVisible, false, null, isUndecorated);
    }

    public DrawFrame(String title, int width, int height, boolean isVisible) {
        this(title, width, height, isVisible, false);
    }

    public DrawFrame(boolean isUndecorated, String title, int width, int height) {
        this(title, width, height, true, isUndecorated);
    }

    public DrawFrame(String title, int width, int height) {
        this(title, width, height, true);
    }

    public DrawFrame(String title, int width, int height, Color backgroundColor, boolean isUndecorated) {
        this(title, width, height, true, isUndecorated);
        setBackgroundColor(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue());
    }

    public DrawFrame(String title, int width, int height, Color backgroundColor) {
        this(title, width, height);
        setBackgroundColor(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue());
    }

    public DrawFrame(String title, int width, int height, int backgroundColor, boolean isUndecorated) {
        this(title, width, height, new Color(getR(backgroundColor), getG(backgroundColor), getB(backgroundColor)), isUndecorated);
    }

    public DrawFrame(String title, int width, int height, int backgroundColor) {
        this(title, width, height, new Color(getR(backgroundColor), getG(backgroundColor), getB(backgroundColor)));
    }

    public void actionPreformed(DrawButton drawButton) {
    }

    public DrawPanel getPanel() {
        return drawPanel;
    }

    public void setBackgroundColor(int red, int green, int blue) {
        drawPanel.setBackground(new Color(red, green, blue));
    }

    public boolean addWindowsClosing(WindowEvent windowEvent, IWindowsClosedEvent iWindowsClosedEvent) {
        return iWindowsClosedEvent != null ? iWindowsClosedEvent.isWindowClose() : false;
    }

    public static int getRGB(int sixTeenByte, int hex) {
        return sixTeenByte >>> hex & 0xFF;
    }

    public static int getR(int sixTeenByte) {
        return getRGB(sixTeenByte, 16);
    }

    public static int getG(int sixTeenByte) {
        return getRGB(sixTeenByte, 8);
    }

    public static int getB(int sixTeenByte) {
        return getRGB(sixTeenByte, 0);
    }

    public Frame getFrame() {
        return mainFrame;
    }

    public boolean isVisible() {
        return mainFrame.isVisible();
    }

    public void setVisible() {
        if (mainFrame != null) mainFrame.setVisible(!isVisible());
        else System.exit(0);
    }

    public void add(Component component) {
        int x = (int) drawPanel.getLocation().getX(), y = (int) drawPanel.getLocation().getY();
        int x2 = (int) component.getLocation().getX(), y2 = (int) component.getLocation().getY();
        component.setLocation(x + x2, y + y2);
        System.out.println(component + ", " + x + ", " + y + ", " + x2 + ", " + y2);
        if (component instanceof Applet) this.applet = (Applet) component;
        else if (this.applet != null) this.applet.add(component);
        else drawPanel.add(component);
    }

    public void add(Component component, String par2) {
        if (component instanceof Applet) this.applet = (Applet) component;
        else mainFrame.add(component, par2);
    }

    public void setApplet(Applet applet) {
        if (applet != null) this.applet = applet;
    }

    public Applet getApplet() {
        return applet;
    }

    public boolean getUndecorated() {
        return this.isUndecorated;
    }

    private static class actionListener implements ActionListener {
        public DrawFrame drawFrame;
        public DrawButton drawButton;
        private boolean isLoaded = false;

        public void actionPerformed(ActionEvent arg0) {
            isLoaded = true;
            if (!isLoaded) drawFrame.actionPreformed(drawButton);
            return;
        }
    }

    public void run() {
        mainFrame = new Frame();
        windowLabels.add(id);
        mainFrame.add(drawPanel);
        drawPanel.add(applet);

        mainFrame.setUndecorated(isUndecorated);
        mainFrame.pack();
        mainFrame.setTitle(title);
        mainFrame.setSize(width, height);

        if (isUndecorated) {
            DrawButton exitButton = new DrawButton("X", 2 ^ 31 - 1, 35, 35, (mainFrame.getX() + mainFrame.getWidth()) - 8, (mainFrame.getY() + mainFrame.getHeight()) - 8);
            exitButton.setBackground(new Color(255, 255, 255));
            add(exitButton);
            drawPanel.addMouseMotionListener(new MouseMotionListener() {
                int mouseX = 0;
                int mouseY = 0;

                public void mouseDragged(MouseEvent arg0) {
                    int x = arg0.getXOnScreen();
                    int y = arg0.getYOnScreen();
                    int movedX = x - (mouseX < mainFrame.getWidth() ? mouseX : 0);
                    int movedY = y - (mouseY < mainFrame.getHeight() ? mouseY : 0);
                    mainFrame.setLocation(movedX, movedY);
                }

                public void mouseMoved(MouseEvent arg0) {
                    mouseX = arg0.getX();
                    mouseY = arg0.getY();
                }
            });

            this.drawingPanelsClosingEvent.add(new IWindowsClosedEvent() {
                public boolean isWindowClose() {
                    return true;
                }

                public void addWindowEvent(WindowEvent windowEvent, int id) {
                    switch (id) {
                        case 2 ^ 31 - 1:
                            System.exit(0);
                            break;
                    }
                }
            });
        }

        int x = mainFrame.getX() - (mainFrame.getWidth() / 2);
        int y = mainFrame.getY() - (mainFrame.getHeight() / 2);
        mainFrame.setLocation(x, y);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(visible);

        for (DrawButton buttons : drawButtons) {
            actionListener listener = new actionListener();
            listener.drawButton = buttons;
            listener.drawFrame = this;
            buttons.addActionListener(new actionListener());
            drawPanel.add(buttons);

            if (buttons instanceof IWindowsClosedEvent) drawingPanelsClosingEvent.add((IWindowsClosedEvent) buttons);

            windowLabels.add(buttons.getId());
        }
        for (DrawPanel panels : drawPanels) {
            for (Component components : panels.getComponentList()) panels.add(components);
            drawPanel.add(panels);

            if (drawPanel instanceof IWindowsClosedEvent) drawingPanelsClosingEvent.add((IWindowsClosedEvent) panels);

            windowLabels.add(panels.getId());
        }

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                for (IWindowsClosedEvent event : drawingPanelsClosingEvent) {
                    if (!addWindowsClosing(we, event)) System.exit(0);
                    else for (int id : windowLabels) event.addWindowEvent(we, id);
                }
            }
        });
    }

    public void windowActivated(WindowEvent arg0) {
    }

    public void windowClosed(WindowEvent arg0) {
    }

    public void windowClosing(WindowEvent arg0) {
    }

    public void windowDeactivated(WindowEvent arg0) {
    }

    public void windowDeiconified(WindowEvent arg0) {
    }

    public void windowIconified(WindowEvent arg0) {
    }

    public void windowOpened(WindowEvent arg0) {
    }
}