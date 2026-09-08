
import java.util.Scanner;

public class TestScoreCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] scores = new double[5];

        System.out.println("Enter 5 test scores:");

        for (int i = 0; i < scores.length; i++) {
            System.out.print("Score " + (i + 1) + ": ");

            // Wait for user to type input and press Enter
            while (!sc.hasNextDouble()) {
                String invalidToken = sc.next(); // Consume the bad input
                System.out.print("Invalid input ('" + invalidToken + "'). Enter a number: ");
            }

            scores[i] = sc.nextDouble();
        }

        double total = 0;
        double highest = scores[0];
        double lowest = scores[0];

        for (double score : scores) {
            total += score;
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        double average = total / scores.length;

        System.out.println("\nResults:");
        System.out.printf("Total: %.0f%n", total);
        System.out.printf("Average: %.0f%n", average);
        System.out.printf("Highest: %.0f%n", highest);
        System.out.printf("Lowest: %.0f%n", lowest);

        System.out.println("\nYour values were:");
        for (double score : scores) {
            char grade;
            if (score >= 90) {
                grade = 'A';
            } else if (score >= 75) {
                grade = 'C';
            } else if (score >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.printf("%.0f - %c%n", score, grade);
        }

        sc.close();
    }
}
