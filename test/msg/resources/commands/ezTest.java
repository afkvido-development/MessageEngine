package msg.resources.commands;

import msg.programs.interactive.login;
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
        System.out.println("\nezTest.fireOffline  [\n");

        String ze = ez.fire();
        System.out.println(i.gray + "Ez message: " + i.cyan + ze);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>fire</strong> method in the <strong>ez</strong> class, and connects to the server <code>gemvido/AlphaCS.msgeng</code>. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void fireOnline () {
        System.out.println("\nezTest.fireOnline  [\n");
        login.server_address = "gemvido/AlphaCS.msgeng";
        String ze = ez.fire();
        System.out.println(i.gray + "Ez message: " + i.cyan + ze);
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>ezTest</strong> from being initialized. <p></p>
     * @author gemsvidø   */
    private ezTest () {}
}