
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeAPI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Current Date details
        LocalDate today = LocalDate.now();
        System.out.println("Date: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());

        // Age calculation with input validation
        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("\nEnter your birth date (YYYY-MM-DD): ");
            String input = sc.nextLine().trim();
            try {
                birthDate = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use YYYY-MM-DD (e.g., 2002-09-21).");
            }
        }

        int age = Period.between(birthDate, today).getYears();
        System.out.println("You are " + age + " years old.");

        // Days until next birthday
        LocalDate birthdayInput = null;
        while (birthdayInput == null) {
            System.out.print("\nEnter your birthday (YYYY-MM-DD): ");
            String input = sc.nextLine().trim();
            try {
                birthdayInput = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use YYYY-MM-DD (e.g., 2002-09-21).");
            }
        }

        LocalDate nextBirthday = birthdayInput.withYear(today.getYear());
        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long daysUntilNextBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days until your next birthday: " + daysUntilNextBirthday);

        sc.close();
    }
}
