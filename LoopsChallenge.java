
public class LoopsChallenge {

    public static void main(String[] args) {

        // 1. For Loop
        System.out.print("For Loop: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + (i < 5 ? " " : ""));
        }
        System.out.println();

        // 2. While Loop
        System.out.print("While Loop: ");
        int w = 1;
        while (w <= 5) {
            System.out.print(w + (w < 5 ? " " : ""));
            w++;
        }
        System.out.println();

        // 3. Do-While Loop
        System.out.print("Do-While Loop: ");
        int d = 1;
        do {
            System.out.print(d + (d < 5 ? " " : ""));
            d++;
        } while (d <= 5);
        System.out.println();
    }
}
