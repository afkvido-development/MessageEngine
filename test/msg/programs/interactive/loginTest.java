package msg.programs.interactive;

import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.UrlReader;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>login</strong> class.  <p></p>
 * @author gemsvidø
 * @since 0.2.0*/
final class loginTest {

    /** This tests the <strong>login</strong> method in the <strong>login</strong> class as Default2 in gemvido/AlphaCS  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    @Test void login1 () {
        i.line("\nloginTest.login1  [\n");
        login.go_credentials("gemvido/AlphaCS", "Default2", "MAKE_A_SECURE_PASSWORD_AND_CLOSED_SRC_IDK_HOW");
        i.line(i.white + "\n]\n\n\n");
    }

    /** This tests the <strong>login</strong> method in the <strong>login</strong> class as Administrator in gemvido/AlphaCS  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    @Test void login2 () {
        i.line("\nloginTest.login2  [\n");
        login.go_credentials("gemvido/AlphaCS", "Administrator", "t");
        i.line(i.white + "\n]\n\n\n");
    }

    /** This tests the <strong>checkServerValidity</strong> method in the <strong>login</strong> class with the <code>gemvido/AlphaCS</code> server. <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    @Test void checkServerValidity1 () {
        i.line("\nloginTest.checkServerValidity1  [\n");
        i.line("\n" + i.cyan + "gemvido/AlphaCS" + i.white + " {");
        i.ServerAddress = "gemvido/AlphaCS";
        login.checkServerValidity();
        i.line(i.white + "}\n\n]\n\n\n");
    }

    /** This tests the <strong>checkServerValidity</strong> method in the <strong>login</strong> class with the <code>afkvido-development/MessageEngine-ServerTemplate</code> server. <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    @Test void checkServerValidity2 () {
        i.line("\nloginTest.checkServerValidity2  [\n");


        i.line(i.cyan + "afkvido-development/MessageEngine-ServerTemplate" + i.white + " {");
        i.ServerAddress = "afkvido-development/MessageEngine-ServerTemplate";
        login.checkServerValidity();

        i.line(i.white + "}\n\n]\n\n\n");
    }

    /** This tests the <strong>setAccount</strong> method in the <strong>login</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void setAccount () {
        i.line("\nloginTest.setAccount  [\n");
        Account account = new Account("Account for setAccount", "AFSA password", rank.OWNER);
        login.setAccount(account);
        i.ProcessInput("A Message");
        i.line(i.white + "\n]\n\n\n");
    }


    /** This tests the <strong>getAccount</strong> method in the <strong>login</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    @Test void getAccount () {
        i.line("\nloginTest.setAccount  [\n");

        i.ServerAddress = "gemvido/AlphaCS";
        String username = "Default2";
        String password = "MAKE_A_SECURE_PASSWORD_AND_CLOSED_SRC_IDK_HOW";



        // Read the account's info from the server
        String rank1 = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");

        // Split the account's info into separate lines
        String[] lines = rank1.split("\\n");

        // Clean the rank String and leave ONLY the pure rank
        String rank2 = lines[0].replace("rank: ", "");

        // Set the rank of the account that will be returned to the rank to the right rank
        rank rank3 = rank.valueOf(rank2.replace("\n", ""));

        // Return the generated account
        i.line(new Account(username, password, rank3));

        i.line(i.white + "\n]\n\n\n");
    }



    /** Private constructor prevents utility class <strong>loginTest</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private loginTest () {}
}