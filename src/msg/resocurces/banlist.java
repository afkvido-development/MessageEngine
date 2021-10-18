package msg.resocurces;

import msg.account.Account;
import java.util.Date;
import java.util.ArrayList;

public class banlist {
    private ArrayList<Account> accounts;
    private ArrayList<Integer> durations;

    public banlist () {
        accounts = new ArrayList<>();
        durations = new ArrayList<>();

    }

    public void add (Account account, Integer duration) {
        accounts.add(account);
        durations.add(duration);
    }

    public boolean contains (Account account) {
        if (accounts.contains(account)) {
            return true;
             
        } else {
            return false;
        }
    }
}
