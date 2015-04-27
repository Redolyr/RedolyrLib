package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceLocation extends Base {

    @XmlValue
    public String domain;

    @XmlValue
    public String source;

    public ResourceLocation(String domain, String source) {
        this.domain = domain;
        this.source = source;
    }

    public Class<? extends Base> getType() {
        return ResourceLocation.class;
    }

    public byte getID() {
        return 5;
    }
}
