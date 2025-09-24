package OOPs_Concept_6.Object_Modeling;

import java.util.*;

/**
 * UniversityManagementDemo: University Management System (fixed version)
 * - Student enrolls in Course (many-to-many)
 * - Professor assigned to Course (one professor per course, professor can teach many courses)
 *
 * Compile: javac UniversityManagementDemo.java
 * Run:     java UniversityManagementDemo
 */
public class UniversityManagementDemo {
    public static void main(String[] args) {
        Professor prof1 = new Professor("P100", "Dr. Sen");
        Professor prof2 = new Professor("P200", "Dr. Iyer");

        Course db = new Course("CS301", "Databases");
        Course algo = new Course("CS302", "Algorithms");
        Course os = new Course("CS303", "Operating Systems");

        prof1.assignCourse(db);
        prof1.assignCourse(os);
        prof2.assignCourse(algo);

        Student s1 = new Student("S101", "Gaurav");
        Student s2 = new Student("S102", "Anita");
        Student s3 = new Student("S103", "Rahul");

        s1.enrollCourse(db);
        s1.enrollCourse(algo);

        s2.enrollCourse(algo);
        s2.enrollCourse(os);

        s3.enrollCourse(db);
        s3.enrollCourse(algo);
        s3.enrollCourse(os);

        System.out.println("=== Courses and their Professors ===");
        db.printDetails();
        algo.printDetails();
        os.printDetails();

        System.out.println("\n=== Student enrollments ===");
        s1.printCourses();
        s2.printCourses();
        s3.printCourses();

        System.out.println("\n=== Professor course loads ===");
        prof1.printCourses();
        prof2.printCourses();
    }
}

/* ------------------ Supporting classes ------------------ */

class Student {
    private String id;
    private String name;
    private Set<Course> courses = new HashSet<>();

    public Student(String id, String name) { this.id = id; this.name = name; }

    public void enrollCourse(Course c) {
        if (courses.add(c)) {
            c.addStudent(this);
            System.out.println(name + " enrolled in " + c.getCode());
        }
    }

    public void dropCourse(Course c) {
        if (courses.remove(c)) {
            c.removeStudent(this);
            System.out.println(name + " dropped " + c.getCode());
        }
    }

    public void printCourses() {
        System.out.println(id + " - " + name + " enrolled in:");
        if (courses.isEmpty()) System.out.println("  (none)");
        for (Course c : courses) {
            System.out.println("  " + c.getCode() + " - " + c.getTitle());
        }
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class Professor {
    private String id;
    private String name;
    private Set<Course> courses = new HashSet<>();

    public Professor(String id, String name) { this.id = id; this.name = name; }

    public void assignCourse(Course c) {
        if (c.getProfessor() != null && c.getProfessor() != this) {
            System.out.println("Course " + c.getCode() + " is already assigned to " + c.getProfessor().getName());
            return;
        }
        if (courses.add(c)) {
            c.setProfessor(this); // safe: uses setter
            System.out.println(name + " assigned to teach " + c.getCode());
        }
    }

    // helper for Course to sync professor's side
    void addCourseInternal(Course c) { courses.add(c); }

    public void printCourses() {
        System.out.println(id + " - " + name + " teaches:");
        if (courses.isEmpty()) System.out.println("  (none)");
        for (Course c : courses) {
            System.out.println("  " + c.getCode() + " - " + c.getTitle());
        }
    }

    public String getName() { return name; }

    @Override
    public String toString() { return id + " - " + name; }
}

class Course {
    private String code;
    private String title;
    private Professor professor; 
    private Set<Student> students = new HashSet<>();

    public Course(String code, String title) { this.code = code; this.title = title; }

    public void setProfessor(Professor p) {
        this.professor = p;
        p.addCourseInternal(this); // use helper instead of direct field access
    }

    public Professor getProfessor() { return professor; }
    public String getCode() { return code; }
    public String getTitle() { return title; }

    void addStudent(Student s) { students.add(s); }
    void removeStudent(Student s) { students.remove(s); }

    public void printDetails() {
        System.out.println(code + " - " + title);
        System.out.println("  Professor: " + (professor == null ? "(none)" : professor));
        System.out.println("  Enrolled students (" + students.size() + "):");
        for (Student s : students) System.out.println("    " + s);
    }

    @Override
    public String toString() { return code + " - " + title; }
}