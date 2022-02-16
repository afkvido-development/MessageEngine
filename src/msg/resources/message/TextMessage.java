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

/** The TextMessage class itself, the core of MessageEngine. Made 100% by gemsvidø. <p></p>
 * @author gemsvidø
 *  @since 0.0.0  */
public class TextMessage {


    /** The author of the message (Account)   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public final @NotNull Account author;

    /** The message contents (text)    <p></p>
     * @author gemsvidø
     * @since 0.0.0*/
    public final @NotNull String message;

    /** The recipient of the message (Account)   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    public final @NotNull Account recipient;

    /** The output of the message, the toString   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    private String output;

    /** The author's rendered account display name   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    protected String authorDisplay;

    /** The recipient's rendered account display name   <p></p>
     * @author gemsvidø
     * @since 0.1.0 */
    protected String recipientDisplay;

    /** Constructor initializes a new TextMessage   <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    public TextMessage (@NotNull Account auth, @NotNull String msg, @NotNull Account rcp) {
        author = auth;
        message = msg;
        recipient = rcp;


    }

    /** Rendered TextMessage   <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    public @NotNull String toString () {
        ConstructString();
        return output;
    }

    /** Constructs the String to make it ready for toString output  <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
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


