package RedolyrLibrary.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GThreeElementInputStream extends DataInputStream
{
	public GThreeElementInputStream(File par1File) throws IOException
	{
		super(new GZIPInputStream(new GZIPInputStream(new GZIPInputStream(new FileInputStream(par1File)))));
	}
}
