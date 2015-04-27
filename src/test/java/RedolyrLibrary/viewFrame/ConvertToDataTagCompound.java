package RedolyrLibrary.viewFrame;

import RedolyrLibrary.dataSystems.DataTagCompound;

/**
 * Created by redolyr on 2015/02/09.
 */
public class ConvertToDataTagCompound {

    private DataTagCompound dataTagCompound = new DataTagCompound();

    public void convertFromDisplay(final int displayID) {
        Display display = Displays.getDisplay(displayID);
        String title = display.getTitle();
        int width = display.getWidth();
        int height = display.getHeight();
        byte[] texture = display.getIcon().getTexture();

        DataTagCompound dataTagCompound = new DataTagCompound();
        dataTagCompound.setString("title", title);
        dataTagCompound.setIntegerArray("size", new int[] {width, height});
        dataTagCompound.setByteArray("texture", texture);
    }
}
