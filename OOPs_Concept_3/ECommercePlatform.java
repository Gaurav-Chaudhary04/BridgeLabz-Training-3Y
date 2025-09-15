package OOPs_Concept_3;

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    public abstract double calculateDiscount();

    public double finalPrice() {
        return getPrice() + calculateTax() - calculateDiscount();
    }

    // Must be implemented by subclasses if they implement Taxable
    public abstract double calculateTax();
}

// Subclass Electronics
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.10; }

    @Override
    public double calculateTax() { return getPrice() * 0.18; }

    @Override
    public String getTaxDetails() { return "18% GST"; }
}

// Subclass Clothing
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.20; }

    @Override
    public double calculateTax() { return getPrice() * 0.05; }

    @Override
    public String getTaxDetails() { return "5% GST"; }
}

// Subclass Groceries
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.05; }

    @Override
    public double calculateTax() { return 0; } // No tax
}

// Main
public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 50000);
        Product p2 = new Clothing(102, "Shirt", 2000);
        Product p3 = new Groceries(103, "Rice", 1000);

        System.out.println(p1.getName() + " Final Price: " + p1.finalPrice());
        System.out.println(p2.getName() + " Final Price: " + p2.finalPrice());
        System.out.println(p3.getName() + " Final Price: " + p3.finalPrice());
    }
}