package msg.resources.account;

import msg.i;
import msg.resources.rank;
import org.junit.jupiter.api.Test;


/** All tests for the <strong>Account</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
final class AccountTest {

    /** This tests the <strong>getPassword</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getPassword() {
        i.line("\nAccountTest.getPassword  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String pwd = account.getPassword();
        i.line(i.cyan + pwd);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>changepassword</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void changepassword() {
        i.line("\nAccountTest.changepassword  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        i.line(account + "\n");
        account.changePassword("Account Test Account", "ATA Password", "ATA Password CHANGED");
        i.line(account);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>changeusername</strong> method in the <strong>Account</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void changeusername() {
        i.line("\nAccountTest.changeusername  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        i.line(account + "\n");
        account.changeUsername("Account Test Account", "ATA Password", "Account Test Account CHANGED");
        i.line(account);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>getRank</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getRank () {
        i.line("\nAccountTest.getRank  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        rank rk = account.getRank();
        i.line(rk);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>getUsername</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getUsername () {
        i.line("\nAccountTest.getUsername  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String name = account.getUsername();
        i.line(name);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>getDisplayName</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getDisplayName () {
        i.line("\nAccountTest.getDisplayName  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String displayname = account.getDisplayName();
        i.line(displayname);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>toString</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void testToString () {
        i.line("\nAccountTest.testToString  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String string = account.toString();
        i.line(string);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>getColorCode</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getColorCode () {
        i.line("\nAccountTest.getColorCode  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String color = account.getColorCode();
        i.line(color + "This text is the same color as the rank.");
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>createConnectionToken</strong> method in the <strong>Account</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void createConnectionToken () {
        i.line("\nAccountTest.createConnectionToken  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        account.createConnectionToken();
        String token = account.requestConnectionToken();
        i.line(i.cyan + token);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>requestConnectionToken</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void requestConnectionToken() {
        i.line("\nAccountTest.requestConnectionToken  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String token = account.requestConnectionToken();
        i.line(i.cyan + token);
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>resetConnectionToken</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void resetConnectionToken() {
        i.line("\nAccountTest.resetConnectionToken  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        account.resetConnectionToken();
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>AccountTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private AccountTest () {}
}