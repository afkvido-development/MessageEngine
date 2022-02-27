package msg.resources.message;

import msg.i;
import msg.resources.account.Account;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>TextMessage</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0   */
class TextMessageTest {

    /** This tests the <strong>toString</strong> method in the <strong>TextMessage</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0   */
    @Test void testToString () {
        i.line("\nTextMessageTest.testToString  [\n");
        Account account = new Account("Author Username", "Author Password", rank.MVP);
        Account recipient = new Account("Recipient Username", "Recipient Password", rank.MVPPLUS2);
        TextMessage message = new TextMessage(account, "Message Text", recipient);
        i.line(message);
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>TextMessageTest</strong> from being initialized. <p></p>
     * @author gemsvidø  */
    private TextMessageTest () {}
}