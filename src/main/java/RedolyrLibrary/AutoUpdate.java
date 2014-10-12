package RedolyrLibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AutoUpdate
{
	/**
	 * 2^21
	 */
	public static final AutoUpdate instance = new AutoUpdate(2097152);
	
	private Map map = new HashMap();
	
	private AutoUpdate(int megaByte) {}
	
	private String siteURL = "";
	private String currentVersion = "Latest";
	private String version = "<none>";
	private String directoryOrFiles = "";
	
	public void setGetterURL(String siteURL)
	{
		this.siteURL = siteURL;
	}
	
	public void currentVersion(String currentVersion)
	{
		this.currentVersion = currentVersion;
	}
	
	public void version(String version)
	{
		this.version = version;
	}
	
	public void directoryOrFiles(String key)
	{
		directoryOrFiles = key;
	}
	
	/**
	 * 
	 * @param value {GET_URL} and {CURRENT_VERSION}, {DIRECTORY_OR_FILES}, {VERSION}, {MAP_ALL}
	 * @return
	 */
	public String get(String value)
	{
		return (String) (value == "{GET_URL}" ? siteURL : (value == "{CURRENT_VERSION}" ? currentVersion : (value == "{DIRECTORY_OR_FILES}" ? directoryOrFiles : (value == "{VERSION}" ? version : (map.containsKey(value) ? map.get(value) : (value == "{MAP_ALL}" ? map.toString() : "<NONE>"))))));
	}
	
	/**
	 * use {@link ThawingZip}'s {@code removeFiles}
	 */
    public void AutoUpdateLogger(boolean isDelete)
    {
    	try
    	{
    		URL site = new URL(get("{GET_URL}"));
    		ReadableByteChannel rbc = Channels.newChannel(site.openStream());
    		FileOutputStream fos = new FileOutputStream(get("{DIRECTORY_OR_FILES}"));
    		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
    		fos.close();
    		
    		String len = "";
    		BufferedReader reader = new BufferedReader(new FileReader(new File(get("{DIRECTORY_OR_FILES}"))));
    		
    		while ((len = reader.readLine()) != null)
    		{
    			String lens = len.replace("<br>", "");
    			String[] astring = lens.split(":");
    			if (!(astring[1].equals("https") || astring[1].equals("http"))) map.put("{" + astring[0] + "}", astring[1]);
    			else map.put("{" + astring[0] + "}", astring[1] + ":" + astring[2]);
    		}
    		reader.close();
    	}
    	catch (IOException exception)
    	{
    		exception.printStackTrace();
    	}
    	
    	if (isDelete) ThawingZip.removeFiles(new File(get("{DIRECTORY_OR_FILES}")).getPath());
    }
    
    public Map getMap()
    {
    	return map;
    }
    
    public Map getCopyMap()
    {
    	Map maps = new HashMap();
    	Iterator it = map.keySet().iterator();
    	while (it.hasNext())
    	{
    		Object key = it.next();
    		Object value = map.get(key);
    		maps.put(key, value);
    	}
    	return maps;
    }
    
    public boolean hasNextVersion()
    {
    	return version == currentVersion;
    }
    
    public String nextVersion()
    {
    	return hasNextVersion() ? "has next update version" : "hasn't next update version found";
    }
}
