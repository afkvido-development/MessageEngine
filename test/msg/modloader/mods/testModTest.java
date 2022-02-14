package msg.modloader.mods;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>testMod</strong> class. */
final class testModTest {

    /** This tests the <strong>previewMessage</strong> method in the <strong>testMod</strong> class, with debug mode off. */
    @Test void previewMessageNoDebug () {
        System.out.println("\ntestModTest.previewMessageNoDebug  [\n");
        i.debugMode = false;
        testMod.previewMessage(4);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>previewMessage</strong> method in the <strong>testMod</strong> class, with debug mode on. */
    @Test void previewMessageYesDebug () {
        System.out.println("\ntestModTest.previewMessageNoDebug  [\n");
        i.debugMode = true;
        testMod.previewMessage(4);
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>testModTest</strong> from being initialized. */
    private testModTest () {}
}