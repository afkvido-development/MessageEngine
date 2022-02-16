package msg.resources;

import org.junit.jupiter.api.Test;
import msg.i;
import java.util.Arrays;

/** All tests for the <strong>rank</strong> class. */
class rankTest {

    /** This tests the <strong>values</strong> method in the <strong>rank</strong> class. */
    @Test void values () {
        System.out.println("\nrankTest.values  [\n");
        rank[] values = rank.values();
        System.out.println(i.yellow + Arrays.toString(values));
        System.out.println(i.white + "\n]\n\n\n");

    }

    /** This tests the <strong>valueOf</strong> method in the <strong>rank</strong> class. */
    @Test void valueOf () {
        System.out.println("\nrankTest.valueOf  [\n");
        rank value = rank.valueOf("OWNER");
        System.out.println(i.yellow + value);
        value = rank.valueOf("ADMINISTRATOR");
        System.out.println(value);
        value = rank.valueOf("MODERATOR");
        System.out.println(value);
        value = rank.valueOf("YT");
        System.out.println(value);
        value = rank.valueOf("MVPPLUS2");
        System.out.println(value);
        value = rank.valueOf("MVPPLUS1");
        System.out.println(value);
        value = rank.valueOf("MVP");
        System.out.println(value);
        value = rank.valueOf("VIPPLUS1");
        System.out.println(value);
        value = rank.valueOf("VIP");
        System.out.println(value);
        value = rank.valueOf("DEFAULT");
        System.out.println(value);
        value = rank.valueOf("CHAT");
        System.out.println(value);
        System.out.println(i.white + "\n]\n\n\n");
    }

    /** Private constructor prevents utility class <strong>rankTest</strong> from being initialized. */
    private rankTest () {}

}