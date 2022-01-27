package msg.version;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLreader {


    public static String check(String c) throws Exception {

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