package msg.resocurces.account;

import msg.resocurces.c;
import msg.resocurces.rank;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Account {

    protected String username;
    protected String password;
    protected String uuid;
    protected msg.resocurces.rank rank;
    protected String rankToString;
    protected String namecolor;
    protected String usernameToString;
    protected String connection_token;

    public String getPassword() {
        return password;
    }


    // Constructor
    public Account (@NotNull String username, @NotNull String password, @NotNull rank r_, @NotNull String predetermineduuid) {
        this.username = username;
        this.password = password;

        if (predetermineduuid.equals("")) {
            this.uuid = UUID.randomUUID().toString();
        } else {
            this.uuid = predetermineduuid;
        }

        unlocked_changerank(r_);


    }

    // Change Property [Internal Only]
    private void unlocked_changerank (@NotNull rank r) {

        this.rank = r;

        switch (r) {
            case OWNER -> this.rankToString = c.rd + "[OWNER]";
            case ADMINISTRATOR -> this.rankToString = c.rs + "[" + c.rd + "ADMIN" + c.rs + "]";
            case MODERATOR -> this.rankToString = c.pr + "[MOD]";
            case YT -> this.rankToString = c.rd + "[YOU" + c.rs + "TUBE" + c.rd + "]";
            case MVPPLUS2 -> this.rankToString = c.cy + "[MVP" + c.bl + "+" + c.bk + "+" + c.cy + "]";
            case MVPPLUS1 -> this.rankToString = c.cy + "[MVP" + c.pr + "+" + c.cy + "]";
            case MVP -> this.rankToString = c.cy + "[MVP]";
            case VIPPLUS1 -> this.rankToString = c.gr + "[VIP" + c.rd + "+" + c.gr + "]";
            case VIP -> this.rankToString = c.gr + "[VIP]";
            case DEFAULT -> this.rankToString = c.wh + "";
            case CHAT -> this.rankToString = c.bl + "[CHAT]";
        }

        switch (r) {
            case OWNER, ADMINISTRATOR, YT -> this.namecolor = c.rd;
            case MODERATOR -> this.namecolor = c.pr;
            case MVPPLUS2, MVPPLUS1, MVP -> this.namecolor = c.cy;
            case VIPPLUS1, VIP -> this.namecolor = c.gr;
            case DEFAULT -> this.namecolor = c.wh;

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
        if (newrank != msg.resocurces.rank.OWNER && newrank != msg.resocurces.rank.ADMINISTRATOR && newrank != msg.resocurces.rank.MODERATOR && newrank != msg.resocurces.rank.CHAT) {
            unlocked_changerank(newrank);
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
            unlocked_changerank(this.rank);
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

        return namecolor + username + c.pr + "'s Account Information\n" + c.bl + "Username: " + namecolor + this.username + c.bl + "\nPassword: " + c.cy + this.password + c.bl + "\nUUID: " + c.cy + this.uuid +
                c.bl + "\nRank: " + rankToString + c.bl + "\nRankID: " + c.cy + this.rank + c.bl + "\nDisplay Name: " + usernameToString;
    }

    public String getColorCode () {
        return this.namecolor;
    }

    public void createConnectionToken () {
        connection_token = UUID.randomUUID().toString();
    }

    public String requestConnectionToken () {
        return connection_token;
    }

    public void resetConnectionToken () {
        connection_token = null;
    }
}
