package msg.programs.interactive;

import msg.Main;
import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.UrlReader;
import msg.version.Version;
import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.util.Scanner;

/** The server login thing, except it logs into a local server if the local server debug mode is on.  <p></p>
 * @author gemsvidø
 * @since 0.1.8 */
public final class login {

    /** If the client is the severs recommended version  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public static Boolean recommended = true;

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

     /** MultiConnect, if true then the server/client version won't be checked. Must be enabled on both client and server to work.  <p></p>
      * @author gemsvidø
      * @since 0.2.1 */
     private static Boolean multiconnect = false;

    /** User's username  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String username;

    /** User's password  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static String password;

    /** Making a login token eventually. */
    private static String loginToken;

    //------------------------------------

    /** This is run when the client needs to log in  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    public static void go () {
        if (debug == null || !debug) {
            serverLogin();
        }
    }

    /** This is run when the client needs to log in with preset credentials  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public static void go_credentials (String serverAddress, String username, String password) {
        if (debug == null || !debug) {
            serverLogin(serverAddress, username, password);
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



            if ((System.getenv("loginWithToken") != null) && System.getenv("loginWithToken").equalsIgnoreCase("true")) {

            Scanner aLoginToken_scan = new Scanner(System.in);
            i.text(i.cyan + "Login Token: ");
            loginToken = aLoginToken_scan.nextLine();


            } else {

                Scanner username_scan = new Scanner(System.in);
                i.text(i.cyan + "Username: ");
                username = username_scan.nextLine();


                Scanner password_scan = new Scanner(System.in);
                i.text(i.cyan + "Password: ");
                password = password_scan.nextLine();

            }





            String ghServerAddress = "https://github.com/" + i.ServerAddress;
            String mainYml = "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml";
            String p = "";


                try {
                    p = UrlReader.check(mainYml);
                } catch (Exception ignored) {  }

                SortInfo(p);

                Boolean valid = checkServerValidity();

                if (valid) {

                    i.line(i.green + "Successfully pinged " + i.cyan + svAddress);
                    String n = "";


                    // Read AccountList.yml

                    try {

                        n = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/!%20AccountList.yml");

                    } catch (Exception ignored) {}



                    String[] line = n.split("\\n");


                    // LOCATE ACCOUNT IN AccountList.yml

                    for (String value : line) {

                        if (value.equals(username)) {
                            i.debugLine("Info", "Account listed (1/2)");
                            break;
                        }

                    }



                    // Read Account

                    String s = "";

                    try {

                       s = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");

                    } catch (Exception ignored) {}

                    String[] accountsInfo = s.split("\\n");
                    String serverAccUsername = accountsInfo[1].replace("username: ", "");
                    String serverAccPassword = accountsInfo[2].replace("password: ", "");

                    if (serverAccUsername.equals(username) && serverAccPassword.equals(password)) {

                        setAccount(getAccount());
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


    /** Log in to a server with username and password args  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    private static void serverLogin (String serverAddress_, String username_, String password_) {

        boolean success;

        do {

            success = false;


            i.text(i.cyan + "Server Address: " + serverAddress_);
            i.ServerAddress = serverAddress_;






            i.text(i.cyan + "Username: " + username_);
            username = username_;



            i.text(i.cyan + "Password: " + password_);
            password = password_;







            String ghServerAddress = "https://github.com/" + i.ServerAddress;
            String mainYml = "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml";
            String p = "";


            try {
                p = UrlReader.check(mainYml);
            } catch (Exception ignored) {  }

            SortInfo(p);

            Boolean valid = checkServerValidity();

            if (valid) {

                i.line(i.green + "Successfully pinged " + i.cyan + svAddress);
                String n = "";


                // Read AccountList.yml

                try {

                    n = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/!%20AccountList.yml");

                } catch (Exception ignored) {}



                String[] line = n.split("\\n");


                // LOCATE ACCOUNT IN AccountList.yml

                for (String value : line) {

                    if (value.equals(username)) {
                        i.debugLine("Info", "Account listed (1/2)");
                        break;
                    }

                }



                // Read Account

                String s = "";

                try {

                    s = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");

                } catch (Exception ignored) {}

                String[] accountsInfo = s.split("\\n");
                String serverAccUsername = accountsInfo[1].replace("username: ", "");
                String serverAccPassword = accountsInfo[2].replace("password: ", "");

                if (serverAccUsername.equals(username) && serverAccPassword.equals(password)) {

                    setAccount(getAccount());
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


    /** <b>COMING SOON.</b> Log in to a server with a token.   <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    private static void serverLogin (String serverAddress_, String loginToken_) {

        boolean success;

        do {

            success = false;


            i.text(i.cyan + "Server Address: " + serverAddress_);
            i.ServerAddress = serverAddress_;





            i.text(i.cyan + "Token: " + loginToken_);
            loginToken = loginToken_;








            String ghServerAddress = "https://github.com/" + i.ServerAddress;
            String mainYml = "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml";
            String p = "";


            try {
                p = UrlReader.check(mainYml);
            } catch (Exception ignored) {  }

            SortInfo(p);

            Boolean valid = checkServerValidity();

            if (valid) {

                i.line(i.green + "Successfully pinged " + i.cyan + svAddress);
                String n = "";


                // Read AccountList.yml

                try {

                    n = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/!%20AccountList.yml");

                } catch (Exception ignored) {}



                String[] line = n.split("\\n");


                // LOCATE ACCOUNT IN AccountList.yml

                for (String value : line) {

                    if (value.equals(username)) {
                        i.debugLine("Info", "Account listed (1/2)");
                        break;
                    }

                }



                // Read Account

                String s = "";

                try {

                    s = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");

                } catch (Exception ignored) {}

                String[] accountsInfo = s.split("\\n");
                String serverAccUsername = accountsInfo[1].replace("username: ", "");
                String serverAccPassword = accountsInfo[2].replace("password: ", "");

                if (serverAccUsername.equals(username) && serverAccPassword.equals(password)) {

                    setAccount(getAccount());
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



        latestSvVersion = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/version/Primary.yml").replace("\n", "");




        boolean valid = false;

        String compatible = UrlReader.check("https://raw.githubusercontent.com/ " + "/main/src/version/Compatible.yml");

        String[] compatibleVersions = compatible.split("\\n");



        if (Version.Version.equals(latestSvVersion)) {
            valid = true;
            i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", " + i.green + "you are on the recommended server version" + i.gray + "!");
            recommended = true;
        } else {


            for (String allowedVersion : compatibleVersions) {

                if (Version.Version.equals(allowedVersion) || Version.Version.equals(allowedVersion.replace("\n", ""))) {
                    valid = true;

                    i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", the server recommends using version " + i.cyan + latestSvVersion + i.gray + ".");


                    break;
                }
            }

        }

        Scanner wait = new Scanner(System.in);


        if (!valid) {
            i.text(i.yellow + "You are running MessageEngine " + i.cyan + Version.Version + i.yellow + ", the server needs version " + i.cyan + latestSvVersion + i.yellow + ".");
            i.line(i.red + "\nYou are on an incompatible version of MessageEngine for this server. \nTo join this server, get MessageEngine " + i.cyan + latestSvVersion + i.red + ".");
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
        valid[1] = disabled.equals("false");
        valid[2] = true;
        valid[3] = true;
        valid[4] = !(Version.Version.equals(latestSvVersion));

        for (int l = 0; l < valid.length; l++) {


            if (!valid[l]) {

                switch (l) {
                    case 0 -> {
                        i.line(i.red + "Server invalid");
                        i.line(i.yellow + "Server Address is invalid. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml");
                        return false;
                    }
                    case 1 -> {
                        i.line(i.red + "Server invalid");
                        i.line(i.yellow + "Server is disabled. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml");
                        return false;
                    }
                    case 4 -> {
                        if (!recommended) {
                            i.line(i.yellow + "The server recommends version " + i.cyan + latestSvVersion + i.yellow + ".");
                            i.line(i.green + "You may still connect to the server.");
                            i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Main.yml");
                        }
                        return true;
                    }
                    default -> throw new IndexOutOfBoundsException("420: How did we get here?");
                }
            }
        }



        return true;

    }

    /** This configures the account on the client once it's been read from the server  <p></p>
     * @author gemsvidø
     * @since 0.1.8 */
    private static @NotNull Account getAccount () {

        // Read the account's info from the server
        String rank1 = UrlReader.check("https://raw.githubusercontent.com/" + i.ServerAddress + "/main/src/Accounts/" + username + ".yml");


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