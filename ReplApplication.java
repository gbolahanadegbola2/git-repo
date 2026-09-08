
import java.util.Scanner;

public class ReplApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 0.0; // Starting account balance
        boolean running = true;

        while (running) {
            // Display main command menu
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.printf("Current Balance: $%.2f%n%n", balance);
                    break;

                case 2:
                    // Deposit funds
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("Deposited $%.2f%n%n", deposit);
                    } else {
                        System.out.println("Deposit amount must be greater than 0.\n");
                    }
                    break;

                case 3:
                    // Withdraw funds
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println("Withdrawal amount must be greater than 0.\n");
                    } else if (balance - withdraw < 0) {
                        // Guard clause: prevent negative balance
                        System.out.println("Transaction declined: Insufficient funds. Balance cannot go below $0.\n");
                    } else {
                        balance -= withdraw;
                        System.out.printf("Withdrew $%.2f%n%n", withdraw);
                    }
                    break;

                case 4:
                    // Exit loop
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please enter a choice between 1 and 4.\n");
                    break;
            }
        }

        sc.close();
    }
}
