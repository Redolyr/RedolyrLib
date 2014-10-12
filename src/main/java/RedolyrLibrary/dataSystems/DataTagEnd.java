package RedolyrLibrary.dataSystems;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by redolyr on 2014/10/07.
 */
public class DataTagEnd extends DataBase
{
    void write(DataOutput par1) throws IOException {}

    void read(DataInput par1) throws IOException {}

    public byte getId()
    {
        return 0;
    }

    public DataTagEnd copy()
    {
        return new DataTagEnd();
    }
}
