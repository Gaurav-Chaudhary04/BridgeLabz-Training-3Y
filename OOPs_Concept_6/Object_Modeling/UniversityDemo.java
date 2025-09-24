package OOPs_Concept_6.Object_Modeling;

import java.util.*;

/**
 * UniversityDemo: University composes Departments (departments are created/owned by University).
 * Faculty objects are aggregated (they may be created outside and assigned).
 *
 * Compile: javac UniversityDemo.java
 * Run:     java UniversityDemo
 */
public class UniversityDemo {
    public static void main(String[] args) {
        // Faculties can be created independently (aggregation)
        Faculty f1 = new Faculty("F101", "Dr. Sharma");
        Faculty f2 = new Faculty("F102", "Dr. Meera");
        Faculty f3 = new Faculty("F103", "Dr. Khan");

        // University composes Departments (created by University)
        University uni = new University("National University");
        Department csDept = uni.createDepartment("CS", "Computer Science");
        Department eeDept = uni.createDepartment("EE", "Electrical Engineering");

        // assign faculty to departments (aggregation)
        csDept.addFaculty(f1);
        csDept.addFaculty(f2);
        eeDept.addFaculty(f3);

        // add employees to departments
        csDept.addStaffMember("TA: Aakash");
        eeDept.addStaffMember("TA: Ritu");

        // show snapshot
        uni.listDepartments();

        // close university -> composition semantics: departments removed
        System.out.println("\\nClosing university...");
        uni.closeUniversity();
        uni.listDepartments(); // should be empty
        // Faculties still exist independently
        System.out.println("\\nFaculty still exist (aggregation): " + f1 + ", " + f2 + ", " + f3);
    }
}

/* ------------------ Supporting classes ------------------ */

class University {
    private String name;
    // composition: University owns Department objects (lifecycle tied)
    private List<Department> departments = new ArrayList<>();

    public University(String name) { this.name = name; }

    public Department createDepartment(String code, String title) {
        Department d = new Department(code, title);
        departments.add(d);
        return d;
    }

    public void listDepartments() {
        System.out.println("University: " + name);
        if (departments.isEmpty()) System.out.println("  No departments.");
        else departments.forEach(d -> System.out.println("  " + d));
    }

    // composition: closing university should remove departments and their staff
    public void closeUniversity() {
        departments.forEach(Department::removeAllStaff);
        departments.clear();
        System.out.println(name + " is closed. Departments removed.");
    }
}

class Department {
    private String code;
    private String title;
    private List<String> staff = new ArrayList<>();
    private List<Faculty> faculties = new ArrayList<>(); // aggregation

    Department(String code, String title) { this.code = code; this.title = title; }

    public void addFaculty(Faculty f) { faculties.add(f); }
    public void removeFaculty(Faculty f) { faculties.remove(f); }

    public void addStaffMember(String member) { staff.add(member); }
    public void removeAllStaff() { staff.clear(); }

    @Override
    public String toString() {
        return code + " - " + title + " | Faculties=" + faculties.size() + " Staff=" + staff.size();
    }
}

class Faculty {
    private String id;
    private String name;

    public Faculty(String id, String name) { this.id = id; this.name = name; }

    @Override
    public String toString() { return id + ":" + name; }
}
