package msg.programs.interactive;

import msg.Main;
import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.URLreader;
import msg.version.Version;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

import static msg.i.ServerAddress;

/** The server login thing, except it logs into a local server if the local server debug mode is on.  <p></p>
 * @author gemsvidø
 * @since 0.1.8 */
public final class login {

    /** Server Address  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String svAddress;

    /** Is the server disabled?  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String disabled;

    /** Server Name  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String svName;

    /** Server URL  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    @SuppressWarnings("unused") private static String svUrl;

    /** Server Version  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String svVersion;

    /** Debug mode for local server  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static Boolean debug = false;

    /** User's username  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String username;

    /** User's password  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String password;

    //------------------------------------

    /** This is run when the client needs to log in  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static void go () {
        if (debug == null || !debug) {
            serverLogin();
        }
    }

    /** Log in to a server  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static void serverLogin () {

        boolean success;

        do {

            success = false;

            Scanner server_address_scan = new Scanner(System.in);
            i.text(i.cyan + "Server Address: ");
            ServerAddress = server_address_scan.nextLine();

            Scanner username_scan = new Scanner(System.in);
            i.text(i.cyan + "Username: ");
            username = username_scan.nextLine();

            Scanner password_scan = new Scanner(System.in);
            i.text(i.cyan + "Password: ");
            password = password_scan.nextLine();




            String ghServerAddress = "https://github.com/" + ServerAddress;
            String mainYml = "https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Main.yml";
            String p = "";


                try {
                    p = URLreader.check(mainYml);
                } catch (Exception ignored) {
                }

                SortMainYml(p);

                Boolean valid = checkServerValidity();

                if (valid) {

                    i.line(i.green + "Successfully pinged " + i.cyan + svAddress);
                    String n = "";


                    // Read AccountList.yml

                    try {

                        n = URLreader.check("https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Accounts/!%20AccountList.yml");

                    } catch (Exception ignored) {}



                    String[] line = n.split("\\n");


                    // LOCATE ACCOUNT IN AccountList.yml

                    for (String value : line) {

                        if (value.equals(username)) {
                            i.line("Account listed (1/2)");
                            break;
                        }

                    }



                    // Read Account

                    String s = "";

                    try {

                       s = URLreader.check("https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Accounts/" + username + ".yml");

                    } catch (Exception ignored) {}

                    String[] accountsInfo = s.split("\\n");
                    String serverAccUsername = accountsInfo[1].replace("username: ", "");
                    String serverAccPassword = accountsInfo[2].replace("password: ", "");

                    if (serverAccUsername.equals(username) && serverAccPassword.equals(password)) {

                        i.line(i.green + "Successfully connected to " + i.purple + svName + i.green + " (" + i.cyan + svAddress + i.green + ") as " + i.cyan + username);
                        success = true;

                    } else {
                        i.line(i.yellow + "Credentials did not match");
                    }




                } else {
                    i.line(i.red + "Could not connect to " + i.cyan + ServerAddress);
                }


        } while (!success);


    }

    /** Sort Main.yml from a server, while logging in  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static void SortMainYml (@NotNull String mainYml) {

        String[] lines = mainYml.split("\\n");

        svAddress = lines[0].replace("serverAddress: ", "");
        disabled = lines[1].replace("disabled: ", "");
        svName = lines[2].replace("serverName: ", "");
        svUrl = lines[3].replace("serverUrl: ", "");
        svVersion = lines[4].replace("version: ", "");

    }

    /** This checks if the server can be logged in to from this client  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static @NotNull Boolean checkServerValidity () {

        Boolean[] valid = new Boolean[5];

        valid[0] = ServerAddress.equals(svAddress);
        valid[1] = !disabled.equals("true");
        valid[2] = true;
        valid[3] = true;
        valid[4] = Version.Version.equals(svVersion);

        for (int l = 0; l < valid.length; l++) {
            if (!valid[l]) {

                i.line(i.red + "Server invalid");

                switch (l) {
                    case 0 -> {
                        i.line(i.yellow + "Server Address is invalid. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Main.yml");
                    }
                    case 1 -> {
                        i.line(i.yellow + "Server is disabled. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Main.yml");
                    }
                    case 4 -> {
                        i.line(i.yellow + "Server version does not match client version.");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Main.yml");
                    }
                    default -> throw new IndexOutOfBoundsException("420: How did we get here?");
                }

                return false;


            }
        }


        setAccount(getAccount());


        return true;

    }

    /** This configures the account on the client once it's been read from the server  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static Account getAccount() {

        String rank1 = "DEFAULT";

        try {

            rank1 = URLreader.check("https://raw.githubusercontent.com/" + ServerAddress + "/main/src/Accounts/" + username + ".yml");

        } catch (Exception ignored) {}

        String[] lines = rank1.split("\\n");
        String rank2 = lines[0].replace("rank: ", "");



        rank rank3;

        switch (rank2) {
            case "OWNER" -> rank3 = rank.OWNER;
            case "ADMINISTRATOR" -> rank3 = rank.ADMINISTRATOR;
            case "MODERATOR" -> rank3 = rank.MODERATOR;
            case "YT" -> rank3 = rank.YT;
            case "MVPPLUS2" -> rank3 = rank.MVPPLUS2;
            case "MVPPLUS1" -> rank3 = rank.MVPPLUS1;
            case "VIPPLUS1" -> rank3 = rank.VIPPLUS1;
            case "VIP" -> rank3 = rank.VIP;
            default -> rank3 = rank.DEFAULT;
        }


        return new Account(username, password, rank3, "");
    }

    /** This sets the account once it's been obtained.  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static void setAccount (@NotNull Account account) {
        Main.loggedin = account;
    }

    /** Private constructor prevents the login class from being initialized.  <p></p>
     * @author gemsvidø */
    private login () {}
}