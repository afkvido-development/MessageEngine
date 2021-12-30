package msg.programs;

import msg.Main;
import msg.resocurces.c;
import msg.resocurces.database;
import msg.v.Version;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.UUID;

public class PreLoader {

    // Variables
    public static final String PreLoaderToken = UUID.randomUUID().toString();
    public static boolean PreLoaderFinished = false;

    // Functions

    private static @NotNull String RunConfig() {

        Main.line(c.wh + "[Info/PreLoader] Starting PreLoader RunConfig");

        String Config;



        if (System.getenv("RUN") == null) {
            Main.line(c.wh + "[Info/PreLoader] Run configuration invalid, " + c.rd + "throwing error");
            Main.line(c.rd + "Invalid run configuration. [902]" + c.rs);
            Main.line("Check the wiki for more information: https://github.com/afkvido/MessageEngine/wiki/Error-Codes#error-code-list");
            Scanner wait1 = new Scanner(System.in);
            String wait2 = wait1.nextLine();

            if (wait2.equals("/configbypass missingENV")) {
                Main.line(c.wh + "[Info/PreLoader] Bypassing Run Configuration for missing environment variable" + c.rs);
                Main.line("Run configuration has been bypassed. Please remember that some features may be faulty." + c.rs);
                Main.c_log.logcmd("Run configuration bypassed, running with no run ENV. /configbypass missingENV", database.empty);
                Config = "bypass_missingENV";
                Main.debug_mode1 = false;
                Main.line(c.wh + "[Info/PreLoader] Variables set");

            } else if (wait2.startsWith("/configbypass")) {
                Main.line("Invalid configuration bypass.");
                Main.line(c.wh + "[Info/PreLoader] Configbypass passed without proper arguments, exiting program" + c.rs);
                return "exit";
            } else {
                return "exit";
            }
        } else {

            if (System.getenv("RUN").equals("debug")) {
                Main.line( "MessageEngine by gemsvido");
                Main.line(c.yw + "Entering Debug Mode");
                Main.line(c.wh + "[Info/PreLoader] Config: Debug");
                Main.line(c.wh + "[Info/PreLoader] Using " + c.yw + "debug" + c.wh + " config");
                Config = "debug";
                Main.debug_mode1 = true;
            } else if (System.getenv("RUN").equals("main")) {
                Main.line("MessageEngine by gemsvido");
                Main.line(c.wh + "[Info/PreLoader] Config: Main");
                Main.line(c.wh + "[Info/PreLoader] Using " + c.cy + "main" + c.wh + " config");
                Config = "main";
                Main.debug_mode1 = false;
            } else {

                Main.line(c.wh + "[Info/PreLoader] InvalidENV detected, throwing error 901");
                Main.line(c.rd + "Invalid run configuration. [901]");
                Main.line("Check the wiki for more information: https://github.com/afkvido/MessageEngine/wiki/Error-Codes#error-code-list");
                Scanner wait1 = new Scanner(System.in);
                String wait2 = wait1.nextLine();

                if (wait2.equals("/configbypass invalidENV")) {
                    Main.line("Run configuration has been bypassed. Please remember that some features may be faulty.");
                    Main.c_log.logcmd("Run configuration bypassed, running with an invalid run ENV. /configbypass invalidENV", database.empty);
                    Main.line(c.wh + "[Info/PreLoader] Bypassing run configuration, invalidENV");
                    Config = "bypass_invalidENV";
                    Main.debug_mode1 = false;

                } else if (wait2.startsWith("/configbypass")) {
                    Main.line("Invalid configuration bypass.");
                    return "exit";
                }
                else {
                    return "exit";
                }
            }
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



    // ----------------------------------- Above: Resources, Below: PreLoading


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

            line(c.rs + "[Info] Running MessageEngine " + Version.Version);



        } else {
            line(c.rd + "[Error] PreLoader cannot run because PreLoader has already run.");
            line(c.wh + "[Info] This can be fixed by forcing preloader, however that may cause corruption");
        }
    }


}
