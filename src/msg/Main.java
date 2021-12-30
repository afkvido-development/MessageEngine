// Base Package
package msg;

// Import all necessary files

import msg.account.Account;
import msg.commands.Commands;
import msg.logging.commandLog;
import msg.logging.messageLog;
import msg.message.TextMessage;
import msg.programs.PreLoader;
import msg.resocurces.c;
import msg.resocurces.database;
import msg.resocurces.rank;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.UUID;

@SuppressWarnings("InfiniteLoopStatement") // Temporary solution to while true
public class Main {

    // Create all static variables

    public static Account loggedin; // Account that is logged in
    public static messageLog n_log = new messageLog("The Message log i guess"); //Create Message log
    public static commandLog c_log = new commandLog("The Command log I guess"); // Create command log
    public static String mode; // Decides on how to run the program (debug, main, etc.)
    public static Boolean debug_mode1; // Debug boolean (true = debug mode)
    static Boolean info_found_username; // For login and other account finding purposes
    public static String sc2;


    public static void main(String[] args) {


        // PRE-LOADING

        line(c.wh + "[Info] Starting PreLoader...");
        PreLoader.PreLoading(false);
        line(c.wh + "[Info] PreLoader finished.");


        // Create all local variables

        boolean blacklist; // Creates blacklist variable, used for chat filter
        loggedin = database.empty; // Presets the account to prevent crashes.
        TextMessage nextmsg; // Creates variable for the next message you send
        TextMessage systemmsg; // Creates variable for system messages (sent to loggedin)


        login(); // Opens login interface
        line(loggedin.getColorCode() + "Welcome, " + loggedin.getDisplayName()); // Welcomes user

        // Starts the loop, where you can chat and use commands
        while (true) {

            blacklist = false; // Resets message blacklist status (For chat filter)


            Scanner sc1 = new Scanner(System.in); // Receives user input
            sc2 = sc1.nextLine(); // Saves user input



            // Info command

            if (sc2.startsWith("/info")) {

                if (sc2.equals("/info") || sc2.equals("/info " + loggedin.getUsername()) || sc2.equals("/info ")) {
                    line(loggedin.toString());
                    sc2 = "cancel_messageL";

                } else {

                    // If sufficient permissions
                    if (loggedin.getRank() == rank.ADMINISTRATOR|| loggedin.getRank() == rank.OWNER) {

                        info_found_username = false;

                        for (int i = 0; i < database.accounts.size(); i++) {
                            if (database.accounts.get(i).getUsername().equals(sc2.replaceAll("/info ", ""))) {
                                debugLine("Info", "Username matches (i = " + i + ")");
                                line(database.accounts.get(i).toString());
                                sc2 = "cancel_messageL";
                                info_found_username = true;
                                break;


                            }

                            debugLine("Info", "Username didn't match (i = " + i + ")");
                        }

                        if (!info_found_username) {
                            line(c.yw + "Account not found");
                        }


                            } else { // Insufficient Permissions
                        line("Insufficient Permissions. Use /info to get your own info, you need Admin or above to see other's info.");
                        sc2 = "cancel_messageL";
                    }



                }


            }




            for (int i = 0; i < database.messageblacklist.size(); i++) {
                if (sc2.contains(database.messageblacklist.get(i))) {
                    blacklist = true;
                    break;
                }
            }


            if (sc2.startsWith("/")) {





                switch (sc2.toLowerCase()) {
                    case "/databasereload":
                        Commands.databaseunload(loggedin.getRank());
                        break;
                    case "/databaseunload":
                        Commands.databaseunload(loggedin.getRank());
                        break;
                    case "/databaseload":
                        Commands.databaseload(loggedin.getRank());
                        break;
                    case "/logout":
                    case "/login":
                        debugLine("Info", "/login");
                        logout();
                        login();
                        c_log.logcmd(sc2, loggedin);
                        break;
                    case "/changepwd":
                    case "/changepassword":
                        Commands.changePassword_SC();
                        break;
                    case "/help":
                        Commands.help(loggedin);
                        break;
                    case "/logaccess messagelog":
                        debugLine("Info", "successfully accessed message log");
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER || loggedin.getRank() == rank.MODERATOR) {
                            line(n_log.viewLog());
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            debugLine("Info", "message log requires moderator or above");
                            line(c.yw + "Missing Permissions");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/logaccess commandlog":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER || loggedin.getRank() == rank.MODERATOR) {
                            debugLine("Info", "Successfully accessed command log");
                            line(c_log.viewLog());
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            debugLine("Info", "command log requires mod or above");
                            line(c.yw + "Missing Permissions");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/generatenewuuid":
                        debugLine("Info", "Successful /generatenewuuid");
                        if (loggedin.getRank() != rank.DEFAULT) {
                            System.out.println(c.cy + UUID.randomUUID());
                            System.out.println(UUID.randomUUID());
                            System.out.println(UUID.randomUUID());
                            System.out.println(UUID.randomUUID() + c.rs);
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            debugLine("Info", "Needs VIP for /generatenewuuid");
                            line("You must be VIP or above to use this command.");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/crash runtime_exception":
                            msg.programs.crash.runtime_exception("REEEEEEEEEEEEEE");
                            break;
                    case "/crash printcrash":
                            msg.programs.crash.function_crash();
                            break;
                    case "/crash securityexception":
                            msg.programs.crash.security_issue_exception("bruh");
                            break;
                    default:
                        line(c.yw + "Unknown Command []");
                }


            } else if (blacklist) {
                debugLine("Info", "Message contains a  blacklisted term.");
                line(c.yw + "Your message could not be sent [701].");
                n_log.logmessage(new TextMessage(loggedin, c.pr + "Said \"" + sc2 + "\", was not sent.", database.chat));
            } else {



                    switch (sc2) {
                        case "ez":
                            debugLine("Info", "\"ez\" was sent.");
                            String ez = database.returnez();
                            nextmsg = new TextMessage(loggedin, ez, database.chat);
                            message(nextmsg, n_log);
                            break;
                        case "cancel_messageL":
                            debugLine("Info", "Cancelled message [702]");
                            n_log.logmessage(new TextMessage(loggedin, c.yw + "Cancelled message: " + sc2, database.chat));
                            break;
                        case "":
                            break;
                        default:
                            nextmsg = new TextMessage(loggedin, sc2, database.chat);
                            message(nextmsg, n_log);

                    }

            }
        }
    }

    public static void line (String println) {

        System.out.print(println + c.rs + "\n");
    }

    public static void message(@NotNull TextMessage message, @NotNull messageLog log) {
        debugLine("Info", "message()");
        System.out.println(message);
        log.logmessage(message);
    }

    private static void logout() {
        debugLine("Info", "logout()");
        loggedin = database.empty;
        debugLine("Info", "Successfully logged out.");
        line(c.gr + "Successfully logged out");
    }

    private static void login () {

        debugLine("Info", "login()");
        boolean success;

        do {

            success = false;

            //Login
            Scanner sc3 = new Scanner(System.in);
            System.out.print(c.yw + "Please log in.\nUsername: ");
            String sc4 = sc3.nextLine();
            Scanner sc5 = new Scanner(System.in);
            System.out.print(c.yw + "Password: ");
            String sc6 = sc5.nextLine();

            success = msg.commands.Commands.login(sc4, sc6);

        } while (!success);


    }

    public static void debugLine (String type, @NotNull String text) {

        if (debug_mode1) {

            if (type == null) {
                System.out.println(c.wh + "[Debug] " + text + c.rs);
            } else if (type.equals("")) {
                System.out.println(c.wh + text + c.rs);
            } else {
                System.out.println(c.wh + "[" + type + "] " + text + c.rs);
            }

        }
    }

    private static boolean mC() {
        // mC means moderator command
        return loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.MODERATOR || loggedin.getRank() == rank.OWNER;
    }


}