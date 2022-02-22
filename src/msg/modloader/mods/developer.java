package msg.modloader.mods;

import msg.Main;
import msg.i;
import msg.modloader.ModLoader;
import msg.modloader.resources.Mod;
import msg.modloader.resources.Script;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import msg.resources.commands.Commands;
import msg.resources.message.TextMessage;
import msg.resources.rank;
import msg.version.URLreader;
import msg.version.enforceVersion;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;


/** This entire class is meant for <strong>DEBUGGING</strong> purposes <strong>only</strong>.
 * You may make modified MessageEngine clients with this, but please don't abuse this debug panel.
 * <p></p>
 * @author gemsvidø
 * @since 0.1.12
 * @see msg.modloader.ModLoader */
@Mod public interface developer {



    /** THIS IS A VERSION CHECK BYPASS, IT IS MEANT FOR <strong>DEBUGGING</strong> PURPOSES <strong>ONLY</strong>.
     * THIS IS NOT A "VERSION JAILBREAK". <p></p>
     * @author gemsvidø
     * @since 0.1.12
     * @see msg.modloader.mods.developer */
    @Script static void bypassVersion (@NotNull Integer b) {

        if (b == 2) {
            enforceVersion.debug = true;
        }
    }

    /** This lets you go on a local server while offline! Useful for testing, especially when your internet goes out. <p></p>
     * @author gemsvidø
     * @since 0.1.12
     * @see msg.modloader.mods.developer */
    @Script static void localServer (@NotNull Integer b) {

        if (b == 3) {

            login.debug = true;

            Account account = new Account("Offline", UUID.randomUUID().toString(), rank.DEFAULT, "");

            login.setAccount(account);

            }

        }

    /** This lets you completely run MessageEngine without internet, how nice! <p></p>
     * @author gemsvidø
     * @since 0.1.12
     * @see msg.modloader.mods.developer */
    @Script static void fullOffline (@NotNull Integer b) {

        if (b == 0) {

            // Run configurations

            if (System.getenv("CONFIG") != null && System.getenv("CONFIG").equals("debug")) {
                i.line(i.yellow + "Entering Debug Mode");
                i.line(i.gray + "[Info/PreLoader] Config: debug");
                i.line(i.gray + "[Info/PreLoader] Using " + i.yellow + "debug" + i.gray + " config");
                i.debugMode = true;
            } else {
                i.line(i.gray + "[Info/PreLoader] Config: main");
                i.line(i.gray + "[Info/PreLoader] Using " + i.yellow + "main" + i.gray + " config");
                i.debugMode = false;

            }

            // User
            login.debug = true;
            Account account = new Account("username", UUID.randomUUID().toString(), rank.ADMINISTRATOR);
            login.setAccount(account);

            i.line( "MessageEngine by gemsvido"); // I made this, so I deserve credit. shutup
            i.line(Main.loggedin.getColorCode() + "Welcome, " + Main.loggedin.getDisplayName());



            String Input;
            Scanner scan = new Scanner(System.in);


            // A replica of The loop, where you can chat and use commands.
            while (true) {

                // Saves user input to a public static String
                Input = scan.nextLine();

                // Replica of ProcessInput


                TextMessage nextmsg;

                if (Input.startsWith("/")) {

                    boolean serverCommand = false;

                    switch (Input.toLowerCase()) {
                        case "/logout", "/login" -> {

                         Scanner login = new Scanner(System.in);
                         i.text(i.yellow + "Set username: ");
                         Main.loggedin.changeUsername(Main.loggedin.getUsername(), Main.loggedin.getPassword(), login.nextLine());
                         i.text(i.yellow + "Set password: ");
                         Main.loggedin.changePassword(Main.loggedin.getUsername(), Main.loggedin.getPassword(), login.nextLine());
                         i.text(i.yellow + "Set rank: ");

                         try {
                             Main.loggedin = new Account(Main.loggedin.getUsername(), Main.loggedin.getPassword(), rank.valueOf(login.nextLine().toUpperCase()));
                         } catch (Exception ignored) {
                             i.line(i.red + "Rank was invalid, defaulting to " + i.cyan + "DEFAULT" + i.red + " rank.");
                             Main.loggedin = new Account(Main.loggedin.getUsername(), Main.loggedin.getPassword(), rank.DEFAULT);
                         }


                         i.line("\n\n\n" + Main.loggedin + "\n\n\n");

                        }
                        case "/exit" -> System.exit(0);
                        case "/generatenewuuid" -> Commands.generateUUIDs(Main.loggedin);
                        default -> i.line("Not a command");
                    }

                    ModLoader.LoadMods(i.getToken(), 7);


                } else {

                    switch (Input) {
                        case "ez":
                            i.debugLine("Info", "\"ez\" was sent.");
                            nextmsg = new TextMessage(Main.loggedin, "Wait... This isn't even online!", i.localServer);
                            i.message(nextmsg);
                            break;
                        case "cancel_messageL": i.debugLine("Info", "Cancelled message"); break;
                        case "": break;
                        default:
                            nextmsg = new TextMessage(Main.loggedin, Input, i.localServer);
                            i.message(nextmsg);

                    }

                }




            }


        }
    }



}