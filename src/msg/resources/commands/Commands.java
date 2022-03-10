package msg.resources.commands;

import msg.Main;
import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.UUID;

/** Commands, these can be run by macros or from local commands. <p></p>
 * @author gemsvidø
 * @since 0.1.12  */
public final class Commands {

    // Fire

    /** Runs a command. <br></br> This is mainly for macros. <br></br> Required VarArgs: CommandTypes cmd <p></p>
     * @author gemsvidø
     *  @since 0.1.13  */
    public static void fire (@NotNull CommandsTypes cmd) { switch (cmd) { case ez -> ez(); case generateUUIDs -> generateUUIDs(Main.loggedin); case changePassword_SC -> changePassword_SC(); } }


    // Public: User Commands (Input from scanner)


    /** Change password, input is obtained through a console dialog with Scanners. <p></p>
     * @author gemsvidø
     *  @since 0.1.9   */
    public static void changePassword_SC () {


        String changepwd2; // Password changing resource
        String changepwd3; // Password changing resource
        String changepwd4; // Password changing resource
        String changepwd5; // Password changing resource





        Scanner scan_changepassword = new Scanner(System.in);

        i.line("Change Password. To abort, just enter the wrong credentials.");
        i.text("Enter your username: ");
        changepwd2 = scan_changepassword.nextLine();
        i.text("Enter your current password: ");
        changepwd3 = scan_changepassword.nextLine();
        i.text("Enter your new password: ");
        changepwd4 = scan_changepassword.nextLine();
        i.text("Confirm your new password: ");
        changepwd5 = scan_changepassword.nextLine();



        if (!changepwd2.equals(Main.loggedin.getUsername())) {
            i.line(i.yellow + "Your username doesn't match what you entered.");
        } else if (!changepwd3.equals(Main.loggedin.getPassword())) {
            i.line(i.yellow + "Your password doesn't match the password your current password you entered");
        } else if (!changepwd4.equals(changepwd5)) {
            i.line(i.yellow + "New password doesn't match with the confirm new password");
        } else if (changepwd3.equals(changepwd4)) {
            i.line(i.yellow + "New password is identical to current password.");
        } else {
            Main.loggedin.changePassword(changepwd2, changepwd3, changepwd4);
        }




    }

    /** Prints 4 randomly generated UUIDs, only if the account is VIP or above. <p></p>
     * @author gemsvidø
     *  @since 0.1.2   */
    public static void generateUUIDs (@NotNull Account acc) {

        if (acc.getRank() != rank.DEFAULT) {
            i.line(i.cyan + UUID.randomUUID());
            i.line(i.cyan + UUID.randomUUID());
            i.line(i.cyan + UUID.randomUUID());
            i.line(i.cyan + UUID.randomUUID() + i.white);
        } else {
            i.line("You must be VIP or above to use this command.");
        }

    }

    /** Change password, input is already sourced as VarArgs. You can make a custom input with this. <p></p>
     * @author gemsvidø
     *  @since 0.1.9   */
    public static void changePassword (@NotNull String username, @NotNull String oldPwd, @NotNull String newPwd, @NotNull String confirmNewPwd) {

        if (!username.equals(Main.loggedin.getUsername())) {
            i.line(i.yellow + "Your username doesn't match what you entered.");
        } else if (!oldPwd.equals(Main.loggedin.getPassword())) {
            i.line(i.yellow + "Your password doesn't match the password your current password you entered");
        } else if (!newPwd.equals(confirmNewPwd)) {
            i.line(i.yellow + "New password doesn't match with the confirm new password");
        } else if (oldPwd.equals(newPwd)) {
            i.line(i.yellow + "New password is identical to current password.");
        } else {
            Main.loggedin.changePassword(username, oldPwd, newPwd);
        }

    }

    /** Returns a random <strong>ez</strong> response from the server <p></p>
     * @author gemsvidø
     * @since 0.1.2   */
    public static @NotNull String ez () {
        return ez.fire();
    }

    /** Utility class <strong>Commands</strong> cannot be initialized <p></p>
     * @author gemsvidø  */
    private Commands () {}

}
