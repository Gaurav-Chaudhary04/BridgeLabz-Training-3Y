import java.util.Scanner;

public class StringReturnChars {

    // Return characters in string without using toCharArray()
    public static char[] getCharsManually(String s) {
        char[] chars = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return chars;
    }

    // Compare two char arrays
    public static boolean compareCharArrays(char[] a1, char[] a2) {
        if(a1.length != a2.length) return false;
        for(int i=0; i<a1.length; i++) {
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] manualChars = getCharsManually(text);
        char[] builtInChars = text.toCharArray();

        boolean equal = compareCharArrays(manualChars, builtInChars);

        System.out.print("Characters using manual method: ");
        for(char c : manualChars) System.out.print(c + " ");
        System.out.println();

        System.out.print("Characters using toCharArray(): ");
        for(char c : builtInChars) System.out.print(c + " ");
        System.out.println();

        System.out.println("Are both character arrays equal? " + equal);
    }
}
