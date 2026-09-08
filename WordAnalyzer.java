
import java.util.Scanner;

public class WordAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        int charCount = input.length();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Characters: " + charCount);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);

        scanner.close();
    }
}
