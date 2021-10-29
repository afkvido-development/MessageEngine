package msg.resocurces;

import msg.Main;
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
            durations.add(80085);
        } else {
            durations.add(duration);

        }

        reasons.add(reason);
        hold(account, duration);
    }

    public void hold (Account account, Integer duration_) {
        if (duration_ != 80085) {

            try {
                //Thread.sleep(duration_ * 60000);
                Thread.sleep(duration_ * 1000);
                remove(account, "Unban timer ");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        } else {
            Main.c_log.logcmd(account.getDisplayName() + " is permanently banned. Manual unban required to unban.", database.system);
        }
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
        for (int i = 0; i < reasons.size(); i++) {
            if (accounts.get(i) == account) {
                d = i;
                break;
            }

        }

        return reasons.get(d);
    }

    public Integer getDuration (Account account) {
        int d = 0;
        for (int i = 0; i < durations.size(); i++) {
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
