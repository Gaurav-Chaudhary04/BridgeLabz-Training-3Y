import java.util.Scanner;

public class StringSplitWithoutSplitMethod {

    // Method to find length without using length() - reuse previous logic
    public static int findLength(String s) {
        int count = 0;
        try {
            while(true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    // Method to split string into words without using split()
    public static String[] splitManually(String text) {
        int length = findLength(text);
        // Count spaces
        int spaceCount = 0;
        for(int i=0; i<length; i++) {
            if(text.charAt(i) == ' ') spaceCount++;
        }
        String[] words = new String[spaceCount + 1];
        int wordStart = 0, wordIndex = 0;
        for(int i=0; i<length; i++) {
            if(text.charAt(i) == ' ') {
                words[wordIndex++] = substringUsingCharAt(text, wordStart, i);
                wordStart = i + 1;
            }
        }
        words[wordIndex] = substringUsingCharAt(text, wordStart, length);
        return words;
    }

    // Helper method for substring using charAt()
    public static String substringUsingCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if(arr1.length != arr2.length) return false;
        for(int i=0; i<arr1.length; i++) {
            if(!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        String[] wordsManual = splitManually(text);
        String[] wordsBuiltIn = text.split(" ");

        boolean equal = compareStringArrays(wordsManual, wordsBuiltIn);

        System.out.println("Manual split result:");
        for(String w : wordsManual) System.out.println(w);

        System.out.println("Built-in split result:");
        for(String w : wordsBuiltIn) System.out.println(w);

        System.out.println("Are both splits equal? " + equal);
    }
}
