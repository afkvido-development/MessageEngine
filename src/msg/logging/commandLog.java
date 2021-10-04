package msg.logging;

import msg.account.Account;
import msg.resocurces.c;
import java.util.ArrayList;

public class commandLog {

    private ArrayList<String> cmdlog;
    private ArrayList<Account> cmds;
    private String name;

    public commandLog(String name) {
        this.name = name;
        cmdlog = new ArrayList<>();
        cmds = new ArrayList<>();
    }

    public String viewLog () {
        StringBuilder str = new StringBuilder(c.gr + "----- COMMAND LOG [" + c.cy + name + c.gr + "] -----" + "\n");
        for (int i = 0; i < cmdlog.size(); i++) {
            str.append(cmds.get(i).getDisplayName() + c.rs + ": " + c.pr + cmdlog.get(i) + "\n");
        }
        str.append(c.gr + "---------------------------------" + c.rs);
        return str.toString();
    }

    public void logcmd (String cmd, Account author) { cmdlog.add(cmd); cmds.add(author); }
}
