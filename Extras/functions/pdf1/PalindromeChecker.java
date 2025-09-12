package functions.pdf1;
import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        if (isPalindrome(str))
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }

    static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
