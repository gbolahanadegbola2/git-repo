
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Create a password: ");
        String password = scanner.nextLine();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("- Must be at least 8 characters");
        }
        if (!hasUpper) {
            errors.add("- Must contain an uppercase letter");
        }
        if (!hasLower) {
            errors.add("- Must contain a lowercase letter");
        }
        if (!hasDigit) {
            errors.add("- Must contain a number");
        }

        if (errors.isEmpty()) {
            System.out.println("Password accepted!");
        } else {
            System.out.println("Password rejected:");
            for (String err : errors) {
                System.out.println(err);
            }
        }

        scanner.close();
    }
}
