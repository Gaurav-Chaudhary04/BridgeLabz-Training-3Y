import java.util.Scanner;

public class CharacterFrequency {

    // Find frequency of characters, return 2D array char & freq
    public static String[][] charFrequency(String text) {
        int[] freq = new int[256];
        int length = text.length();
        for(int i=0; i<length; i++) {
            freq[text.charAt(i)]++;
        }
        int uniqueCount = 0;
        for(int f : freq) if (f > 0) uniqueCount++;

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for(int i=0; i<256; i++) {
            if(freq[i] > 0) {
                result[index][0] = Character.toString((char)i);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] freq = charFrequency(text);
        System.out.println("Character	Frequency");
        for(String[] pair : freq) {
            System.out.println(pair[0] + "		" + pair[1]);
        }
    }
}
