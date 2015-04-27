package RedolyrLibrary.arCardTest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;
import java.util.Arrays;

/**
 * Created by redolyr on 2015/03/21.
 */
public class DrawComponent implements Serializable {

    private static final long serialVersionUID = 4836999227084380591L;

    private Vertices[] verticeses = null;
    private int vertices;

    private ISound iSound = null;

    private Texture texture;

    public DrawComponent addVertices(Vertices vertices) {
        if (vertices != null) {
            if (this.verticeses == null) this.verticeses = new Vertices[1];
            else this.verticeses = Arrays.copyOf(this.verticeses, this.vertices + 1);
            this.verticeses[this.vertices] = vertices;
            this.verticeses[this.vertices].setDrawComponent(this);
            ++this.vertices;
        }
        return this;
    }

    public DrawComponent setSound(ISound iSound) {
        if (iSound != null) {
            this.iSound = iSound;
        }
        return this;
    }

    public DrawComponent setTexture(Texture texture) {
        if (texture != null) {
            this.texture = texture;
        }
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrawComponent)) return false;

        DrawComponent that = (DrawComponent) o;

        if (this.vertices != that.vertices) return false;
        if (this.iSound != that.iSound) return false;
        if (this.texture != that.texture) return false;
        if (!Arrays.equals(this.verticeses, that.verticeses)) return false;

        return true;
    }

    public int hashCode() {
        int result = this.verticeses != null ? Arrays.hashCode(this.verticeses) : 0;
        result = 31 * result + this.vertices;
        result = 31 * result + this.iSound.hashCode();
        result = 31 * result + this.texture.hashCode();
        return result;
    }

    public DrawComponent copy() {
        DrawComponent drawComponent = new DrawComponent();
        drawComponent.verticeses = this.verticeses;
        drawComponent.vertices= this.vertices;
        drawComponent.iSound = this.iSound;
        drawComponent.texture = this.texture;
        return drawComponent;
    }

    public String encode(DrawComponent drawComponent) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(drawComponent);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return Base64.encode(bytes);
    }

    public DrawComponent decode(String encode) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(encode));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (DrawComponent) objectInputStream.readObject();
    }

    public String toString() {
        String verticeses = "";
        for (int len = 0; len < this.vertices; ++len) {
            verticeses += String.format("'verticeses%d': %s, ", len, this.verticeses[len]);
        }
        return String.format("{'drawComponent': {%s'iSound': %s, 'texture': %s}}", verticeses, this.iSound, this.texture).replace('\'', '"');
    }
}
