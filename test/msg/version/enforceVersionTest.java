package msg.version;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>enforceVersion</strong> class. */
class enforceVersionTest {

    /** This tests the <strong>fire</strong> method in the <strong>enforceVersion</strong> class. */
    @Test void fire() {
        System.out.println("\nenforceVersionTest.fire  [\n");
        msg.version.enforceVersion.fire();
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>enforceVersionTest</strong> from being initialized. */
    private enforceVersionTest () {}

}