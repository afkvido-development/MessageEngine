package msg.resources.message;

import msg.resources.account.Account;
import msg.i;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>TextMessage</strong> class. */
class TextMessageTest {

    /** This tests the <strong>toString</strong> method in the <strong>TextMessage</strong> class. */
    @Test void testToString () {
        System.out.println("\nTextMessageTest.testToString  [\n");
        Account account = new Account("Author Username", "Author Password", rank.MVP);
        Account recipient = new Account("Recipient Username", "Recipient Password", rank.MVPPLUS2);
        TextMessage message = new TextMessage(account, "Message Text", recipient);
        System.out.println(message);
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>TextMessageTest</strong> from being initialized. */
    private TextMessageTest () {}
}