package msg.resources;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>ClipBored</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
class ClipBoredTest {

    /** This tests the <strong>copy</strong> method in the <strong>ClipBored</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void copy () {
        i.line("\nClipBoredTest.copy  [\n");
        String text = "Copied to clipboard (copy method)";
        ClipBored cb = new ClipBored();
        cb.Copy(text);
        i.line(i.gray + "ClipBored: " + i.cyan + cb.GetContents());
        i.line(i.white + "\n]");
    }

    /** This tests the <strong>get</strong> method in the <strong>ClipBored</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void get () {
        i.line("\nClipBoredTest.get  [\n");
        String text = "Copied to clipboard (get method)";
        ClipBored cb = new ClipBored();
        cb.Copy(text);
        i.line(i.gray + "ClipBored: " + i.cyan + cb.GetContents());
        i.line(i.white + "\n]");
    }

    /** This tests the <strong>print</strong> method in the <strong>ClipBored</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void print () {
        i.line("\nClipBoredTest.print  [\n");
        String text = "Copied to clipboard (print method)";
        ClipBored cb = new ClipBored();
        i.text(i.gray + "ClipBored: " + i.cyan);
        cb.Print();
        i.line(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>ClipBoredTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private ClipBoredTest () {}
}