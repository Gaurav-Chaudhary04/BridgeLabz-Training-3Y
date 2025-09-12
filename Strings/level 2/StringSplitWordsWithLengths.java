import java.util.Scanner;

public class StringSplitWordsWithLengths {

    public static int findLength(String s) {
        int count = 0;
        try {
            while(true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    public static String[] splitManually(String text) {
        int length = findLength(text);
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

    public static String substringUsingCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<end; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    // Returns 2D array with word and length as string
    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for(int i=0; i<words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        String[] words = splitManually(text);
        String[][] wordsLen = wordsWithLengths(words);

        System.out.println("Word	Length");
        for(int i=0; i<wordsLen.length; i++) {
            System.out.println(wordsLen[i][0] + "	" + Integer.parseInt(wordsLen[i][1]));
        }
    }
}
