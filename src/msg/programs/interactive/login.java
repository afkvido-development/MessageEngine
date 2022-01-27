package msg.programs.interactive;

import msg.Main;
import msg.resocurces.account.Account;
import msg.resocurces.c;
import msg.resocurces.rank;
import msg.version.URLreader;
import msg.version.Version;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class login {

    static String svAddress;
    static String disabled;
    static String svName;
    static String svUrl;
    static String svVersion;
    static String server_address;

    static String username;
    static String password;


    public static void serverLogin() {

        boolean success;

        do {

            success = false;

            Scanner server_address_scan = new Scanner(System.in);
            System.out.print(c.cy + "Server Address: ");
            server_address = server_address_scan.nextLine();

            Scanner username_scan = new Scanner(System.in);
            System.out.print(c.cy + "Username: ");
            username = username_scan.nextLine();

            Scanner password_scan = new Scanner(System.in);
            System.out.print(c.cy + "Password: ");
            password = password_scan.nextLine();


            if (!server_address.endsWith(".msgeng")) {
                System.out.println(c.yw + "Server address must end with .msgeng");
            }


            String ghServerAddress = "https://github.com/" + server_address;
            String mainYml = "https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Main.yml";
            String p = "";


                try {
                    p = URLreader.check(mainYml);
                } catch (Exception ignored) {
                }

                SortMainYml(p);

                Boolean valid = checkServerValidity();

                if (valid) {

                    System.out.println(c.gr + "Successfully pinged " + c.cy + svAddress);
                    String n = "";


                    // Read AccountList.yml

                    try {

                        n = URLreader.check("https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Accounts/!%20AccountList.yml");

                    } catch (Exception ignored) {}

                    String[] line = n.split("\\n");


                    // LOCATE ACCOUNT IN AccountList.yml

                    for (String value : line) {

                        if (value.equals(username)) {
                            System.out.println("Account listed (1/2)");
                            break;
                        }

                    }



                    // Read Account

                    String s = "";

                    try {

                       s = URLreader.check("https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Accounts/" + username + ".yml");

                    } catch (Exception ignored) {}

                    String[] accountsInfo = s.split("\\n");
                    String serverAccUsername = accountsInfo[1].replace("username: ", "");
                    String serverAccPassword = accountsInfo[2].replace("password: ", "");

                    if (serverAccUsername.equals(username) && serverAccPassword.equals(password)) {

                        System.out.println(c.gr + "Successfully connected to " + c.pr + svName + c.gr + " (" + c.cy + svAddress + c.gr + ") as " + c.cy + username);
                        success = true;

                    } else {
                        System.out.println(c.yw + "Credentials did not match");
                    }




                } else {
                    System.out.println(c.rd + "Could not connect to " + c.cy + server_address);
                }


        } while (!success);


    }

    public static void SortMainYml (@NotNull String mainYml) {

        String[] lines = mainYml.split("\\n");

        svAddress = lines[0].replace("serverAddress: ", "");
        disabled = lines[1].replace("disabled: ", "");
        svName = lines[2].replace("serverName: ", "");
        svUrl = lines[3].replace("serverUrl: ", "");
        svVersion = lines[4].replace("version: ", "");

    }

    public static Boolean checkServerValidity () {

        Boolean[] valid = new Boolean[5];

        valid[0] = server_address.equals(svAddress);
        valid[1] = !disabled.equals("true");
        valid[2] = true;
        valid[3] = true;
        valid[4] = Version.Version.equals(svVersion);

        for (int i = 0; i < valid.length; i++) {
            if (!valid[i]) {

                System.out.println(c.rd + "Server invalid");

                switch (i) {
                    case 0:
                        System.out.println(c.yw + "Server Address is invalid. ");
                        System.out.println(c.wh + "at " + c.cy + "https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Main.yml");
                        break;
                    case 1:
                        System.out.println(c.yw + "Server is disabled. ");
                        System.out.println(c.wh + "at " + c.cy + "https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Main.yml");
                        break;
                    case 4:
                        System.out.println(c.yw + "Server version does not match client version.");
                        System.out.println(c.wh + "at " + c.cy + "https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Main.yml");
                    default:
                        throw new IndexOutOfBoundsException("420: How did we get here?");

                }

                return false;


            }
        }

        // TEMPORARY UNTIL CHATSERVER WORKS:

        Main.loggedin =  temporary();

        // END TEMPORARY

        return true;

    }



    private static Account temporary () {

        String rank1 = "DEFAULT";

        try {

            rank1 = URLreader.check("https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/Accounts/" + username + ".yml");

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

}