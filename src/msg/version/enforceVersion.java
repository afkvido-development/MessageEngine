package msg.version;

import msg.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Scanner;

/** Class is used to enforce the version, aka prevent people from running old versions of MessageEngine without using debugs. <p></p>
 * @author gemsvidø
 *  @since 0.1.4 */
public final @Unmodifiable @NotNull class enforceVersion {

    /** If debug mode is on, then the version will not be checked.  <p></p>
     * @author gemsvidø
     * @since 0.1.13 */
    public static Boolean debug = false;


    /** This is what is run to enforce the version.  <p></p>
     * @author gemsvidø
     * @since 0.1.4 */
    public static void fire () {

        boolean valid = false;
        Scanner wait = new Scanner(System.in);
        String latestVersion = "waiting";




        if (debug) {
            i.line(i.yellow + "EnforceVersion is disabled.\nThis should " + i.red + "ONLY" + i.yellow + " be used for debugging purposes." + i.white);
        } else {

            String apiConnection = UrlReader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/API.yml");

            if (apiConnection.equals(UrlReader.fail)) {
                i.line(i.red + "Cannot connect to MessageEngine API\nMake sure you're on the latest version of MessageEngine");
                wait.nextLine();
                System.exit(0);
            } else if (!apiConnection.equals("api\n")) {
                i.line(i.red + "API error, make sure you're on the latest version of MessageEngine" + i.white);
                wait.nextLine();
                System.exit(0);
            }

            latestVersion = UrlReader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/latest.yml").replace("\n", "");


            String allowed = UrlReader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/AllowedVersions.yml");


            String[] allowedVersions = allowed.split("\\n");


            for (String allowedVersion : allowedVersions) {

                if ((Version.Version).equals(allowedVersion.replace("\n", ""))) {
                    valid = true;

                    if (Version.Version.equals(latestVersion)) {
                        i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", " + i.green + "you are on the latest version" + i.gray + "!");
                    } else {
                        i.line(i.gray + "Running version " + i.cyan + Version.Version + i.gray + ", the latest version is " + i.cyan + latestVersion + i.gray + ".");
                    }


                    break;
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

    /** Private constructor prevents utility class from being initialized.  <p></p>
     * @author gemsvidø  */
    private enforceVersion () {}

}
