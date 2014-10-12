/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RedolyrLibrary;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Clipboards implements ClipboardOwner
{
    public void lostOwnership(Clipboard clipboard, Transferable contents) {}
    
    public void setClipboardContents(String string)
    {
        StringSelection stringSelection = new StringSelection(string);
        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        board.setContents(stringSelection, this);
    }
    
    public String getClipboardContents()
    {
        String result = "";
        Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = board.getContents(null);
        boolean hasContents = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasContents)
        {
            try
            {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            }
            catch (UnsupportedFlavorException exception)
            {
                exception.printStackTrace();
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        }
        return result;
    }
}
