package msg;

import msg.resocurces.database; // Database with all necessary stuff like Account info, ArrayLists, ez, etc.
import msg.account.Account; // Account class
import msg.message.TextMessage; // TextMessage Class
import msg.resocurces.c; // Color Codes
import msg.logging.messageLog; // MessageLog to log sent messages
import msg.resocurces.rank; // Rank system
import java.util.Scanner; // Scanner for Input, who would have guessed?
import java.util.UUID; // UUID System, also UUID generator.

public class Main {

    static Account loggedin;

    public static void main(String[] args) {


        database.load(); //Load Database. This initializes all the Accounts
        messageLog n_log = new messageLog("the msg log"); //Create Message log
        loggedin = database.empty;
        Boolean impersonate = false;
        Account wait = database.empty;
        TextMessage nextmsg;
        TextMessage systemmsg;


        login();


        while (true) {


            Scanner sc1 = new Scanner(System.in);
            String sc2 = sc1.nextLine();

            if (sc2.startsWith("/")) {

                if (sc2.startsWith("/impersonate")) {

                    if (impersonate && sc2.equals("/impersonate reset")) {
                        loggedin = wait;
                        impersonate = false;
                        wait = database.empty;
                        systemmsg = new TextMessage(database.system, "Reset impersonation.", loggedin);
                        message(systemmsg, n_log);
                    } else {
                        line(c.yw + "No impersonation to reset.");
                    }


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
                                break;
                        }
                    } else if (loggedin.getRank() == rank.MODERATOR) {
                        line(c.yw + "Unknown command");
                        systemmsg = new TextMessage(database.system, "You must be Admin or higher to use this command.", loggedin);
                        message(systemmsg, n_log);
                    }
                    else {
                        line(c.yw + "Unknown command");
                    }
                }
                switch (sc2.toLowerCase()) {
                    case "/login":
                        logout();
                        login();
                        break;
                    case "/help":
                        line(c.pr + "Just type out your message. Not complicated.");
                        break;
                    case "/logaccess messagelog":
                        if (loggedin.getRank() == rank.ADMINISTRATOR || loggedin.getRank() == rank.OWNER || loggedin.getRank() == rank.MODERATOR) {
                            line(n_log.viewLog());
                        } else {
                            line(c.yw + "Missing Permissions");
                        }
                        break;
                    case "/generatenewuuid":
                        if (loggedin.getRank() != rank.MUTED || loggedin.getRank() != rank.DEFAULT) {
                            System.out.println(c.cy + UUID.randomUUID().toString());
                            System.out.println(UUID.randomUUID().toString());
                            System.out.println(UUID.randomUUID().toString());
                            System.out.println(UUID.randomUUID().toString() + c.rs);
                        } else {
                            line("You must be VIP or above to use this command.");
                        }
                        break;
                    default:
                        line(c.yw + "Unknown Command");
                }
            } else if (sc2.contains("chatfilter")) {
                line(c.yw + "Blocked inappropriate message");
            } else {

                if (loggedin.getRank() != rank.MUTED) {

                    switch (sc2) {
                        case "ez":
                            nextmsg = new TextMessage(loggedin, database.returnez(), database.chat);
                            message(nextmsg, n_log);
                            break;
                        default:
                            nextmsg = new TextMessage(loggedin, sc2, database.chat);
                            message(nextmsg, n_log);

                    }
                } else {
                    line(c.yw + "You are muted.");
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