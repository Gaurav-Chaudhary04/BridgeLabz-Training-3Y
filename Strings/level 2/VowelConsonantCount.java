import java.util.Scanner;

public class VowelConsonantCount {

    // Method to check char type
    public static String checkCharType(char ch) {
        char c = ch;
        if(c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }
        if(c >= 'a' && c <= 'z') {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to count vowels and consonants
    public static int[] countVowelsConsonants(String s) {
        int vowels = 0, consonants = 0;
        for(int i=0; i<s.length(); i++) {
            String type = checkCharType(s.charAt(i));
            if(type.equals("Vowel")) vowels++;
            else if(type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        int[] counts = countVowelsConsonants(text);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
    }
}
