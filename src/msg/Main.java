package msg;

import msg.modloader.ModLoader;
import msg.programs.PreLoader;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;


/** The main class. It all happens here. <p></p>
 * @author gemsvidø */
@SuppressWarnings("InfiniteLoopStatement") public final class Main {


    /** Account that is logged in. */
    public static Account loggedin;

    /** Input from Scanner, used to read sent messages and commands */
    public volatile static String Input;

    /** The main method. It all happens here. */
    public static void main (@Nullable String[] args) {



        // PRE-LOADING

        i.info("Starting PreLoader...");
        PreLoader.PreLoading(false);
        i.info("PreLoader finished.");


        // SETUP

        login.go();
        i.line(loggedin.getColorCode() + "Welcome, " + loggedin.getDisplayName()); // Welcomes user
        ModLoader.LoadMods(i.getToken(), 5);

        // Create all local variables


        // Starts the loop, where you can chat and use commands
        while (true) {
            Scanner scan = new Scanner(System.in); // Receives user input
            Input = scan.nextLine(); // Saves user input
            i.ProcessInput(Input);
        }
    }

    /** Utility class <strong>Main</strong> cannot be initialized*/
    private Main () {}


}