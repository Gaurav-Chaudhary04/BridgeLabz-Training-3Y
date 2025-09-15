package instanceVsclassVaribleandMethod;
class Product_Inventory {
    String productName;
    double price;

    static int totalProducts = 0;

    public Product_Inventory(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
     public void displayProductDetails(){
        System.out.println("Product Name: " + productName + ", Price: $" + price);
     }
    
    public static int getTotalProducts() {
        return totalProducts;
    }

    public static void main(String[] args) {
        Product_Inventory product1 = new Product_Inventory("Laptop", 800.00);
        Product_Inventory product2 = new Product_Inventory("Smartphone", 500.00);

        System.out.println("Product 1 details " ); 
        product1.displayProductDetails();
        System.out.println("Product 2 details " );
        product2.displayProductDetails();
        System.out.println("Total products in inventory: " + Product_Inventory.getTotalProducts());
    }
}