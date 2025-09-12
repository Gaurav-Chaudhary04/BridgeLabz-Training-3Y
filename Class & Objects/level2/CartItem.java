
public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " items added. Total Quantity: " + quantity);
    }

    public void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " items removed. Remaining Quantity: " + quantity);
        } else {
            System.out.println("Not enough items in cart!");
        }
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void display() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + getTotalCost());
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Headphones", 1500, 2);
        cart.display();
        cart.addItem(1);
        cart.removeItem(2);
        cart.display();
    }
}
