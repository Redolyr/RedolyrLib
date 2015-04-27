package RedolyrLibrary.blender;

/**
 * Created by redolyr on 2015/02/28.
 */
public interface ObjectPointWriter {

    public void setVertex(VertexWriter vertexWriter);

    public void setTextureCoord(TextureCoordWriter textureCoordWriter);

    public void setBoxType(BoxType boxType);

    public void setObjectName(String objectName);
}
