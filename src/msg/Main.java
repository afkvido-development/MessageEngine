package msg;

import msg.programs.PreLoader;
import msg.programs.interactive.login;
import msg.resocurces.account.Account;
import msg.resocurces.c;
import msg.resocurces.commands.Commands;
import msg.resocurces.database;
import msg.resocurces.message.TextMessage;
import msg.resocurces.rank;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.UUID;

@SuppressWarnings("InfiniteLoopStatement") // Temporary solution to while true
public class Main {



    // Create all static variables

    public static Account loggedin; // Account that is logged in
    public static String mode; // Decides on how to run the program (debug, main, etc.)
    public static Boolean debug_mode1; // Debug boolean (true = debug mode)
    static Boolean info_found_username; // For login and other account finding purposes
    public static String sc2;


    public static void main(String[] args) {



        // PRE-LOADING

        line(c.wh + "[Info] Starting PreLoader...");
        PreLoader.PreLoading(false);
        line(c.wh + "[Info] PreLoader finished.");


        // SETUP

        login.serverLogin();


        // Create all local variables

        TextMessage nextmsg; // Creates variable for the next message you send


        line(loggedin.getColorCode() + "Welcome, " + loggedin.getDisplayName()); // Welcomes user










        // Starts the loop, where you can chat and use commands
        while (true) {


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






            if (sc2.startsWith("/")) {





                switch (sc2.toLowerCase()) {
                    case "/databasereload":
                        Commands.databasereload(loggedin.getRank());
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
                        login.serverLogin();
                        break;
                    case "/changepwd":
                    case "/changepassword":
                        Commands.changePassword_SC();
                        break;
                    case "/help":
                        Commands.help(loggedin);
                        break;

                    case "/generatenewuuid":
                        debugLine("Info", "Successful /generatenewuuid");
                        if (loggedin.getRank() != rank.DEFAULT) {
                            System.out.println(c.cy + UUID.randomUUID());
                            System.out.println(UUID.randomUUID());
                            System.out.println(UUID.randomUUID());
                            System.out.println(UUID.randomUUID() + c.rs);
                        } else {
                            debugLine("Info", "Needs VIP for /generatenewuuid");
                            line("You must be VIP or above to use this command.");
                        }
                        break;
                    default:
                        line(c.yw + "Unknown Command []");
                }


            } else {



                    switch (sc2) {
                        case "ez":
                            debugLine("Info", "\"ez\" was sent.");
                            String z = Commands.ez();
                            nextmsg = new TextMessage(loggedin, z, database.LocalServer);
                            message(nextmsg);
                            break;
                        case "cancel_messageL":
                            debugLine("Info", "Cancelled message [702]");
                            break;
                        case "":
                            break;
                        default:
                            nextmsg = new TextMessage(loggedin, sc2, database.LocalServer);
                            message(nextmsg);

                    }

            }
        }
    }

    public static void line (String println) {

        System.out.print(println + c.rs + "\n");
    }

    public static void message(@NotNull TextMessage message) {
        debugLine("Info", "message()");
        System.out.println(message);
    }



    private static void login () {

        debugLine("Info", "login()");
        boolean success;

        do {


            //Login
            Scanner sc3 = new Scanner(System.in);
            System.out.print(c.yw + "Please log in.\nUsername: ");
            String sc4 = sc3.nextLine();

            Scanner sc5 = new Scanner(System.in);
            System.out.print(c.yw + "Password: ");
            String sc6 = sc5.nextLine();

            success = Commands.login(sc4, sc6);

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


}