package msg.resources.commands;

import msg.Main;
import msg.resources.account.Account;
import msg.i;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>Commands</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
final class CommandsTest {


    /** This tests the <strong>fire</strong> method in the <strong>Commands</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void fire () {
        i.line("\nCommandsTest.fire  [\n");
        Account account = new Account("Account for Commands", "AFC password", rank.ADMINISTRATOR);
        Main.loggedin = account;
        Commands.fire(CommandsTypes.help);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>changePassword_SC</strong> method in the <strong>Commands</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void changePassword_SC () {
        i.line("\nCommandsTest.changePassword_SC  [\n");
        // Test coming soon.
        // Commands.changePassword_SC();
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>generateUUIDs</strong> method in the <strong>Commands</strong> class, and the account has VIP. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void generateUUIDsYesVIP () {
        i.line("\nCommandsTest.generateUUIDsYesVIP  [\n");
        Account account = new Account("Account for Commands", "AFC password", rank.VIP);
        Commands.generateUUIDs(account);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>generateUUIDs</strong> method in the <strong>Commands</strong> class, but the account does not have VIP.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void generateUUIDsNoVIP () {
        i.line("\nCommandsTest.generateUUIDsNoVIP  [\n");
        Account account = new Account("Account for Commands", "AFC password", rank.DEFAULT);
        Commands.generateUUIDs(account);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>changePasswordSuccess</strong> method in the <strong>Commands</strong> class, and the process is successful.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void changePasswordSuccess () {
        i.line("\nCommandsTest.changePasswordSuccess  [\n");
        Main.loggedin = new Account("Password testing Account", "Password", rank.VIP);
        i.line(i.white + "Password of loggedin: " + i.cyan + Main.loggedin.getPassword() + i.white);
        Commands.changePassword("Password testing Account", "Password", "NewPassword", "NewPassword");
        i.line(i.white + "Password of loggedin: " + i.cyan + Main.loggedin.getPassword() + i.white);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>changePasswordSuccess</strong> method in the <strong>Commands</strong> class, and the process is unsuccessful, because the old password is identical to the new password. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void changePasswordFail1 () {
        i.line("\nCommandsTest.changePasswordFail1  [\n");
        Main.loggedin = new Account("Password testing Account", "Password", rank.VIP);
        i.line(i.white + "Password of loggedin: " + i.cyan + Main.loggedin.getPassword() + i.white);
        Commands.changePassword("Password testing Account", "Password", "Password", "Password");
        i.line(i.white + "Password of loggedin: " + i.cyan + Main.loggedin.getPassword() + i.white);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>changePasswordSuccess</strong> method in the <strong>Commands</strong> class,
     * and the process is unsuccessful, because the new password doesn't match the confirm new password. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void changePasswordFail2 () {
        i.line("\nCommandsTest.changePasswordFail2  [\n");
        Main.loggedin = new Account("Password testing Account", "Password", rank.VIP);
        i.line(i.white + "Password of loggedin: " + i.cyan + Main.loggedin.getPassword() + i.white);
        Commands.changePassword("Password testing Account", "Password", "NewPassword", "NotNewPassword");
        i.line(i.white + "Password of loggedin: " + i.cyan + Main.loggedin.getPassword() + i.white);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>ez</strong> method in the <strong>Commands</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void ez () {
        i.line("\nCommandsTest.ez  [\n");
        String ze = Commands.ez();
        i.line(i.gray + "Ez message: " + i.cyan + ze);
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>CommandsTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private CommandsTest () {}

}