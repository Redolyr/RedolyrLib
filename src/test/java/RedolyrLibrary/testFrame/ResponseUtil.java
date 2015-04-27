package RedolyrLibrary.testFrame;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/18.
 */
public class ResponseUtil {

    public static void add(Graphics graphics, int x, int y, Font font, String[] texts, String format) {
        graphics.setFont(font);
        graphics.drawString(format, x + 25, y + 25);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        for (int len = 0; len < texts.length; ++len)
            graphics.drawString(texts[len], x + 30, y = y + (fontMetrics.getHeight() * 10));
    }

    public static void add(Graphics graphics, int x, int y, int responseId, String username, String[] texts, String date, String base64) {
        add(graphics, x, y, new Font("Monospaced", 0, 24), texts, String.format("#%s User: %s Date: %s %s", responseId, username, date, base64));
    }

    public static void addResponse(GraphicsUtil graphicsUtil, Response response) {
        add(graphicsUtil.graphics, graphicsUtil.x, graphicsUtil.y, response.getResponse(), response.getUsername(), response.getTexts(), response.getDate(), response.getBase64());
    }

    public static void setThreads(GraphicsUtil graphicsUtil, Threads threads) {
        for (Response response : threads.getResponses()) addResponse(graphicsUtil, response);
    }


//    public static JTextArea add(JTextArea jTextArea, Font font, boolean isEditable, Border border, String[] texts, String format) {
//        jTextArea.setFont(font != null ? font : new Font("Monospaced", 0, 24));
//        jTextArea.setEditable(isEditable);
//        jTextArea.setBorder(new TitledBorder(border != null ? border : new EtchedBorder(), format != "<Unknown>" || format != null ? format : "<Unknown>"));
//
//        for (int len = 0; len < texts.length; ++len) jTextArea.append(texts[len]);
//        return jTextArea;
//    }
//
//    public static JTextArea add(int responseId, String username, String[] texts, String date, String base64) {
//        if (username != null || username != "") username = "<Unknown>";
//        if (date != null || date != "") date = "<Unknown>";
//        if (base64 != null || base64 != "") base64 = "<Unknown>";
//
//        if (texts != null) texts = new String[0];
//        return add(new JTextArea(), new Font("Monospaced", 0, 24), false, new EtchedBorder(), texts, String.format("#%s User: %s Date: %s %s", responseId, username, date, base64));
//    }
//
//    public static JTextArea add(Response response) {
//        return response != null ? add(response.getResponse(), response.getUsername(), response.getTexts(), response.getDate(), response.getBase64()) : new JTextArea();
//    }
//
//    public static JTextArea[] setThreads(int length, Response[] responses) {
//        JTextArea[] jTextAreas = new JTextArea[responses != null ? responses.length : 0];
//        for (int len = 0; len < length; ++len) jTextAreas[len] = add(responses[len]);
//        return jTextAreas;
//    }
//
//    public static JTextArea[] setThreads(Threads threads) {
//        return setThreads(threads.length(), threads.getResponses());
//    }

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
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(compress.getBytes());
            byte[] bytes = md.digest();

            for (int len = 0; len < bytes.length; ++len) result += String.format("%02x", bytes[len]);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Unknown";
        }
        return result;
    }

    @Deprecated
    public static void sort(Response[] responses) {
        Response[] responses1 = new Response[1];
        int length = 0;

        for (int len = 0; len < responses.length; ++len)
            if (responses[len] != null) responses[len] = responses1[length++];

        int[] ids = new int[length];
        for (int len = 0; len < length; ++len) ids[len] = responses1[len].getResponse();

        Arrays.sort(ids);

        Response[] responses2 = new Response[length];
        for (int i = 0; i < length; ++i) {
            for (int len = 0; len < length; ++len) {
                Response response = responses1[len];
                int id = ids[len];
                if (id == response.getResponse()) responses2[len] = response;
            }
        }
        responses = responses2;
    }
}
