package msg.modloader.mods;

import msg.modloader.resources.Mod;
import msg.modloader.resources.Script;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import msg.resources.rank;
import msg.version.enforceVersion;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


/** THIS IS MEANT FOR <strong>DEBUGGING</strong> PURPOSES <strong>ONLY</strong>. THIS IS NOT A "JAILBREAK". You may make modified MessageEngine clients with this, but please don't abuse this debug panel. */
@Mod public interface developer {



    /** THIS IS A VERSION CHECK BYPASS, IT IS MEANT FOR <strong>DEBUGGING</strong> PURPOSES <strong>ONLY</strong>. THIS IS NOT A "VERSION JAILBREAK". */
    @Script static void bypassVersion (@NotNull Integer b) { if (b == 2) enforceVersion.debug = true; }

    @Script static void localServer (@NotNull Integer b) {


        if (b == 3) {

            login.debug = true;

            Account account = new Account("Offline", UUID.randomUUID().toString(), rank.DEFAULT, "");

            login.setAccount(account);

            }

        }


}
