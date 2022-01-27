package msg.resocurces.commands;
import msg.Main;
import msg.resocurces.c;
import msg.resocurces.database;
import msg.resocurces.rank;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;


public class Commands {

    // Public: User Commands (Input from scanner)

    public static void changePassword_SC () {


        String changepwd2; // Password changing resource
      String changepwd3; // Password changing resource
     String changepwd4; // Password changing resource
        String changepwd5; // Password changing resource





        Scanner scan_changepassword = new Scanner(System.in);

        line("Change Password. To abort, just enter the wrong credentials.");
        System.out.print("Enter your username: ");
        changepwd2 = scan_changepassword.nextLine();
        System.out.print("Enter your current password: ");
        changepwd3 = scan_changepassword.nextLine();
        System.out.print("Enter your new password: ");
        changepwd4 = scan_changepassword.nextLine();
        System.out.print("Confirm your new password: ");
        changepwd5 = scan_changepassword.nextLine();



        if (!changepwd2.equals(Main.loggedin.getUsername())) {
            line(c.yw + "Your username doesn't match what you entered.");
        } else if (!changepwd3.equals(Main.loggedin.getPassword())) {
            line(c.yw + "Your password doesn't match the password your current password you entered");
        } else if (!changepwd4.equals(changepwd5)) {
            line(c.yw + "New password doesn't match with the confirm new password");
        } else if (changepwd3.equals(changepwd4)) {
            line(c.yw + "New password is identical to current password.");
        } else {
            line(Main.loggedin.changepassword(changepwd2, changepwd3, changepwd4));
        }




    }


    // Public: User Commands (Input sourced)

    public static boolean login (String LOGIN_USERNAME, String LOGIN_PASSWORD) {

        boolean success;



            success = false;



            for (int i = 0; i < database.accounts.size(); i++) {


                if (database.accounts.get(i).getUsername().equals(LOGIN_USERNAME) && database.accounts.get(i).getPassword().equals(LOGIN_PASSWORD)) {

                    Main.debugLine("Info", "Credentials match (i = " + i + ")");


                        Main.loggedin = database.accounts.get(i);
                        success = true;
                        break;


                } else {
                    Main.debugLine("Info", "Credentials didn't match (i = " + i + ")");
                }

            }

            if (success) {
                Main.debugLine("Info", "Successful login to " + Main.loggedin.getDisplayName());
                line(c.gr + "Successfully logged in");
            }
            else { line(c.rd + "no"); }







        return success;
    }

    public static void changePassword (@NotNull String c2, String c3, String c4, String c5) {

        if (!c2.equals(Main.loggedin.getUsername())) {
            line(c.yw + "Your username doesn't match what you entered.");
        } else if (!c3.equals(Main.loggedin.getPassword())) {
            line(c.yw + "Your password doesn't match the password your current password you entered");
        } else if (!c4.equals(c5)) {
            line(c.yw + "New password doesn't match with the confirm new password");
        } else if (c3.equals(c4)) {
            line(c.yw + "New password is identical to current password.");
        } else {
            line(Main.loggedin.changepassword(c2, c3, c4));
        }

    }

    public static String help (msg.resocurces.account.@NotNull Account DisplayHelpFor) {

        return switch (DisplayHelpFor.getRank()) {
            case MODERATOR -> """
                    -------Moderation Commands-------
                     /mute <user>
                     /ban <user>
                     /impersonate <Username>
                     -------Account Commands-------
                     /login
                     /logout
                     /changepassword
                     """;
            case OWNER, ADMINISTRATOR -> """
                    -------Database Commands-------
                    /databaseunload
                    /databasereload
                    /databaseload
                    -------Moderation Commands-------
                    /mute <user>
                    /ban <user>
                    /impersonate <Username>
                    -------Account Commands-------
                    /login
                    /logout
                    /changepassword
                    """;
            default -> "e";
        };




    }



    public static String ez () {
        return ez.fire();
    }


    // Public: Admin Commands

    public static boolean databaseunload (rank Permission) {

        boolean success;


        if (Permission == rank.ADMINISTRATOR || Permission== rank.OWNER) {
            database.unload();
            success = true;
        } else {
            line(c.rd + "dont even try");
            success = false;
        }


        return success;
    }

    public static boolean databaseload (rank Permission) {

        boolean success;



        if (Permission == rank.ADMINISTRATOR || Permission == rank.OWNER) {
            Main.debugLine("Info", "Loading database");
            database.load();
            success = true;

        } else {
            Main.debugLine("Info", "Only Administrators or Owners can load the database.");
            line(c.rd + "admins only");
            success = false;
        }


        return success;
    }

    public static boolean databasereload (rank Permission) {

        boolean success;

        if (Permission == rank.ADMINISTRATOR || Permission == rank.OWNER) {
            database.reload();
            success = true;
        } else {
            line(c.rd + "admins only, become a cool kid first.");
            success = false;
        }

        return success;

    }



    // Private: Resources

    private static void line (String println) {

        System.out.print(println + c.rs + "\n");
    }



}
