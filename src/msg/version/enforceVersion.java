package msg.version;

import msg.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Scanner;

/** Class is used to enforce the version, aka prevent people from running old versions of MessageEngine without using debugs */
public final @Unmodifiable @NotNull class enforceVersion {

    public static Boolean debug = false;

    /** This is what is run to enforce the version. */
    public static void fire () {

        if (debug) {

            i.line(i.yellow + "EnforceVersion is disabled.\nThis should " + i.red + "ONLY" + i.yellow + " be used for debugging purposes." + i.white);

        } else {

        Scanner wait = new Scanner(System.in);

        String apiConnection = "false";

        try {

            apiConnection = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/API.yml");

        } catch (Exception ignored) {}


        if (apiConnection.equals("false")) {
            i.line(i.red + "Cannot connect to MessageEngine API\nMake sure you're on the latest version of MessageEngine Alpha");
            wait.nextLine();
            System.exit(0);
        } else if (!apiConnection.equals("api\n")) {
            i.line(i.red + "API error, make sure you're on the latest version of MessageEngine Alpha" + i.white);
            wait.nextLine();
            System.exit(0);
        }




        String latest = "waiting";

        try {
            latest = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/Alpha.yml");
        } catch (Exception ignored) {}

        if (latest.equals("waiting")) {

            i.line(i.red + "API error, make sure you're on the latest version of MessageEngine Alpha" + i.white);
            wait.nextLine();
            System.exit(0);

        } else if (!(Version.Version + "\n").equals(latest)) {
            i.text(i.yellow + "You are running MessageEngine " + i.cyan + Version.Version + i.yellow + ", the latest version is " + i.cyan + latest.replace("\n", "") + i.yellow + ".");
            i.line(i.red + "\nYou are on an unsupported version of MessageEngine Alpha. \nMake sure you're on the latest version of MessageEngine Alpha" + i.white);
            i.line(i.cyan + "Download the latest version of MessageEngine: https://messageengine-alpha.github.io");
            wait.nextLine();
            System.exit(0);


        }
        }

    }

    /** Private constructor prevents utility class from being initialized. */
    private enforceVersion () {}

}
