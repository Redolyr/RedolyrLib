package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Color extends Base {

    @XmlValue
    public int red;

    @XmlValue
    public int green;

    @XmlValue
    public int blue;

    @XmlValue
    public int alpha;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(int red, int green, int blue, int alpha) {
        this(red, green, blue);
        this.alpha = alpha;
    }

    public Class<? extends Base> getType() {
        return Color.class;
    }

    public byte getID() {
        return 2;
    }
}
