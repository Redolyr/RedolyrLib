package SupplyPower.dataSystems;

import SupplyPower.io.GThreeDataInputStream;
import SupplyPower.io.GThreeDataOutputStream;

import java.io.*;

/**
 * Created by redolyr on 2016/08/10.
 */
public class DataStream {
    public static void write(File par1File, DataTagCompound par2DataTagCompound) throws IOException {
        GThreeDataOutputStream gtdos = new GThreeDataOutputStream(par1File);
        par2DataTagCompound.write(gtdos);
        gtdos.close();
    }

    public static DataTagCompound read(File par1File) throws IOException {
        try {
            DataTagCompound dtc = new DataTagCompound();
            GThreeDataInputStream gtdis = new GThreeDataInputStream(par1File);
            dtc.read(gtdis);
            gtdis.close();
            return dtc;
        } catch (EOFException exception) {
            exception.printStackTrace();
            return new DataTagCompound();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return new DataTagCompound();
        }
    }

    public static File dataFile(String parent, String child) {
        return new File(parent, child + ".r7.daf");
    }

    /**
     * @param dataTagCompound
     * @param outputStream
     * @return NotClosed
     * @throws IOException
     */
    public static DataOutputStream write(DataTagCompound dataTagCompound, OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataTagCompound.write(dataOutputStream);
        return dataOutputStream;
    }

    /**
     * @param inputStream
     * @return InputStream reading Data
     * @throws IOException
     */
    public static DataTagCompound read(InputStream inputStream) throws IOException {
        DataTagCompound dataTagCompound = new DataTagCompound();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        dataTagCompound.read(dataInputStream);
        return dataTagCompound;
    }
}
