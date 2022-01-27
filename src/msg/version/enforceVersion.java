package msg.version;
import msg.resocurces.c;

import java.util.Scanner;

public class enforceVersion {



    public static void fire() {

        Scanner wait = new Scanner(System.in);

        String apiConnection = "false";

        try {

            apiConnection = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/API.yml");

        } catch (Exception ignored) {}


        if (apiConnection.equals("false")) {
            System.out.println(c.rd + "Cannot connect to MessageEngine API\nMake sure you're on the latest version of MessageEngine");
            wait.nextLine();
            System.exit(0);
        } else if (!apiConnection.equals("api\n")) {
            System.out.println(c.rd + "API error, make sure you're on the latest version of MessageEngine" + c.rs);
            wait.nextLine();
            System.exit(0);
        }




        String latest = "waiting";

        try {
            latest = URLreader.check("https://raw.githubusercontent.com/afkvido-development/MessageEngine-API/master/src/api/versions/latest/Stable.yml");
        } catch (Exception ignored) {}

        if (latest.equals("waiting")) {

            System.out.println(c.rd + "API error, make sure you're on the latest version of MessageEngine" + c.rs);
            wait.nextLine();
            System.exit(0);

        } else if (!(Version.Version + "\n").equals(latest)) {
            System.out.print(c.yw + "You are running MessageEngine " + c.cy + Version.Version + c.yw + ", the latest version is " + c.cy + latest + c.yw + ".");
            System.out.println(c.rd + "You are on an unsupported version of MessageEngine. \nMake sure you're on the latest version of MessageEngine" + c.rs);
            System.out.println(c.cy + "Download the latest version of MessageEngine: https://afkvido-development.github.io/MessageEngine/");
            wait.nextLine();
            System.exit(0);
        }

    }



}
