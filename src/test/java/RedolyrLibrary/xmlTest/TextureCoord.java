package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TextureCoord extends Base {

    @XmlValue
    public int u;

    @XmlValue
    public int v;

    public TextureCoord(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public Class<? extends Base> getType() {
        return TextureCoord.class;
    }

    public byte getID() {
        return 1;
    }
}
