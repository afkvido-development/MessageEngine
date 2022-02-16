package msg.modloader.mods;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>developer</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
final class developerTest {

    /** This tests the <strong>bypassVersion</strong> method in the <strong>developer</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void bypassVersion () {
        System.out.println("\ndeveloperTest.bypassVersion  [\n");
        developer.bypassVersion(3);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>localServer</strong> method in the <strong>developer</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void localServer () {
        System.out.println("\ndeveloperTest.localServer  [\n");
        developer.localServer(4);
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>developerTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private developerTest () {}
}