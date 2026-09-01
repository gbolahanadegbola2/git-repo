
public class ControlFlowGrade {

    public static void main(String[] args) {
        int score = 47;
        char grade = 'B';

        // Check if student passed or failed (50 or above is a pass)
        if (score >= 50) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        // Determine grade letter based on score
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 75) {
            grade = 'B';
        } else if (score >= 60) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("Grade: " + grade);
    }
}
