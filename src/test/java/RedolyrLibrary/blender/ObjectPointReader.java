package RedolyrLibrary.blender;

/**
 * Created by redolyr on 2015/02/28.
 */
public interface ObjectPointReader {

    public VertexReader getVertex();

    public TextureCoordReader getTextureCoord();

    public BoxType getBoxType();

    public String getObjectName();
}
