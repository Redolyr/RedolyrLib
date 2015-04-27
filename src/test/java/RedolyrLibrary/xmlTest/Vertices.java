package RedolyrLibrary.xmlTest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by redolyr on 2015/03/30.
 */
@XmlRootElement(name = "Vertices")
public class Vertices {

    @XmlElements({@XmlElement(name = "vertex", type = Vertex.class), @XmlElement(name = "texCoord", type = TextureCoord.class), @XmlElement(name = "color", type = Color.class), @XmlElement(name = "brightness", type = Brightness.class), @XmlElement(name = "normal", type = Normal.class), @XmlElement(name = "bindTexture", type = ResourceLocation.class)})
    public List<Base> bases = new ArrayList<Base>();

    public String toString() {
        return String.valueOf(this.bases);
    }
}
