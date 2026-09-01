
public class OperatorsChallenge {

    public static void main(String[] args) {
        int a = 20;
        int b = 10;

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;

        boolean isAGreaterThanB = a > b;
        boolean isBothConditionsTrue = (a > b) && (b > 0);

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + difference);
        System.out.println("Multiplication: " + product);
        System.out.println("Division: " + quotient);
        System.out.println("Is a greater than b? " + isAGreaterThanB);
        System.out.println("Is a > b and b > 0? " + isBothConditionsTrue);
    }
}
