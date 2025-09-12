import java.util.Scanner;

public class CharacterFrequencyNestedLoops {

    public static String[][] frequencesUsingNestedLoops(String text) {
        char[] chars = text.toCharArray();
        int length = chars.length;
        int[] freq = new int[length];
        for(int i=0; i<length; i++) freq[i] = 1;

        for(int i=0; i<length; i++) {
            if(chars[i] == '0') continue;
            for(int j=i+1; j<length; j++) {
                if(chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int uniqueCount = 0;
        for(char c : chars) if(c != '0') uniqueCount++;

        String[][] result = new String[uniqueCount][2];
        int idx=0;
        for(int i=0; i<length; i++) {
            if(chars[i] != '0') {
                result[idx][0] = Character.toString(chars[i]);
                result[idx][1] = Integer.toString(freq[i]);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] freq = frequencesUsingNestedLoops(text);
        System.out.println("Character	Frequency");
        for(String[] pair : freq) {
            System.out.println(pair[0] + "		" + pair[1]);
        }
    }
}
