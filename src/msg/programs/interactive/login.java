package msg.programs.interactive;

import msg.Main;
import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.URLreader;
import msg.version.Version;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public final class login {

    /** Server Address */
    private static String svAddress;

    /** Is the server disabled? */
    private static String disabled;

    /** Server Name */
    private static String svName;

    /** Server URL */
    private static String svUrl;

    /** Server Version */
    private static String svVersion;

    /** Server Address */
    public static String server_address;

    /** Debug mode for local server */
    public static Boolean debug = false;

    /** User's username */
    private static String username;

    /** User's password */
    private static String password;

    //------------------------------------

    /** This is run when the client needs to log in */
    public static void go () { if (debug == null || !debug) serverLogin(); }

    /** Log in to a server */
    private static void serverLogin () {

        boolean success;

        do {

            success = false;

            Scanner server_address_scan = new Scanner(System.in);
            i.text(i.cyan + "Server Address: ");
            server_address = server_address_scan.nextLine();

            Scanner username_scan = new Scanner(System.in);
            i.text(i.cyan + "Username: ");
            username = username_scan.nextLine();

            Scanner password_scan = new Scanner(System.in);
            i.text(i.cyan + "Password: ");
            password = password_scan.nextLine();




            String ghServerAddress = "https://github.com/" + server_address;
            String mainYml = "https://raw.githubusercontent.com/" + server_address + "/main/src/Main.yml";
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

                        n = URLreader.check("https://raw.githubusercontent.com/" + server_address + "/main/src/Accounts/!%20AccountList.yml");

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

                       s = URLreader.check("https://raw.githubusercontent.com/" + server_address + "/main/src/Accounts/" + username + ".yml");

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
                    i.line(i.red + "Could not connect to " + i.cyan + server_address);
                }


        } while (!success);


    }

    /** Sort Main.yml from a server, while logging in */
    private static void SortMainYml (@NotNull String mainYml) {

        String[] lines = mainYml.split("\\n");

        svAddress = lines[0].replace("serverAddress: ", "");
        disabled = lines[1].replace("disabled: ", "");
        svName = lines[2].replace("serverName: ", "");
        svUrl = lines[3].replace("serverUrl: ", "");
        svVersion = lines[4].replace("version: ", "");

    }

    /** This checks if the server can be logged in to from this client */
    public static @NotNull Boolean checkServerValidity () {

        Boolean[] valid = new Boolean[5];

        valid[0] = server_address.equals(svAddress);
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
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + server_address + "/main/src/Main.yml");
                    }
                    case 1 -> {
                        i.line(i.yellow + "Server is disabled. ");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + server_address + "/main/src/Main.yml");
                    }
                    case 4 -> {
                        i.line(i.yellow + "Server version does not match client version.");
                        i.line(i.gray + "at " + i.cyan + "https://raw.githubusercontent.com/" + server_address + "/main/src/Main.yml");
                    }
                    default -> throw new IndexOutOfBoundsException("420: How did we get here?");
                }

                return false;


            }
        }


        setAccount(getAccount());


        return true;

    }

    /** This configures the account on the client once it's been read from the server */
    private static Account getAccount() {

        String rank1 = "DEFAULT";

        try {

            rank1 = URLreader.check("https://raw.githubusercontent.com/" + server_address + "/main/src/Accounts/" + username + ".yml");

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

    /** This sets the account once it's been obtained. */
    public static void setAccount (@NotNull Account account) { Main.loggedin = account; }

    /** Private constructor prevents the login class from being initialized. */
    private login () {}
}