package msg.version;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>enforceVersion</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
class enforceVersionTest {

    /** This tests the <strong>fire</strong> method in the <strong>enforceVersion</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void fire() {
        i.line("\nenforceVersionTest.fire  [\n");

        if (System.getenv("OFFLINE") != null && System.getenv("OFFLINE").equals("true")) {
            i.line(i.green + "enforceVersionTest.fire was not run, because OFFLINE=true.");
        } else {
            enforceVersion.fire();
        }

        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>enforceVersionTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private enforceVersionTest () {}

}