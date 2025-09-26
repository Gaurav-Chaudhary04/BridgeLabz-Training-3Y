package OOPS_Concept_4;

// Employee.java

class Employee {
    // Static variable for the company name, shared by all employees
    static String companyName;
    private static int employeeCount = 0;

    // Final variable for employee ID, cannot be modified
    final int id;

    // Instance variables
    String name;
    String designation;

    // Constructor using 'this' for initialization
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        employeeCount++; // Increment total employee count
    }

    // Instance method to print employee details
    public void printEmployeeDetails() {
        System.out.println("==========================");
        System.out.println("Company: " + companyName);
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + this.designation);
        System.out.println("==========================");
    }

    // Static method to show the total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees at " + companyName + ": " + employeeCount);
    }
}

// Main class to run the program
public class EmployeeSystemDemo {
    public static void main(String[] args) {
        // Set the static company name
        Employee.companyName = "Innovatech Solutions";

        // Create employee objects
        Employee emp1 = new Employee("Charles", 101, "Software Engineer");
        Employee emp2 = new Employee("Diana", 102, "Project Manager");

        // Array of objects to test 'instanceof'
        Object[] staff = { emp1, emp2, new String("A guest") };

        for (Object person : staff) {
            System.out.println("\nChecking if object is an Employee...");
            // Use 'instanceof' to check the type before processing
            if (person instanceof Employee) {
                System.out.println("Object is an Employee. Details:");
                ((Employee) person).printEmployeeDetails();
            } else {
                System.out.println("Object is not an Employee. Type: " + person.getClass().getSimpleName());
            }
        }

        // Display the total employee count using the static method
        System.out.println();
        Employee.displayTotalEmployees();
    }
}