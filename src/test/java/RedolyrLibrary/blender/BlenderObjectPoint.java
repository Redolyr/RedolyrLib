package RedolyrLibrary.blender;

/**
 * Created by redolyr on 2015/02/28.
 */
public class BlenderObjectPoint implements ObjectPointWriter, ObjectPointReader {

    private AxisAlignedBB axisAlignedBB = new AxisAlignedBB();
    private UVField uvField = new UVField();
    private BoxType boxType;
    private String objectName;

    public VertexReader getVertex() {
        return this.axisAlignedBB;
    }

    public TextureCoordReader getTextureCoord() {
        return this.uvField;
    }

    public BoxType getBoxType() {
        return this.boxType;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public void setVertex(VertexWriter vertexWriter) {
        this.axisAlignedBB = (AxisAlignedBB) vertexWriter;
    }

    public void setTextureCoord(TextureCoordWriter textureCoordWriter) {
        this.uvField = (UVField) textureCoordWriter;
    }

    public void setBoxType(BoxType boxType) {
        this.boxType = boxType;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
