package functions.pdf1;
import java.util.*;

public class NumberGuessingGame {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int low = 1, high = 100;
        System.out.println("Think of a number between 1 and 100.");
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = sc.nextLine().trim().toLowerCase();
            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed it!");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else {
                System.out.println("Please type 'high', 'low', or 'correct'.");
            }
        }
    }

    static int generateGuess(int low, int high) {
        return rand.nextInt(high - low + 1) + low;
    }
}
