package msg;

import msg.modloader.ModLoader;
import msg.programs.interactive.login;
import msg.resources.ClipBored;
import msg.resources.account.Account;
import msg.resources.commands.Commands;
import msg.resources.message.TextMessage;
import msg.resources.rank;
import msg.version.URLreader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;
import java.util.UUID;


/** <strong>The new database</strong>, also a utility class! <p></p>
 * @author gemsvidø */
public @NotNull @Unmodifiable final class i {

    //---------------------------------------------------
    // Clipboard

    public static final ClipBored cb = new ClipBored();

    // Clipboard
    //---------------------------------------------------
    //---------------------------------------------------
    // Token/Security things

    /** Client Token */
    private static final @Unmodifiable @NotNull String Token = UUID.randomUUID().toString();

    /** Get Client Token */
    public static @Unmodifiable @NotNull String getToken () {
        return Token;
    }

    // Token/Security things
    //---------------------------------------------------
    //---------------------------------------------------
    // Debug stuff

    /** Decides if the project is using debug mode or not. If it is, then debug lines will show. */
    public static volatile @NotNull Boolean debugMode = true;

    /** Prints a debug line, only if debug mode is enabled. */
    public static void debugLine (@Nullable String type, @NotNull String text) {

        if (i.debugMode) {

            if (type == null) {
                i.line(i.gray + "[Debug] " + text + i.white);
            } else if (type.equals("")) {
                i.line(i.gray + text + i.white);
            } else {
                i.line(i.gray + "[" + type + "] " + text + i.white);
            }

        }
    }


    // Debug stuff
    //---------------------------------------------------
    //---------------------------------------------------
    // Accounts

    /** Local Server is where messages are sent. This will be removed in v1.0, because we will have real, multiplayer servers. */
    public static final @Unmodifiable @NotNull Account localServer = new Account("localServer", UUID.randomUUID().toString(), rank.CHAT);

    // Accounts
    //---------------------------------------------------
    //---------------------------------------------------
    // Color Codes
    
    /** <strong>Reset</strong> color to <strong>default white</strong> */
    public static final @Unmodifiable @NotNull String white = "\u001B[0m";


    /** Change color to <strong>Black</strong> */
    public static final @Unmodifiable @NotNull String black = "\u001B[30m";


    /** Change color to <strong>Red</strong> */
    public static final @Unmodifiable @NotNull String red = "\u001B[31m";


    /** Change color to <strong>Green</strong> */
    public static final @Unmodifiable @NotNull String green = "\u001B[32m";


    /** Change color to <strong>Yellow</strong> */
    public static final @Unmodifiable @NotNull String yellow = "\u001B[33m";


    /** Change color to <strong>Blue</strong> */
    public static final @Unmodifiable @NotNull String blue = "\u001B[34m";


    /** Change color to <strong>Purple</strong> */
    public static final @Unmodifiable @NotNull String purple = "\u001B[35m";


    /** Change color to <strong>Cyan</strong> */
    public static final @Unmodifiable @NotNull String cyan = "\u001B[36m";


    /** Change color to <strong>Gray</strong> */
    public static final @Unmodifiable @NotNull String gray = "\u001B[37m";


    // Color codes
    //---------------------------------------------------
    //---------------------------------------------------
    // Info method

    public static void info (@NotNull String info) {
        System.out.print(i.gray + "[Info] " + info + i.white);
    }


    // Info method
    //---------------------------------------------------
    //---------------------------------------------------
    // Text method


    /** Just a better version of <code>System.out.print()</code> <br></br> For Strings only. */
    public static void text (@NotNull String text) {
        System.out.print(text + i.white);
    }

    /** Just a better version of <code>System.out.print()</code> <br></br> For all Objects only. */
    public static void text (@NotNull Object text) {
        System.out.print(text + i.white);
    }

    /** Just a better version of <code>System.out.print()</code> <br></br> Prints literally nothing, just resets the color. */
    public static void text ()  {
        System.out.print(i.white);
    }

    /** Just a better version of <code>System.out.print()</code> <br></br> For integers only. */
    public static void text (@NotNull Integer text) {
        System.out.print(text + i.white);
    }

    // Text method
    //---------------------------------------------------
    //---------------------------------------------------
    // Line method

    /** Just a better version of <code>System.out.println()</code> <br></br> For Strings only. */
    public static void line (@NotNull String text) {
        System.out.print(text + i.white + "\n");
    }

    /** Just a better version of <code>System.out.println()</code> <br></br> For all Objects only. */
    public static void line (@NotNull Object text) {
        System.out.print(text + i.white + "\n");
    }

    /** Just a better version of <code>System.out.println()</code> <br></br> Prints a blank line */
    public static void line () {
        System.out.println();
    }

    /** Just a better version of <code>System.out.println()</code> <br></br> For integers only. */
    public static void line (@NotNull Integer text) {
        System.out.println(text + i.white + "\n");
    }

    // Line method
    //---------------------------------------------------
    //---------------------------------------------------
    // Send a message

    /** Send a TextMessage, but do not trigger any mods */
    public static void display (@NotNull TextMessage message) {
        i.debugLine("Info", "message()");
        line(message);
    }

    /** Send a TextMessage, and triggers all mods that trigger on message() */
    public static void message (@NotNull TextMessage message) {
        display(message);
        ModLoader.LoadMods(i.getToken(), 5);
    }

    // Send a message
    //---------------------------------------------------
    //---------------------------------------------------
    // Process input

    /** Process an input */
    static void ProcessInput (@NotNull String Input) {

        TextMessage nextmsg;

        if (Input.startsWith("/")) {

            boolean serverCommand = false;

            switch (Input.toLowerCase()) {
                case "/logout" -> login.go();
                case "/generatenewuuid" -> Commands.generateUUIDs(Main.loggedin);
                default -> serverCommand = true;
            }

            String print;

            if (serverCommand) {


                try {

                    print = URLreader.check("https://raw.githubusercontent.com/" + login.server_address.replace(".msgeng", "") + "/main/src/Commands/" + Input.replace("/", "") + ".txt");

                } catch (Exception ignored) {

                    try {
                        print = URLreader.check("https://raw.githubusercontent.com/" + login.server_address.replace(".msgeng", "") + "/main/src/Commands/notfound.txt");
                    } catch (Exception ignore) {
                        print = i.red + "Failed to fetch.";
                    }

                }


                i.line(print);
            }

            ModLoader.LoadMods(i.getToken(), 7);


        } else {

            switch (Input) {
                case "ez":
                    i.debugLine("Info", "\"ez\" was sent.");
                    String z = Commands.ez();
                    nextmsg = new TextMessage(Main.loggedin, z, i.localServer);
                    i.message(nextmsg);
                    break;
                case "cancel_messageL": i.debugLine("Info", "Cancelled message [702]"); break;
                case "": break;
                default:
                    nextmsg = new TextMessage(Main.loggedin, Input, i.localServer);
                    i.message(nextmsg);

            }

        }
    }

    // Process input
    //---------------------------------------------------

}
