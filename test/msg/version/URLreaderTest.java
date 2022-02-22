package msg.version;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>URLreader</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
class URLreaderTest {

    /** This tests the <strong>check</strong> method in the <strong>URLreader</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void check () {
        i.line("\nURLreaderTest.check  [\n");

        String e = "";
        try {
            e = msg.version.URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/API.yml");
        } catch (Exception i) {
            i.printStackTrace();
        }
        i.line(e);
        i.line(i.white + "\n]\n\n\n");
    }

    /** Private constructor prevents utility class <strong>URLreaderTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private URLreaderTest () {}
}