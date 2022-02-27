package msg.modloader.mods;

import msg.modloader.resources.Mod;
import msg.modloader.resources.Script;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.enforceVersion;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


/** This entire class is meant for <strong>DEBUGGING</strong> purposes <strong>only</strong>.
 * You may make modified MessageEngine clients with this, but please don't abuse this debug panel.
 * <p></p>
 * @author gemsvidø
 * @since 0.1.12
 * @see msg.modloader.ModLoader */
@Mod public interface developer_mod {



    /** THIS IS A VERSION CHECK BYPASS, IT IS MEANT FOR <strong>DEBUGGING</strong> PURPOSES <strong>ONLY</strong>.
     * THIS IS NOT A "VERSION JAILBREAK". <p></p>
     * @author gemsvidø
     * @since 0.1.12
     * @see developer_mod */
    @Script static void bypassVersion (@NotNull Integer b) {

        if (b == 2) {
            enforceVersion.debug = true;
        }
    }

    /** This lets you go on a local server while offline! Useful for testing, especially when your internet goes out. <p></p>
     * @author gemsvidø
     * @since 0.1.12
     * @see developer_mod */
    @Script static void localServer (@NotNull Integer b) {

        if (b == 3) {

            login.debug = true;

            Account account = new Account("Offline", UUID.randomUUID().toString(), rank.DEFAULT, "");

            login.setAccount(account);

            }

        }

}