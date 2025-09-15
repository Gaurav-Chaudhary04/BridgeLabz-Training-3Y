// HospitalPatientManagement.java
import java.util.*;

abstract class Patient {
    private final String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        if (patientId == null || patientId.isBlank()) throw new IllegalArgumentException("Invalid patient id");
        this.patientId = patientId;
        setName(name);
        setAge(age);
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required"); this.name = name; }
    public void setAge(int age) { if (age < 0) throw new IllegalArgumentException("Age invalid"); this.age = age; }

    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.printf("ID: %s | Name: %s | Age: %d | Bill: %.2f%n", patientId, name, age, calculateBill());
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private final List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, int daysAdmitted, double dailyRate) {
        super(id, name, age);
        this.daysAdmitted = Math.max(0, daysAdmitted);
        this.dailyRate = Math.max(0, dailyRate);
    }

    @Override public double calculateBill() { return daysAdmitted * dailyRate; }
    @Override public void addRecord(String record) { records.add(record); }
    @Override public List<String> viewRecords() { return Collections.unmodifiableList(records); }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private final List<String> records = new ArrayList<>();

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = Math.max(0, consultationFee);
    }

    @Override public double calculateBill() { return consultationFee; }
    @Override public void addRecord(String record) { records.add(record); }
    @Override public List<String> viewRecords() { return Collections.unmodifiableList(records); }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient ip = new InPatient("IP100","Anita",45,5,2000);
        Patient op = new OutPatient("OP200","Vikram",30,500);

        ((MedicalRecord) ip).addRecord("Surgery: appendectomy");
        ((MedicalRecord) op).addRecord("Consultation: cold and fever");

        List<Patient> patients = Arrays.asList(ip, op);
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Records: " + ((MedicalRecord) p).viewRecords());
            System.out.println("---");
        }
    }
}