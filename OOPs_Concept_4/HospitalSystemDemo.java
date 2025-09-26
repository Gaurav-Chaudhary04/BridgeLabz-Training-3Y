package OOPS_Concept_4;

// Patient.java

class Patient {
    // Static variable for the hospital name, common to all patients
    static String hospitalName;
    private static int totalPatients = 0;

    // Final variable for a unique patient ID
    final int patientID;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using 'this' to set patient data
    public Patient(String name, int patientID, int age, String ailment) {
        this.name = name;
        this.patientID = patientID;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increment patient count
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("*************************");
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + this.patientID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Ailment: " + this.ailment);
        System.out.println("*************************");
    }

    // Static method to get the total number of patients
    public static void getTotalPatients() {
        System.out.println("Total patients currently at " + hospitalName + ": " + totalPatients);
    }
}

// Main class to run the program
public class HospitalSystemDemo {
    public static void main(String[] args) {
        // Set the static hospital name
        Patient.hospitalName = "City General Hospital";

        // Create patient objects
        Patient p1 = new Patient("Emily White", 9001, 45, "Fractured Arm");
        Patient p2 = new Patient("Michael Brown", 9002, 62, "Pneumonia");

        // Use 'instanceof' to check if an object is a Patient
        Object person = p1;

        System.out.println("Checking object type...");
        if (person instanceof Patient) {
            System.out.println("Object is a Patient. Displaying information.");
            ((Patient) person).displayDetails();
        } else {
            System.out.println("Object is not a Patient.");
        }

        // Display details for the other patient
        p2.displayDetails();

        // Call the static method to show the total patient count
        System.out.println();
        Patient.getTotalPatients();
    }
}