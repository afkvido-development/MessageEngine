package msg.version;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/** This is used to read URLs. Improved by gemsvido, original from [idk]. <p></p>
 * @author gemsvido
 *  @since 0.1.4 */
public interface UrlReader {

    /** This String will determine if the URLreader failed or not*/
    String fail = "URLreader failed";


    /** Read a URL. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    static @NotNull String check (@NotNull String url) {
        String r = fail;
        try {
            r = read(url);
        } catch (Exception ignored) {}
        return r;

    }


    /** Read a URL, if it couldn't return a String then it throws an Exception. <p></p>
     * @author gemsvidø
     * @since 0.2.0 */
    static @NotNull String read (@NotNull String url) throws Exception {

        URL oracle = new URL(url);
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