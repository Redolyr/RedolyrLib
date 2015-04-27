package RedolyrLibrary;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by redolyr on 2015/03/08.
 */
public class NativeLoader {

    public static void loadLibrary(final String library_path, final String lib_name) {
        int platform;
        final int platform_windows = 3;
        final int platform_linux = 2;
        final int platform_macosx = 1;
        final String osName = System.getProperty("os.name");
        if ( osName.startsWith("Windows") )
            platform = platform_windows;
        else if ( osName.startsWith("Linux") || osName.startsWith("FreeBSD") || osName.startsWith("OpenBSD") || osName.startsWith("SunOS") || osName.startsWith("Unix") )
            platform = platform_linux;
        else if ( osName.startsWith("Mac OS X") || osName.startsWith("Darwin") )
            platform = platform_macosx;
        else
            throw new LinkageError("Unknown platform: " + osName);

        String osArch = System.getProperty("os.arch");
        boolean try64First = platform != platform_macosx && ("amd64".equals(osArch) || "x86_64".equals(osArch));

        final String lib_name64 = System.mapLibraryName(lib_name + "64");

        Error error = null;
        try {
            AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    if (library_path != null) {
                        System.load(library_path + File.separator + System.mapLibraryName(lib_name.replace(".dll", "")));
                    } else {
                        System.loadLibrary(lib_name);
                    }
                    return null;
                }
            });
            return;
        } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            error = unsatisfiedLinkError;
        }

        try {
            AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    if (library_path != null) {
                        System.load(library_path + File.separator + lib_name);
                    } else {
                        System.loadLibrary(lib_name);
                    }
                    return null;
                }
            });
        } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            if (try64First) {
                throw error;
            }

            if (platform != platform_macosx) {
                try {
                    AccessController.doPrivileged(new PrivilegedAction<Object>() {
                        public Object run() {
                            if (library_path != null) {
                                System.load(library_path + File.separator + lib_name64);
                            } else {
                                System.loadLibrary(lib_name64);
                            }
                            return null;
                        }
                    });
                    return;
                } catch (UnsatisfiedLinkError unsatisfiedLinkError1) {
                    System.err.println("Failed to load 64 bit library: " + unsatisfiedLinkError1.getMessage());
                }
            }

            throw error;
        }
    }
}
