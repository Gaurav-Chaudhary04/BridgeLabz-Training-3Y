// Problem: Circle class demonstrating constructor chaining
public class Circle {
    private double radius;

    // Default constructor calls parameterized constructor
    public Circle() {
        this(5);  // Default radius of 5
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void display() {
        System.out.println("Radius of circle: " + radius);
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        defaultCircle.display();

        Circle customCircle = new Circle(10);
        customCircle.display();
    }
}
