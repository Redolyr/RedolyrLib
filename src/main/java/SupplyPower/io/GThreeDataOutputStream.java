package SupplyPower.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by redolyr on 2016/08/10.
 */
public class GThreeDataOutputStream extends DataOutputStream {

    public GThreeDataOutputStream(File par1File) throws IOException {
        super(new GZIPOutputStream(new GZIPOutputStream(new GZIPOutputStream(new FileOutputStream(par1File)))));
    }
}