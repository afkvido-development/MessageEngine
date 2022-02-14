package msg.resources;

import msg.i;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public @NotNull interface CB {

    static void Copy (@NotNull String text) {

        StringSelection stringSelection = new StringSelection(text);
        java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    static @NotNull String get () {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String result = "";

        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (IOException | UnsupportedFlavorException ignored) {}

        return result;
    }

    static void Print () {
        i.line(get());
    }


}
