package msg.modloader;

import msg.i;
import msg.programs.PreLoader;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("EmptyMethod")
public final class ModLoader {


    /*   DOCUMENTATION


    i = 1: Run mods before run configs
    i = 2: Run mods before Version checking
    i = 3: Run mods after Version checking
    i = 4: Run mods after logging in
    i = 5: Run mods after sending a message
    i = 6: Run mods after executing a command
    i = 7: Run mods when PreLoader was unsuccessful due to PreLoading already happened.
    i = 8: Run mods after PreLoader finishes

    */


    /** List of all scripts to be loaded. */
    private static void ScriptList (@NotNull Integer b) {

        // LOAD ALL SCRIPTS HERE



    }


    /** List of all mods to be loaded. <strong>CURRENTLY WIP</strong>  */
    private static void ModList (@NotNull Integer c) {


        // WORK IN PROGRESS


    }

    /** This method loads all the mods */
    public static void LoadMods (@NotNull String token, int p) {

        if (!token.equals(PreLoader.getToken())) {

            i.line(i.yellow + "PreLoader token doesn't match." + i.white);

        } else {

            ScriptList(p);

        }

    }


    /** Private constructor prevents utility class <strong>ModLoader</strong> from being initialized. */
    private ModLoader () {}


}
