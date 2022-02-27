package msg;

import msg.modloader.ModLoader;
import msg.programs.PreLoader;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;


/** The main class. It all happens here. <p></p>
 * @author gemsvidø
 * @since 0.0.0 */
@SuppressWarnings("InfiniteLoopStatement") public final class Main {


    /** Account that is logged in. <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static Account loggedin;

    /** Input from Scanner, used to read sent messages and commands. <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    public volatile static String Input;

    /** The main method. It all happens here. <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    public static void main (@Nullable String[] args) {

        ModLoader.LoadMods(i.getToken(), 0);

        // PreLoader
        i.info("Starting PreLoader...");
        PreLoader.PreLoading();
        i.info("PreLoader finished.\n\n");


        // Login
        login.go();

        // Welcome the user
        i.line(loggedin.getColorCode() + "Welcome, " + loggedin.getDisplayName());

        // Load the mods that load after logging in
        ModLoader.LoadMods(i.getToken(), 4);

        // Receives user input using Scanner
        Scanner scan = new Scanner(System.in);


        // The loop, where you can chat and use commands.
        while (true) {

            // Saves user input to a public static String
            Input = scan.nextLine();

            // Process the user input (Send a message or run a command)
            i.ProcessInput(Input);
        }


    }

    /** Utility class <strong>Main</strong> cannot be initialized <p></p>
     @author gemsvidø */
    private Main () {}


}