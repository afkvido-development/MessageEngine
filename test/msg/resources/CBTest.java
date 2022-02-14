package msg.resources;

import org.junit.jupiter.api.Test;
import msg.i;

/** All tests for the <strong>CB</strong> class. */
class CBTest {

    /** This tests the <strong>copy</strong> method in the <strong>CB</strong> class. */
    @Test void copy () {
        System.out.println("\nCBTest.copy  [\n");
        String text = "Copied to clipboard (copy method)";
        CB.Copy(text);
        System.out.println(i.gray + "Text has been copied to your clipboard: " + i.cyan + text);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>get</strong> method in the <strong>CB</strong> class. */
    @Test void get () {
        System.out.println("\nCBTest.get  [\n");
        // Test coming soon
        // String e = CB.get();
        // System.out.println(e);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>print</strong> method in the <strong>CB</strong> class. */
    @Test void print () {
        System.out.println("\nCBTest.print  [\n");
        // Test coming soon
        // CB.Copy("Copied to clipboard (print method)");
        // CB.Print();
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>CBTest</strong> from being initialized. */
    private CBTest () {}
}