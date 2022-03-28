package msg.modloader.mods;

import msg.i;
import msg.modloader.resources.Mod;
import msg.modloader.resources.Mod_Main;
import msg.modloader.resources.Script;
import org.jetbrains.annotations.NotNull;


/** I'm testing out some experimental features to put into MessageEngine, and they will be tested here.
 * <p></p>
 * @author gemsvidø
 * @since 0.2.0
 * @see msg.modloader.ModLoader */
@Mod public interface Experimental_$mod {

    @Mod_Main static void main () {
        i.line(i.gray + "[Info/Experimental] Enabling Experiments...");
        i.enableExperiments = true;
        i.line(i.gray + "[Info/Experimental] Experiments are now enabled.");
    }


    /** I'll add an experimental feature here soonTM <p></p>
     * Experiment ID: <code>e1104588</code> <br></br>
     * Experiment Status: Developing
     * <p></p>
     * @author gemsvidø
     * @since 0.2.0
     * @see Experimental_$mod */
    @Script static void e1104588 (@NotNull Integer b) {

        if (!i.enableExperiments) {

            i.line(i.gray + "[Info/Experimental]" + i.red + " Script " + i.cyan + "e1104588" + i.red + " was not run because experimental is disabled.");

        } else if (!(b == 1)) {

            // Do nothing

        } else {

            // Run the script


        }

    }

    /** I'll add an experimental feature here soonTM <p></p>
     * Experiment ID: <code>a8283146</code> <br></br>
     * Experiment Status: Developing
     * <p></p>
     * @author gemsvidø
     * @since 0.2.0
     * @see Experimental_$mod */
    @Script static void a8283146 (@NotNull Integer b) {

        if (!i.enableExperiments) {

            i.line(i.gray + "[Info/Experimental]" + i.red + " Script " + i.cyan + "a8283146" + i.red + " was not run because experimental is disabled.");

        } else if (!(b == 1)) {

            // Do nothing

        } else {

            // Run the script


        }
    }

    /** I'll add an experimental feature here soonTM <p></p>
     * Experiment ID: <code>e636581f</code> <br></br>
     * Experiment Status: Developing
     * <p></p>
     * @author gemsvidø
     * @since 0.2.0
     * @see Experimental_$mod */
    @Script static void e636581f (@NotNull Integer b) {

        if (!i.enableExperiments) {

            i.line(i.gray + "[Info/Experimental]" + i.red + " Script " + i.cyan + "e636581f" + i.red + " was not run because experimental is disabled.");

        } else if (!(b == 1)) {

            // Do nothing

        } else {

            // Run the script


        }
    }

}
