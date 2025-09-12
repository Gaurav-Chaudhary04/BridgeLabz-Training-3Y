import java.util.Scanner;

public class VowelConsonantCharType {

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

    public static String[][] getCharTypes(String s) {
        int length = s.length();
        String[][] result = new String[length][2];
        for(int i=0; i<length; i++) {
            char ch = s.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    public static void displayCharTypes(String[][] arr) {
        System.out.println("Character	Type");
        for(String[] row : arr) {
            System.out.println(row[0] + "		" + row[1]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.nextLine();

        String[][] charTypes = getCharTypes(text);
        displayCharTypes(charTypes);
    }
}
