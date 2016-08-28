package SupplyPower.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * Created by redolyr on 2016/08/10.
 */
public class GThreeDataInputStream extends DataInputStream {

    public GThreeDataInputStream(File par1File) throws IOException {
        super(new GZIPInputStream(new GZIPInputStream(new GZIPInputStream(new FileInputStream(par1File)))));
    }
}
