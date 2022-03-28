package msg.resources.message;

import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.UUID;

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

    /** The message's ID, used to prevent the same message sent twice.  <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    protected final String messageID;

    //-----------------------------------------------------

    /** Constructor initializes a new TextMessage   <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    public TextMessage (@NotNull Account auth, @NotNull String msg, @NotNull Account rcp) {
        this.author = auth;
        this.message = msg;
        this.recipient = rcp;
        this.messageID = UUID.randomUUID().toString().replace("-", "");

    }

    /** Rendered TextMessage   <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    public @NotNull String toString () {
        return ConstructString();
    }

    /** Constructs the String to make it ready for toString output  <p></p>
     * @author gemsvidø
     * @since 0.0.0 */
    private String ConstructString () {

        authorDisplay = author.getDisplayName();
        recipientDisplay = recipient.getDisplayName();


        if (recipient.getRank() == rank.CHAT) {
            output = authorDisplay + ": " + i.white + message;
        } else {
            output = i.purple + "[" + authorDisplay + i.purple + " to " + recipientDisplay + i.purple + "]: " + i.white + message;
        }

        return output;
    }

    /** Returns the raw contents of the message. <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public @NotNull @Unmodifiable String getContent () {
        return this.message;
    }

    /** Returns the message's ID.   <p></p>
     * @author gemsvidø
     * @since 0.2.1 */
    public @NotNull @Unmodifiable String getMessageID () {
        return this.messageID;
    }


}
