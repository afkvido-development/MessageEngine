package msg.version;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/** This is used to read URLs.*/
public interface URLreader {

    /** Read a URL */
    static @NotNull String check (@NotNull String c) throws Exception {

        URL oracle = new URL(c);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        StringBuilder r = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            r.append(inputLine).append("\n");

        in.close();
        return r.toString();

    }


}