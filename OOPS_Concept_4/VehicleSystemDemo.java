package OOPS_Concept_4;

// Vehicle.java

class Vehicle {
    // Static variable for a common registration fee
    static double registrationFee;

    // Final variable: registration number is unique and cannot be changed
    final String registrationNumber;

    // Instance variables
    String ownerName;
    String vehicleType;

    // Constructor using 'this' to initialize vehicle properties
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Method to display registration details
    public void displayRegistrationDetails() {
        System.out.println("--- Vehicle Registration ---");
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Type: " + this.vehicleType);
        System.out.println("Registration #: " + this.registrationNumber);
        System.out.println("Registration Fee: $" + String.format("%.2f", registrationFee));
        System.out.println("--------------------------");
    }

    // Static method to update the registration fee for all vehicles
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println(
                "\n>>> Registration fee updated to $" + String.format("%.2f", newFee) + " for all vehicles.\n");
    }
}

// Main class to run the program
public class VehicleSystemDemo {
    public static void main(String[] args) {
        // Set initial static registration fee
        Vehicle.registrationFee = 150.00;

        // Create vehicle instances
        Vehicle car = new Vehicle("Peter Jones", "Sedan", "UP32-AB-1234");
        Vehicle truck = new Vehicle("Sue Miller", "Truck", "MH12-CD-5678");

        // Use 'instanceof' to check object type before displaying details
        Object obj = truck;
        if (obj instanceof Vehicle) {
            System.out.println("Object is a Vehicle. Displaying details:");
            ((Vehicle) obj).displayRegistrationDetails();
        }

        // Update the static registration fee
        Vehicle.updateRegistrationFee(175.50);

        // Display the car's details to show the fee change
        car.displayRegistrationDetails();
    }
}