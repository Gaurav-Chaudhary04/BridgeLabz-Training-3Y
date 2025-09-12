import java.util.Scanner;

public class UniqueCharactersFinder {

    // Get length of string without length() method
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

    // Find unique characters and return array
    public static char[] uniqueCharacters(String text) {
        int length = findLength(text);
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] unique = uniqueCharacters(text);
        System.out.println("Unique characters:");
        for(char c : unique) System.out.print(c + " ");
        System.out.println();
    }
}
