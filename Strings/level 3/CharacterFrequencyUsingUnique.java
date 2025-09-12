import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    public static char[] uniqueCharacters(String text) {
        int length = text.length();
        char[] uniqueTemp = new char[length];
        int uniqueCount = 0;
        boolean isUnique;
        for(int i=0; i<length; i++) {
            char c = text.charAt(i);
            isUnique = true;
            for(int j=0; j<uniqueCount; j++) {
                if(uniqueTemp[j] == c) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) uniqueTemp[uniqueCount++] = c;
        }
        char[] unique = new char[uniqueCount];
        for(int i=0; i<uniqueCount; i++) unique[i] = uniqueTemp[i];
        return unique;
    }

    public static String[][] charFrequencyUsingUnique(String text) {
        int length = text.length();
        int[] freq = new int[256];
        for(int i=0; i<length; i++) freq[text.charAt(i)]++;

        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];
        for(int i=0; i<uniqueChars.length; i++) {
            result[i][0] = Character.toString(uniqueChars[i]);
            result[i][1] = Integer.toString(freq[uniqueChars[i]]);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] frequency = charFrequencyUsingUnique(text);
        System.out.println("Character	Frequency");
        for(String[] pair : frequency) {
            System.out.println(pair[0] + "		" + pair[1]);
        }
    }
}
