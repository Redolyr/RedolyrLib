package RedolyrLibrary.testFrame;

import RedolyrLibrary.documentSystems.DocumentStream;
import RedolyrLibrary.documentSystems.DocumentTagCompound;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by redolyr on 2014/12/08.
 */
public class TestFrameDocument implements ActionListener, MouseMotionListener, WindowListener, WindowFocusListener, WindowStateListener {

    private JFrame jFrame = new JFrame();
    private JFrame jFrame1 = new JFrame();
    private JFrame jFrame2 = new JFrame();
    private JPanel jPanel = new JPanel();
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JScrollPane jScrollPane;
    private JTextField jTextField = new JTextField();
    private JTextArea jTextArea = new JTextArea();
    private JLabel jLabel = new JLabel();
    private JButton jButton = new JButton();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();

    private Threads threads = new Threads();

    private int mouseX;
    private int mouseY;

    private Dimension[] titleBar = new Dimension[2];

    public TestFrameDocument() {
        this.readFromDocument();

        this.pack();
        this.pack1();
        this.pack2();
        this.jFrame.setLocationRelativeTo(null);
        int movedX = this.jFrame.getX();
        int movedY = this.jFrame.getY() / 2;
        this.jFrame.setLocation(movedX, movedY);
        this.jFrame1.setLocation(movedX, movedY + this.jFrame.getHeight() + 5);
        this.jFrame2.setLocation(movedX, movedY + this.jFrame1.getHeight() + 60);
    }

    public void pack() {
        if (this.jFrame == null) this.jFrame = new JFrame();
        if (this.jLabel == null) this.jLabel = new JLabel();
        if (this.jButton1 == null) this.jButton1 = new JButton();
        if (this.jButton2 == null) this.jButton2 = new JButton();
        if (this.jPanel3 == null) this.jPanel3 = new JPanel();

        this.jFrame.setUndecorated(true);
        this.jFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        String threadTitle = this.threads.getThreadsTitle();

        this.jFrame.setTitle("Test" + (threadTitle != "" || threadTitle != null ? " - " + threadTitle : ""));

        this.jFrame.addWindowListener(this);
        this.jFrame.addWindowStateListener(this);
        this.jFrame.addWindowFocusListener(this);
        this.jFrame.addMouseMotionListener(this);

        this.jFrame.setLayout(new BorderLayout());

        this.jPanel3.add(this.jButton1, "West");
        this.jPanel3.add(this.jButton2, "East");

        this.jButton1.setActionCommand("exit");
        this.jButton2.setActionCommand("focus");

        this.jButton1.addActionListener(this);
        this.jButton2.addActionListener(this);

        this.jButton1.setText("X");
        this.jButton2.setText("\uFF0D");

        this.jLabel.setText(" " + this.jFrame.getTitle());
        if (this.jFrame.getIconImage() != null) this.jLabel.setIcon(new ImageIcon(this.jFrame.getIconImage()));

        this.jFrame.add(this.jLabel, "West");
        this.jFrame.add(this.jPanel3, "East");

        this.jFrame.pack();

        this.titleBar[0] = new Dimension(1000, 50);
        this.titleBar[1] = new Dimension(this.jLabel.getWidth() + this.jButton1.getWidth() + this.jButton2.getWidth() + 50, 50);
        this.jFrame.setSize(this.titleBar[0]);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
    }

    public void pack1() {
        if (this.jFrame1 == null) this.jFrame1 = new JFrame();
        else this.jFrame1.dispose();
        if (this.jPanel == null) this.jPanel = new JPanel();
        if (this.jPanel2 == null) this.jPanel2 = new JPanel() {

            public void paint(GraphicsUtil graphicsUtil) {
                Threads threads = TestFrameDocument.this.threads;
                ResponseUtil.setThreads(graphicsUtil, threads);
            }

            public void paint(Graphics g) {
                super.paint(g);
                this.paint(new GraphicsUtil(g, 0, 0));
            }

            public void update(Graphics g) {
                super.update(g);
                this.paint(new GraphicsUtil(g, 0, 0));
            }
        };
        if (this.jTextField == null) this.jTextField = new JTextField();
        if (this.jTextArea == null) this.jTextArea = new JTextArea();
        if (this.jButton == null) this.jButton = new JButton();

        this.jFrame1.setUndecorated(this.jFrame.isUndecorated());
        this.jFrame1.getRootPane().setWindowDecorationStyle(this.jFrame.getRootPane().getWindowDecorationStyle());

        for (WindowListener windowListener : this.jFrame.getWindowListeners())
            this.jFrame1.addWindowListener(windowListener);
        for (WindowStateListener windowStateListener : this.jFrame.getWindowStateListeners())
            this.jFrame1.addWindowStateListener(windowStateListener);
        for (WindowFocusListener windowFocusListener : this.jFrame.getWindowFocusListeners())
            this.jFrame1.addWindowFocusListener(windowFocusListener);
        this.jFrame1.setLayout(new BorderLayout());

        this.jPanel.setLayout(new BorderLayout());

        this.jPanel2.setLayout(new BoxLayout(this.jPanel2, BoxLayout.Y_AXIS));

        this.jPanel.add(this.jPanel2, "Center");

        Dimension d = this.jPanel2.getPreferredSize();
        d.height /= 2;
        this.jScrollPane = new JScrollPane(this.jPanel2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.jScrollPane.getViewport().setPreferredSize(d);
        this.jScrollPane.getVerticalScrollBar().setUnitIncrement(this.jPanel2.getPreferredSize().height / 1000);

//        for (JTextArea jTextArea : ResponseUtil.setThreads(this.threads))
//            if (jTextArea != null)
//                this.jScrollPane.add(jTextArea);

        this.jPanel.validate();
        this.jFrame1.add(this.jScrollPane, "Center");
        this.jFrame1.add(this.jPanel, "South");

        this.jFrame1.pack();

        this.jFrame1.setResizable(this.jFrame.isResizable());
        this.jFrame1.setVisible(this.jFrame.isVisible());
        this.jFrame1.setTitle(this.jFrame.getTitle());
        this.jFrame1.setSize(new Dimension(this.jFrame.getWidth(), 450));
    }

    public void pack2() {
        if (this.jFrame2 == null) this.jFrame2 = new JFrame();
        if (this.jPanel1 == null) this.jPanel1 = new JPanel();

        this.jFrame2.setUndecorated(this.jFrame.isUndecorated());
        this.jFrame2.getRootPane().setWindowDecorationStyle(this.jFrame.getRootPane().getWindowDecorationStyle());

        this.jPanel1.setLayout(new BorderLayout());

        this.jPanel1.setBorder(new TitledBorder(new EtchedBorder(), "Sends"));
        this.jTextField.setBorder(new TitledBorder(new EtchedBorder(), "Username"));
        this.jTextArea.setBorder(new TitledBorder(new EtchedBorder(), "Texts"));

        this.jButton.setActionCommand("Send");
        this.jButton.addActionListener(this);
        this.jButton.setText("Send Text Area's Texts");

        this.jPanel1.add(this.jTextField, "North");
        this.jPanel1.add(this.jTextArea, "Center");
        this.jPanel1.add(this.jButton, "East");

        for (WindowListener windowListener : this.jFrame.getWindowListeners())
            this.jFrame2.addWindowListener(windowListener);
        for (WindowStateListener windowStateListener : this.jFrame.getWindowStateListeners())
            this.jFrame2.addWindowStateListener(windowStateListener);
        for (WindowFocusListener windowFocusListener : this.jFrame.getWindowFocusListeners())
            this.jFrame2.addWindowFocusListener(windowFocusListener);
        this.jFrame2.setLayout(new BorderLayout());

        this.jFrame2.add(this.jPanel1, "Center");

        this.jFrame2.pack();

        this.jFrame2.setResizable(this.jFrame.isResizable());
        this.jFrame2.setVisible(this.jFrame.isVisible());
        this.jFrame2.setTitle(this.jFrame.getTitle());
        this.jFrame2.setSize(new Dimension(this.jFrame.getWidth(), 200));
    }

    public void readFromDocument() {
        try {
            try {
                this.threads.readFromDocument(DocumentStream.read(new File("C:/Users/redolyr/Desktop/tests.xml")));
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            System.out.println(this.threads);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToDocument() {
        try {
            DocumentTagCompound DocumentTagCompound = new DocumentTagCompound();
            this.threads.writeToDocument(DocumentTagCompound);
            System.out.println(DocumentTagCompound);
            try {
                DocumentStream.write(new File("C:/Users/redolyr/Desktop/tests.xml"), DocumentTagCompound);
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Send")) {
            this.threads.addResponse(this.jTextField.getText(), this.jTextArea.getText().split("\n"));
            this.jTextArea.setText("");

            this.pack1();
        } else if (cmd.equals("exit")) {
            this.writeToDocument();

            System.exit(0);
        } else if (cmd.equals("focus")) {
            this.jFrame.setFocusable(!this.jFrame.isFocusable());
            this.jFrame1.setVisible(!this.jFrame1.isVisible());
            this.jFrame2.setVisible(!this.jFrame2.isVisible());
            this.jFrame.setSize(this.titleBar[this.jFrame.isFocusable() ? 0 : 1]);
        }
    }

    public void mouseDragged(MouseEvent arg0) {
        int x = arg0.getXOnScreen();
        int y = arg0.getYOnScreen();
        int movedX = x - (this.mouseX < this.jFrame.getWidth() ? this.mouseX : 0);
        int movedY = y - (this.mouseY < this.jFrame.getHeight() ? this.mouseY : 0);
        this.jFrame.setLocation(movedX, movedY);
        this.jFrame1.setLocation(movedX, movedY + this.jFrame.getHeight() + 5);
        this.jFrame2.setLocation(movedX, movedY + this.jFrame1.getHeight() + 60);
    }

    public void mouseMoved(MouseEvent arg0) {
        this.mouseX = arg0.getX();
        this.mouseY = arg0.getY();
    }

    public void windowGainedFocus(WindowEvent e) {
    }

    public void windowLostFocus(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
        this.readFromDocument();
    }

    public void windowClosing(WindowEvent e) {
        this.writeToDocument();
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
}

/**
 HelloWorld.
 Niconico KUNIKAIGI.
 I have not Youtube Account.
 OKAY? :D
 */