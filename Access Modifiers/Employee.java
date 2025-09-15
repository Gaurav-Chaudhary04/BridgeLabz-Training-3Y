// Problem 4: Employee Records
// Develop an Employee class with:
// employeeID (public).
// department (protected).
// salary (private).
// Write methods to:
// Modify salary using a public method.
// Create a subclass Manager to access employeeID and department.
package AccessModifiers;

public class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
    }
    public static void main(String[] args) {
        Manager manager = new Manager(1001, "Sales", 75000.00);
        manager.displayDetails();
        manager.setSalary(80000.00);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}