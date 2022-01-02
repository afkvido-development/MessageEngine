package msg.account;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import msg.resocurces.c;
import msg.resocurces.database;
import msg.resocurces.rank;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.UUID;

public class Account {

    protected String username;
    protected String password;
    protected String uuid;
    protected msg.resocurces.rank rank;
    protected String rankToString;
    protected String namecolor;
    protected String usernameToString;
    protected ArrayList<Integer> hours_ban;
    protected static ArrayList<LocalDateTime> date_banned;
    protected static ArrayList<LocalDateTime> date_to_unban;
    protected DateTimeFormatter DTF;
    protected Boolean ban_status_bool;

    public String getPassword() {
        return password;
    }


    // Constructor
    public Account (@NotNull String username, @NotNull String password, @NotNull String rank, @NotNull String predetermineduuid) {
        this.username = username;
        this.password = password;

        if (predetermineduuid.equals("")) {
            String uuid = UUID.randomUUID().toString();
            this.uuid = uuid;
        } else {
            this.uuid = predetermineduuid;
        }

        unlocked_changerank(rank);

       this.date_banned = new ArrayList<>();
       this.date_to_unban = new ArrayList<>();
       this.DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       this.ban_status_bool = false;

    }

    // Change Property [Internal Only]
    private void unlocked_changerank (@NotNull String rank) {
        switch (rank.toUpperCase()) {
            case "CHAT":
                this.rank = msg.resocurces.rank.CHAT;
                this.rankToString = "";
                this.namecolor = c.bl;
                break;
            case "VIP":
                this.rank = msg.resocurces.rank.VIP;
                this.rankToString = c.gr + "[VIP]" + c.rs;
                this.namecolor = c.gr;
                break;
            case "VIP+":
            case "VIPPLUS":
                this.rank = msg.resocurces.rank.VIPPLUS;
                this.rankToString = c.gr + "[VIP" + c.cy + "+" + c.gr + "]" + c.rs;
                this.namecolor = c.gr;
                break;
            case "MVP":
                this.rank = msg.resocurces.rank.MVP;
                this.rankToString = c.cy + "[MVP]" + c.rs;
                this.namecolor = c.cy;
                break;
            case "MVP+":
            case "MVPPLUS":
                this.rank = msg.resocurces.rank.MVPPLUS;
                this.rankToString = c.cy + "[MVP" + c.pr + "+" + c.cy + "]" + c.rs;
                this.namecolor = c.cy;
                break;
            case "MVP++":
            case "MVPPLUSPLUS":
                this.rank = msg.resocurces.rank.MVPPLUSPLUS;
                this.rankToString = c.pr + "[MVP" + c.bk + "++" + c.pr + "]" + c.rs;
                this.namecolor = c.pr;
                break;
            case "YOUTUBE":
            case "TWITCH":
            case "CONTENT":
                this.rank = msg.resocurces.rank.CONTENT;
                this.rankToString = c.rd + "[" + c.rs + "YOUTUBE" + c.rd + "]" + c.rs;
                this.namecolor = c.rd;
                break;
            case "ASSISTANT":
            case "HELPER":
                this.rank = msg.resocurces.rank.ASSISTANT;
                this.rankToString = c.rd + "[" + c.bl + "ASSISTANT" + c.rd + "]" + c.rs;
                this.namecolor = c.bl;
                break;
            case "MOD":
            case "MODERATOR":
                this.rank = msg.resocurces.rank.MODERATOR;
                this.rankToString = c.rd + "[" + c.gr + "MOD" + c.rd + "]" + c.rs;
                this.namecolor = c.bl;
                break;
            case "ADMIN":
            case "ADMINISTRATOR":
                this.rank = msg.resocurces.rank.ADMINISTRATOR;
                this.rankToString = c.rs + "[" + c.rd + "ADMIN" + c.rs + "]" + c.rs;
                this.namecolor = c.rd;
                break;
            case "OWNER":
                this.rank = msg.resocurces.rank.OWNER;
                this.rankToString = c.rd + "[OWNER]";
                this.namecolor = c.rd;
                break;
            default:
                System.out.println("");
            case "DEFAULT":
            case "NON":
                this.rank = msg.resocurces.rank.DEFAULT;
                this.namecolor = c.wh;
                this.rankToString = "";
                break;
        }
        if (this.rank == msg.resocurces.rank.DEFAULT || this.rank == msg.resocurces.rank.CHAT) {
            this.usernameToString = rankToString + namecolor + username;
        } else {
            this.usernameToString = rankToString + " " + namecolor + username;
        }
    }

    // Change Property
    public String changerank (rank newrank) {
        msg.resocurces.rank oldrank = this.rank;
        if (newrank != msg.resocurces.rank.OWNER && newrank != msg.resocurces.rank.ADMINISTRATOR && newrank != msg.resocurces.rank.MODERATOR && newrank != msg.resocurces.rank.ASSISTANT && newrank != msg.resocurces.rank.CHAT) {
            this.rank = newrank;
            return c.gr + "Successfully changed the rank of " + c.cy + username + c.gr + " from " + c.cy + oldrank + c.gr + " to " + c.cy + newrank;
        } else {
            return c.yw + "Could not change the rank of " + c.cy + username + c.yw + " to " + c.cy + newrank;
        }
    }


    public String changepassword (String username, String oldpassword, String newpassword) {

        if (username.equals(this.username) && oldpassword.equals(this.password)) {
            this.password = newpassword;
            return c.gr + "Successfully changed the password of " + c.cy + username + c.gr + " from " + c.cy + oldpassword + c.gr + " to " + c.cy + newpassword;
        } else {
            return c.yw + "Could not change the password of " + c.cy + username + c.yw + " to " + c.cy + newpassword;
        }

    }

    public String changeusername (String oldusername, String password, String newusername) {
        if (oldusername.equals(this.username) && password.equals(this.password)) {
            this.username = newusername;
            unlocked_changerank(this.rank.toString());
            return c.gr + "Successfully changed username of " + c.cy + oldusername + c.gr + " to " + c.cy + newusername;
        } else {
            return c.yw + "Could not update username of " + c.cy + oldusername + c.yw + " to " + c.cy + newusername;
        }

    }


    // Getter
    public msg.resocurces.rank getRank() {
        return rank;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName () {
        return usernameToString;
    }

    public String toString () {
        StringBuilder profile_ = new StringBuilder(namecolor + username + c.pr + "'s Account Information\n" + c.bl + "Username: ");
        profile_.append(namecolor + this.username + c.bl + "\nPassword: " + c.cy + this.password + c.bl + "\nUUID: " + c.cy + this.uuid);
        profile_.append(c.bl + "\nRank: " + rankToString + c.bl + "\nRankID: " + c.cy + this.rank + c.bl + "\nDisplay Name: " + usernameToString);

        return profile_.toString();
    }

    public String getColorCode () {
        return this.namecolor;
    }

    public String ban (Integer duration_hours, String admin_username, String admin_password) {


        for (int i = 0; i < database.accounts.size(); i++) {

            if (database.accounts.get(i).getUsername().equals(admin_username) && database.accounts.get(i).getPassword().equals(password)) { //If credentials match

                if (database.accounts.get(i).getRank() == msg.resocurces.rank.ADMINISTRATOR) { //If admin

                    date_banned.add(LocalDateTime.now());
                    hours_ban.add(duration_hours);
                    date_to_unban.add(date_banned.get(date_banned.size()).plusHours(hours_ban.get(hours_ban.size())));
                    ban_status_bool = true;

                    return "Success: " + this.getColorCode() + this.getDisplayName() + " was banned by " + database.accounts.get(i).getDisplayName() + this.getColorCode() + " for " + hours_ban.get(hours_ban.size()) + " hours. That is from " + DTF.format(date_banned.get(date_banned.size())) + " to " + DTF.format(date_to_unban.get(date_to_unban.size()));

                } else {
                    return "The account used to attempt the ban has Insufficient Permissions to ban. [301]";
                }

            }

        }


        return "The account used to attempt the ban could not be found as the Credentials are invalid. [201]";
    }

    public String unban (String admin_username, String password_or_token, String reason) {
        for (int i = 0; i < database.accounts.size(); i++) {

            if (password_or_token.equals(database.accessSystemToken(c.gr + "Automatic unban for " + this.getDisplayName())) || (database.accounts.get(i).getUsername().equals(admin_username) && database.accounts.get(i).getPassword().equals(password_or_token))) { //If credentials match

            date_banned.clear();
            hours_ban.clear();
            date_to_unban.clear();
            ban_status_bool = false;


            }
        }

        return "e";
    }

    public String check_unban_timer () {

        if (ban_status_bool) {

            if (LocalDateTime.now().isAfter(date_to_unban.get(date_to_unban.size())) || LocalDateTime.now().isEqual(date_to_unban.get(date_to_unban.size()))) {
                ban_status_bool = false;
                return "Account was unbanned.";

            } else {

                return "\"Not Yet\" - Account's unban timer has not passed yet.";
            }

        } else {
            return "Account is not banned. (How did we get here?) [420]";
        }
    }

    public Boolean getBanBooleanStatus () {
        return ban_status_bool;
    }

    public String getUnbanDate () {
        if (ban_status_bool) {
            return DTF.format(date_to_unban.get(date_to_unban.size()));
        }
        return "How did we get here? [420]";

    }
}
