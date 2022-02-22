package msg.modloader.mods;

import msg.Main;
import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>macro</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
final class macroTest {

    /** This tests the <strong>tbh</strong> method in the <strong>macro</strong> class, with debug mode on.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void tbhYesDebug() {
        i.line("\nmacroTest.tbhYesDebug  [\n");
        Account afm = new Account("Author for macro", "AFM password", rank.VIP);
        Main.loggedin = afm;
        i.debugMode = true;
        macro.tbh(6);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>tbh</strong> method in the <strong>macro</strong> class, with debug mode off.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void tbhNoDebug() {
        i.line("\nmacroTest.tbhNoDebug  [\n");
        Account afm = new Account("Author for macro", "AFM password", rank.VIP);
        Main.loggedin = afm;
        i.debugMode = false;
        macro.tbh(6);
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>macroTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private macroTest () {}
}