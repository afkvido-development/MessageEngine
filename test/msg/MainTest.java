package msg;

import msg.modloader.ModLoader;
import msg.modloader.mods.developer_mod;
import msg.programs.PreLoader;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>main</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
class MainTest {

    /** This tests the <strong>main</strong> method in the <strong>main</strong> class,
     * using developer.LocalServer to run an offline server. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void mainLocalServer () {

        i.line("\nMainTest.mainLocalServer  [\n");


        if (System.getenv("OFFLINE") != null && System.getenv("OFFLINE").equals("true")) {
            i.line(i.green + "MainTest.mainLocalServer was not tested, because OFFLINE=true.");
        } else {

            // Required stuff
            PreLoader.PreLoading();
            Account aa = new Account("An Account", "AA password", rank.VIPPLUS1);
            login.setAccount(aa);

            // Local server
            developer_mod.localServer(4);

            // Welcome the user
            i.line(Main.loggedin.getColorCode() + "Welcome, " + Main.loggedin.getDisplayName()); // Welcomes user
            ModLoader.LoadMods(i.getToken(), 5);


            // Send some messages
            i.ProcessInput("Hello, my name is bob!");
            i.ProcessInput("How are you?");
            i.ProcessInput("i like your username");

            // Send some commands
            i.ProcessInput("/help"); // Help command (Fetched from server, 'help.txt')
            i.ProcessInput("/generatenewuuid"); // generatenewuuid command (Local, requires VIP)
            i.ProcessInput("/whfapijawfoh"); // A nonexistent command (Fetched from server, 'notfound.txt')

        }

        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>main</strong> method in the <strong>main</strong> class, using <code>gemvido/AlphaCS.msgeng</code> as the server. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void mainOnlineServer () {
        i.line("\nMainTest.mainOnlineServer  [\n");

        if (System.getenv("OFFLINE") != null && System.getenv("OFFLINE").equals("true")) {
            i.line(i.green + "MainTest.mainOnlineServer was not tested, because OFFLINE=true.");
        } else {



        // Required stuff
        PreLoader.PreLoading(false);
        Account aa = new Account("An Account", "AA password", rank.VIPPLUS1);
        login.setAccount(aa);

        // Connect to server
        i.ServerAddress = "gemvido/AlphaCS.msgeng";

        // Welcome the user
        i.line(Main.loggedin.getColorCode() + "Welcome, " + Main.loggedin.getDisplayName()); // Welcomes user
        ModLoader.LoadMods(i.getToken(), 5);




        // Send some messages
        i.ProcessInput("Hello, my name is bob!");
        i.ProcessInput("How are you?");
        i.ProcessInput("i like your username");

        // Just some spacing
        i.line();

        // Send some commands
        i.ProcessInput("/help"); // Help command (Fetched from server, 'help.txt')
        i.ProcessInput("/generatenewuuid"); // generatenewuuid command (Local, requires VIP)
        i.ProcessInput("/whfapijawfoh"); // A nonexistent command (Fetched from server, 'notfound.txt')

        }

        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>MainTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private MainTest () {}


}