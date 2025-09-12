public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        int len = Math.min(str1.length(), str2.length());
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }
        if (result == 0) result = str1.length() - str2.length();

        if (result < 0)
            System.out.println(str1 + " comes before " + str2);
        else if (result > 0)
            System.out.println(str1 + " comes after " + str2);
        else
            System.out.println("Both strings are equal.");
    }
}
