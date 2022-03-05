package msg.version;

import msg.i;
import org.junit.jupiter.api.Test;

/** All tests for the <strong>UrlReader</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
class UrlReaderTest {

    /** This tests the <strong>check</strong> method in the <strong>UrlReader</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void check () {
        i.line("\nUrlReaderTest.check  [\n");

        String e = "";
        try {
            e = UrlReader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/API.yml");
        } catch (Exception i) {
            i.printStackTrace();
        }
        i.line(e);
        i.line(i.white + "\n]\n\n\n");
    }

    /** Private constructor prevents utility class <strong>UrlReaderTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private UrlReaderTest() {}
}