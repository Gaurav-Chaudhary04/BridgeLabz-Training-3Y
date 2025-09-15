// Create a Student class with:
// rollNumber (public).
// name (protected).
// CGPA (private).
// Write methods to:
// Access and modify CGPA using public methods.
// Create a subclass PostgraduateStudent to demonstrate the use of protected members.

package AccessModifiers;

public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA()); 
    }
    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Alice", 8.8);
        pgStudent.displayDetails();
        pgStudent.setCGPA(8.9);
        System.out.println("Updated CGPA: " + pgStudent.getCGPA());
    }
}
