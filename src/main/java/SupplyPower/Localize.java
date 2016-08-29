package SupplyPower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class Localize {

    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @param shiftJIS before split string
     * @param split    example ':' or '='
     * @return after split string
     */
    public String getUTF8(String shiftJIS, String split) {
        if (this.file == null || this.file.isFile() == false) return shiftJIS;
        String string = shiftJIS;

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file));
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                String[] splits = buffer.split(split);
                if (split.length() > 1 && splits[0].equals(shiftJIS)) string = (splits[1] != null || splits[1] != "") ? splits[1] : "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string;
    }
}
