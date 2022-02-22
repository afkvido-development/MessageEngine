package msg.resources;

import org.junit.jupiter.api.Test;
import msg.i;
import java.util.Arrays;

/** All tests for the <strong>rank</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0  */
class rankTest {

    /** This tests the <strong>values</strong> method in the <strong>rank</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void values () {
        i.line("\nrankTest.values  [\n");
        rank[] values = rank.values();
        i.line(i.yellow + Arrays.toString(values));
        i.line(i.white + "\n]\n\n\n");

    }

    /** This tests the <strong>valueOf</strong> method in the <strong>rank</strong> class. <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void valueOf () {
        i.line("\nrankTest.valueOf  [\n");
        rank value = rank.valueOf("OWNER");
        i.line(i.yellow + value);
        value = rank.valueOf("ADMINISTRATOR");
        i.line(value);
        value = rank.valueOf("MODERATOR");
        i.line(value);
        value = rank.valueOf("YT");
        i.line(value);
        value = rank.valueOf("MVPPLUS2");
        i.line(value);
        value = rank.valueOf("MVPPLUS1");
        i.line(value);
        value = rank.valueOf("MVP");
        i.line(value);
        value = rank.valueOf("VIPPLUS1");
        i.line(value);
        value = rank.valueOf("VIP");
        i.line(value);
        value = rank.valueOf("DEFAULT");
        i.line(value);
        value = rank.valueOf("CHAT");
        i.line(value);
        i.line(i.white + "\n]\n\n\n");
    }

    /** Private constructor prevents utility class <strong>rankTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private rankTest () {}

}