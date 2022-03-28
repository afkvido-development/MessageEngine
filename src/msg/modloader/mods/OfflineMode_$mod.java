package msg.modloader.mods;

import msg.Main;
import msg.i;
import msg.modloader.ModLoader;
import msg.modloader.resources.Mod;
import msg.modloader.resources.Mod_Main;
import msg.programs.interactive.login;
import msg.resources.account.Account;
import msg.resources.commands.Commands;
import msg.resources.message.TextMessage;
import msg.resources.rank;

import java.util.Scanner;
import java.util.UUID;

@Mod public interface OfflineMode_$mod {


 /** This lets you completely run MessageEngine without internet, how nice! <p></p>
  * @author gemsvidø
  * @since 0.2.0
  * @see OfflineMode_$mod */
    @Mod_Main static void main () {



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
        case "/exit" -> {
         System.exit(0);
        }
        case "/generatenewuuid" -> {
         Commands.generateUUIDs(Main.loggedin);
        }
        case "/help" -> {
         i.line(i.gray + "Welcome to the " + i.cyan + " MessageEngine Offline Mod" + i.gray + ".");
         i.line(i.blue + "Commands: ");
         i.line(i.cyan + "cancel_messageL" + i.purple + " - Cancels sending that message");
         i.line(i.cyan + "/help" + i.purple + " - Display this help message");
         i.line(i.cyan + "ez" + i.purple + " - Sends an ez message instead of what you typed.");
        }
        default -> {
         i.line("Not a command");
        }
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
         // i.sendPacket(nextmsg); We won't be sending a packet because it's offline.
       }

      }

     }
}

}
