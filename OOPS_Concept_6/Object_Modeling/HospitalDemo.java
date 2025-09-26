package OOPS_Concept_6.Object_Modeling;

import java.util.*;

/**
 * HospitalDemo: Hospital contains doctors and patients.
 * Doctors consult patients and return a Prescription object.
 *
 * Compile: javac HospitalDemo.java
 * Run:     java HospitalDemo
 */
public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("D001", "Dr. Aisha");
        Doctor d2 = new Doctor("D002", "Dr. Raj");

        Patient p1 = new Patient("P001", "Neha");
        Patient p2 = new Patient("P002", "Sameer");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.registerPatient(p1);
        hospital.registerPatient(p2);

        // Patient requests consultation with a doctor
        Prescription pr1 = d1.consult(p1, "fever and sore throat");
        System.out.println("Prescription issued: " + pr1);

        Prescription pr2 = d2.consult(p2, "back pain");
        System.out.println("Prescription issued: " + pr2);

        // Hospital listing
        hospital.listDoctors();
        hospital.listPatients();
    }
}

/* ------------------ Supporting classes ------------------ */

class Hospital {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public Hospital(String name) { this.name = name; }

    public void addDoctor(Doctor d) { doctors.add(d); }
    public void registerPatient(Patient p) { patients.add(p); }

    public void listDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor d : doctors) System.out.println("  " + d);
    }

    public void listPatients() {
        System.out.println("Registered patients at " + name + ":");
        for (Patient p : patients) System.out.println("  " + p);
    }
}

class Doctor {
    private String id;
    private String name;
    private List<Prescription> issued = new ArrayList<>();

    public Doctor(String id, String name) { this.id = id; this.name = name; }

    // consult returns a Prescription and records it
    public Prescription consult(Patient p, String complaint) {
        System.out.println(name + " consulting " + p.getName() + " (" + complaint + ")");
        Prescription pres = new Prescription(UUID.randomUUID().toString(), this, p, generateMedicines(complaint));
        issued.add(pres);
        p.addHistory(pres);
        return pres;
    }

    private List<String> generateMedicines(String complaint) {
        // simplistic rule-based prescription generator (demo only)
        List<String> meds = new ArrayList<>();
        if (complaint.toLowerCase().contains("fever")) {
            meds.add("Paracetamol");
        }
        if (complaint.toLowerCase().contains("throat")) {
            meds.add("Lozenges");
        }
        if (complaint.toLowerCase().contains("pain")) {
            meds.add("Ibuprofen");
        }
        if (meds.isEmpty()) meds.add("Multivitamin");
        return meds;
    }

    @Override
    public String toString() { return id + " - " + name; }
}

class Patient {
    private String id;
    private String name;
    private List<Prescription> history = new ArrayList<>();

    public Patient(String id, String name) { this.id = id; this.name = name; }

    public String getName() { return name; }
    public void addHistory(Prescription p) { history.add(p); }

    @Override
    public String toString() { return id + " - " + name + " (visits=" + history.size() + ")"; }
}

class Prescription {
    private String presId;
    private Doctor doctor;
    private Patient patient;
    private List<String> medicines;

    public Prescription(String presId, Doctor d, Patient p, List<String> meds) {
        this.presId = presId;
        this.doctor = d;
        this.patient = p;
        this.medicines = meds;
    }

    @Override
    public String toString() {
        return "Prescription{" + presId + ", Doctor=" + doctor + ", Patient=" + patient +
                ", meds=" + medicines + "}";
    }
}
