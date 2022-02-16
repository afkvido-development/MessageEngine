package msg.resources.commands;

import msg.version.URLreader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static msg.programs.interactive.login.server_address;

/** Automatically replaces "ez" with messages from a predetermined list by a ChatServer. Inspired by Hypixel, made by gemsvidø. <p></p>
 * @author gemsvidø */
final @NotNull class ez {

    private static final @NotNull ArrayList<String> e = new ArrayList<>();
    private static @NotNull Boolean build = false;

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

    private static void buildEz () {

        String fetchEz = "";

        try {
            fetchEz = URLreader.check("https://raw.githubusercontent.com/" + server_address.replace(".msgeng", "") + "/main/src/ez/list.txt");
        } catch (Exception ignored) {}

        String[] ezS = fetchEz.split("\\n");


        e.addAll(Arrays.asList(ezS));


        build = true;


    }

    private ez () {}



}
