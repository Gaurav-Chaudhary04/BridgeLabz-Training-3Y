import java.util.Scanner;
import java.util.Random;

public class StudentMarksGrade {

    public static int[][] generatePCM(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for(int i=0; i<n; i++) {
            scores[i][0] = rand.nextInt(90) + 10;
            scores[i][1] = rand.nextInt(90) + 10;
            scores[i][2] = rand.nextInt(90) + 10;
        }
        return scores;
    }

    public static double[][] calculateTotals(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for(int i=0; i<scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100) / 100.0;
            result[i][2] = Math.round((avg / 100.0) * 10000) / 100.0;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] totals) {
        String[] grades = new String[totals.length];
        for(int i=0; i<totals.length; i++) {
            double percentage = totals[i][2];
            if(percentage >= 90) grades[i] = "A";
            else if(percentage >= 80) grades[i] = "B";
            else if(percentage >= 70) grades[i] = "C";
            else if(percentage >= 60) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] totals, String[] grades) {
        System.out.println("Physics	Chemistry	Maths	Total	Average	Percentage	Grade");
        for(int i=0; i<scores.length; i++) {
            System.out.println(scores[i][0] + "	" + scores[i][1] + "		" + scores[i][2] + "	" +
                               (int)totals[i][0] + "	" + totals[i][1] + "	" + totals[i][2] + "		" + grades[i]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generatePCM(n);
        double[][] totals = calculateTotals(scores);
        String[] grades = calculateGrades(totals);
        displayScorecard(scores, totals, grades);
    }
}
