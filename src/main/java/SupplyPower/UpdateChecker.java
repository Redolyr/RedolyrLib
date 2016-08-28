package SupplyPower;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.Map;

/**
 * Created by redolyr on 2016/08/10.
 */
public class UpdateChecker {

    public static final UpdateChecker instance = new UpdateChecker(2097152);

    private UpdateChecker(int megaByte) {
    }

    private Map map;
    private String siteURL = "";
    private String currentVersion = "Latest";
    private String version = "<none>";
    private String directoryOrFiles = "";

    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    public void currentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public void version(String version) {
        this.version = version;
    }

    public void directoryOrFiles(String key) {
        directoryOrFiles = key;
    }

    public void logger(boolean isDelete) throws IOException {
        FileOutputStream fos = new FileOutputStream(this.directoryOrFiles);
        fos.getChannel().transferFrom(Channels.newChannel(new URL(this.siteURL).openStream()), 0, 1 << 24);
        fos.close();

        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.directoryOrFiles));

        while ((line = bufferedReader.readLine()) != null) {
            String lens = line.replace("<br>", "");
            String[] astring = lens.split(":");
            if (!(astring[1].equals("https") || astring[1].equals("http")))
                this.map.put("{" + astring[0] + "}", astring[1]);
            else this.map.put("{" + astring[0] + "}", astring[1] + ":" + astring[2]);
        }
        bufferedReader.close();

        if (isDelete) ThawingZip.removeFiles(new File(this.directoryOrFiles).getPath());
    }

    public Map getMap() {
        return this.map;
    }

    public boolean hasNextVersion() {
        return this.version == this.currentVersion;
    }

    public String nextVersion() {
        return this.hasNextVersion() ? "has next update version" : "hasn't next update version found";
    }
}
