package OOPS_Concept_3;

// FoodDeliverySystem.java
import java.util.*;

abstract class FoodItem {
    private final String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        if (itemName == null || itemName.isBlank()) throw new IllegalArgumentException("Name required");
        this.itemName = itemName;
        setPrice(price);
        setQuantity(quantity);
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price can't be negative");
        this.price = price;
    }
    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity > 0");
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice(); // price * qty + extras
    public void getItemDetails() {
        System.out.printf("%s x%d => Subtotal: %.2f%n", itemName, quantity, calculateTotalPrice());
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discountPercent;
    public VegItem(String name, double price, int qty, double discountPercent) {
        super(name, price, qty);
        this.discountPercent = Math.max(0, discountPercent);
    }
    @Override public double calculateTotalPrice() {
        double subtotal = getPrice() * getQuantity();
        double discount = subtotal * (discountPercent / 100.0);
        return subtotal - discount;
    }
    @Override public double applyDiscount() {
        return getPrice() * getQuantity() * (discountPercent / 100.0);
    }
    @Override public String getDiscountDetails() { return discountPercent + "% off"; }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraChargePerItem;
    private double discountPercent;
    public NonVegItem(String name, double price, int qty, double extraChargePerItem, double discountPercent) {
        super(name, price, qty);
        this.extraChargePerItem = Math.max(0, extraChargePerItem);
        this.discountPercent = Math.max(0, discountPercent);
    }
    @Override public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double extra = extraChargePerItem * getQuantity();
        double discount = (base + extra) * (discountPercent / 100.0);
        return base + extra - discount;
    }
    @Override public double applyDiscount() { return (getPrice() * getQuantity() + extraChargePerItem * getQuantity()) * (discountPercent / 100.0); }
    @Override public String getDiscountDetails() { return discountPercent + "% off + extra Rs" + extraChargePerItem + "/item"; }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = Arrays.asList(
            new VegItem("Paneer Butter Masala", 220, 2, 10),
            new NonVegItem("Chicken Biryani", 250, 1, 30, 5)
        );

        double total = 0;
        for (FoodItem f : order) {
            f.getItemDetails();
            total += f.calculateTotalPrice();
            if (f instanceof Discountable) {
                System.out.println("  Discount: " + ((Discountable) f).getDiscountDetails());
            }
            System.out.println("---");
        }
        System.out.printf("Order Total: %.2f%n", total);
    }
}