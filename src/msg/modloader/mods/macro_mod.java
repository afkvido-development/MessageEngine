package msg.modloader.mods;

import msg.Main;
import msg.i;
import msg.modloader.resources.Mod;
import msg.modloader.resources.Script;
import msg.resources.message.TextMessage;
import org.jetbrains.annotations.NotNull;

/** A mod that runs a script automatically when [action]
 * <p></p>
 * @author gemsvidø
 * @since 0.1.12
 * @see msg.modloader.ModLoader */
@Mod public interface macro_mod {

    /** A script of sending two extra messages every time someone sends a message
     * <p></p>
     * @author gemsvidø
     * @since 0.1.12
     * @see macro_mod */
    @Script static void tbh (@NotNull Integer r) {

        if (r == 5) {

            i.display(new TextMessage(Main.loggedin, "Macro: Message 1", i.localServer));
            i.display(new TextMessage(Main.loggedin, "Macro: Message 2", i.localServer));


        }
    }



}
