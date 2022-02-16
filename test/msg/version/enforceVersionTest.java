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
        System.out.println("\nenforceVersionTest.fire  [\n");
        msg.version.enforceVersion.fire();
        System.out.println(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>enforceVersionTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private enforceVersionTest () {}

}