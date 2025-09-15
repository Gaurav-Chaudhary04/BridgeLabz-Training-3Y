// Problem: Car Rental System with cost calculation
public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = rentalDays * 1500;  // Assume ₹1500/day
    }

    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays + ", Total Cost: ₹" + totalCost);
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Nitin", "Toyota Fortuner", 5);
        rental.displayRentalDetails();
    }
}
