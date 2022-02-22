package msg.resources.commands;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>ez</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0   */
final class ezTest {

    /** This tests the <strong>fire</strong> method in the <strong>ez</strong> class, but does not connect to a server.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void fireOffline () {
        i.line("\nezTest.fireOffline  [\n");

        String ze = ez.fire();
        i.line(i.gray + "Ez message: " + i.cyan + ze);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>fire</strong> method in the <strong>ez</strong> class, and connects to the server <code>gemvido/AlphaCS.msgeng</code>. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void fireOnline () {
        i.line("\nezTest.fireOnline  [\n");
        i.ServerAddress = "gemvido/AlphaCS.msgeng";
        String ze = ez.fire();
        i.line(i.gray + "Ez message: " + i.cyan + ze);
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>ezTest</strong> from being initialized. <p></p>
     * @author gemsvidø   */
    private ezTest () {}
}