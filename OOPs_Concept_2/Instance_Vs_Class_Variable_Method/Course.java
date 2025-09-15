package OOPs_Concept_2.Instance_Vs_Class_Variable_Method;

public class Course {
    String courseName;
    int duration; // in weeks
    double fee;
    static String instituteName = "ABCD Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " weeks, Fee: $" + fee + ", Institute: " + instituteName);
    }
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 12, 300.00);
        Course course2 = new Course("Web Development", 10, 250.00);

        System.out.println("Course 1 details:");
        course1.displayCourseDetails();
        System.out.println("Course 2 details:");
        course2.displayCourseDetails();

        Course.updateInstituteName("XYZ Academy");
        
        System.out.println("After updating institute name:");
        System.out.println("Course 1 details:");
        course1.displayCourseDetails();
        System.out.println("Course 2 details:");
        course2.displayCourseDetails();
    }
}
