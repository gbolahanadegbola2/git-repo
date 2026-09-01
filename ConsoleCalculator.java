
public class ConsoleCalculator {

    public static void main(String[] args) {
        double num1 = 88;
        double num2 = 5;
        char operator = '*';

        String again = "y";

        while (again.equals("y")) {
            if (operator == '+') {
                System.out.println("Result: " + (num1 + num2));
            } else if (operator == '-') {
                System.out.println("Result: " + (num1 - num2));
            } else if (operator == '*') {
                System.out.println("Result: " + (num1 * num2));
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    System.out.println("Result: " + (num1 / num2));
                }
            } else {
                System.out.println("Invalid operator.");
            }

            // Set again to "n" so the while loop terminates after one pass
            again = "n";
        }

        System.out.println("Thank you for using the calculator.");
    }
}
