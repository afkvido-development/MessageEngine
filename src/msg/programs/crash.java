package msg.programs;
import java.util.UUID;

public class crash {

    public static void print_lag() {

        while (true) {
            System.out.print(UUID.randomUUID());
        }

    }

    public static void system_exit (Integer status) {
        System.exit(status);
    }

    public static void security_issue_exception (String text) {
        throw new SecurityException(text);
    }

    public static void runtime_exception (String text) {
        throw new RuntimeException(text);
    }

    public static void function_crash () {
        fc1();
    }

    public static void function_print () {
        fcp1();
    }


    // ------------------------------------------------

    private static void fc1 () {
        fc2();
    }

    private static void fc2 () {
        fc1();
    }

    private static void fcp1 () {
        System.out.print(UUID.randomUUID());
        fcp2();
    }

    private static void fcp2 () {
        System.out.print(UUID.randomUUID());
        fcp1();
    }


}
