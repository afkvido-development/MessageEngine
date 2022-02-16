package msg.resources.commands;

import msg.i;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/** All tests for the <strong>CommandsTypes</strong> class. <p></p>
 * @author gemsvidø
 * @since 0.2.0   */
final class CommandsTypesTest {

    /** This tests the <strong>values</strong> method in the <strong>CommandsTypes</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void values () {
        System.out.println("\nCommandsTypesTest.values  [\n");
        CommandsTypes[] values = CommandsTypes.values();
        System.out.println(Arrays.toString(values));
        System.out.println(i.white + "\n]");
    }

    /** This tests the <strong>values</strong> method in the <strong>CommandsTypes</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void valueOf () {
        System.out.println("\nCommandsTypesTest.valueOf  [\n");
        CommandsTypes value = CommandsTypes.valueOf("changePassword_SC");
        System.out.println(i.yellow + value);
        value = CommandsTypes.valueOf("generateUUIDs");
        System.out.println(i.yellow + value);
        value = CommandsTypes.valueOf("login");
        System.out.println(i.yellow + value);
        value = CommandsTypes.valueOf("changePassword");
        System.out.println(i.yellow + value);
        value = CommandsTypes.valueOf("help");
        System.out.println(i.yellow + value);
        value = CommandsTypes.valueOf("ez");
        System.out.println(i.yellow + value);
        System.out.println(i.white + "\n]");
    }

    /** Private constructor prevents utility class <strong>CommandsTypesTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private CommandsTypesTest () {}
}