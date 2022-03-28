package msg.programs;

import msg.i;
import msg.modloader.ModLoader;
import msg.version.Version;
import msg.version.enforceVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Objects;

/** PreLoader runs before you can log in   <p></p>
 * @author gemsvidø
 * @since 0.1.6 */
public @NotNull final class PreLoader {

    /** When PreLoader finishes, this is set to true, to prevent PreLoader from running multiple times  <p></p>
     * @author gemsvidø
     * @since 0.1.6 */
    private static boolean PreLoaderFinished = false;

    /** Run Configurations handle debug mode and main mode.  <p></p>
     * @author gemsvidø
     * @since 0.1.6 */
    private static void RunConfig () {

        i.line(i.gray + "[Info/PreLoader] Starting PreLoader RunConfig");

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

    /** Loads all the mods  <p></p>
     * @author gemsvidø
     * @since 0.1.6 */
    private static void loadMods (int e) {
        ModLoader.LoadMods(i.getToken(), e);
    }

    /** Prevents PreLoader from being initialized.  <p></p>
     * @author gemsvidø
     * @since 0.1.6 */
    private PreLoader () {}



    // ----------------------------------- Above: Resources, Below: PreLoading --------------

    /** The entire PreLoading process.  <p></p>
     * @author gemsvidø
     * @since 0.1.6 */
    public static void PreLoading (@NotNull @Unmodifiable Boolean Force) {

        if (Force || !PreLoaderFinished) {

            loadMods(1); // Run mods before run configs

            i.line("\nMessageEngine by gemsvido"); // I made this, so I deserve credit. shutup

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

        loadMods(8); // Run mods after PreLoader finishes
    }

    public static void PreLoading () {

        PreLoading(false);

    }


}
