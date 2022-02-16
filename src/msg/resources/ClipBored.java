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
 * @author gemsvidø
 *  @since 0.1.12 */
public @NotNull final class ClipBored {

    /** Copy a string to the clipboard.   <p></p>
     * @author gemsvidø
     * @since 0.1.12 */
    public void Copy (@NotNull String text) {

        StringSelection stringSelection = new StringSelection(text);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    /** Returns the clipboard contents as a string   <p></p>
     * @author gemsvidø
     * @since 0.1.12 */
    public @NotNull String GetContents () {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String result = "";

        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (IOException | UnsupportedFlavorException ignored) {}

        return result;
    }

    /** Print the clipboard contents   <p></p>
     * @author gemsvidø
     * @since 0.1.12 */
    public void Print () {
        i.text(GetContents());
    }

    /** Print the Clipboard contents onto a new line.   <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public void PrintLine() {
        i.line(GetContents());
    }

    /** Public constructor to initialize the ClipBored object   <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    public ClipBored () {}


}
