package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Vertex extends Base {

    @XmlValue
    public int x;

    @XmlValue
    public int y;

    @XmlValue
    public int z;

    public Vertex(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Class<? extends Base> getType() {
        return Vertex.class;
    }

    public byte getID() {
        return 0;
    }
}
