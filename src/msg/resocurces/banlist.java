package msg.resocurces;

import msg.account.Account;
import java.util.Date;
import java.util.ArrayList;

public class banlist {
    private ArrayList<Account> accounts;
    private ArrayList<Integer> durations;
    private ArrayList<String> reasons;

    public banlist () {
        accounts = new ArrayList<>();
        durations = new ArrayList<>();
        reasons = new ArrayList<>();

    }

    public void add (Account account, Integer duration, String reason) {
        accounts.add(account);
        if (duration == 0) {
            durations.add(2147483647);
        } else {
            durations.add(duration);
        }

        reasons.add(reason);
    }


    public void remove (Account account, String reason) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) == account) {

                accounts.remove(i);
                durations.remove(i);
                reasons.remove(i);
                break;
            }
        }
    }

    public String getReason (Account account) {
        int d = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) == account) {
                d = i;
                break;
            }

        }

        return reasons.get(d);
    }

    public Integer getDuration (Account account) {
        int d = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) == account) {
                d = i;
                break;
            }

        }

        return durations.get(d);
    }


    public boolean contains (Account account) {
        if (accounts.contains(account)) {
            return true;

        } else {
            return false;
        }
    }
}
