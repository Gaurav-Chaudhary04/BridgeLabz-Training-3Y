package OOPS_Concept_4;

// Student.java

class Student {
    // Static variable for university name, shared by all students
    static String universityName;
    private static int totalStudents = 0;

    // Final variable: roll number is permanent
    final String rollNumber;

    // Instance variables
    String name;
    char grade;

    // Constructor using 'this' to initialize student data
    public Student(String name, String rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increment the total student count
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("------------------------");
        System.out.println("University: " + universityName);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Name: " + this.name);
        System.out.println("Grade: " + this.grade);
        System.out.println("------------------------");
    }

    // Static method to show the total number of enrolled students
    public static void displayTotalStudents() {
        System.out.println("Total students at " + universityName + ": " + totalStudents);
    }
}

// Main class to run the program
public class UniversitySystemDemo {
    public static void main(String[] args) {
        // Set the shared university name
        Student.universityName = "Tech University";

        // Create student objects
        Student student1 = new Student("John Doe", "CS101", 'A');
        Student student2 = new Student("Jane Smith", "EE202", 'B');

        // Demonstrate 'instanceof'
        Object person = student1;
        System.out.println("Checking if object is an instance of Student...");
        if (person instanceof Student) {
            System.out.println("Yes, it is a Student. Displaying info:");
            // Cast and call method
            ((Student) person).displayStudentInfo();
        } else {
            System.out.println("Object is not a Student.");
        }

        // Display details for the second student
        student2.displayStudentInfo();

        // Call static method to get total student count
        System.out.println();
        Student.displayTotalStudents();
    }
}