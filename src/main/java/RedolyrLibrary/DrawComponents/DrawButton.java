package RedolyrLibrary.DrawComponents;
import java.awt.Button;

public class DrawButton extends Button
{
    private final int id;
    public DrawButton(String drawing, int id, int x, int y, int width, int height)
    {
        super(drawing);
        this.id = id;
        this.setSize(width, height);
        this.setLocation(x, y);
        System.out.println(getSize() + ", " + getLocation() + ", " + getBackground() + ", " + getBounds() + ", " + getId() + ", " + getLabel());
    }
    public int getId()
    {
        return id;
    }
    public String toString()
    {
    	return String.format("%s[%s,%s,%s,%sx%s,%s,label=%s,id=%s]", getClass().getSimpleName(), getName(), getX(), getY(), getWidth(), getHeight(), isValid() ? "outvalid" : "invalid", getLabel(), getId());
    }
}
