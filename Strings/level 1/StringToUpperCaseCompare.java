import java.util.Scanner;

public class StringToUpperCaseCompare {

    // Convert to uppercase using charAt()
    public static String toUpperCaseManual(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                sb.append((char)(c - 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareStringsCharAt(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upperManual = toUpperCaseManual(text);
        String upperBuiltIn = text.toUpperCase();

        boolean equals = compareStringsCharAt(upperManual, upperBuiltIn);

        System.out.println("Manual toUpperCase: " + upperManual);
        System.out.println("Built-in toUpperCase: " + upperBuiltIn);
        System.out.println("Are both equal? " + equals);
    }
}
