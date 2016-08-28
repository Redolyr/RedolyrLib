package SupplyPower;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by redolyr on 2016/08/10.
 */
public final class NativeLoader {

    public static final int platform_windows = 3;
    public static final int platform_linux = 2;
    public static final int platform_macosx = 1;
    public static final String osName = System.getProperty("os.name");
    public static final String osArch = System.getProperty("os.arch");

    public static void loadLibrary(final String lib_path, final String lib_name) {
        int platform;
        if (osName.startsWith("Windows"))
            platform = platform_windows;
        else if (osName.startsWith("Linux") || osName.startsWith("FreeBSD") || osName.startsWith("OpenBSD") || osName.startsWith("SunOS") || osName.startsWith("Unix"))
            platform = platform_linux;
        else if (osName.startsWith("Mac OS X") || osName.startsWith("Darwin"))
            platform = platform_macosx;
        else
            throw new LinkageError("Unknown platform: " + osName);

        Error error;
        try {
            AccessController.doPrivileged(new PrivilegedActionInit(lib_path, lib_name, System.mapLibraryName(lib_name.replace(".dll", ""))));
            return;
        } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            error = unsatisfiedLinkError;
        }

        try {
            AccessController.doPrivileged(new PrivilegedActionInit(lib_path, lib_name));
        } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            if (platform != platform_macosx && ("amd64".equals(osArch) || "x86_64".equals(osArch))) {
                throw error;
            }

            if (platform != platform_macosx) {
                try {
                    AccessController.doPrivileged(new PrivilegedActionInit(lib_path, System.mapLibraryName(lib_name + "64")));
                } catch (UnsatisfiedLinkError unsatisfiedLinkError1) {
                    System.err.println("Failed to load 64 bit library: " + unsatisfiedLinkError1.getMessage());
                }
            }

            throw error;
        }
    }

    private static class PrivilegedActionInit implements PrivilegedAction {

        public String path;
        public String name0;
        public String name1;
        public boolean isName;

        public PrivilegedActionInit(String path, String name0, String name1) {
            this.path = path;
            this.name0 = name0;
            this.name1 = name1;
            this.isName = true;
        }

        public PrivilegedActionInit(String path, String name) {
            this.path = path;
            this.name0 = name;
            this.isName = false;
        }

        public Object run() {
            if (this.path != null) {
                System.load(this.path + File.separator + (this.isName ? this.name1 : this.name0));
            } else {
                System.loadLibrary(this.name0);
            }
            return null;
        }
    }
}
