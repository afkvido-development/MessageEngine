package msg.programs;

import msg.Main;
import msg.resocurces.c;
import msg.resocurces.database;
import msg.version.Version;
import msg.version.enforceVersion;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class PreLoader {

    // Variables
    private static final String PreLoaderToken = UUID.randomUUID().toString();
    public static boolean PreLoaderFinished = false;

    // Functions




    private static @NotNull String RunConfig() {

        Main.line(c.wh + "[Info/PreLoader] Starting PreLoader RunConfig");
        String Config;
        Main.line( "MessageEngine by gemsvido");

        if (Objects.equals(System.getenv("CONFIG"), "debug")) {
            Main.line(c.yw + "Entering Debug Mode");
            Main.line(c.wh + "[Info/PreLoader] Config: debug");
            Main.line(c.wh + "[Info/PreLoader] Using " + c.yw + "debug" + c.wh + " config");
            Config = "debug";
            Main.debug_mode1 = true;
        } else {
            Main.line(c.wh + "[Info/PreLoader] Config: main");
            Main.line(c.wh + "[Info/PreLoader] Using " + c.yw + "main" + c.wh + " config");
            Config = "main";
            Main.debug_mode1 = false;

        }


        Main.mode = Config;
        return Config;



    }

    private static void line(String input) {
        System.out.print(input + "\n" + c.rs);
    }

    private static void database () {
        database.load();
    }

    public static String getToken () {
        return PreLoaderToken;
    }



    // ----------------------------------- Above: Resources, Below: PreLoading --------------


    public static void PreLoading (boolean Force) {

        if (Force || !PreLoaderFinished) {


            // Run Configs

            String preloading = RunConfig();

            if (preloading.equals("exit")) {
                line("Exit");
                line(c.wh + "[Info] PreLoader returned exit, exiting program" + c.rs);
                System.exit(0);
            }


            // Database

            line(c.wh + "[Info/PreLoader] Loading database...");
            database();
            line(c.wh + "[Info/PreLoader] Loaded database.");

            // Version

            enforceVersion.fire();

            line(c.rs + "[Info] Running MessageEngine " + Version.Version);



        } else {
            line(c.rd + "[Error] PreLoader cannot run because PreLoader has already run.");
            line(c.wh + "[Info] This can be fixed by forcing preloader, however that may cause corruption");
        }
    }


}