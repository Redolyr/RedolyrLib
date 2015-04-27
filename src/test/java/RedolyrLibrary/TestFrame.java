package RedolyrLibrary;

/**
 * Created by redolyr on 2014/12/08.
 */
public class TestFrame {} /*implements ActionListener, MouseMotionListener, WindowListener, WindowFocusListener, WindowStateListener {

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

    public TestFrame() {
        this.readFromData();

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
        if (this.jPanel2 == null) this.jPanel2 = new JPanel();
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

        for (JTextArea jTextArea : ResponseUtil.setThreads(this.threads))
            if (jTextArea != null)
                this.jScrollPane.add(jTextArea);

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

    public void readFromData() {
        try {
            this.threads.readFromData(DataStream.read(new File("C:/Users/redolyr/Desktop/test.dat")));
            System.out.println(this.threads);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToData() {
        try {
            DataTagCompound dataTagCompound = new DataTagCompound();
            this.threads.writeToData(dataTagCompound);
            System.out.println(dataTagCompound);
            DataStream.write(new File("C:/Users/redolyr/Desktop/test.dat"), dataTagCompound);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Send")) {
            this.readFromData();

            this.threads.addResponse(this.jTextField.getText(), this.jTextArea.getText().split("\n"));
            this.jTextArea.setText("");

            this.writeToData();

            this.pack1();
        } else if (cmd.equals("exit")) {
            this.writeToData();

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
        this.readFromData();
    }

    public void windowClosing(WindowEvent e) {
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

class Threads {

    private Response[] responses = new Response[1000];
    private int length;
    private String threadsTitle = "<Unknown>";

    public void readFromData(DataTagCompound dataTagCompound) {

        this.responses = new Response[1000];

        this.threadsTitle = dataTagCompound.getString("threadsTitle") != null ? dataTagCompound.getString("threadsTitle") : "<Unknown>";

        this.length = dataTagCompound.getInteger("ResponseLength");

        DataTagList dataTagList = dataTagCompound.getList("Responses");

        for (int len = 0; len < dataTagList.count(); ++len)
            if (this.responses[len] != null)
                this.responses[len].readFromData(dataTagList.getCompound(len));
    }

    public void writeToData(DataTagCompound dataTagCompound) {

        dataTagCompound.setString("threadsTitle", this.threadsTitle);

        dataTagCompound.setInteger("ResponseLength", this.length);

        DataTagList dataTagList = new DataTagList();

        for (int len = 0; len < this.length; ++len) {
            if (this.responses[len] != null) {
                DataTagCompound dataTagCompound1 = new DataTagCompound();
                this.responses[len].writeToData(dataTagCompound1);
                dataTagList.appendTag(dataTagCompound1);
            }
        }

        dataTagCompound.setList("Responses", dataTagList);
    }

    public void addResponse(String username, String[] texts) {
        this.responses[this.length] = new Response(this.length + 1, username, texts, new SimpleDateFormat("EEE mm/dd/yyyy hh/MM/ss").format(new Date()));

        ++this.length;
    }

    public Response[] getResponses() {
        return this.responses;
    }

    public int length() {
        return this.length;
    }

    public String getThreadsTitle() {
        return this.threadsTitle;
    }

    public String toString() {
        String result = "[";
        for (int len = 0; len < this.length; ++len) {
            Response response = this.responses[len];
            if (response != null) result += response + (len == this.length - 1 ? "" : ", ");
        }
        result += "]";
        return String.format("{ThreadsTitle=\"%s\", Responses=%s, ReponseLength=%s", this.threadsTitle, result, this.length);
    }
}

class Response {
    private int response;
    private String username;
    private String[] texts;
    private String date;
    private String base64;

    public Response(int response, String username, String[] texts, String date) {
        this.response = response;
        this.username = username;
        this.texts = texts;
        this.date = date;
        this.base64 = ResponseUtil.setBase64();
        String.format("#%s Username: %s Texts: %s Date: %s %s", this.response, this.username, Arrays.toString(this.texts), this.date, this.base64);
    }

    public void readFromData(DataTagCompound dataTagCompound) {
        this.response = dataTagCompound.getInteger("ResponseId");
        this.username = dataTagCompound.getString("Username");
        this.texts = dataTagCompound.getStringArray("Texts");
        this.date = dataTagCompound.getString("Date");
        this.base64 = dataTagCompound.getString("Base64");
    }

    public void writeToData(DataTagCompound dataTagCompound) {
        dataTagCompound.setInteger("ResponseId", this.response);
        dataTagCompound.setString("Username", this.username);
        dataTagCompound.setStringArray("Texts", this.texts);
        dataTagCompound.setString("Date", this.date);
        dataTagCompound.setString("Base64", this.base64);
    }

    public int getResponse() {
        return this.response;
    }

    public String getUsername() {
        return this.username;
    }

    public String[] getTexts() {
        return this.texts;
    }

    public String getDate() {
        return this.date;
    }

    public String getBase64() {
        return this.base64;
    }

    public String toString() {
        return String.format("#%s Username: %s Texts: %s Date: %s %s", this.response, this.username, Arrays.toString(this.texts), this.date, this.base64);
    }
}

class GraphicsUtil {

    public Graphics graphics;
    public int x;
    public int y;

    public GraphicsUtil(Graphics graphics, int x, int y) {
        this.graphics = graphics;
        this.x = x;
        this.y = y;
    }
}

class ResponseUtil {

//    public static void add(Graphics graphics, int x, int y, Font font, String[] texts, String format) {
//        graphics.setFont(font);
//        graphics.drawString(format, x + 25, y + 25);
//        FontMetrics fontMetrics = graphics.getFontMetrics();
//        for (int len = 0; len < texts.length; ++len) graphics.drawString(texts[len], x + 30, y = y + (fontMetrics.getHeight() * 10));
//    }
//
//    public static void add(Graphics graphics, int x, int y, int responseId, String username, String[] texts, String date, String base64) {
//        add(graphics, x, y, new Font("Monospaced", 0, 24), texts, String.format("#%s User: %s Date: %s %s", responseId, username, date, base64));
//    }
//
//    public static void addResponse(GraphicsUtil graphicsUtil, Response response) {
//        add(graphicsUtil.graphics, graphicsUtil.x, graphicsUtil.y, response.getResponse(), response.getUsername(), response.getTexts(), response.getDate(), response.getBase64());
//    }
//
//    public static void setThreads(GraphicsUtil graphicsUtil, Threads threads) {
//        for (Response response : threads.getResponses()) addResponse(graphicsUtil, response);
//    }


    public static JTextArea add(JTextArea jTextArea, Font font, boolean isEditable, Border border, String[] texts, String format) {
        jTextArea.setFont(font != null ? font : new Font("Monospaced", 0, 24));
        jTextArea.setEditable(isEditable);
        jTextArea.setBorder(new TitledBorder(border != null ? border : new EtchedBorder(), format != "<Unknown>" || format != null ? format : "<Unknown>"));

        for (int len = 0; len < texts.length; ++len) jTextArea.append(texts[len]);
        return jTextArea;
    }

    public static JTextArea add(int responseId, String username, String[] texts, String date, String base64) {
        if (username != null || username != "") username = "<Unknown>";
        if (date != null || date != "") date = "<Unknown>";
        if (base64 != null || base64 != "") base64 = "<Unknown>";

        if (texts != null) texts = new String[0];
        return add(new JTextArea(), new Font("Monospaced", 0, 24), false, new EtchedBorder(), texts, String.format("#%s User: %s Date: %s %s", responseId, username, date, base64));
    }

    public static JTextArea add(Response response) {
        return response != null ? add(response.getResponse(), response.getUsername(), response.getTexts(), response.getDate(), response.getBase64()) : new JTextArea();
    }

    public static JTextArea[] setThreads(int length, Response[] responses) {
        JTextArea[] jTextAreas = new JTextArea[responses != null ? responses.length : 0];
        for (int len = 0; len < length; ++len) jTextAreas[len] = add(responses[len]);
        return jTextAreas;
    }

    public static JTextArea[] setThreads(Threads Threads) {
        return setThreads(Threads.length(), Threads.getResponses());
    }

    public static String setBase64() {

        boolean isDebug = ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("jdwp") >= 0;

        String computerName = System.getProperty("user.name");
        String hostAddress = "Unknown";
        String hostName = "Unknown";
        String result = "";

        String compress = String.format("ComputerName: %s, HostAddress: %s, HostName: %s", computerName, hostAddress, hostName);

        if (isDebug && false) System.out.println(compress);

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostAddress = inetAddress.getHostAddress();
            hostName = inetAddress.getHostName();
        } catch (UnknownHostException exception) {
            exception.printStackTrace();
            return "Unknown";
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(compress.getBytes());
            byte[] bytes = md.digest();

            for (int len = 0; len < bytes.length; ++len) result += String.format("%02x", bytes[len]);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Unknown";
        }
        return result;
    }
}

class Packet {

    protected Socket socket;
    protected DataOutputStream dataOutputStream;
    protected DataInputStream dataInputStream;

    public Packet(Socket socket) throws IOException {
        this.socket = new Socket();
        if (socket != null) {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        }
    }

    public Socket getSocket() {
        return this.socket;
    }

    public DataInputStream getDataInputStream() throws IOException {
        return this.dataInputStream;
    }

    public DataOutputStream getDataOutputStream() throws IOException {
        return this.dataOutputStream;
    }
}

class ClientPacket extends Packet {

    public ClientPacket(Socket socket) throws IOException{
        super(socket);
    }
}

class ServerPacket extends Packet {

    public ServerPacket(Socket socket) throws IOException {
        super(socket);
    }

    public ServerPacket(ServerSocket serverSocket) throws IOException {
        super(serverSocket.accept());
    }
}*/
/**
 HelloWorld.
 Niconico KUNIKAIGI.
 I have not Youtube Account.
 OKAY? :D
 */