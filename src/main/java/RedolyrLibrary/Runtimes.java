package RedolyrLibrary;

import java.io.IOException;

public class Runtimes
{
	private Runtimes(int megabyte) {}
	
	public Runtimes(Runtime instanceRuntime, String runtimeLine) throws IOException
	{
		this(2097152);
		Runtime runtime = instanceRuntime;
		runtime.exec(runtimeLine);
	}
	/**
	 * 
	 * @param path runtime line of java get file
	 * @param meta_info runtime line of java get path is meta-info
	 * @throws java.io.IOException
	 */
	public Runtimes(String path, String meta_info) throws IOException
	{
		this(Runtime.getRuntime(), "java -cp " + path + " " + meta_info);
	}
}
