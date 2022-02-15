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

        boolean valid = false;
        Scanner wait = new Scanner(System.in);
        String latestVersion = "waiting";




        if (debug) {
            i.line(i.yellow + "EnforceVersion is disabled.\nThis should " + i.red + "ONLY" + i.yellow + " be used for debugging purposes." + i.white);
        } else {

            String apiConnection = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/API.yml");

            if (apiConnection.equals(URLreader.fail)) {
                i.line(i.red + "Cannot connect to MessageEngine API\nMake sure you're on the latest version of MessageEngine");
                wait.nextLine();
                System.exit(0);
            } else if (!apiConnection.equals("api\n")) {
                i.line(i.red + "API error, make sure you're on the latest version of MessageEngine" + i.white);
                wait.nextLine();
                System.exit(0);
            }


            String allowed;
            allowed = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/AllowedVersions.yml");


            String[] allowedVersions = allowed.split("\\n");


            latestVersion = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/latest.yml");



            valid = false;

            for (String allowedVersion : allowedVersions) {

                if ((Version.Version + "\n").equals(allowedVersion.replace("\n", ""))) {
                    valid = true;
                    i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", the latest version is " + i.cyan + latestVersion + i.gray + ".");
                }
            }

        }


        if (!valid) {
            i.text(i.yellow + "You are running MessageEngine " + i.cyan + Version.Version + i.yellow + ", the latest version is " + i.cyan + latestVersion.replace("\n", "") + i.yellow + ".");
            i.line(i.red + "\nYou are on an unsupported version of MessageEngine. \nMake sure you're on the latest version of MessageEngine" + i.white);
            i.line(i.cyan + "Download the latest version of MessageEngine: https://github.com/afkvido-development/MessageEngine/releases/latest ");
            wait.nextLine();
            System.exit(0);
        }


    }

    /** Private constructor prevents utility class from being initialized. */
    private enforceVersion () {}

}
