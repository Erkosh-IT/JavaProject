import HOSPITAL.Patient;
import HOSPITAL.Doctor;
import HOSPITAL.Appointment;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== HOSPITAL SYSTEM ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Add Appointment");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // important!

            if (choice == 1) {
                addPatient();
            } else if (choice == 2) {
                viewPatients();
            } else if (choice == 3) {
                addDoctor();
            } else if (choice == 4) {
                viewDoctors();
            } else if (choice == 5) {
                addAppointment();
            } else if (choice == 6) {
                viewAppointments();
            } else if (choice == 0) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Wrong choice!");
            }

            if (running) {
                System.out.println("Press Enter...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void addPatient() {
        System.out.print("Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("Patient added!");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients.");
            return;
        }

        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private static void addDoctor() {
        System.out.print("Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        doctors.add(new Doctor(id, name, spec, exp));
        System.out.println("Doctor added!");
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors.");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    private static void addAppointment() {
        System.out.print("Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Time: ");
        String time = scanner.nextLine();

        System.out.print("Status: ");
        String status = scanner.nextLine();

        appointments.add(new Appointment(id, date, time, status));
        System.out.println("Appointment added!");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}
