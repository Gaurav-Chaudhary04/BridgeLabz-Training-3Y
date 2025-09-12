import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Generate NumberFormatException
    public static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }

    // Handle NumberFormatException
    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } catch(NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number string: ");
        String input = sc.nextLine();

        // generateException(input); // Uncomment to see exception
        handleException(input);
    }
}
