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

public class Main {

    static Account loggedin;

    public static void main(String[] args) {




        database.load(); //Load Database. This initializes all the Accounts
        messageLog n_log = new messageLog("the msg log"); //Create Message log
        commandLog c_log = new commandLog("cmd log");
        Boolean blacklist = false;
        loggedin = database.empty;
        Boolean impersonate = false;
        Account wait = database.empty;
        TextMessage nextmsg;
        TextMessage systemmsg;


        login();


        while (true) {

            //blacklist = false;


            Scanner sc1 = new Scanner(System.in);
            String sc2 = sc1.nextLine();

            if (sc2.startsWith("/mute")) {
                if (loggedin.getRank() == rank.MODERATOR || loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                    for (int i = 0; i < database.accounts.size(); i++) {
                        if (database.accounts.get(i).getUsername().equals(sc2.replaceAll("/mute ", ""))) {
                            database.accounts.get(i).changerank(rank.MUTED);
                            line(c.rd + "Muted " + database.accounts.get(i).getDisplayName());
                            c_log.logcmd(sc2, loggedin);
                            sc2 = "I am muted";
                        }
                    }
                } else {
                    line(c.rd + "no, this is for moderators dumas");
                }
            }

            for (int i = 0; i < database.messageblacklist.size(); i++) {
                if (sc2.contains(database.messageblacklist.get(i))) {
                    blacklist = true;
                    break;
                }
            }


            if (sc2.startsWith("/")) {


                if (impersonate && sc2.equals("/impersonate reset")) {
                    loggedin = wait;
                    impersonate = false;
                    wait = database.empty;
                    systemmsg = new TextMessage(database.system, "Reset impersonation.", loggedin);
                    message(systemmsg, n_log);
                } else if (sc2.equals("/impersonate reset")) {
                    line(c.yw + "No impersonation to reset.");
                } else {
                    if (sc2.startsWith("/impersonate")) {

                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER) {
                            switch (sc2.toLowerCase()) {
                                case "/impersonate":
                                    wait = loggedin;
                                    loggedin = database.impersonated;
                                    impersonate = true;
                                    systemmsg = new TextMessage(database.system, "Impersonated Jimothy (Default)", wait);
                                    message(systemmsg, n_log);
                                    break;
                                default:
                                    database.impersonated.changeusername(database.impersonated.getUsername(), database.impersonated.getPassword(), sc2.replaceAll("/impersonate ", ""));
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
                            System.out.println(c.cy + UUID.randomUUID().toString());
                            System.out.println(UUID.randomUUID().toString());
                            System.out.println(UUID.randomUUID().toString());
                            System.out.println(UUID.randomUUID().toString() + c.rs);
                            c_log.logcmd(sc2, loggedin);
                        } else {
                            line("You must be VIP or above to use this command.");
                            c_log.logcmd(c.wh + "[Attempted, failed]" + c.rs + sc2, loggedin);
                        }
                        break;
                    default:
                        line(c.yw + "Unknown Command [RR]");
                }


            } else if (blacklist) {
                line(c.yw + "Blocked inappropriate message");
                n_log.logmessage(new TextMessage(loggedin, c.pr + "Said \"" + sc2 + "\", was not sent.", database.chat));
            } else {

                if (loggedin.getRank() != rank.MUTED) {

                    switch (sc2) {
                        case "ez":
                            String ez = database.returnez();
                            nextmsg = new TextMessage(loggedin, ez, database.chat);
                            message(nextmsg, n_log);
                            break;
                        default:
                            nextmsg = new TextMessage(loggedin, sc2, database.chat);
                            message(nextmsg, n_log);

                    }
                } else {
                    line(c.yw + "You are muted.");
                    c_log.logcmd("Attempted to say \"" + sc2 + "\", but was muted.", loggedin);
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

                if (database.accounts.get(i).getUsername().equals(sc4) && database.accounts.get(i).getPassword().equals(sc6)) {
                    loggedin = database.accounts.get(i);
                    success = true;
                }

            }

            if (success) { line(c.gr + "Successfully logged in"); }
            else { line(c.rd + "no"); }



        } while (!success);


    }
}