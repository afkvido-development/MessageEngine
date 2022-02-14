package msg.modloader.mods;

import msg.Main;
import msg.i;
import msg.modloader.resources.Mod;
import msg.modloader.resources.Script;
import msg.resources.message.TextMessage;
import org.jetbrains.annotations.NotNull;

@Mod public interface macro {

    @Script static void tbh (@NotNull Integer r) {

        if (r == 5) {

            i.display(new TextMessage(Main.loggedin, "Macro: Message 1", i.localServer));
            i.display(new TextMessage(Main.loggedin, "Macro: Message 2", i.localServer));


        }
    }

}
