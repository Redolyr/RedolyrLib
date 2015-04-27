package RedolyrLibrary.viewFrame;

import java.awt.*;
import java.io.IOException;

/**
 * Created by redolyr on 2015/01/27.
 */
public class Frame extends java.awt.Frame {

    private final Viewport viewport;
    private final EventListener eventListener;

    public boolean isUpdate;

    public Frame(Viewport viewport, EventListener eventListener) {
        this.viewport = viewport;
        this.eventListener = eventListener;
    }

    public void pack() {
        this.setUndecorated(this.viewport.isUndecorated());
        super.pack();

        this.setTitle(this.viewport.getTitle());
        this.setSize(new Dimension(this.viewport.getWidth(), this.viewport.getHeight()));
        this.setLocationRelativeTo(null);
        this.getLocation().translate(this.viewport.getScreenX(), this.viewport.getScreenY());
        try {
            if (this.viewport.getIcon() != null) {
                this.setIconImage(TextureManager.getTexture(this.viewport.getIcon()).getImage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setResizable(this.viewport.isResizable());

        this.addKeyListener(this.eventListener);
        this.addMouseListener(this.eventListener);
        this.addMouseMotionListener(this.eventListener);
        this.addMouseWheelListener(this.eventListener);
        this.addWindowListener(this.eventListener);
        this.addWindowFocusListener(this.eventListener);
        this.addWindowStateListener(this.eventListener);

        this.setVisible(true);
    }

    public void start(final Display display) throws Exception {
        Thread thread = new Thread() {
            public void run() {
                Frame.this.pack();
                EventThread eventThreads = Frame.this.viewport.getEventThread();
                if (eventThreads != null && !Frame.this.isUpdate) {
                    System.out.print("");
                    try {
                        eventThreads.run(display.displayID);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Displays.stop(display.displayID);
            }
        };
        thread.start();
    }

    public void paint(Graphics g) {
//        g.fillRect(0, 0, 100, 100);
        DrawGraphics.paint(g, this.viewport.getDraw(), this);
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        super.paint(g);
    }

    public void update(Graphics g) {
        this.paint(g);
    }
}
