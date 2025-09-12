import java.util.Scanner;

public class StringSubstringCharAt {

    // Method to create substring using charAt()
    public static String substringUsingCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareStringsCharAt(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String substringByCharAt = substringUsingCharAt(text, start, end);
        String substringBuiltIn = text.substring(start, end);

        boolean isEqual = compareStringsCharAt(substringByCharAt, substringBuiltIn);

        System.out.println("Substring using charAt(): " + substringByCharAt);
        System.out.println("Substring using built-in substring(): " + substringBuiltIn);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}
