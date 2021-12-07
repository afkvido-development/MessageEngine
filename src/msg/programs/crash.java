package msg.programs;
import java.util.UUID;

public class crash {

    public static void print_lag() {

        while (true) {
            System.out.print(UUID.randomUUID());
        }

    }

    public static void system_exit_ (Integer status) {
        System.exit(status);
    }

    public static void security_issue_exception (String text) {
        throw new SecurityException(text);
    }
}
