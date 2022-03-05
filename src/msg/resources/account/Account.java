package msg.resources.account;

import msg.i;
import msg.resources.rank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.UUID;

/** The Account class, customizable with ranks, usernames, passwords, and UUIDs!
 * This class is the most chaotic and glitchy part of MessageEngine.   <p></p>
 * @author gemsvidø
 * @since 0.1.0 */
public class Account {

    //-----------------------------------------------------------
    // Variables (Protected)
    //-----------------------------------------------------------


    /** Account username   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    protected @NotNull String username;

    /** Account password   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    protected @NotNull String password;

    /** Account UUID. Generated/Decided on construct, stays final.   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    protected @NotNull final String uuid;

    /** Account rank.   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    protected rank rank;

    /** Rendered account rank   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    protected String rankToString;

    /** Name color of the rendered account display, usually decided by a rank.   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    protected String namecolor;

    /** Rendered account username   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    protected String usernameToString;

    /** Account login tokens   <p></p>
     * @author gemsvidø
     * @since 0.2.1  */
    protected ArrayList<String> tokens;






    //-----------------------------------------------------------
    // Constructors (Public)
    //-----------------------------------------------------------

    /** Construct an account with a pre-determined UUID.   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    public Account (@NotNull String username, @NotNull String password, @NotNull rank rank, @Nullable String uuid) {
        this.username = username;
        this.password = password;

        if (uuid == null || uuid.equals("")) {
            this.uuid = UUID.randomUUID().toString();
        } else {
            this.uuid = uuid;
        }

        changeRank_(rank);


    }

    /** Construct an account with a randomly generated UUID.   <p></p>
     * @author gemsvidø
     * @since 0.1.13 */
    public Account (@NotNull String username, @NotNull String password, @NotNull rank rank) {
        this.username = username;
        this.password = password;
        this.uuid = UUID.randomUUID().toString();
        changeRank_(rank);


    }






    //-----------------------------------------------------------
    // Change Property (Private)
    //-----------------------------------------------------------

    /** Change the rank of the account <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    private void changeRank_ (@NotNull rank newRank) {

        this.rank = newRank;

        switch (newRank) {
            case OWNER -> this.rankToString = i.red + "[OWNER]";
            case ADMINISTRATOR -> this.rankToString = i.white + "[" + i.red + "ADMIN" + i.white + "]";
            case MODERATOR -> this.rankToString = i.purple + "[MOD]";
            case YT -> this.rankToString = i.red + "[YOU" + i.white + "TUBE" + i.red + "]";
            case MVPPLUS2 -> this.rankToString = i.cyan + "[MVP" + i.blue + "+" + i.black + "+" + i.cyan + "]";
            case MVPPLUS1 -> this.rankToString = i.cyan + "[MVP" + i.purple + "+" + i.cyan + "]";
            case MVP -> this.rankToString = i.cyan + "[MVP]";
            case VIPPLUS1 -> this.rankToString = i.green + "[VIP" + i.red + "+" + i.green + "]";
            case VIP -> this.rankToString = i.green + "[VIP]";
            case DEFAULT -> this.rankToString = i.gray + "";
            case CHAT -> this.rankToString = i.blue + "[CHAT]";
        }

        switch (newRank) {
            case OWNER, ADMINISTRATOR, YT -> this.namecolor = i.red;
            case MODERATOR -> this.namecolor = i.purple;
            case MVPPLUS2, MVPPLUS1, MVP -> this.namecolor = i.cyan;
            case VIPPLUS1, VIP -> this.namecolor = i.green;
            case DEFAULT -> this.namecolor = i.gray;

        }

        if (this.rank == msg.resources.rank.DEFAULT || this.rank == msg.resources.rank.CHAT) {
            this.usernameToString = rankToString + namecolor + username;
        } else {
            this.usernameToString = rankToString + " " + namecolor + username;
        }
    }

    /** Change the password of the account   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    private void changePassword_ (@NotNull String newPassword) {
        this.password = newPassword;
    }

    /** Change the username of the account    <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    private void changeUsername_ (@NotNull String newUsername) {
        this.username = newUsername;

        if (this.rank == msg.resources.rank.DEFAULT || this.rank == msg.resources.rank.CHAT) {
            this.usernameToString = rankToString + namecolor + username;
        } else {
            this.usernameToString = rankToString + " " + namecolor + username;
        }

    }







    //-----------------------------------------------------------
    // Change Property (Public)
    //-----------------------------------------------------------

    public void changePassword (@NotNull String username, @NotNull String oldPassword, @NotNull String newPassword) {

        if (username.equals(this.username) && oldPassword.equals(this.password)) {
            changePassword_(newPassword);
            i.debugLine("Info", i.green + "Successfully changed the password of " + i.cyan + username + i.green + " from " + i.cyan + oldPassword + i.green + " to " + i.cyan + newPassword);
        } else {
            i.debugLine("Info", i.yellow + "Could not change the password of " + i.cyan + username + i.yellow + " to " + i.cyan + newPassword);
        }

    }

    public void changeUsername (@NotNull String oldUsername, @NotNull String password, @NotNull String newUsername) {

        if (oldUsername.equals(this.username) && password.equals(this.password)) {
            changeUsername_(newUsername);
            i.debugLine("Info", i.green + "Successfully changed username of " + i.cyan + oldUsername + i.green + " to " + i.cyan + newUsername);
        } else {
            i.debugLine("Info", i.yellow + "Could not update username of " + i.cyan + oldUsername + i.yellow + " to " + i.cyan + newUsername);
        }

    }





    //-----------------------------------------------------------
    // Getter (Public)
    //-----------------------------------------------------------

    /** Returns a summary of the account, including some potentially sensitive information.    <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public @NotNull String toString () {
        return namecolor + username + i.purple + "'s Account Information\n" + i.blue + "Username: "
        + namecolor + this.username + i.blue + "\nPassword: " + i.cyan + this.password + i.blue + "\nUUID: "
        + i.cyan + this.uuid + i.blue + "\nRank: " + rankToString + i.blue + "\nRankID: " + i.cyan + this.rank + i.blue
        + "\nDisplay Name: " + usernameToString;
    }

    /** Returns the account's rank   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    public @NotNull rank getRank () { return rank; }

    /** Returns the account's username   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    public @NotNull String getUsername () { return username; }

    /** Returns the account's display name.   <p></p>
     * @author gemsvidø
     * @since 0.1.0  */
    public @NotNull String getDisplayName () {
        return usernameToString;
    }

    /** Returns the account's ANSI color code.   <p></p>
     * @author gemsvidø
     * @since 0.1.11 */
    public @NotNull String getColorCode () {
        return this.namecolor;
    }

    /** Get the account's password.   <p></p>
     * @author gemsvidø
     * @since 0.1.0   */
    public @NotNull String getPassword () {
        return password;
    }

    /** Get the account's UUID.   <p></p>
     * @author gemsvidø
     * @since 0.2.1   */
    public @NotNull String getUUID () {
        return this.uuid;
    }





    //-----------------------------------------------------------
    // Login token (Public)
    //-----------------------------------------------------------

    /** Create a new connection token for the account   <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public void newLoginToken () {
        if (tokens == null) {
            tokens = new ArrayList<>();
        }
        tokens.add(UUID.randomUUID().toString());
    }

    /** Requests the login tokens of the account. If successful, the tokens will be returned as an <code>ArrayList<*String></code>  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public @Nullable ArrayList<String> requestLoginToken () {

        // Coming soon

        /*


        if (something) {
        return tokens;
        } else {
        return null;
        }



         */


        return tokens;
    }

    /** Sets the account's login tokens to <code>null</code>    <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public void nullLoginTokens () {
        tokens = null;
    }

    /** Clears all of the account's login tokens. <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public void clearLoginTokens () {
            tokens.clear();
    }

    /** Sets an amount of the account's login tokens to <code>null</code>    <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public void clearLoginTokens (int Amount) {

        for (int i = 0; i < Amount; i++) {
            tokens.remove(i);
        }
    }


}
