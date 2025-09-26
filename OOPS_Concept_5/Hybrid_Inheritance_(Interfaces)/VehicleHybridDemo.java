package OOPs_Concept_5.Hybrid_Inheritance_Interfaces;

// Hybrid Inheritance: Vehicle Management System
interface Refuelable {
    void refuel();
}

class VehicleV {
    int maxSpeed;
    String model;

    VehicleV(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends VehicleV {
    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println(model + " is charging.");
    }
}

class PetrolVehicle extends VehicleV implements Refuelable {
    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling.");
    }
}

public class VehicleHybridDemo {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(200, "Tesla");
        PetrolVehicle pv = new PetrolVehicle(180, "Honda City");

        ev.charge();
        pv.refuel();
    }
}
