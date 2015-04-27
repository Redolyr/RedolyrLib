package RedolyrLibrary;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by redolyr on 2014/10/27.
 */
public class Logger {
    private static PrintStream loggerPrint;
    private static int loggerId = 0;
    private final byte[] info;
    private byte[] export;
    public static boolean logPrint = false;
    private static final boolean isDebugMode = ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("jdwp") >= 0;
    private static File logPath = new File(".");

    private Logger(byte[] info) {
        this.info = info;
    }

    public static final Logger getLogger(Class classes) {
        return new Logger(("[" + classes.getSimpleName() + "] ").getBytes());
    }

    private void info(String info, boolean isDebug) {
        byte[] dataFormat = new SimpleDateFormat(String.format("[mm/dd/yyyy - hh:MM:ss%s] ", isDebug ? ".SSS" : "")).format(new Date()).getBytes();
        byte[] debugModeMessage = "[Debug] ".getBytes();
        byte[] infoModeMessage = "[Info] ".getBytes();
        if (isDebug && this.isDebugMode)
            this.println((new String(dataFormat) + new String(debugModeMessage) + info).getBytes());
        else if (!isDebug) this.println((new String(dataFormat) + new String(infoModeMessage) + info).getBytes());
    }

    private void println(byte[] bytes) {
        if (this.loggerPrint != null) this.loggerPrint.println(new String(this.info) + new String(bytes));
        System.out.println(new String(this.info) + new String(bytes));
        this.export = bytes;
    }

    public byte[] getInfo() {
        return this.export;
    }

    public void info(Object info) {
        this.info(info.toString(), false);
    }

    public void debug(Object info) {
        this.info(info.toString(), true);
    }

    public void infoDebug(Object info) {
        this.info(info);
        this.debug(info);
    }

    private static final File checkId(File path) {
        File file = new File(path, "logger - " + loggerId + ".log");
        while (file.isFile()) {
            ++loggerId;
            file = new File(path, "logger - " + loggerId + ".log");
        }
        return file;
    }

    public static final PrintStream getLoggerPrint() {
        return loggerPrint;
    }

    public static final void setLogPath(File path) {
        logPath = path;
    }

    static {
        try {
            if (!logPath.isDirectory()) logPath.mkdir();
            if (logPrint) loggerPrint = new PrintStream(checkId(logPath));
            ++loggerId;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
