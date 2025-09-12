import java.util.Scanner;

public class IllegalArgumentDemonstration {

    // Generate IllegalArgumentException
    public static void generateException(String s) {
        System.out.println(s.substring(5, 2));
    }

    // Handle IllegalArgumentException
    public static void handleException(String s) {
        try {
            System.out.println(s.substring(5, 2));
        } catch(IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // generateException(text); // Uncomment to see exception
        handleException(text);
    }
}
