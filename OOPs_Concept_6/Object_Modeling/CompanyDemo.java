package OOPs_Concept_6.Object_Modeling;

import java.util.*;

/**
 * CompanyDemo: Company composes Department which composes Employees (composition).
 *
 * Compile: javac CompanyDemo.java
 * Run:     java CompanyDemo
 */
public class CompanyDemo {
    public static void main(String[] args) {
        Company comp = new Company("TechCorp");
        Department rd = comp.createDepartment("R&D");
        Department hr = comp.createDepartment("HR");

        rd.addEmployee(new Employee("E001", "Amit"));
        rd.addEmployee(new Employee("E002", "Sana"));
        hr.addEmployee(new Employee("E003", "Rita"));

        comp.listDepartments();

        System.out.println("\\nClosing company...");
        comp.closeCompany();
        comp.listDepartments();
    }
}

/* Supporting classes */
class Employee {
    private String id, name;
    public Employee(String id, String name){ this.id = id; this.name = name; }
    @Override public String toString(){ return id + ":" + name; }
}

class Department {
    private String name;
    private List<Employee> employees = new ArrayList<>();
    Department(String name){ this.name = name; }
    public void addEmployee(Employee e){ employees.add(e); }
    public void removeAllEmployees(){ employees.clear(); }
    @Override public String toString(){ return name + " | Employees=" + employees.size(); }
}

class Company {
    private String name;
    private List<Department> departments = new ArrayList<>();
    public Company(String name){ this.name = name; }
    public Department createDepartment(String name){
        Department d = new Department(name);
        departments.add(d);
        return d;
    }
    public void listDepartments(){
        System.out.println("Company: " + name);
        if(departments.isEmpty()) System.out.println("  No departments.");
        else departments.forEach(d -> System.out.println("  " + d));
    }
    public void closeCompany(){
        departments.forEach(Department::removeAllEmployees);
        departments.clear();
        System.out.println(name + " closed and departments removed.");
    }
}
