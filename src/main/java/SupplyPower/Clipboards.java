package SupplyPower;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * Created by redolyr on 2016/08/10.
 */
public class Clipboards implements ClipboardOwner {

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }

    public void setClipboardContents(String string) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), this);
    }

    public String getClipboardContents() {
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if ((contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                return (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
