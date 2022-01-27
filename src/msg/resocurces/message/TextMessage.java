/**
 * TextMessage class, returns a text message with the toString function.
 * Parameters: Author, Message, Recipient
 * It is very convenient to make a simple messaging system in your own server.
 * REQUIRES ACCOUNT CLASS, COLORCODE BANK, RANK EMUM
 *
 * Made by gemsvido
 * @gemsvido - twitch.tv/gemsvido
 **/

package msg.resocurces.message;
import msg.resocurces.account.Account;
import msg.resocurces.c;
import msg.resocurces.rank;

public class TextMessage {

    private Account author;
    private String message;
    private Account recipient;
    private String output;
    private String authordisplay;
    private String recipientdisplay;

    public TextMessage(Account auth, String msg, Account rcp) {
        author = auth;
        message = msg;
        recipient = rcp;


    }

    public String toString() {

        FlickSwitches();
        ConstructString();
        return output;


    }

    public String send() {

        FlickSwitches();
        ConstructString();

        return output;


    }




    private void ConstructString() {
        if (recipient.getRank() == rank.CHAT) {
            output = authordisplay + ": " + c.rs + message;
        } else {
            output = c.pr + "[" + authordisplay + c.pr + " to " + recipientdisplay + c.pr + "]: " + c.rs + message;
        }
    }

    private void FlickSwitches() {
        authordisplay = author.getDisplayName();
        recipientdisplay = recipient.getDisplayName();

        }
}


