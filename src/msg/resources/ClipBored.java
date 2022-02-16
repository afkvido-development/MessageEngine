package msg.resources;

import msg.i;
import org.jetbrains.annotations.NotNull;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/** ClipBored is a class used for interacting with the clipboard (ex. Copy and Paste).
 * I found some of the code on the web idk, but this class is improved and put together by gemsvidø. <p></p>
 * @author gemsvidø */
public @NotNull final class ClipBored {

    void Copy (@NotNull String text) {

        StringSelection stringSelection = new StringSelection(text);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    @NotNull String GetContents () {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String result = "";

        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (IOException | UnsupportedFlavorException ignored) {}

        return result;
    }

    void Print () {
        i.text(GetContents());
    }

    void PrintLine () {
        i.line(GetContents());
    }

    public ClipBored () {}


}
