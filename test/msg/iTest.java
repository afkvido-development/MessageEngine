package msg;

import msg.resources.account.Account;
import msg.resources.message.TextMessage;
import msg.resources.rank;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>i</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
final class iTest {

    /** This tests the <strong>line</strong> method in the <strong>i</strong> class, with a <strong>String</strong> passed in VarArgs <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testline1 () {
        System.out.println("\niTest.testline1  [\n");
        i.line("Test");
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>line</strong> method in the <strong>i</strong> class, with an <strong>Object</strong> passed in VarArgs <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testLine2 () {
        System.out.println("\niTest.testLine2  [\n");
        Object obj = new Object();
        i.line(obj);
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>line</strong> method in the <strong>i</strong> class, with nothing passed in VarArgs, printing an empty line. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testLine3 () {
        System.out.println("\niTest.testLine3  [\n");
        i.line();
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>line</strong> method in the <strong>i</strong> class, with an <strong>integer</strong> passed in VarArgs <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testLine4 () {
        System.out.println("\niTest.testLine4  [\n");
        i.line(69);
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>text</strong> method in the <strong>i</strong> class, with a <strong>String</strong> passed in VarArgs <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testText1 () {
        System.out.println("\niTest.testText1  [\n");
        i.text("Test");
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>text</strong> method in the <strong>i</strong> class, with an <strong>Object</strong> passed in VarArgs <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testText2 () {
        System.out.println("\niTest.testText2  [\n");
        Object obj = new Object();
        i.text(obj);
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>text</strong> method in the <strong>i</strong> class, with nothing passed in VarArgs, printing literally nothing. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testText3 () {
        System.out.println("\niTest.testText3  [\n");
        i.text();
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>text</strong> method in the <strong>i</strong> class, with an <strong>integer</strong> passed in VarArgs <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testText4 () {
        System.out.println("\niTest.testText4  [\n");
        i.line(69);
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>cb</strong> ClipBored in the <strong>i</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void testClipBoard () {
        i.line("\niTest.testClipBoard  [\n");

        i.cb.Copy("Copied text to ClipBoard");

        i.text("Print method: " + i.cyan);
        i.cb.Print();

        i.text("\nLine method: " + i.cyan);
        i.cb.PrintLine();

        i.text("GetContents method: "  + i.cyan + i.cb.GetContents());

        i.line(i.white + "\n]\n\n\n");
    }


    /** This tests the <strong>debugLine</strong> method in the <strong>i</strong> class, with debug mode <strong>on</strong>.  <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    @Test void debugLineYesDebug () {
        System.out.println("\niTest.debugLineYesDebug  [\n");
        i.debugMode = true;
        i.debugLine("Test", "Debug line works!");
        System.out.println(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>debugLine</strong> method in the <strong>i</strong> class, with debug mode <strong>off</strong>. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void debugLineNoDebug () {
        System.out.println("\niTest.debugLineNoDebug  [\n");
        i.debugMode = false;
        i.debugLine("Test", "Debug line works!");
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>display</strong> method in the <strong>i</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void display () {
        System.out.println("\niTest.display  [\n");
        Account afi = new Account("Author for i", "AFI password", rank.VIP);
        TextMessage msg = new TextMessage(afi, "Message Text for display()", i.localServer);
        i.display(msg);
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>message</strong> method in the <strong>i</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void message () {
        System.out.println("\niTest.message  [\n");
        Account afi = new Account("Author for i", "AFM password", rank.VIP);
        TextMessage msg = new TextMessage(afi, "Message Text for message()", i.localServer);
        i.display(msg);
        System.out.println(i.white + "\n]\n\n\n");    }


    /** This tests the <strong>ProcessInput</strong> method in the <strong>i</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void ProcessInput () {
        System.out.println("\niTest.ProcessInput  [\n");
        Main.loggedin = new Account("ProcessInput Tester", "ProcessInput Tester Password", rank.MVPPLUS2);
        i.ServerAddress = "gemvido/AlphaCS";
        i.ProcessInput("/generatenewuuids"); // Generate new UUIDs
        i.ProcessInput("Hello"); // Send a chat message
        i.ProcessInput("/help"); // Help command
        i.ProcessInput("LMAOOOOOOOOO"); // Send a chat message
        i.ProcessInput("/uhfpiahhawihawif"); // Unknown command
        System.out.println(i.white + "\n]\n\n\n");
    }


    /** This tests the <strong>getToken</strong> method in the <strong>i</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void getToken () {
        i.line("\niTest.getToken  [\n");
        i.line("Token: " + i.cyan + i.getToken());
        i.line(i.white + "\n]\n\n\n");
    }


    /** This tests the <strong>info</strong> method in the <strong>i</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void info () {
        i.line("\niTest.info  [\n");
        i.info("Text");
        i.line(i.white + "\n]\n\n\n");
    }


    /** Private constructor prevents utility class <strong>iTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private iTest () {}
}