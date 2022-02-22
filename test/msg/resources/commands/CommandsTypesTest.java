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
        i.line("\nCommandsTypesTest.values  [\n");
        CommandsTypes[] values = CommandsTypes.values();
        i.line(Arrays.toString(values));
        i.line(i.white + "\n]\n\n\n");    }

    /** This tests the <strong>values</strong> method in the <strong>CommandsTypes</strong> class.  <p></p>
     * @author gemsvidø
     * @since 0.2.0  */
    @Test void valueOf () {
        i.line("\nCommandsTypesTest.valueOf  [\n");
        CommandsTypes value = CommandsTypes.valueOf("changePassword_SC");
        i.line(i.yellow + value);
        value = CommandsTypes.valueOf("generateUUIDs");
        i.line(i.yellow + value);
        value = CommandsTypes.valueOf("login");
        i.line(i.yellow + value);
        value = CommandsTypes.valueOf("changePassword");
        i.line(i.yellow + value);
        value = CommandsTypes.valueOf("help");
        i.line(i.yellow + value);
        value = CommandsTypes.valueOf("ez");
        i.line(i.yellow + value);
        i.line(i.white + "\n]\n\n\n");    }

    /** Private constructor prevents utility class <strong>CommandsTypesTest</strong> from being initialized. <p></p>
     * @author gemsvidø */
    private CommandsTypesTest () {}
}