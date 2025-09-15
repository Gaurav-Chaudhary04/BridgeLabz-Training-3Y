package OOPs_Concept_3;

// RideHailingApp.java
import java.util.*;

abstract class VehicleRH {
    private final String vehicleId;
    private String driverName;
    private double ratePerKm;

    public VehicleRH(String vehicleId, String driverName, double ratePerKm) {
        if (vehicleId == null || vehicleId.isBlank()) throw new IllegalArgumentException("Invalid ID");
        this.vehicleId = vehicleId;
        setDriverName(driverName);
        setRatePerKm(ratePerKm);
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void setDriverName(String driverName) { this.driverName = (driverName == null ? "Unknown" : driverName); }
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm < 0) throw new IllegalArgumentException("Rate can't be negative");
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.printf("Vehicle: %s | Driver: %s | Rate/km: %.2f%n", vehicleId, driverName, ratePerKm);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class CarRH extends VehicleRH implements GPS {
    private String location;
    public CarRH(String id, String driver, double ratePerKm) { super(id, driver, ratePerKm); }
    @Override public double calculateFare(double distance) { return getRatePerKm() * distance + 20; /* base fee */ }
    @Override public String getCurrentLocation() { return location == null ? "Unknown" : location; }
    @Override public void updateLocation(String newLocation) { this.location = newLocation; }
}

class BikeRH extends VehicleRH implements GPS {
    private String location;
    public BikeRH(String id, String driver, double ratePerKm) { super(id, driver, ratePerKm); }
    @Override public double calculateFare(double distance) { return getRatePerKm() * distance; }
    @Override public String getCurrentLocation() { return location == null ? "Unknown" : location; }
    @Override public void updateLocation(String newLocation) { this.location = newLocation; }
}

class AutoRH extends VehicleRH implements GPS {
    private String location;
    public AutoRH(String id, String driver, double ratePerKm) { super(id, driver, ratePerKm); }
    @Override public double calculateFare(double distance) { return Math.max(30, getRatePerKm() * distance); }
    @Override public String getCurrentLocation() { return location == null ? "Unknown" : location; }
    @Override public void updateLocation(String newLocation) { this.location = newLocation; }
}

public class RideHailingApp {
    public static void calculateFares(List<VehicleRH> vehicles, double distance) {
        for (VehicleRH v : vehicles) {
            v.getVehicleDetails();
            System.out.printf("Fare for %.2f km: %.2f%n", distance, v.calculateFare(distance));
            if (v instanceof GPS) System.out.println("Location: " + ((GPS) v).getCurrentLocation());
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        CarRH car = new CarRH("CAR123", "Suresh", 12);
        BikeRH bike = new BikeRH("BIKE45", "Neha", 6);
        AutoRH auto = new AutoRH("AUTO9", "Raju", 8);

        car.updateLocation("MG Road");
        bike.updateLocation("Brigade Road");
        auto.updateLocation("Market");

        List<VehicleRH> list = Arrays.asList(car, bike, auto);
        calculateFares(list, 10.5);
    }
}