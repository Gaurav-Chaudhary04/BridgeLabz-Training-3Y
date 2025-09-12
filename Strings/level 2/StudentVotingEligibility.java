import java.util.Scanner;
import java.util.Random;

public class StudentVotingEligibility {

    // Generate random ages for n students
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for(int i=0; i<n; i++) {
            ages[i] = rand.nextInt(90) + 10; // 10 to 99
        }
        return ages;
    }

    // Get voting eligibility as 2D String array [age, "true"/"false"]
    public static String[][] votingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for(int i=0; i<ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            boolean canVote = ages[i] >= 18 && ages[i] >= 0;
            result[i][1] = String.valueOf(canVote);
        }
        return result;
    }

    // Display 2D array in tabular format
    public static void displayEligibility(String[][] eligibility) {
        System.out.println("Age	Can Vote");
        for(String[] row : eligibility) {
            System.out.println(row[0] + "	" + row[1]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateAges(n);
        String[][] eligibility = votingEligibility(ages);

        displayEligibility(eligibility);
    }
}
