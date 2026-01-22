package menu;

import HOSPITAL.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private List<Person> people = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
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
        while (true) {
            displayMenu();
            System.out.print("Your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice == 0) {
                    System.out.println("Program finished.");
                    break;
                }
                if (choice == 1) addPatient();
                else if (choice == 2) viewPatients();
                else if (choice == 3) addDoctor();
                else if (choice == 4) viewDoctors();
                else if (choice == 5) addAppointment();
                else if (choice == 6) viewAppointments();
                else if (choice == 7) demonstratePolymorphism();
                else System.out.println("Invalid choice! Enter 0-7.");
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
            System.out.print("Patient ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Diagnosis: ");
            String diagnosis = scanner.nextLine().trim();

            Patient patient = new Patient(id, name, age, diagnosis);
            people.add(patient);
            System.out.println("Patient added: " + name);
        } catch (NumberFormatException e) {
            System.out.println("ID/Age must be numbers!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addDoctor() {
        try {
            System.out.print("Doctor ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Specialization: ");
            String specialization = scanner.nextLine().trim();
            System.out.print("Experience years: ");
            int experience = Integer.parseInt(scanner.nextLine().trim());

            Doctor doctor = new Doctor(id, name, specialization, experience);
            people.add(doctor);
            System.out.println("Doctor added: " + name);
        } catch (NumberFormatException e) {
            System.out.println("ID/Experience must be numbers!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addAppointment() {
        try {
            System.out.print("Appointment ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Date: ");
            String date = scanner.nextLine().trim();
            System.out.print("Time: ");
            String time = scanner.nextLine().trim();
            System.out.print("Status: ");
            String status = scanner.nextLine().trim();

            Appointment appointment = new Appointment(id, date, time, status);
            appointments.add(appointment);
            System.out.println("Appointment added.");
        } catch (NumberFormatException e) {
            System.out.println("ID must be number!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewPatients() {
        boolean hasPatients = false;
        System.out.println("\n--- PATIENTS ---");
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof Patient) {
                System.out.println((i + 1) + ". " + people.get(i));
                hasPatients = true;
            }
        }
        if (!hasPatients) {
            System.out.println("No patients.");
        }
    }

    private void viewDoctors() {
        boolean hasDoctors = false;
        System.out.println("\n--- DOCTORS ---");
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof Doctor) {
                System.out.println((i + 1) + ". " + people.get(i));
                hasDoctors = true;
            }
        }
        if (!hasDoctors) {
            System.out.println("No doctors.");
        }
    }

    private void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }
        System.out.println("\n--- APPOINTMENTS ---");
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
        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.print(p.getRole() + " (" + p.getName() + "): ");
            p.performDuty();
        }
    }
}
