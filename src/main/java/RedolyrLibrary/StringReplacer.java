package RedolyrLibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by redolyr on 2014/10/07.
 */
public class StringReplacer
{
    private File file;

    /**
     *
     * @param file path or file
     */
    public void setFile(File file)
    {
        this.file = file;
    }

    /**
     *
     * @param shiftJIS before split string
     * @param split example ':' or '='
     * @return after split string
     */
    public String getUTF8(String shiftJIS, String split)
    {
        String string = shiftJIS;
        if (this.file.isFile() == false) return string;

        BufferedReader bufferedReader = null;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(this.file));
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null)
            {
                String[] splits = buffer.split(split);
                if (split.length() < 1 && splits[0].equals(shiftJIS)) string = splits[1] != null ? splits[1] : "";
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return string;
    }
}
