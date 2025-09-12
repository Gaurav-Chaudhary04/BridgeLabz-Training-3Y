import java.util.Scanner;

public class Abundant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }

        if (sum > num)
            System.out.println(num + " is an Abundant Number");
        else
            System.out.println(num + " is NOT an Abundant Number");

        sc.close();
    }
}
