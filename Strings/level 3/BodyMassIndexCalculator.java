import java.util.Scanner;

public class BodyMassIndexCalculator {

    // Calculate BMI and status given height in cm and weight in kg
    public static String[][] calculateBMIStatus(double[][] heightWeight) {
        String[][] results = new String[heightWeight.length][4];
        for (int i = 0; i < heightWeight.length; i++) {
            double weight = heightWeight[i][0];
            double heightM = heightWeight[i][1] / 100.0;
            double bmi = weight / (heightM * heightM);
            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25) status = "Normal";
            else if (bmi < 30) status = "Overweight";
            else status = "Obese";

            results[i][0] = String.valueOf(heightWeight[i][1]); // height cm as string
            results[i][1] = String.valueOf(weight);
            results[i][2] = String.format("%.2f", bmi);
            results[i][3] = status;
        }
        return results;
    }

    // Display BMI results in tabular format
    public static void displayBMIResults(String[][] bmiResults) {
        System.out.println("Height(cm)	Weight(kg)	BMI	Status");
        for (String[] r : bmiResults) {
            System.out.println(r[0] + "		" + r[1] + "		" + r[2] + "	" + r[3]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[][] heightWeight = new double[10][2];
        for(int i=0; i<10; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            heightWeight[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            heightWeight[i][1] = sc.nextDouble();
        }

        String[][] bmiResults = calculateBMIStatus(heightWeight);
        displayBMIResults(bmiResults);
    }
}
