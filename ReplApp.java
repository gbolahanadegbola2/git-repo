import java.util.Random;
import java.util.Scanner;

public class ReplApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        System.out.println("Welcome to my REPL App!\n");

        while (running) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "help" -> printHelp();
                case "add" -> {
                    double num1 = getNumber(scanner, "First number: ");
                    double num2 = getNumber(scanner, "Second number: ");
                    System.out.println("Result: " + formatResult(num1 + num2));
                }
                case "subtract" -> {
                    double num1 = getNumber(scanner, "First number: ");
                    double num2 = getNumber(scanner, "Second number: ");
                    System.out.println("Result: " + formatResult(num1 - num2));
                }
                case "multiply" -> {
                    double num1 = getNumber(scanner, "First number: ");
                    double num2 = getNumber(scanner, "Second number: ");
                    System.out.println("Result: " + formatResult(num1 * num2));
                }
                case "divide" -> {
                    double num1 = getNumber(scanner, "First number: ");
                    double num2 = getNumber(scanner, "Second number: ");
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        System.out.println("Result: " + formatResult(num1 / num2));
                    }
                }
                case "random" -> {
                    int min = (int) getNumber(scanner, "Minimum: ");
                    int max = (int) getNumber(scanner, "Maximum: ");
                    if (min > max) {
                        System.out.println("Error: Minimum cannot be greater than Maximum.");
                    } else {
                        int randomNum = random.nextInt((max - min) + 1) + min;
                        System.out.println("Random number: " + randomNum);
                    }
                }
                case "reverse" -> {
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    System.out.println(new StringBuilder(text).reverse().toString());
                }
                case "quit" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> {
                    if (!command.isEmpty()) {
                        System.out.println("Unknown command. Type 'help' for available commands.");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  add\n  subtract\n  multiply\n  divide\n  random\n  reverse\n  quit");
    }

    private static double getNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Enter a valid number.");
            scanner.next();
            System.out.print(prompt);
        }
        double val = scanner.nextDouble();
        scanner.nextLine(); // Clear scanner buffer
        return val;
    }

    private static String formatResult(double value) {
        return (value == (long) value) ? String.format("%d", (long) value) : String.valueOf(value);
    }
}