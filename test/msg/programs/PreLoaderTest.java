package msg.programs;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>PreLoader</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
final class PreLoaderTest {

    /** This tests the <strong>preLoading</strong> method in the <strong>PreLoader</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void preLoadingNormal () {
        i.line("\nPreLoaderTest.preLoadingNormal  [\n");

        if (System.getenv("OFFLINE").equals("true")) {
            i.line(i.green + "PreLoaderTest.preLoadingNormal was not tested, because OFFLINE=true.");
        } else {
            PreLoader.PreLoading();
        }

        i.line(i.white + "\n]\n\n\n");
    }

    /** This tests the <strong>preLoading</strong> method in the <strong>PreLoader</strong> class, it runs PreLoader twice without <code>force</code> being true. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void preLoadingDoubleNoForce () {
        i.line("\nPreLoaderTest.preLoadingDoubleNoForce  [\n");

        if (System.getenv("OFFLINE").equals("true")) {
            i.line(i.green + "PreLoaderTest.preLoadingDoubleNoForce was not tested, because OFFLINE=true.");
        } else {

            PreLoader.PreLoading(false);
            PreLoader.PreLoading(false);
        }

        i.line(i.white + "\n]\n\n\n");
    }

    /** Private constructor prevents utility class <strong>PreLoaderTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private PreLoaderTest () {}

}