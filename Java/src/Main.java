import HOSPITAL.Person;
import HOSPITAL.Patient;
import HOSPITAL.Doctor;
import HOSPITAL.Appointment;

import java.util.ArrayList;
import java.util.Scanner;
 // менюшка
public class Main {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Person> people = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n--- HOSPITAL MENU ---");
            System.out.println("1 - Add patient");
            System.out.println("2 - View patients");
            System.out.println("3 - Add doctor");
            System.out.println("4 - View doctors");
            System.out.println("5 - Add appointment");
            System.out.println("6 - View appointments");
            System.out.println("0 - Exit");

            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addPatient();
            }

            if (choice == 2) {
                viewPatients();
            }

            if (choice == 3) {
                addDoctor();
            }

            if (choice == 4) {
                viewDoctors();
            }

            if (choice == 5) {
                addAppointment();
            }

            if (choice == 6) {
                viewAppointments();
            }

            if (choice == 0) {
                System.out.println("Program finished.");
            }
        }

        System.out.println("\n--- People list (polymorphism) ---");
        for (Person p : people) {
            System.out.println(p);
        }

        scanner.close();
    }

    // пацик

    static void addPatient() {

        System.out.print("Patient id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        Patient p = new Patient(id, name, age, diagnosis);

        patients.add(p);
        people.add(p);

        System.out.println("Patient added.");
    }

    static void viewPatients() {

        if (patients.size() == 0) {
            System.out.println("No patients.");
        }

        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i));
        }
    }

    // доктр

    static void addDoctor() {

        System.out.print("Doctor id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        Doctor d = new Doctor(id, name, spec, exp);

        doctors.add(d);
        people.add(d);

        System.out.println("Doctor added.");
    }

    static void viewDoctors() {

        if (doctors.size() == 0) {
            System.out.println("No doctors.");
        }

        for (int i = 0; i < doctors.size(); i++) {
            System.out.println(doctors.get(i));
        }
    }

    // аппойнтмент

    static void addAppointment() {

        System.out.print("Appointment id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Time: ");
        String time = scanner.nextLine();

        System.out.print("Status: ");
        String status = scanner.nextLine();

        Appointment a = new Appointment(id, date, time, status);
        appointments.add(a);

        System.out.println("Appointment added.");
    }

    static void viewAppointments() {

        if (appointments.size() == 0) {
            System.out.println("No appointments.");
        }

        for (int i = 0; i < appointments.size(); i++) {
            System.out.println(appointments.get(i));
        }
    }
}
