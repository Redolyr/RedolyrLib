package RedolyrLibrary.fileSystems;

import RedolyrLibrary.io.GThreeElementInputStream;
import RedolyrLibrary.io.GThreeElementOutputStream;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ElementStream
{
	public static void write(File par1File, ElementTagCompound par2ElementTagCompound) throws IOException
	{
		if (!par1File.isFile()) par1File.createNewFile();
		GThreeElementOutputStream gtdos = new GThreeElementOutputStream(par1File);
		par2ElementTagCompound.write(gtdos);
		gtdos.close();
	}
	public static ElementTagCompound read(File par1File) throws IOException
	{
		try
		{
			ElementTagCompound dtc = new ElementTagCompound();
			GThreeElementInputStream gtdis = new GThreeElementInputStream(par1File);
			dtc.read(gtdis);
			gtdis.close();
			return dtc;
		}
		catch (EOFException exception)
		{
			exception.printStackTrace();
			return new ElementTagCompound();
		}
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
			return new ElementTagCompound();
		}
	}
}
