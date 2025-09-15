// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

// Subclass Car
class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 1000; }

    @Override
    public String getInsuranceDetails() { return "Car insurance"; }
}

// Subclass Bike
class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 300; }

    @Override
    public String getInsuranceDetails() { return "Bike insurance"; }
}

// Subclass Truck
class Truck extends Vehicle implements Insurable {
    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // Extra charge
    }

    @Override
    public double calculateInsurance() { return 2000; }

    @Override
    public String getInsuranceDetails() { return "Truck insurance"; }
}

// Main
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C123", 2000);
        Vehicle v2 = new Bike("B123", 500);
        Vehicle v3 = new Truck("T123", 5000);

        System.out.println("Car Rent + Insurance: " + (v1.calculateRentalCost(3) + ((Insurable)v1).calculateInsurance()));
        System.out.println("Bike Rent + Insurance: " + (v2.calculateRentalCost(2) + ((Insurable)v2).calculateInsurance()));
        System.out.println("Truck Rent + Insurance: " + (v3.calculateRentalCost(5) + ((Insurable)v3).calculateInsurance()));
    }
}