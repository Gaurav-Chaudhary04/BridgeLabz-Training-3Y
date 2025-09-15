// Create a Vehicle class to manage the details of vehicles:
// Instance Variables: ownerName, vehicleType.
// Class Variable: registrationFee (fixed for all vehicles).
// Methods:
// An instance method displayVehicleDetails() to display owner and vehicle details.
// A class method updateRegistrationFee() to change the registration fee.

package instanceVsclassVaribleandMethod;

public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 100.00;
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName + ", Vehicle Type: " + vehicleType + ", Registration Fee: $" + registrationFee);
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Alice", "Car");
        Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle");

        System.out.println("Vehicle 1 details:");
        vehicle1.displayVehicleDetails();
        System.out.println("Vehicle 2 details:");
        vehicle2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(150.00);
        
        System.out.println("After updating registration fee:");
        System.out.println("Vehicle 1 details:");
        vehicle1.displayVehicleDetails();
        System.out.println("Vehicle 2 details:");
        vehicle2.displayVehicleDetails();
    }
}
