package msg.resources.commands;

import msg.version.UrlReader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static msg.i.ServerAddress;

/** Automatically replaces "ez" with messages from a predetermined list by a ChatServer. Inspired by Hypixel, made by gemsvidø. <p></p>
 * @author gemsvidø
 *  @since 0.1.2 */
final @NotNull class ez {

    /** ArrayList of ez messages fetched from the server <p></p>
      * @author gemsvidø
      * @since 0.1.13  */
    private static final @NotNull ArrayList<String> e = new ArrayList<>();

    /** If the ez messages are ready to send, then true. <p></p>
     * @author gemsvidø
     * @since 0.1.13 */
    private static @NotNull Boolean build = false;

    /** Return a random ez message <p></p>
     * @author gemsvidø
     * @since 0.1.13  */
    static @NotNull String fire () {

        if (build) {

            int random = new Random().nextInt(e.size());
            return e.get(random);

        } else {
            buildEz();
            int random = new Random().nextInt(e.size());
            return e.get(random);
        }

    }

    /** Fetch the ez messages from the servers <p></p>
     * @author gemsvidø
     * @since 0.1.13  */
    private static void buildEz () {

        String fetchEz = "";

        try {
            fetchEz = UrlReader.check("https://raw.githubusercontent.com/" + ServerAddress.replace(".msgeng", "") + "/main/src/ez/list.txt");
        } catch (Exception ignored) {}

        String[] ezS = fetchEz.split("\\n");


        e.addAll(Arrays.asList(ezS));


        build = true;


    }

    /** Private constructor prevents utility class <strong>ez</strong> from being initialized. <p></p>
     * @author gemsvidø
     * @since 0.1.13 */
    private ez () {}



}
