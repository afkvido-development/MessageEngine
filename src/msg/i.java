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


/** <strong>The</strong> utility class <p></p>
 * @author gemsvidø
 * @since 0.2.0 */
public @NotNull @Unmodifiable final class i {

    //---------------------------------------------------
    // Server Address

    /** Server Address, accounts and ez messages are fetched from here  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static volatile @Unmodifiable String ServerAddress;

    // Server Address
    //---------------------------------------------------
    //---------------------------------------------------
    // Clipboard

    /** Utility ClipBoard  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static final @NotNull @Unmodifiable ClipBored cb = new ClipBored();

    // Clipboard
    //---------------------------------------------------
    //---------------------------------------------------
    // Token/Security things

    /** Client Token   <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    private static final @Unmodifiable @NotNull String Token = UUID.randomUUID().toString();

    /** Get Client Token  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static @Unmodifiable @NotNull String getToken () {
        return Token;
    }

    // Token/Security things
    //---------------------------------------------------
    //---------------------------------------------------
    // Debug stuff

    /** Decides if the project is using debug mode or not. If it is, then debug lines will show.  <p></p>
     * @author gemsvidø
     * @since 0.1.1 */
    public static volatile @NotNull Boolean debugMode = true;

    /** Prints a debug line, only if debug mode is enabled.  <p></p>
     * @author gemsvidø
     * @since 0.1.1 */
    public static void debugLine (@Nullable String type, @NotNull String text) {

        if (i.debugMode) {

            if (type == null) {
                i.line(i.gray + "[Debug] " + text);
            } else if (type.equals("")) {
                i.line(i.gray + text);
            } else {
                i.line(i.gray + "[" + type + "] " + text);
            }

        }
    }


    // Debug stuff
    //---------------------------------------------------
    //---------------------------------------------------
    // Accounts

    /** Local Server is where messages are sent. This will be removed in v1.0, because we will have real, multiplayer servers.  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull Account localServer = new Account("localServer", UUID.randomUUID().toString(), rank.CHAT);

    // Accounts
    //---------------------------------------------------
    //---------------------------------------------------
    // Color Codes
    
    /** <strong>Reset</strong> color to <strong>default white</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String white = "\u001B[0m";


    /** Change color to <strong>Black</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String black = "\u001B[30m";


    /** Change color to <strong>Red</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String red = "\u001B[31m";


    /** Change color to <strong>Green</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String green = "\u001B[32m";


    /** Change color to <strong>Yellow</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String yellow = "\u001B[33m";


    /** Change color to <strong>Blue</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String blue = "\u001B[34m";


    /** Change color to <strong>Purple</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String purple = "\u001B[35m";


    /** Change color to <strong>Cyan</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String cyan = "\u001B[36m";


    /** Change color to <strong>Gray</strong>  <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public static final @Unmodifiable @NotNull String gray = "\u001B[37m";


    // Color codes
    //---------------------------------------------------
    //---------------------------------------------------
    // Info method

    /** Prints an info line  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void info (@NotNull String info) {
        System.out.print(i.gray + "[Info] " + info + i.white);
    }


    // Info method
    //---------------------------------------------------
    //---------------------------------------------------
    // Text method


    /** Just a better version of <code>System.out.print()</code> <br></br> For Strings only.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void text (@NotNull String text) {
        System.out.print(text + i.white);
    }

    /** Just a better version of <code>System.out.print()</code> <br></br> For all Objects only.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void text (@NotNull Object text) {
        System.out.print(text + i.white);
    }

    /** Just a better version of <code>System.out.print()</code> <br></br> Prints literally nothing, just resets the color.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void text ()  {
        System.out.print(i.white);
    }

    /** Just a better version of <code>System.out.print()</code> <br></br> For integers only.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void text (@NotNull Integer text) {
        System.out.print(text + i.white);
    }

    // Text method
    //---------------------------------------------------
    //---------------------------------------------------
    // Line method

    /** Just a better version of <code>System.out.println()</code> <br></br> For Strings only.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void line (@NotNull String text) {
        System.out.print(text + i.white + "\n");
    }

    /** Just a better version of <code>System.out.println()</code> <br></br> For all Objects only.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void line (@NotNull Object text) {
        System.out.print(text + i.white + "\n");
    }

    /** Just a better version of <code>System.out.println()</code> <br></br> Prints a blank line  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void line () {
        System.out.println();
    }

    /** Just a better version of <code>System.out.println()</code> <br></br> For integers only.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    public static void line (@NotNull Integer text) {
        System.out.println(text + i.white + "\n");
    }

    // Line method
    //---------------------------------------------------
    //---------------------------------------------------
    // Send a message

    /** Send a TextMessage, but do not trigger any mods. <p></p>
     * @author gemsvidø
     * @since 0.1.13 */
    public static void display (@NotNull TextMessage message) {
        i.debugLine("Info", "message()");
        line(message);
    }

    /** Send a TextMessage, and triggers all mods that trigger on message() <p></p>
     * @author gemsvidø
     * @since 0.1.10 */
    public static void message (@NotNull TextMessage message) {
        display(message);
        ModLoader.LoadMods(i.getToken(), 5);
    }

    // Send a message
    //---------------------------------------------------
    //---------------------------------------------------
    // Process input

    /** Process an input <p></p>
     * @author gemsvidø
     * @since 0.1.13 */
    public static void ProcessInput (@NotNull String Input) {

        TextMessage nextmsg;

        if (Input.startsWith("/")) {

            boolean serverCommand = false;

            switch (Input.toLowerCase()) {
                case "/logout" -> login.go();
                case "/exit" -> System.exit(0);
                case "/generatenewuuid" -> Commands.generateUUIDs(Main.loggedin);
                default -> serverCommand = true;
            }

            String print;

            if (serverCommand) {


                try {

                    print = URLreader.read("https://raw.githubusercontent.com/" + i.ServerAddress.replace(".msgeng", "") + "/main/src/Commands/" + Input.replace("/", "") + ".txt");

                } catch (Exception ignored) {

                        print = URLreader.check("https://raw.githubusercontent.com/" + i.ServerAddress.replace(".msgeng", "") + "/main/src/Commands/notfound.txt");

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
                case "cancel_messageL": i.debugLine("Info", "Cancelled message"); break;
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
