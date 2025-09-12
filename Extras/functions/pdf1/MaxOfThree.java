package functions.pdf1;
import java.util.*;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = inputNumber(sc, "Enter first number: ");
        int b = inputNumber(sc, "Enter second number: ");
        int c = inputNumber(sc, "Enter third number: ");
        int max = findMax(a, b, c);
        System.out.println("Maximum number: " + max);
    }

    static int inputNumber(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
