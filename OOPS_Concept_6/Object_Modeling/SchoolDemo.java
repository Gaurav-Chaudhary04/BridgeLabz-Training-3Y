package OOPS_Concept_6.Object_Modeling;

import java.util.*;

/**
 * SchoolDemo: School aggregates Student (students can exist independently).
 * Student <-> Course is many-to-many association.
 *
 * Compile: javac SchoolDemo.java
 * Run:     java SchoolDemo
 */
public class SchoolDemo {
    public static void main(String[] args) {
        // create courses
        Course math = new Course("MTH101", "Mathematics");
        Course cs = new Course("CS101", "Intro to CS");
        Course hist = new Course("HIS101", "World History");

        // students (can exist before being added to School) -> aggregation
        Student s1 = new Student("S001", "Gaurav");
        Student s2 = new Student("S002", "Priya");

        // enroll students in courses
        s1.enrollCourse(math);
        s1.enrollCourse(cs);
        s2.enrollCourse(cs);
        s2.enrollCourse(hist);

        // create school and add students (aggregation)
        School school = new School("City High School");
        school.addStudent(s1);
        school.addStudent(s2);

        // show data
        System.out.println("=== School Snapshot ===");
        school.listStudents();

        System.out.println("\\n=== Course rosters ===");
        math.listStudents();
        cs.listStudents();
        hist.listStudents();

        // student leaves a course
        s2.dropCourse(cs);
        System.out.println("\\nAfter Priya drops CS:");
        cs.listStudents();
        s2.listCourses();
    }
}

/* ------------------ Supporting classes ------------------ */

class School {
    private String name;
    private List<Student> students = new ArrayList<>();

    public School(String name) { this.name = name; }

    // aggregation: Student objects are created outside and passed in
    public void addStudent(Student s) { students.add(s); }
    public void removeStudent(Student s) { students.remove(s); }

    public void listStudents() {
        System.out.println("School: " + name);
        if (students.isEmpty()) System.out.println("  No students.");
        for (Student s : students) System.out.println("  " + s);
    }
}

class Student {
    private String id;
    private String name;
    private Set<Course> courses = new HashSet<>(); // many-to-many

    public Student(String id, String name) { this.id = id; this.name = name; }

    public void enrollCourse(Course c) {
        if (courses.add(c)) {
            c.addStudent(this); // keep both sides consistent
        }
    }

    public void dropCourse(Course c) {
        if (courses.remove(c)) {
            c.removeStudent(this);
        }
    }

    public void listCourses() {
        System.out.println("Courses for " + name + ":");
        if (courses.isEmpty()) System.out.println("  None");
        for (Course c : courses) System.out.println("  " + c);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class Course {
    private String code;
    private String title;
    private Set<Student> enrolled = new HashSet<>();

    public Course(String code, String title) { this.code = code; this.title = title; }

    // called by Student.enrollCourse to maintain bidirectional link
    void addStudent(Student s) { enrolled.add(s); }
    void removeStudent(Student s) { enrolled.remove(s); }

    public void listStudents() {
        System.out.println("Course: " + code + " - " + title);
        if (enrolled.isEmpty()) System.out.println("  No students enrolled.");
        for (Student s : enrolled) System.out.println("  " + s);
    }

    @Override
    public String toString() { return code + " - " + title; }
}
