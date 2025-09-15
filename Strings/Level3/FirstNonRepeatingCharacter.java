package Strings.Level3;

public class FirstNonRepeatingCharacter {
    public static Character firstNonRepeatingCharacter(String text) {
        int[] freq = new int[256];
        for(char c : text.toCharArray()) {
            freq[c]++;
        }
        for(char c : text.toCharArray()) {
            if(freq[c] == 1) return c;
        }
        return null; // No non-repeating character found
    }

    public static void main(String[] args) {
        String text = "swiss";
        Character result = firstNonRepeatingCharacter(text);
        if(result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
    
}
