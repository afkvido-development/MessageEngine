package msg.programs;

import msg.i;
import msg.modloader.ModLoader;
import msg.version.Version;
import msg.version.enforceVersion;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

/** PreLoader runs before you can log in */
public @NotNull final class PreLoader {

    /** PreLoader token to ensure things like mods only load when permitted */
    private static final String PreLoaderToken = UUID.randomUUID().toString();

    /** When PreLoader finishes, this is set to true, to prevent PreLoader from running multiple times */
    private static boolean PreLoaderFinished = false;

    /** Run Configurations handle debug mode and main mode. */
    private static void RunConfig () {

        i.line(i.gray + "[Info/PreLoader] Starting PreLoader RunConfig");
        i.line( "MessageEngine by gemsvido");

        if (Objects.equals(System.getenv("CONFIG"), "debug")) {
            i.line(i.yellow + "Entering Debug Mode");
            i.line(i.gray + "[Info/PreLoader] Config: debug");
            i.line(i.gray + "[Info/PreLoader] Using " + i.yellow + "debug" + i.gray + " config");
            i.debugMode = true;
        } else {
            i.line(i.gray + "[Info/PreLoader] Config: main");
            i.line(i.gray + "[Info/PreLoader] Using " + i.yellow + "main" + i.gray + " config");
            i.debugMode = false;

        }


    }

    /** Obtains the PreLoader Token, used for loading things like mods */
    public static String getToken () { return PreLoaderToken; }

    /** Loads all the mods */
    private static void loadMods (int i) { ModLoader.LoadMods(getToken(), i); }

    /** Prevents PreLoader from being initialized. */
    private PreLoader () {}



    // ----------------------------------- Above: Resources, Below: PreLoading --------------

    /** The entire PreLoading process. */
    public static void PreLoading (boolean Force) {

        if (Force || !PreLoaderFinished) {

            loadMods(1); // Run mods before run configs
            RunConfig(); // Run Configs

            loadMods(2); // Run mods before Version checking
            enforceVersion.fire(); // Check version
            i.line(i.white + "[Info] Running MessageEngine " + Version.Version); // Announce version
            loadMods(3); // Run mods after Version checking

            PreLoaderFinished = true;

        } else {

            loadMods(7); // Run mods when PreLoader was unsuccessful due to PreLoading already happened.
            i.line(i.red + "[Error] PreLoader cannot run because PreLoader has already run.");
            i.line(i.gray + "[Info] This can be fixed by forcing preloader, however that may cause corruption");
        }

        loadMods(7); // Run mods after PreLoader finishes
    }


}
