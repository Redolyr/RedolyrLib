package RedolyrLibrary.DrawComponents;

import java.awt.*;

/**
 * Created by redolyr on 2014/12/03.
 */
public interface DrawPaintListener {
    public void paint(Graphics graphics, int mouseX, int mouseY, int mouseClicked);

    public Drawing drawing();
}
