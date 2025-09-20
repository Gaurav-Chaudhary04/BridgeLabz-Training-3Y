package OOPs_Concept_5.Introduction;

// Employee Management System
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String mentor;

    Intern(String name, int id, double salary, String mentor) {
        super(name, id, salary);
        this.mentor = mentor;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Mentor: " + mentor);
    }
}

public class EmployeeSystemDemo {
    public static void main(String[] args) {
        Employee e1 = new Manager("Alice", 101, 80000, 10);
        Employee e2 = new Developer("Bob", 102, 60000, "Java");
        Employee e3 = new Intern("Charlie", 103, 20000, "Alice");

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
