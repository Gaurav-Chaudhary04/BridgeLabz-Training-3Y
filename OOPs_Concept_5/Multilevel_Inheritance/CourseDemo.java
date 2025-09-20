package OOPs_Concept_5.Multilevel_Inheritance;

// Multilevel Inheritance: Educational Course Hierarchy
class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void displayCourse() {
        System.out.println(courseName + " (" + duration + " hrs) - Platform: " + platform +
                ", Fee: " + fee + ", Discount: " + discount + "%");
    }
}

public class CourseDemo {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse("AI Fundamentals", 40, "Coursera", true, 5000, 20);
        poc.displayCourse();
    }
}
