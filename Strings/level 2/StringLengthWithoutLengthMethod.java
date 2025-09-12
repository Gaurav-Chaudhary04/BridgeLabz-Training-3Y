import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    // Method to find length without using length()
    public static int findLength(String s) {
        int count = 0;
        try {
            while(true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.next();

        int lengthManual = findLength(text);
        int lengthBuiltIn = text.length();

        System.out.println("Length without using length(): " + lengthManual);
        System.out.println("Length using built-in length(): " + lengthBuiltIn);
    }
}
