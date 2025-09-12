public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char remove = 'l';
        String result = "";
        for (char ch : str.toCharArray()) {
            if (ch != remove) result += ch;
        }
        System.out.println("Modified String: " + result);
    }
}
