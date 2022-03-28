package msg.modloader.mods;

import msg.modloader.resources.*;
import msg.version.enforceVersion;

@Mod public interface MultiConnect_$mod {


    /** This is a version check bypass, it is meant for <strong>debugging</strong> purposes <strong>only</strong>.
     * This isn't meant to be a "version jailbreak". <p></p>
     * @author gemsvidø
     * @since 0.2.0
     * @see MultiConnect_$mod */
    @Mod_Main static void main () {

        enforceVersion.debug = true;

    }


}
