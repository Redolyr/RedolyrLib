package RedolyrLibrary.arCardTest;

import java.io.Serializable;

/**
 * Created by redolyr on 2015/03/23.
 */
public interface Texture extends Serializable {

    public int getTextureMinU();

    public int getTextureMinV();

    public int getTextureMaxU();

    public int getTextureMaxV();

    public int getImageWidth();

    public int getImageHeight();

    public byte[] getImage();

    public String getFileType();

    public String getFileName();

    public int getImageType();
}
