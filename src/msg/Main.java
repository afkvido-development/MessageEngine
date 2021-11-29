package msg;

import msg.resocurces.database; // Database with all necessary stuff like Account info, ArrayLists, ez, etc.
import msg.account.Account; // Account class
import msg.message.TextMessage; // TextMessage Class
import msg.resocurces.c; // Color Codes
import msg.logging.commandLog;
import msg.logging.messageLog; // MessageLog to log sent messages
import msg.resocurces.rank; // Rank system
import java.util.Scanner; // Scanner for Input, who would have guessed?
import java.util.UUID; // UUID System, also UUID generator.

@SuppressWarnings("InfiniteLoopStatement")
public class Main {

    public static Account loggedin;
    public static messageLog n_log = new messageLog("the msg log"); //Create Message log
    public static commandLog c_log = new commandLog("cmd log");
    public static String mode;
    public static Boolean debug_mode1;

    public static void main(String[] args) {


        // Run Configurations
        if (System.getenv("RUN") == null) {
            line(c.rd + "Invalid run configuration. [902]");
            line("Check the wiki for more information: https://github.com/afkvido/MessageEngine/wiki/Error-Codes#error-code-list");
            Scanner wait1 = new Scanner(System.in);
            String wait2 = wait1.nextLine();

            if (wait2.equals("/configbypass missingENV")) {
                line("Run configuration has been bypassed. Please remember that some features may be faulty.");
                c_log.logcmd("Run configuration bypassed, running with no run ENV. /configbypass missingENV", database.empty);

            } else if (wait2.startsWith("/configbypass")) {
                line("Invalid configuration bypass.");
                System.exit(0);
            } else {
                System.exit(0);
            }



        } else {

            if (System.getenv("RUN").equals("debug")) {
                line(c.wh + "Running MessageEngine by gemsvido");
                line(c.yw + "Entering Debug Mode");
                mode = "debug";
                debug_mode1 = true;
            } else if (System.getenv("RUN").equals("main")) {
                line(c.wh + "Running MessageEngine by gemsvido");
                line("Config: Main");
                mode = "main";
                debug_mode1 = false;
            } else {

                line(c.rd + "Invalid run configuration. [901]");
                line("Check the wiki for more information: https://github.com/afkvido/MessageEngine/wiki/Error-Codes#error-code-list");
                Scanner wait1 = new Scanner(System.in);
                String wait2 = wait1.nextLine();

                if (wait2.equals("/configbypass invalidENV")) {
                    line("Run configuration has been bypassed. Please remember that some features may be faulty.");
                    c_log.logcmd("Run configuration bypassed, running with an invalid run ENV. /configbypass invalidENV", database.empty);

                } else if (wait2.startsWith("/configbypass")) {
                    line("Invalid configuration bypass.");
                    System.exit(0);
                }
                else {
                    System.exit(0);
                }
            }
        }


        //Load Database. This loads in all the Accounts
        database.load();



        boolean blacklist = false; // Creates blacklist variable, used for chat filter
        loggedin = database.empty; // Presets the account to prevent crashes.
        boolean impersonate = false; // Creates impersonation variable, defaults to false.
        Account wait = database.empty; // Creates hold/temporary account, used for impersonation feature.
        TextMessage nextmsg; // Creates variable for the next message you send
        TextMessage systemmsg; // Creates variable for system messages (sent to loggedin)




        login(); // Opens login interface
        line(loggedin.getColorCode() + "Welcome, " + loggedin.getDisplayName()); // Welcomes user

        // Starts the loop, where you can chat and use commands
        while (true) {

            blacklist = false; // Resets blacklist


            Scanner sc1 = new Scanner(System.in); // Receives user input
            String sc2 = sc1.nextLine(); // Saves user input


            // Mute command
            if (sc2.startsWith("/mute")) {

                // If sufficient permissions
                if (loggedin.getRank() == rank.MODERATOR || loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {

                    // Find account
                    for (int i = 0; i < database.accounts.size(); i++) {
                        if (database.accounts.get(i).getUsername().equals(sc2.replaceAll("/mute ", ""))) {

                            // Change to muted
                            database.accounts.get(i).changerank(rank.MUTED);
                            line(c.rd + "Muted " + database.accounts.get(i).getDisplayName());

                            // Logs the command
                            c_log.logcmd(sc2, loggedin);
                            if (loggedin == database.accounts.get(i)) {

                                // This won't be sent anyways.
                                sc2 = "I am muted";
                            } else {

                                // Cancels message if you are muting yourself.
                                sc2 = "cancel_messageL";
                            }
                        }
                    }
                } else {
                    // If the command is used by a non-moderator.
                    line(c.rd + "no, this is for moderators");
                }

                // Ban command
            } else if (sc2.startsWith("/ban")) {

                // Check for sufficient permissions
                if (loggedin.getRank() == rank.MODERATOR || loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                    for (int i = 0; i < database.accounts.size(); i++) {
                        if (database.accounts.get(i).getUsername().equals(sc2.replaceAll("/ban ", ""))) {

                            database.accounts.get(i).ban(1, loggedin.getUsername(), loggedin.getPassword());
                            line(c.rd + "Banned " + database.accounts.get(i).getDisplayName());
                            c_log.logcmd(sc2, loggedin);



                            if (loggedin == database.accounts.get(i)) {
                                //TextMessage banreturn = new TextMessage(database.system, c.rd + "Your account has been banned for " + c.cy + database.bannedpeople.getReason(database.accounts.get(i)) + c.rd + " for " + database.bannedpeople.getDuration(database.accounts.get(i)) + "m", loggedin);
                                TextMessage banreturn = new TextMessage(database.system, c.rd + "Your account has been banned", loggedin);

                                message(banreturn, n_log);
                                login();
                                sc2 = "cancel_messageL";
                            } else {
                                sc2 = "cancel_messageL";
                            }
                        }
                    }
                } else {
                    line(c.rd + "you cant do that what were you exepecting. come back when ur mod or above.");
                }
            }

            for (int i = 0; i < database.messageblacklist.size(); i++) {
                if (sc2.contains(database.messageblacklist.get(i))) {
                    blacklist = true;
                    break;
                }
            }


            if (sc2.startsWith("/")) {


                if (impersonate && sc2.equals("/impersonate reset") || sc2.equals("/im reset")) {
                    loggedin = wait;
                    impersonate = false;
                    wait = database.empty;
                    systemmsg = new TextMessage(database.system, "Reset impersonation.", loggedin);
                    message(systemmsg, n_log);
                } else if (sc2.equals("/impersonate reset") || sc2.equals("/im reset")) {
                    line(c.yw + "No impersonation to reset.");
                } else {
                    if (sc2.startsWith("/impersonate") || sc2.startsWith("/im")) {

                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                            switch (sc2.toLowerCase()) {
                                case "/im":
                                case "/impersonate":
                                    wait = loggedin;
                                    loggedin = database.impersonated;
                                    impersonate = true;
                                    systemmsg = new TextMessage(database.system, "Impersonated Jimothy (Default)", wait);
                                    message(systemmsg, n_log);
                                    break;
                                default:
                                    database.impersonated.changeusername(database.impersonated.getUsername(), database.impersonated.getPassword(), sc2.replaceAll("/impersonate ", "").replaceAll("/im ", ""));
                                    wait = loggedin;
                                    loggedin = database.impersonated;
                                    impersonate = true;
                                    systemmsg = new TextMessage(database.system, "Impersonated " + database.impersonated.getUsername(), wait);
                                    message(systemmsg, n_log);
                            }
                        } else if (loggedin.getRank() == rank.MODERATOR) {
                            systemmsg = new TextMessage(database.system, "You must be Admin or higher to use this command.", loggedin);
                            message(systemmsg, n_log);
                        } else {
                            line(c.yw + "Unknown command");
                        }
                    }
                }



                switch (sc2.toLowerCase()) {
                    case "/databasereload":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                            database.reload();
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line(c.rd + "piss off. admins only");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/databaseunload":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                            database.unload();
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line(c.rd + "piss off. admins only");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/databaseload":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                            database.load();
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line(c.rd + "piss off. admins only");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/login":
                        logout();
                        login();
                        c_log.logcmd(sc2, loggedin);
                        break;
                    case "/help":
                        line(c.pr + "Just type out your message. Not complicated.");
                        c_log.logcmd(sc2, loggedin);
                        break;
                    case "/logaccess messagelog":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER || loggedin.getRank() == rank.MODERATOR) {
                            line(n_log.viewLog());
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line(c.yw + "Missing Permissions");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/logaccess commandlog":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER || loggedin.getRank() == rank.MODERATOR) {
                            line(c_log.viewLog());
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line(c.yw + "Missing Permissions");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    case "/generatenewuuid":
                        if (loggedin.getRank() != rank.MUTED || loggedin.getRank() != rank.DEFAULT) {
                            System.out.println(c.cy + UUID.randomUUID());
                            System.out.println(UUID.randomUUID());
                            System.out.println(UUID.randomUUID());
                            System.out.println(UUID.randomUUID() + c.rs);
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line("You must be VIP or above to use this command.");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    default:
                        if (sc2.equals("cancel_messageL"))
                        line(c.yw + "Unknown Command [RR]");
                }


            } else if (blacklist) {
                line(c.yw + "Your message could not be sent [701].");
                n_log.logmessage(new TextMessage(loggedin, c.pr + "Said \"" + sc2 + "\", was not sent.", database.chat));
            } else {

                if (loggedin.getRank() != rank.MUTED) {

                    switch (sc2) {
                        case "ez":
                            String ez = database.returnez();
                            nextmsg = new TextMessage(loggedin, ez, database.chat);
                            message(nextmsg, n_log);
                            break;
                        case "cancel_messageL":
                            line(c.yw + "Cancelled message [702]");
                            n_log.logmessage(new TextMessage(loggedin, c.yw + "Cancelled message: " + sc2, database.chat));
                            break;
                        default:
                            nextmsg = new TextMessage(loggedin, sc2, database.chat);
                            message(nextmsg, n_log);

                    }
                } else {
                    line(c.yw + "You are muted, therefore your message could not be sent [703]. (get rekt)");
                    n_log.logmessage(new TextMessage(loggedin, c.yw + "Attempted to say \"" + sc2 + "\", but was muted.", database.chat));
                }

            }
        }
    }

    public static void line (String println) {
        System.out.print(println + "\n");
    }

    public static void message(TextMessage message, messageLog log) {
        System.out.println(message.toString());
        log.logmessage(message);
    }

    private static void logout() {
        loggedin = database.empty;
        line(c.gr + "Successfully logged out");
    }

    private static void login () {

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


            for (int i = 0; i < database.accounts.size(); i++) {



                if (database.accounts.get(i).getBanBooleanStatus()) {

                    database.accounts.get(i).check_unban_timer();
                }




                if (database.accounts.get(i).getUsername().equals(sc4) && database.accounts.get(i).getPassword().equals(sc6)) {

                    if (database.accounts.get(i).getBanBooleanStatus()) { //If banned

                    line(c.yw + "Your account could not be logged in to. [101]");
                    line(c.yw + "Your account is currently banned. Your account will be unbanned on " + database.accounts.get(i).getUnbanDate() + " (dd/mm/yyyy)");
                        success = false;

                    } else {

                        line("not banned");
                        loggedin = database.accounts.get(i);
                        success = true;
                    }

                }

            }

            if (success) { line(c.gr + "Successfully logged in"); }
            else { line(c.rd + "no"); }



        } while (!success);


    }
}