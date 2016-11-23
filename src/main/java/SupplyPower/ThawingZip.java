package SupplyPower;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * Created by redolyr on 2016/08/10.
 */
public class ThawingZip {

    private ThawingZip() {
    }

    public static String ThawingZIP(String fileAndPath, boolean isJarFile) {
        String exported = "<None>";

        if (fileAndPath == null || fileAndPath.equals("")) {
            return exported;
        }

        String s = "";
        String name = ThawingZip.class.getResource("/" + ThawingZip.class.getName().replace('.', '/') + ".class").toString();
        if (isJarFile) name = name.substring(0, name.indexOf(".jar"));
        name = name.substring(name.lastIndexOf(':') - 1, name.lastIndexOf('/') + 1).replace('%', ' ');
        for (int len = 0; len< name.length(); ++len) {
            s += name.charAt(len);
            if (name.charAt(len) == ' ') len += 2;
        }
        File file = new File(s.replace('/', File.separatorChar), fileAndPath);

        File path = new File(fileAndPath.substring(0, fileAndPath.lastIndexOf(".")));
        if (path.isDirectory() == false) path.mkdirs();

        try {
            String fileName = file.getName();
            File baseDir = new File(file.getParent(), fileName.substring(0, fileName.lastIndexOf(".")));
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            List<String> content = new ArrayList<String>();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            int ava;
            byte[] bs;
            while (entries.hasMoreElements()) {
                ZipEntry ze = entries.nextElement();
                File outFile = new File(baseDir, ze.getName());
                if (!ze.isDirectory()) {
                    outFile.mkdirs();
                } else {
                    try {
                        bis = new BufferedInputStream(zipFile.getInputStream(ze));
                        if (!outFile.getParentFile().exists()) {
                            outFile.getParentFile().mkdirs();
                        }
                        bos = new BufferedOutputStream(new FileOutputStream(outFile));
                        while ((ava = bis.available()) > 0) {
                            bs = new byte[ava];
                            bis.read(bs);
                            bos.write(bs);
                        }
                    } catch (FileNotFoundException e) {
                        throw e;
                    } catch (IOException e) {
                        throw e;
                    } finally {
                        try {
                            if (bis != null) bis.close();
                            if (bos != null) bos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                content.add(ze.getName());
            }

            for (int len = 0; len < content.size(); len++) exported = String.format("%s", content.get(len));
        } catch (ZipException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return "Exported: " + exported;
    }

    public static void removeFiles(String par1String) {
        deleteFile(new File(par1String));
    }

    public static boolean deleteFile(File dirOrFile) {
        if (dirOrFile.isDirectory()) {
            String[] children = dirOrFile.list();
            for (int i = 0; i < children.length; i++) {
                if (!deleteFile(new File(dirOrFile, children[i]))) {
                    return false;
                }
            }
        }
        return dirOrFile.delete();
    }

    public static long getURLFile(URL url, File file) {
        long longs = 0L;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            longs = fos.getChannel().transferFrom(Channels.newChannel(url.openStream()), 0, 1 << 24);
            fos.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return longs;
    }
}
