package msg.modloader.mods;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>testMod</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
final class testModTest {

    /** This tests the <strong>previewMessage</strong> method in the <strong>testMod</strong> class, with debug mode off. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void previewMessageNoDebug () {
        i.line("\ntestModTest.previewMessageNoDebug  [\n");
        i.debugMode = false;
        testMod.previewMessage(4);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>previewMessage</strong> method in the <strong>testMod</strong> class, with debug mode on. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void previewMessageYesDebug () {
        i.line("\ntestModTest.previewMessageNoDebug  [\n");
        i.debugMode = true;
        testMod.previewMessage(4);
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>testModTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private testModTest () {}
}