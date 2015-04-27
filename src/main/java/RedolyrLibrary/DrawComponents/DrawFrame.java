package RedolyrLibrary.drawComponents;

import RedolyrLibrary.drawComponents.mouse.MouseCursor;
import RedolyrLibrary.drawComponents.mouse.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/11/30.
 */
public class DrawFrame implements MouseListener, MouseMotionListener, MouseWheelListener, WindowListener, WindowStateListener, WindowFocusListener, KeyListener, ActionListener, DrawPaintListener {
    public static final int DRAW_UNKNOWN = -1;
    public static final int DRAW_TITLE = 0;
    public static final int DRAW_X = 1;
    public static final int DRAW_Y = 2;
    public static final int DRAW_WIDTH = 3;
    public static final int DRAW_HEIGHT = 4;
    public static final int DRAW_UNDECORATED = 5;
    public static final int DRAW_VISIBLE = 6;
    public static final int DRAW_RESIZABLE = 7;
    public static final int DRAW_TITLE_BAR_COLOR_RED = 8;
    public static final int DRAW_TITLE_BAR_COLOR_GREEN = 9;
    public static final int DRAW_TITLE_BAR_COLOR_BLUE = 10;
    public static final int DRAW_MAIN_COLOR_RED = 11;
    public static final int DRAW_MAIN_COLOR_GREEN = 12;
    public static final int DRAW_MAIN_COLOR_BLUE = 13;
    public static final int DRAW_TITLE_BAR_IMAGE_ICON = 14;
    public static final int DRAW_BOUNDS_CENTER = 15;
    public static final int DRAW_TITLE_BAR_TITLE_COLOR_RED = 16;
    public static final int DRAW_TITLE_BAR_TITLE_COLOR_GREEN = 17;
    public static final int DRAW_TITLE_BAR_TITLE_COLOR_BLUE = 18;
    public static final int DRAW_MOUSE_X = 19;
    public static final int DRAW_MOUSE_Y = 20;
    public static final int DRAW_MOUSE_CLICKED_ID = 21;
    public static final int DRAW_MOUSE_WHEEL = 22;
    public static final int DRAW_MOUSE_CURSOR_GRAP = 23;

    private Frame frame;
    private Panel panel;
    private Panel panel1;
    private Panel panel2;
    private Button button;
    private Button button1;
    private Button button2;
    private DrawLabel drawLabel;

    private Drawing drawing;

    private MouseCursor mouseCursor;

    private DrawPaintListener[] drawPaintListeners;
    private int listenerLength;

    private int[][] rawBuffer;
    private int length;

    public DrawFrame() {
        this.addDrawPaintListener(this);
    }

    public void add(int id, Object object) {
        int[] parseIntArray = this.parseIntArray(object);

        if (this.rawBuffer == null) this.rawBuffer = new int[1][];
        else this.rawBuffer = Arrays.copyOf(this.rawBuffer, this.length + 1);

        int[] raw = new int[1 + parseIntArray.length];
        raw[0] = id;
        for (int len = 1; len < raw.length; ++len) raw[len] = parseIntArray[len - 1];

        this.rawBuffer[this.length] = raw;

        ++this.length;
    }

    public Object get(int id) {
        if (!this.has(id)) throw new IllegalArgumentException("Does not have this ID [" + id + "] :(");
        int[] raw = new int[0];
        for (int len = 0; len < this.length; ++len) {
            raw = this.rawBuffer[len];
            if (raw[0] == id) break;
        }
        return this.replaceBlank(String.valueOf(this.parseObject(raw)));
    }

    public boolean has(int id) {
        boolean has = false;
        for (int len = 0; len < this.length; ++len) {
            int[] raw = this.rawBuffer[len];
            has = raw[0] == id;
            if (has) break;
        }
        return has;
    }

    public int hasGetIndex(int id) {
        int index = -1;
        for (int len = 0; len < this.length; ++len) {
            int[] raw = this.rawBuffer[len];
            index = len;
            if (raw[0] == id) break;
            index = -1;
        }
        return index;
    }

    public void set(int id, Object object) {
        int[] parseIntArray = this.parseIntArray(object);

        int[] raw = new int[1 + parseIntArray.length];
        raw[0] = id;
        for (int len = 1; len < raw.length; ++len) raw[len] = parseIntArray[len - 1];

        this.rawBuffer[this.hasGetIndex(id)] = raw;
    }

    public void addAndSet(int id, Object object) {
        if (this.has(id)) this.set(id, object);
        else this.add(id, object);
    }

    public String replaceBlank(String regex) {
        String[] strings = new String[]{"\u0000", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\u0008", "\u0009", "\u0010", "\u0011", "\u0012", "\u0013", "\u0014", "\u0015", "\u0016", "\u0017", "\u0018", "\u0019"};
        for (int len = 0; len < strings.length; ++len) regex = regex.replaceAll(strings[len], "");
        return regex;
    }

    public int[] parseIntArray(Object par1) {
        byte[] bytes = String.valueOf(par1).getBytes();
        int[] rawBuffer = new int[bytes.length];
        for (int len = 0; len < rawBuffer.length; ++len) rawBuffer[len] = bytes[len];
        return rawBuffer;
    }

    public Object parseObject(int[] rawBuffer) {
        byte[] bytes = new byte[rawBuffer.length];
        for (int len = 0; len < bytes.length; ++len) bytes[len] = (byte) rawBuffer[len];
        return new String(bytes);
    }

    public String getTitle() {
        return String.valueOf(this.get(this.DRAW_TITLE));
    }

    public void setTitle(String title) {
        this.addAndSet(this.DRAW_TITLE, title);
    }

    public int getX() {
        return Integer.valueOf(String.valueOf(this.get(this.DRAW_X)));
    }

    public void setX(int x) {
        this.addAndSet(this.DRAW_X, x);
    }

    public int getY() {
        return Integer.valueOf(String.valueOf(this.get(this.DRAW_Y)));
    }

    public void setY(int y) {
        this.addAndSet(this.DRAW_Y, y);
    }

    public int getWidth() {
        return Integer.valueOf(String.valueOf(this.get(this.DRAW_WIDTH)));
    }

    public void setWidth(int width) {
        this.addAndSet(this.DRAW_WIDTH, width);
    }

    public int getHeight() {
        return Integer.valueOf(String.valueOf(this.get(this.DRAW_HEIGHT)));
    }

    public void setHeight(int height) {
        this.addAndSet(this.DRAW_HEIGHT, height);
    }

    public boolean isUndecorated() {
        return Boolean.valueOf(String.valueOf(this.get(this.DRAW_UNDECORATED)));
    }

    @Deprecated
    public void setUndecorated(boolean isUndecorated) {
        this.addAndSet(this.DRAW_UNDECORATED, isUndecorated);
    }

    public boolean isVisible() {
        return Boolean.valueOf(String.valueOf(this.get(this.DRAW_VISIBLE)));
    }

    public void setVisible(boolean isVisible) {
        this.addAndSet(this.DRAW_VISIBLE, isVisible);
    }

    public boolean isResizable() {
        return Boolean.valueOf(String.valueOf(this.get(this.DRAW_RESIZABLE)));
    }

    public void setResizable(boolean isResizable) {
        this.addAndSet(this.DRAW_RESIZABLE, isResizable);
    }

    public int getTitleBarColorRed() {
        return this.getColor(this.DRAW_TITLE_BAR_COLOR_RED, 255);
    }

    public void setTitleBarColorRed(int red) {
        this.addAndSet(this.DRAW_TITLE_BAR_COLOR_RED, this.colorOption(red));
    }

    public int getTitleBarColorGreen() {
        return this.getColor(this.DRAW_TITLE_BAR_COLOR_GREEN, 255);
    }

    public void setTitleBarColorGreen(int green) {
        this.addAndSet(this.DRAW_TITLE_BAR_COLOR_GREEN, this.colorOption(green));
    }

    public int getTitleBarColorBlue() {
        return this.getColor(this.DRAW_TITLE_BAR_COLOR_BLUE, 255);
    }

    public void setTitleBarColorBlue(int blue) {
        this.addAndSet(this.DRAW_TITLE_BAR_COLOR_BLUE, this.colorOption(blue));
    }

    public int[] getTitleBarColorRGB() {
        return new int[]{this.getTitleBarColorRed(), this.getTitleBarColorGreen(), this.getTitleBarColorBlue()};
    }

    public void setTitleBarColorRGB(int red, int green, int blue) {
        this.setTitleBarColorRed(red);
        this.setTitleBarColorGreen(green);
        this.setTitleBarColorBlue(blue);
    }

    public int getMainColorRed() {
        return this.getColor(this.DRAW_MAIN_COLOR_RED, 255);
    }

    public void setMainColorRed(int red) {
        this.addAndSet(this.DRAW_MAIN_COLOR_RED, this.colorOption(red));
    }

    public int getMainColorGreen() {
        return this.getColor(this.DRAW_MAIN_COLOR_GREEN, 255);
    }

    public void setMainColorGreen(int green) {
        this.addAndSet(this.DRAW_MAIN_COLOR_GREEN, this.colorOption(green));
    }

    public int getMainColorBlue() {
        return this.getColor(this.DRAW_MAIN_COLOR_BLUE, 255);
    }

    public void setMainColorBlue(int blue) {
        this.addAndSet(this.DRAW_MAIN_COLOR_BLUE, this.colorOption(blue));
    }

    public int[] getMainColorRGB() {
        return new int[]{this.getMainColorRed(), this.getMainColorGreen(), this.getMainColorBlue()};
    }

    public void setMainColorRGB(int red, int green, int blue) {
        this.setMainColorRed(red);
        this.setMainColorGreen(green);
        this.setMainColorBlue(blue);
    }

    public ImageIcon getTitleBarIcon() {
        String[] items = String.valueOf(this.get(this.DRAW_TITLE_BAR_IMAGE_ICON)).replaceAll("\\[", "").replaceAll("\\]", "").split(",");
        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
            }
        }

        DrawLabel drawLabel = new DrawLabel();
        try {
            drawLabel.rawBuffer(results);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return drawLabel.getIcon();
    }

    public void setTitlebarImageIcon(ImageIcon imageIcon) {
        try {
            this.addAndSet(this.DRAW_TITLE_BAR_IMAGE_ICON, Arrays.toString(new DrawLabel(imageIcon).rawBuffer()));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public boolean isBoundsCenter() {
        return Boolean.valueOf(String.valueOf(this.get(this.DRAW_BOUNDS_CENTER)));
    }

    public void setBoundsCenter(boolean isBoundsCenter) {
        this.addAndSet(this.DRAW_BOUNDS_CENTER, isBoundsCenter);
    }

    public int getTitleBarTitleColorRed() {
        return this.getColor(this.DRAW_TITLE_BAR_TITLE_COLOR_RED, 255);
    }

    public void setTitleBarTitleColorRed(int red) {
        this.addAndSet(this.DRAW_TITLE_BAR_TITLE_COLOR_RED, this.colorOption(red));
    }

    public int getTitleBarTitleColorGreen() {
        return this.getColor(this.DRAW_TITLE_BAR_TITLE_COLOR_GREEN, 255);
    }

    public void setTitleBarTitleColorGreen(int green) {
        this.addAndSet(this.DRAW_TITLE_BAR_TITLE_COLOR_GREEN, this.colorOption(green));
    }

    public int getTitleBarTitleColorBlue() {
        return this.getColor(this.DRAW_TITLE_BAR_TITLE_COLOR_BLUE, 255);
    }

    public void setTitleBarTitleColorBlue(int blue) {
        this.addAndSet(this.DRAW_TITLE_BAR_TITLE_COLOR_BLUE, this.colorOption(blue));
    }

    public int[] getTitleBarTitleColorRGB() {
        return new int[]{this.getTitleBarTitleColorRed(), this.getTitleBarTitleColorGreen(), this.getTitleBarTitleColorBlue()};
    }

    public void setTitleBarTitleColorRGB(int red, int green, int blue) {
        this.setTitleBarTitleColorRed(red);
        this.setTitleBarTitleColorGreen(green);
        this.setTitleBarTitleColorBlue(blue);
    }

    public int[] getPoint() {
        return new int[]{this.getX(), this.getY()};
    }

    public void setPoint(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int[] getDimension() {
        return new int[]{this.getWidth(), this.getHeight()};
    }

    public void setDimension(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public int[] getBounds() {
        return new int[]{this.getPoint()[0], this.getPoint()[1], this.getDimension()[0], this.getDimension()[1]};
    }

    public void setBounds(int x, int y, int width, int height) {
        this.setPoint(x, y);
        this.setDimension(width, height);
    }

    public int getMouseX() {
        return this.has(this.DRAW_MOUSE_X) ? Integer.valueOf(String.valueOf(this.get(this.DRAW_MOUSE_X))) : 0;
    }

    public void setMouseX(int mouseX) {
        this.addAndSet(this.DRAW_MOUSE_X, mouseX);
    }

    public int getMouseY() {
        return this.has(this.DRAW_MOUSE_Y) ? Integer.valueOf(String.valueOf(this.get(this.DRAW_MOUSE_Y))) : 0;
    }

    public void setMouseY(int mouseY) {
        this.addAndSet(this.DRAW_MOUSE_Y, mouseY);
    }

    public int getMouseClickedID() {
        return this.has(this.DRAW_MOUSE_CLICKED_ID) ? Integer.valueOf(String.valueOf(this.get(this.DRAW_MOUSE_CLICKED_ID))) : 0;
    }

    public void setMouseClickedID(int mouseClickedID) {
        this.addAndSet(this.DRAW_MOUSE_CLICKED_ID, mouseClickedID);
    }

    public int getMouseWheel() {
        return this.has(this.DRAW_MOUSE_WHEEL) ? Integer.valueOf(String.valueOf(this.get(this.DRAW_MOUSE_WHEEL))) : 0;
    }

    public void setMouseWheel(int mouseWheel) {
        this.addAndSet(this.DRAW_MOUSE_WHEEL, mouseWheel);
    }

    public boolean isMouseGrapped() {
        return Boolean.valueOf(String.valueOf(this.has(this.DRAW_MOUSE_CURSOR_GRAP) ? this.get(this.DRAW_MOUSE_CURSOR_GRAP) : false));
    }

    public void setMouseGrapped(boolean isMouseGrapped) {
        this.addAndSet(this.DRAW_MOUSE_CURSOR_GRAP, isMouseGrapped);
    }

    public void addDrawPaintListener(DrawPaintListener drawPaintListener) {
        if (this.drawPaintListeners == null) this.drawPaintListeners = new DrawPaintListener[1];
        else this.drawPaintListeners = Arrays.copyOf(this.drawPaintListeners, this.listenerLength + 1);

        this.drawPaintListeners[this.listenerLength] = drawPaintListener;

        ++this.listenerLength;
    }

    public int colorOption(int color) {
        return color < 0 ? 0 : color > 255 ? 255 : color;
    }

    public int colorOptionHex(int red, int green, int blue) {
        return (int) Long.parseLong(Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue), 16);
    }

    public int[] colorOptionToHex(int rgba) {
        return new int[]{rgba >> 16 & 0xFF, rgba >> 8 & 0xFF, rgba >> 0 & 0xFF};
    }

    public int getColor(int id, int default_) {
        return Integer.valueOf(String.valueOf(this.has(id) ? this.get(id) : default_).substring(1));
    }

    public String string() {
        String string = "[";
        for (int len = 0; len < this.rawBuffer.length; ++len)
            string += Arrays.toString(this.rawBuffer[len]) + (len == this.rawBuffer.length - 1 ? "]" : ", ");
        return string;
    }

    public int[][] rawBuffer() {
        return this.rawBuffer;
    }

    public int length() {
        return this.length;
    }

    public String toString() {
        return "DrawFrame{" +
                "rawBuffer=" + this.string() +
                ", length=" + this.length +
                '}';
    }

    public void pack() {
        try {
            if (this.frame == null) this.frame = new Frame();
            else this.frame.dispose();
            if (this.panel == null) this.panel = new Panel() {

                private void paint(Graphics graphics, int mouseX, int mouseY, int mouseClicked) {
                    DrawPaintListener[] drawPaintListeners1 = DrawFrame.this.drawPaintListeners;
                    for (int len = 0; len < DrawFrame.this.listenerLength; ++len)
                        drawPaintListeners1[len].paint(graphics, mouseX, mouseY, mouseClicked);
                }

                public void paint(Graphics g) {
                    super.paint(g);
                    this.paint(g, DrawFrame.this.getMouseX(), DrawFrame.this.getMouseY(), DrawFrame.this.getMouseClickedID());
                }

                public void update(Graphics g) {
                    super.update(g);
                    this.paint(g, DrawFrame.this.getMouseX(), DrawFrame.this.getMouseY(), DrawFrame.this.getMouseClickedID());
                }
            };//Main Panel
            if (this.panel1 == null) this.panel1 = new Panel();//Undecorated Title bar
            if (this.panel2 == null) this.panel2 = new Panel();//Undecorated Title bar Exit Panel
            if (this.button == null) this.button = new Button();//Undecorated Title bar Exit
            if (this.button1 == null) this.button1 = new Button();//Undecorated Title bat Maximum
            if (this.button2 == null) this.button2 = new Button();//Undecorated Title bat Minimum
            if (this.drawLabel == null) this.drawLabel = new DrawLabel();//Undecorated Title bar Title

            if (this.has(this.DRAW_UNDECORATED)) if (this.isUndecorated()) this.frame.setUndecorated(true);

            this.frame.pack();

            if (this.isMouseGrapped()) {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] gs = ge.getScreenDevices();
                for (GraphicsDevice device : gs) {
                    Robot robot = new Robot(device);
                    int mouseX = this.getMouseX() < 0 ? 0 : this.getMouseX() > this.getWidth() ? this.getWidth() : this.getMouseX();
                    int mouseY = this.getMouseY() < 0 ? 0 : this.getMouseY() > this.getHeight() ? this.getHeight() : this.getMouseY();
                    robot.mouseMove(mouseX, mouseY);
                }

//                BufferedImage bufferedImage = this.getMouseCursorIcon();
//                if (bufferedImage != null) this.frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(this.getMouseCursorIcon(), new Point(this.getX(), this.getY()), "img"));
            }

            TitleBarAdapter titleBarAdapter = new TitleBarAdapter(this.frame);
            Color titleBarColor = new Color(this.getTitleBarColorRed(), this.getTitleBarColorGreen(), this.getTitleBarColorBlue());
            Color mainColor = new Color(this.getMainColorRed(), this.getMainColorGreen(), this.getMainColorBlue());
            Color titleBarTitleColor = new Color(this.getTitleBarTitleColorRed(), this.getTitleBarTitleColorGreen(), this.getTitleBarTitleColorBlue());
            int x = this.has(this.DRAW_X) ? this.getX() : 0;
            int y = this.has(this.DRAW_Y) ? this.getY() : 0;
            int w = this.has(this.DRAW_WIDTH) ? this.getWidth() : 0;
            int h = this.has(this.DRAW_HEIGHT) ? this.getHeight() : 0;
            Rectangle rectangle = new Rectangle(x, y, w, h);
            Point point = new Point(x, y);
            Dimension dimension = new Dimension(w, h);
            String title = this.getTitle();
            this.frame.setLayout(new BorderLayout());
            this.frame.addWindowListener(this);
            this.frame.addWindowFocusListener(this);
            this.frame.addWindowStateListener(this);

            this.drawLabel.setText(title);
            this.drawLabel.setForeground(titleBarTitleColor);

            if (this.has(this.DRAW_TITLE_BAR_IMAGE_ICON)) {
                this.frame.setIconImage(this.getTitleBarIcon().getImage());
                this.drawLabel.setIcon(this.getTitleBarIcon());
            }

            this.button.setActionCommand("Exit");
            this.button1.setActionCommand("Maximum");
            this.button2.setActionCommand("Minimum");

            this.button.setLabel("X");
            this.button1.setLabel("\u25A1");
            this.button2.setLabel("\uFF0D");

            this.button.addActionListener(this);
            this.button1.addActionListener(this);
            this.button2.addActionListener(this);

            this.panel2.setLayout(new BorderLayout());
            this.panel2.add(this.button, "East");
            this.panel2.add(this.button1, "Center");
            this.panel2.add(this.button2, "West");

            this.panel1.setLayout(new BorderLayout());
            this.panel1.add(this.panel2, "East");
            this.panel1.add(this.drawLabel, "West");

            this.panel1.addMouseMotionListener(titleBarAdapter);
            this.drawLabel.addMouseMotionListener(titleBarAdapter);
            this.panel.addMouseListener(this);
            this.panel.addMouseMotionListener(this);
            this.panel.addMouseWheelListener(this);

            this.panel.setBackground(mainColor);
            this.panel1.setBackground(titleBarColor);
            this.panel2.setBackground(titleBarColor);

            if (this.frame.isUndecorated()) this.frame.add(this.panel1, "North");
            this.frame.add(this.panel, "Center");

            this.frame.setTitle(title);

            this.frame.setVisible(this.isVisible());
            if (this.has(this.DRAW_RESIZABLE)) {
                this.frame.setResizable(this.isResizable());
                this.button1.setEnabled(this.isResizable());
            }
            if (this.has(this.DRAW_BOUNDS_CENTER) ? this.isBoundsCenter() : false) {
                this.frame.setSize(dimension);
                this.frame.setLocationRelativeTo(null);
            } else this.frame.setBounds(rectangle);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.exit(-1);
        }
    }

    private void println(Object format, Object... objects) {
        if (ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("jdwp") >= 0) {
            if (format instanceof Object[]) format = Arrays.toString((Object[]) format);
            else if (format instanceof Integer[] | format instanceof int[]) format = Arrays.toString((int[]) format);
            else if (format instanceof Short[] | format instanceof short[]) format = Arrays.toString((short[]) format);
            else if (format instanceof Long[] | format instanceof long[]) format = Arrays.toString((long[]) format);
            else if (format instanceof Byte[] | format instanceof byte[]) format = Arrays.toString((byte[]) format);
            else if (format instanceof Double[] | format instanceof double[])
                format = Arrays.toString((double[]) format);
            else if (format instanceof Float[] | format instanceof float[]) format = Arrays.toString((float[]) format);
            else if (format instanceof Boolean[] | format instanceof boolean[])
                format = Arrays.toString((boolean[]) format);
            else if (format instanceof String[]) format = Arrays.toString((String[]) format);
            for (int len = 0; len < objects.length; ++len) {
                Object obj = objects[len];
                if (obj instanceof Object[]) obj = Arrays.toString((Object[]) format);
                else if (obj instanceof Integer[] | obj instanceof int[]) obj = Arrays.toString((int[]) obj);
                else if (obj instanceof Short[] | obj instanceof short[]) obj = Arrays.toString((short[]) obj);
                else if (obj instanceof Long[] | obj instanceof long[]) obj = Arrays.toString((long[]) obj);
                else if (obj instanceof Byte[] | obj instanceof byte[]) obj = Arrays.toString((byte[]) obj);
                else if (obj instanceof Double[] | obj instanceof double[]) obj = Arrays.toString((double[]) obj);
                else if (obj instanceof Float[] | obj instanceof float[]) obj = Arrays.toString((float[]) obj);
                else if (obj instanceof Boolean[] | obj instanceof boolean[]) obj = Arrays.toString((boolean[]) obj);
                else if (obj instanceof String[]) obj = Arrays.toString((String[]) obj);
                objects[len] = obj;
            }
            System.out.printf("[debug] " + format + "\n", objects);
        }
    }

    public Panel getMainPanel() {
        return this.panel;
    }

    public void paint(Graphics graphics, int mouseX, int mouseY, int mouseClicked) {
        //Begin true: throw new IllegalArgumentException("Has been started");
        //Begin false: throw new IllegalArgumentException("Not been started");

        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        int[][] rawBuffer = this.drawing.rawBuffer();
        int vertex = this.drawing.getVertex();

        for (int len = 0; len < vertex; ++len) {
            int[] raw = rawBuffer[len];
            int id = raw[0];
            if (id == Drawing.DRAW_COLOR_4D) {
                int red = raw[1];
                int green = raw[2];
                int blue = raw[3];
                int alpha = raw[4];
                graphics.setColor(new Color(red, green, blue, alpha));
            } else if (id == Drawing.DRAW_COLOR_3D) {
                int red = raw[1];
                int green = raw[2];
                int blue = raw[3];
                graphics.setColor(new Color(red, green, blue));
            } else if (id == Drawing.DRAW_QUADS) {
                int x = raw[1];
                int y = raw[2];
                int w = raw[3];
                int h = raw[4];
                graphics.fillRect(x, y, w, h);
            } else if (id == Drawing.DRAW_LINE) {
                int x = raw[1];
                int y = raw[2];
                int x2 = raw[3];
                int y2 = raw[4];
                graphics.drawLine(x, y, x2, y2);
            }
        }
    }

    @Deprecated
    public Drawing drawing() {
        return this.drawing != null ? this.drawing : new Drawing();
    }

    @Deprecated
    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    @Deprecated
    public MouseCursor mouseCursor() {
        return this.mouseCursor != null ? this.mouseCursor : new MouseCursor(16, 16);
    }

    @Deprecated
    public void setMouseCursor(MouseCursor mouseCursor) {
        this.mouseCursor = mouseCursor;
    }

    @Deprecated
    public BufferedImage getMouseCursorIcon() {
        boolean isNull = this.mouseCursor == null;
        if (isNull) this.mouseCursor = new MouseCursor(16, 16);

        int pixelWidth = this.mouseCursor.getWidth(), pixelHeight = this.mouseCursor.getHeight();
        this.println(pixelWidth + "x" + pixelHeight);
        Vertex[] vertexes = this.mouseCursor.vertexes();

        BufferedImage bufferedImage = new BufferedImage(pixelWidth, pixelHeight, BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        if (isNull) {
            graphics2D.setColor(new Color(0, 0, 0, 0));
            graphics2D.fillRect(0, 0, pixelWidth, pixelHeight);
            graphics2D.create();
            return bufferedImage;
        } else {
            for (int len = 0; len < this.mouseCursor.length(); ++len) {
                Vertex vertex = vertexes[len];
                graphics2D.setColor(new Color(vertex.getRed(), vertex.getGreen(), vertex.getBlue(), vertex.getAlpha()));
                graphics2D.fillRect(vertex.getX(), vertex.getY(), 1, 1);
            }
        }
        graphics2D.create();
        return isNull ? bufferedImage : null;
    }

    public void mouseClicked(MouseEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.setMouseClickedID(e.getButton());
        this.panel.repaint();
    }

    public void mousePressed(MouseEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.setMouseClickedID(e.getButton());
        this.panel.repaint();
    }

    public void mouseReleased(MouseEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.setMouseClickedID(e.getButton());
        this.panel.repaint();
    }

    public void mouseEntered(MouseEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.panel.repaint();
        this.setMouseClickedID(e.getButton());
    }

    public void mouseExited(MouseEvent e) {
        this.panel.repaint();
    }

    public void mouseDragged(MouseEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.setMouseClickedID(e.getButton());
        this.panel.repaint();
    }

    public void mouseMoved(MouseEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.setMouseClickedID(e.getButton());
        this.panel.repaint();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        this.setMouseX(e.getX());
        this.setMouseY(e.getY());
        this.setMouseClickedID(e.getButton());
        this.setMouseWheel(e.getWheelRotation());
        this.panel.repaint();
    }

    public void windowGainedFocus(WindowEvent e) {
    }

    public void windowLostFocus(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        this.windowCloseEvent(e, null);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowStateChanged(WindowEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        String action = e.getActionCommand();
        if (action == "Exit" || action.equals("Exit"))
            this.windowCloseEvent(null, e);
        else if (action == "Maximum" || action.equals("Maximum")) {
            if (this.getWidth() == width && this.getHeight() == height)
                this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            else this.setBounds(0, 0, width, height);
            this.pack();
        }
    }

    public void windowCloseEvent(WindowEvent windowEvent, ActionEvent actionEvent) {
        System.exit(0);
    }
}
