package menu;

import HOSPITAL.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Person> people = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== HOSPITAL MENU ===");
        System.out.println("1 - Add patient");
        System.out.println("2 - View patients");
        System.out.println("3 - Add doctor");
        System.out.println("4 - View doctors");
        System.out.println("5 - Add appointment");
        System.out.println("6 - View appointments");
        System.out.println("7 - Polymorphism demo");
        System.out.println("0 - Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Your choice: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> addPatient();
                    case 2 -> viewPatients();
                    case 3 -> addDoctor();
                    case 4 -> viewDoctors();
                    case 5 -> addAppointment();
                    case 6 -> viewAppointments();
                    case 7 -> demonstratePolymorphism();
                    case 0 -> {
                        running = false;
                        System.out.println("Program finished.");
                    }
                    default -> System.out.println("Invalid choice! Enter 0-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error! Enter NUMBER (0-7)");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void addPatient() {
        try {
            System.out.print("Patient ID: "); int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: "); String name = scanner.nextLine().trim();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Diagnosis: "); String diagnosis = scanner.nextLine().trim();
            Patient p = new Patient(id, name, age, diagnosis);
            patients.add(p);
            people.add(p);
            System.out.println("Patient added: " + p.getName());
        } catch (NumberFormatException e) {
            System.out.println("ID/Age: enter NUMBER!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients.");
            return;
        }
        System.out.println("--- Patients ---");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }
    }

    private void addDoctor() {
        try {
            System.out.print("Doctor ID: "); int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: "); String name = scanner.nextLine().trim();
            System.out.print("Specialization: "); String spec = scanner.nextLine().trim();
            System.out.print("Experience years: "); int exp = Integer.parseInt(scanner.nextLine().trim());
            Doctor d = new Doctor(id, name, spec, exp);
            doctors.add(d);
            people.add(d);
            System.out.println("Doctor added: " + d.getName());
        } catch (NumberFormatException e) {
            System.out.println("ID/Experience: enter NUMBER!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors.");
            return;
        }
        System.out.println("--- Doctors ---");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
    }

    private void addAppointment() {
        try {
            System.out.print("Appointment ID: "); int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Date: "); String date = scanner.nextLine().trim();
            System.out.print("Time: "); String time = scanner.nextLine().trim();
            System.out.print("Status: "); String status = scanner.nextLine().trim();
            Appointment a = new Appointment(id, date, time, status);
            appointments.add(a);
            System.out.println("Appointment added.");
        } catch (NumberFormatException e) {
            System.out.println("ID: enter NUMBER!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }
        System.out.println("--- Appointments ---");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i + 1) + ". " + appointments.get(i));
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        if (people.isEmpty()) {
            System.out.println("Add people first!");
            return;
        }
        for (Person p : people) {
            System.out.print(p.getRole() + " (" + p.getName() + "): ");
            p.performDuty();
        }
        if (!doctors.isEmpty()) {
            Doctor doc = doctors.get(0);
            System.out.print("Treatable (" + doc.getName() + "): ");
            doc.treatPatient();
            System.out.println(doc.getTreatmentInfo());
        }
    }
}
