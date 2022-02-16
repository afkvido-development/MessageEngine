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
        System.out.println("\nAccountTest.getPassword  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String pwd = account.getPassword();
        System.out.println(i.cyan + pwd);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>changepassword</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void changepassword() {
        System.out.println("\nAccountTest.changepassword  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        System.out.println(account + "\n");
        account.changePassword("Account Test Account", "ATA Password", "ATA Password CHANGED");
        System.out.println(account);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>changeusername</strong> method in the <strong>Account</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void changeusername() {
        System.out.println("\nAccountTest.changeusername  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        System.out.println(account + "\n");
        account.changeUsername("Account Test Account", "ATA Password", "Account Test Account CHANGED");
        System.out.println(account);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>getRank</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getRank () {
        System.out.println("\nAccountTest.getRank  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        rank rk = account.getRank();
        System.out.println(rk);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>getUsername</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getUsername () {
        System.out.println("\nAccountTest.getUsername  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String name = account.getUsername();
        System.out.println(name);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>getDisplayName</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getDisplayName () {
        System.out.println("\nAccountTest.getDisplayName  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String displayname = account.getDisplayName();
        System.out.println(displayname);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>toString</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void testToString () {
        System.out.println("\nAccountTest.testToString  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String string = account.toString();
        System.out.println(string);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>getColorCode</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void getColorCode () {
        System.out.println("\nAccountTest.getColorCode  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String color = account.getColorCode();
        System.out.println(color + "This text is the same color as the rank.");
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>createConnectionToken</strong> method in the <strong>Account</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void createConnectionToken () {
        System.out.println("\nAccountTest.createConnectionToken  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        account.createConnectionToken();
        String token = account.requestConnectionToken();
        System.out.println(i.cyan + token);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>requestConnectionToken</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void requestConnectionToken() {
        System.out.println("\nAccountTest.requestConnectionToken  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        String token = account.requestConnectionToken();
        System.out.println(i.cyan + token);
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>resetConnectionToken</strong> method in the <strong>Account</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void resetConnectionToken() {
        System.out.println("\nAccountTest.resetConnectionToken  [\n");
        Account account = new Account("Account Test Account", "ATA Password", rank.MODERATOR);
        account.resetConnectionToken();
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>AccountTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private AccountTest () {}
}