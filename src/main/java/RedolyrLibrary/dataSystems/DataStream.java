package RedolyrLibrary.dataSystems;

import java.io.*;

import RedolyrLibrary.io.GThreeDataInputStream;
import RedolyrLibrary.io.GThreeDataOutputStream;

public class DataStream
{
	public static void write(File par1File, DataTagCompound par2DataTagCompound) throws IOException
	{
		GThreeDataOutputStream gtdos = new GThreeDataOutputStream(par1File);
		par2DataTagCompound.write(gtdos);
		gtdos.close();
	}
	public static DataTagCompound read(File par1File) throws IOException
	{
		try
		{
			DataTagCompound dtc = new DataTagCompound();
			GThreeDataInputStream gtdis = new GThreeDataInputStream(par1File);
			dtc.read(gtdis);
			gtdis.close();
			return dtc;
		}
		catch (EOFException exception)
		{
			exception.printStackTrace();
			return new DataTagCompound();
		}
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
			return new DataTagCompound();
		}
	}
    public static File dataFile(String parent, String child)
    {
        return new File(parent, child + ".r7.daf");
    }

    /**
     *
     * @param dataTagCompound
     * @param outputStream
     * @return NotClosed
     * @throws IOException
     */
    public static DataOutputStream write(DataTagCompound dataTagCompound, OutputStream outputStream) throws IOException
    {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataTagCompound.write(dataOutputStream);
        return dataOutputStream;
    }

    /**
     *
     * @param dataTagCompound
     * @param inputStream
     * @return NotClosed
     * @throws IOException
     */
    public static DataInputStream read(DataTagCompound dataTagCompound, InputStream inputStream) throws IOException
    {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        dataTagCompound.read(dataInputStream);
        return dataInputStream;
    }
}
