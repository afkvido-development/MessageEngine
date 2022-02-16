package msg.programs.interactive;

import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>login</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0*/
final class loginTest {

    /** This tests the <strong>login</strong> method in the <strong>login</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0*/
    @Test void login () {
        System.out.println("\nloginTest.login  [\n");
        // Test coming soon
        System.out.println(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>checkServerValidity</strong> method in the <strong>login</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void checkServerValidity () {
        System.out.println("\nloginTest.checkServerValidity  [\n");
        // Test coming soon
        System.out.println(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>setAccount</strong> method in the <strong>login</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void setAccount () {
        System.out.println("\nloginTest.setAccount  [\n");
        Account account = new Account("Account for setAccount", "AFSA password", rank.OWNER);
        login.setAccount(account);
        System.out.println(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>loginTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private loginTest () {}
}