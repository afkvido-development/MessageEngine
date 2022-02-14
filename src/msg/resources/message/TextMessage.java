/**
 * TextMessage class, returns a text message with the toString function.
 * Parameters: Author, Message, Recipient
 * It is very convenient to make a simple messaging system in your own server.
 * REQUIRES ACCOUNT CLASS, COLORCODE BANK, RANK ENUM
 *
 * Made by gemsvidø - https://github.com/afkvido
 **/

package msg.resources.message;
import msg.resources.account.Account;
import msg.i;
import msg.resources.rank;
import org.jetbrains.annotations.NotNull;

public class TextMessage {

    public final @NotNull Account author;
    public final @NotNull String message;
    public final @NotNull Account recipient;
    private String output;
    protected String authorDisplay;
    protected String recipientDisplay;

    public TextMessage (@NotNull Account auth, @NotNull String msg, @NotNull Account rcp) {
        author = auth;
        message = msg;
        recipient = rcp;


    }

    public @NotNull String toString () {
        ConstructString();
        return output;
    }

    private void ConstructString () {

        authorDisplay = author.getDisplayName();
        recipientDisplay = recipient.getDisplayName();


        if (recipient.getRank() == rank.CHAT) {
            output = authorDisplay + ": " + i.white + message;
        } else {
            output = i.purple + "[" + authorDisplay + i.purple + " to " + recipientDisplay + i.purple + "]: " + i.white + message;
        }
    }


}


