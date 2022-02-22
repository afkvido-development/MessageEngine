package msg.modloader;

import msg.modloader.mods.*; // DO NOT DELETE
import msg.i;
import org.jetbrains.annotations.NotNull;

/** ModLoader, this loads all the mods.  <p></p>
 * @author gemsvidø
 * @since 0.1.12 */
@SuppressWarnings("EmptyMethod")
public final class ModLoader {


    /*   DOCUMENTATION


    i = 0: Run mods before PreLoader or literally anything in MessageEngine
    i = 1: Run mods before run configs
    i = 2: Run mods before Version checking
    i = 3: Run mods after Version checking
    i = 4: Run mods after logging in
    i = 5: Run mods after sending a message
    i = 6: Run mods after executing a command
    i = 7: Run mods when PreLoader was unsuccessful due to PreLoading already happened.
    i = 8: Run mods after PreLoader finishes

    */


    /** List of all scripts to be loaded.  <p></p>
     * @author gemsvidø
     * @since 0.1.12 */
    private static void ScriptList (@NotNull Integer b) {

        // LOAD ALL SCRIPTS HERE


    }


    /** List of all mods to be loaded. <strong>CURRENTLY WIP</strong>   <p></p>
     * @author gemsvidø
     * @since <strong>COMING SOON</strong> */
    private static void ModList (@NotNull Integer c) {


        // WORK IN PROGRESS


    }

    /** This method loads all the mods  <p></p>
     * @author gemsvidø
     * @since 0.1.12 */
    public static void LoadMods (@NotNull String ClientToken, int p) {

        if (!ClientToken.equals(i.getToken())) {

            i.line(i.yellow + "Client token doesn't match." + i.white);

        } else {

            ScriptList(p);

        }

    }


    /** Private constructor prevents utility class <strong>ModLoader</strong> from being initialized.  <p></p>
     * @author gemsvidø */
    private ModLoader () {}


}
