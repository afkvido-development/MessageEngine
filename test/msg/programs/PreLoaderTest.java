package msg.programs;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>PreLoader</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
final class PreLoaderTest {

    /** This tests the <strong>getToken</strong> method in the <strong>PreLoader</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0*/
    @Test void getToken () {
        System.out.println("\nPreLoaderTest.getToken  [\n");
        String token = i.getToken();
        System.out.println(i.cyan + token);
        System.out.println(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>preLoading</strong> method in the <strong>PreLoader</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void preLoadingNormal () {
        System.out.println("\nPreLoaderTest.preLoadingNormal  [\n");
        PreLoader.PreLoading(false);
        System.out.println(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>preLoading</strong> method in the <strong>PreLoader</strong> class, it runs PreLoader twice without <code>force</code> being true. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void preLoadingDoubleNoForce () {
        System.out.println("\nPreLoaderTest.preLoadingDoubleNoForce  [\n");
        PreLoader.PreLoading(false);
        PreLoader.PreLoading(false);
        System.out.println(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>PreLoaderTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private PreLoaderTest () {}

}