import java.util.Scanner;

public class StringIndexOutOfBoundsDemonstration {

    // Generate StringIndexOutOfBoundsException
    public static void generateException(String s) {
        System.out.println(s.charAt(s.length())); // Will throw exception
    }

    // Handle StringIndexOutOfBoundsException
    public static void handleException(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // generateException(text); // Uncomment to see exception
        handleException(text);
    }
}
