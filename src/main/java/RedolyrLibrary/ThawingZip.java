package RedolyrLibrary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class ThawingZip
{
	private ThawingZip() {}
	/**
	 * Thawing in Name Paths
	 * 
	 * @param par1String
	 * @param isJarPatch
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String ThawingZIP(String par1String, boolean isJarPatch)
	{
		String exported = "<None>";
		
		//Paths's replaces
		String s = "";
		{
			String name = ThawingZip.class.getName().replace('.', '/');
			name = ThawingZip.class.getResource("/" + name + ".class").toString();
			if (isJarPatch) name = name.substring(0, name.indexOf(".jar"));
			name = name.substring(name.lastIndexOf(':')-1, name.lastIndexOf('/')+1).replace('%', ' ');
			for (int k=0; k<name.length(); k++)
			{
				s += name.charAt(k);
				if (name.charAt(k) == ' ') k += 2;
			}
		}
		File file = new File(s.replace('/', File.separatorChar), par1String);
		
		//Create Directories
		File path = new File(par1String.substring(0, par1String.lastIndexOf(".")));
		if (path.isDirectory() == false) path.mkdirs();
		
		//Thawing Zip
		try
		{
			String fileName = file.getName();
			int exindex = fileName.lastIndexOf(".");
			String baseDirName = fileName.substring(0, exindex);
			File baseDir = new File(file.getParent(), baseDirName);
			ZipFile zipFile = new ZipFile(file);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			List<String> content = new ArrayList<String>();
			while (entries.hasMoreElements())
			{
				ZipEntry ze = entries.nextElement();
				File outFile = new File(baseDir, ze.getName());
				if (ze.isDirectory())
				{
					outFile.mkdirs();
				}
				else
				{
					BufferedInputStream bis = null;
					BufferedOutputStream bos = null;
					try
					{
						InputStream is = zipFile.getInputStream(ze);
						bis = new BufferedInputStream(is);
						if (!outFile.getParentFile().exists())
						{
							outFile.getParentFile().mkdirs();
						}
						bos = new BufferedOutputStream(new FileOutputStream(outFile));
						int ava;
						while ((ava = bis.available()) > 0)
						{
							byte[] bs = new byte[ava];
							bis.read(bs);
							bos.write(bs);
						}
					}
					catch (FileNotFoundException e)
					{
						throw e;
					}
					catch (IOException e)
					{
						throw e;
					}
					finally
					{
						try
						{
							if (bis != null) bis.close();
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
						try
						{
							if (bos != null) bos.close();
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
				content.add(ze.getName());
			}
			
			for (int len = 0; len < content.size(); len++) exported = String.format("%s", content.get(len));
		}
		catch (ZipException exception)
		{
			exception.printStackTrace();
			return "Exported: " + exported;
		}
		catch (IOException exception)
		{
			exception.printStackTrace();
			return "Exported: " + exported;
		}
		//Output in Thawing All File name and paths
		return "Exported: " + exported;
	}
	public static void removeFiles(String par1String)
	{
		deleteFile(new File(par1String));
	}
	private static boolean deleteFile(File dirOrFile)
	{
		if (dirOrFile.isDirectory())
		{
			String[] children = dirOrFile.list();
			for (int i=0; i<children.length; i++)
			{
				boolean success = deleteFile(new File(dirOrFile, children[i]));
				if (!success)
				{
					return false;
				}
			}
		}
		return dirOrFile.delete();
	}
	public static long getURLFile(URL url, File file)
	{
		long longs = 0L;
		try
		{
    		URL site = url;
    		ReadableByteChannel rbc = Channels.newChannel(site.openStream());
    		FileOutputStream fos = new FileOutputStream(file);
    		longs = fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    		fos.close();
		}
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
		return longs;
	}
}
/* 
 * http://stackoverflow.com/
 * In this source code's, Where i do is put the JarInputStream?
 * I'm Japanese
 */