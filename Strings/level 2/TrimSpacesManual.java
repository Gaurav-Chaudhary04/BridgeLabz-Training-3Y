import java.util.Scanner;

public class TrimSpacesManual {

    // Method to find start and end index after trimming spaces
    public static int[] trimSpacesIndices(String s) {
        int start = 0, end = s.length()-1;
        while(start <= end && s.charAt(start) == ' ') start++;
        while(end >= start && s.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String substringUsingCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<=end; i++) {
            sb.append(s.charAt(i));
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
        System.out.print("Enter a string with spaces: ");
        String text = sc.nextLine();

        int[] indices = trimSpacesIndices(text);
        if(indices[0] > indices[1]) {
            System.out.println("String is empty after trimming");
            return;
        }

        String trimmedManual = substringUsingCharAt(text, indices[0], indices[1]);
        String trimmedBuiltIn = text.trim();

        boolean equal = compareStringsCharAt(trimmedManual, trimmedBuiltIn);

        System.out.println("Trimmed using manual method: '" + trimmedManual + "'");
        System.out.println("Trimmed using built-in trim(): '" + trimmedBuiltIn + "'");
        System.out.println("Are both trimmed strings equal? " + equal);
    }
}
