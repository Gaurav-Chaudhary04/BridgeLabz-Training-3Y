package OOPS_Concept_6.Object_Modeling;

import java.util.*;

/**
 * EcommerceDemo: E-commerce minimal model.
 * Customer places Order, Order contains OrderItems referencing Products.
 *
 * Compile: javac EcommerceDemo.java
 * Run:     java EcommerceDemo
 */
public class EcommerceDemo {
    public static void main(String[] args) {
        // product catalog
        Product p1 = new Product("P100", "Wireless Mouse", 799.0);
        Product p2 = new Product("P200", "USB-C Charger", 499.0);
        Product p3 = new Product("P300", "Notebook", 199.0);

        Customer c = new Customer("C100", "Gaurav");

        // customer adds to cart (we'll simulate by building an order)
        Order order = c.createOrder();
        order.addItem(p1, 1);
        order.addItem(p3, 3);
        order.addItem(p2, 2);

        System.out.println("Order summary:");
        System.out.println(order.detailedInvoice());
        System.out.println("Grand total: ₹" + order.getTotal());
    }
}

/* ------------------ Supporting classes ------------------ */

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) { this.id = id; this.name = name; this.price = price; }
    public double getPrice() { return price; }
    public String getName() { return name; }
    public String getId() { return id; }

    @Override
    public String toString() { return id + " - " + name + " @ ₹" + price; }
}

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) { this.id = id; this.name = name; }

    public Order createOrder() {
        return new Order(UUID.randomUUID().toString(), this);
    }

    @Override
    public String toString() { return id + ":" + name; }
}

class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private double total = 0.0;

    public Order(String orderId, Customer customer) { this.orderId = orderId; this.customer = customer; }

    public void addItem(Product product, int quantity) {
        if (quantity <= 0) return;
        OrderItem oi = new OrderItem(product, quantity);
        items.add(oi);
        total += oi.getLineTotal();
    }

    public double getTotal() { return total; }

    public String detailedInvoice() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderId: ").append(orderId).append("\\nCustomer: ").append(customer).append("\\n");
        sb.append(String.format("%-10s %-25s %6s %10s\\n", "ProdID", "Name", "Qty", "LineTotal"));
        for (OrderItem oi : items) {
            sb.append(String.format("%-10s %-25s %6d %10.2f\\n",
                    oi.getProduct().getId(), oi.getProduct().getName(), oi.getQuantity(), oi.getLineTotal()));
        }
        sb.append("------------------------------------------------\\n");
        sb.append(String.format("Total: ₹%.2f\\n", total));
        return sb.toString();
    }
}

class OrderItem {
    private Product product;
    private int quantity;
    private double lineTotal;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.lineTotal = product.getPrice() * quantity;
    }

    public double getLineTotal() { return lineTotal; }
    public int getQuantity() { return quantity; }
    public Product getProduct() { return product; }
}
