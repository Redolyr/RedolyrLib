package RedolyrLibrary.fileSystems;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

/**
 * Created by redolyr on 2014/10/08.
 */
public class ElementStream
{
    public static void write(File file, ElementTagCompound elementTagCompound)
    {
        ElementExporter elementExporter = null;
        try
        {
            elementExporter = new ElementExporter(file);
            elementTagCompound.write(elementExporter);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (elementExporter != null)
            {
                try
                {
                    elementExporter.close();
                }
                catch (TransformerException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static ElementTagCompound read(File file)
    {
        ElementTagCompound elementTagCompound = new ElementTagCompound();
        ElementImporter elementImporter = null;
        try
        {
            elementImporter = new ElementImporter(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (elementImporter != null)
            {
                try
                {
                    elementImporter.close();
                    elementTagCompound.read(elementImporter);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return elementTagCompound;
    }
}
