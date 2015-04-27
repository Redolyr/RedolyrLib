package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Normal extends Base {

    @XmlValue
    public int red;

    @XmlValue
    public int green;

    @XmlValue
    public int blue;

    public Normal(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Class<? extends Base> getType() {
        return Normal.class;
    }

    public byte getID() {
        return 4;
    }
}
