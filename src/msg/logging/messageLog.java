package msg.logging;

import msg.message.TextMessage;
import msg.resocurces.c;
import msg.resocurces.logtypes;
import java.util.ArrayList;

public class messageLog {

    private ArrayList<TextMessage> msglog;
    private String name;

    public messageLog(String name) {
        this.name = name;
        msglog = new ArrayList<>();
    }

    public String viewLog () {
        StringBuilder str = new StringBuilder(c.gr + "----- MESSAGE LOG [" + c.cy + name + c.gr + "] -----" + "\n");
        for (int i = 0; i < msglog.size(); i++) {
            str.append(msglog.get(i).toString() + "\n");
        }
        str.append(c.gr + "---------------------------------" + c.rs);
        return str.toString();
    }

    public void logmessage (TextMessage msg) { msglog.add(msg); }
}
