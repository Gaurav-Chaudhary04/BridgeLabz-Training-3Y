import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

    // Generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]);
    }

    // Handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of names:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] names = new String[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            names[i] = sc.nextLine();
        }

        // generateException(names); // Uncomment to see exception
        handleException(names);
    }
}
