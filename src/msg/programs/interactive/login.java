package msg.programs.interactive;

import msg.Main;
import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.URLreader;
import msg.version.Version;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

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
    @SuppressWarnings("unused") static String svUrl;

    /** Server Version  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String latestSvVersion;

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
            i.ServerAddress = server_address_scan.nextLine();

            Scanner username_scan = new Scanner(System.in);
            i.text(i.cyan + "Username: ");
            username = username_scan.nextLine();

            Scanner password_scan = new Scanner(System.in);
            i.text(i.cyan + "Password: ");
            password = password_scan.nextLine();




            String ghServerAddress = "https://github.com/" + i.ServerAddress;
            String mainYml = "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml";
            String p = "";


                try {
                    p = URLreader.check(mainYml);
                } catch (Exception ignored) {
                }

                SortInfo(p);

                Boolean valid = checkServerValidity();

                if (valid) {

                    i.line(i.green + "Successfully pinged " + i.cyan + svAddress);
                    String n = "";


                    // Read AccountList.yml

                    try {

                        n = URLreader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/!%20AccountList.yml");

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

                       s = URLreader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");

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
                    i.line(i.red + "Could not connect to " + i.cyan + i.ServerAddress);
                }


        } while (!success);


    }

    /** Sort information from a server, while logging in  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static void SortInfo (@NotNull String mainYml) {

        String[] infos = mainYml.split("\\n");

        svAddress = infos[0].replace("serverAddress: ", "");
        disabled = infos[1].replace("disabled: ", "");
        svName = infos[2].replace("serverName: ", "");
        svUrl = infos[3].replace("serverUrl: ", "");



        latestSvVersion = URLreader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/version/Primary.yml");




        boolean valid = false;

        String compatible = URLreader.check("https://raw.githubusercontent.com/ " + "/main/src/version/Compatible.yml");

        String[] compatibleVersions = compatible.split("\\n");


        for (String allowedVersion : compatibleVersions) {

            if ((Version.Version).equals(allowedVersion.replace("\n", ""))) {
                valid = true;

                if (Version.Version.equals(latestSvVersion)) {
                    i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", " + i.green + "you are on the recommend server version" + i.gray + "!");
                } else {
                    i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", the server recommends using version " + i.cyan + latestSvVersion + i.gray + ".");
                }


                break;
            }
        }

        Scanner wait = new Scanner(System.in);


        if (!valid) {
            i.text(i.yellow + "You are running MessageEngine " + i.cyan + Version.Version + i.yellow + ", the server needs version " + i.cyan + latestSvVersion.replace("\n", "") + i.yellow + ".");
            i.line(i.red + "\nYou are on an incompatible version of MessageEngine for this server. \nTo join this server, get MessageEngine " + i.cyan + latestSvVersion);
            i.line(i.cyan + "MessageEngine Downloads: https://github.com/afkvido-development/MessageEngine/releases");
            wait.nextLine();
        }


    }

    /** This checks if the server can be logged in to from this client  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static @NotNull Boolean checkServerValidity () {

        Boolean[] valid = new Boolean[5];

        valid[0] = i.ServerAddress.equals(svAddress);
        valid[1] = !disabled.equals("true");
        valid[2] = true;
        valid[3] = true;
        valid[4] = Version.Version.equals(latestSvVersion);

        for (int l = 0; l < valid.length; l++) {
            if (!valid[l]) {

                i.line(i.red + "Server invalid");

                switch (l) {
                    case 0 -> {
                        i.line(i.yellow + "Server Address is invalid. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml");
                    }
                    case 1 -> {
                        i.line(i.yellow + "Server is disabled. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml");
                    }
                    case 4 -> {
                        i.line(i.yellow + "The server recommends version " + i.cyan + latestSvVersion + i.yellow + ".");
                        i.line(i.green + "You may still connect to the server.");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml");
                        return true;
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
    private static @NotNull Account getAccount () {

        // Read the account's info from the server
        String rank1 = URLreader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");

        // Split the account's info into separate lines
        String[] lines = rank1.split("\\n");

        // Clean the rank String and leave ONLY the pure rank
        String rank2 = lines[0].replace("rank: ", "");

        // Set the rank of the account that will be returned to the rank to the right rank
        rank rank3 = rank.valueOf(rank2.replace("\n", ""));

        // Return the generated account
        return new Account(username, password, rank3, "");
    }

    /** This sets the account once it's been obtained.  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static void setAccount (@NotNull Account account) {
        // Set the account in Main to [account]
        Main.loggedin = account;
    }

    /** Private constructor prevents the login class from being initialized.  <p></p>
     * @author gemsvidø */
    private login () {}
}