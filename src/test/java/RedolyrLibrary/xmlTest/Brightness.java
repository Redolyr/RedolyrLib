package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Brightness extends Base {

    @XmlValue
    public int brightness;

    public Brightness(int brightness) {
        this.brightness = brightness;
    }

    public Class<? extends Base> getType() {
        return Brightness.class;
    }

    public byte getID() {
        return 3;
    }
}
