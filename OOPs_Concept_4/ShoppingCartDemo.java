package OOPS_Concept_4;

// Product.java

class Product {
    // Static variable for a shared discount
    static double discount = 0.0;

    // Final variable for a unique, unchangeable product ID
    final String productID;

    // Instance variables
    String productName;
    double price;
    int quantity;

    // Constructor using 'this' to initialize product attributes
    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display product details including the static discount
    public void displayProductDetails() {
        double finalPrice = this.price * (1 - discount);
        System.out.println("--- Product Info ---");
        System.out.println("ID: " + this.productID);
        System.out.println("Name: " + this.productName);
        System.out.println("Original Price: $" + String.format("%.2f", this.price));
        System.out.println("Discount: " + (discount * 100) + "%");
        System.out.println("Final Price: $" + String.format("%.2f", finalPrice));
        System.out.println("Quantity: " + this.quantity);
        System.out.println("--------------------");
    }

    // Static method to update the shared discount for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("\n*** Discount updated to " + (discount * 100) + "% for all products. ***\n");
    }
}

// Main class to run the program
public class ShoppingCartDemo {
    public static void main(String[] args) {
        // Create product instances
        Product p1 = new Product("Laptop", "ELEC-1001", 1200.00, 1);
        Product p2 = new Product("Mouse", "ELEC-1002", 25.00, 2);

        Object item = p1;

        // Use 'instanceof' to validate the object before processing
        System.out.println("Validating if item is a Product...");
        if (item instanceof Product) {
            System.out.println("Validation successful. Processing details.");
            ((Product) item).displayProductDetails();
        } else {
            System.out.println("Item is not a valid product.");
        }

        // Update the static discount variable
        Product.updateDiscount(0.10); // 10% discount

        // Display details again to show the updated discount effect
        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}