import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative check by comparing chars start/end
    public static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while(start < end) {
            if(text.charAt(start) != text.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    // Logic 2: Recursive palindrome check
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if(start >= end) return true;
        if(text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Compare char array with reversed array
    public static boolean isPalindromeArrays(String text) {
        char[] orig = text.toCharArray();
        char[] rev = new char[orig.length];
        for(int i=0; i<orig.length; i++) rev[i] = orig[orig.length - 1 - i];
        for(int i=0; i<orig.length; i++) if(orig[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative palindrome check: " + isPalindromeIterative(text));
        System.out.println("Recursive palindrome check: " + isPalindromeRecursive(text, 0, text.length()-1));
        System.out.println("Char array palindrome check: " + isPalindromeArrays(text));
    }
}
