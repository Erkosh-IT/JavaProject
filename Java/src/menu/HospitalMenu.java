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
        System.out.println("1-Add patient  2-View patients");
        System.out.println("3-Add doctor   4-View doctors");
        System.out.println("5-Add appointment     6-View appointments");
        System.out.println("7-Polymorphism 0-Exit");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice == 0) break;
                executeChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Enter number 0-7!");
            }
        }
        System.out.println("Program finished.");
        scanner.close();
    }

    private void executeChoice(int choice) {
        switch (choice) {
            case 1 -> addPatient();
            case 2 -> viewPatients();
            case 3 -> addDoctor();
            case 4 -> viewDoctors();
            case 5 -> addAppointment();
            case 6 -> viewAppointments();
            case 7 -> demonstratePolymorphism();
            default -> System.out.println("Invalid: 0-7");
        }
    }

    private <T extends Person> void addPerson(String type, String[] prompts, PersonCreator<T> creator) {
        try {
            String[] inputs = new String[prompts.length];
            for (int i = 0; i < prompts.length; i++) {
                System.out.print(prompts[i] + ": ");
                inputs[i] = scanner.nextLine().trim();
            }
            T person = creator.create(inputs);
            people.add(person);
            System.out.println(type + " added: " + person.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FunctionalInterface
    interface PersonCreator<T> {
        T create(String[] inputs);
    }

    private void addPatient() {
        addPerson("Patient", new String[]{"ID", "Name", "Age", "Diagnosis"},
                inputs -> new Patient(
                        Integer.parseInt(inputs[0]), inputs[1],
                        Integer.parseInt(inputs[2]), inputs[3]));
    }

    private void addDoctor() {
        addPerson("Doctor", new String[]{"ID", "Name", "Specialization", "Experience"},
                inputs -> new Doctor(
                        Integer.parseInt(inputs[0]), inputs[1], inputs[2],
                        Integer.parseInt(inputs[3])));
    }

    private void addAppointment() {
        try {
            System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Date: "); String date = scanner.nextLine().trim();
            System.out.print("Time: "); String time = scanner.nextLine().trim();
            System.out.print("Status: "); String status = scanner.nextLine().trim();
            appointments.add(new Appointment(id, date, time, status));
            System.out.println("Appointment added.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewPatients() {
        printList("Patients", p -> p instanceof Patient);
    }

    private void viewDoctors() {
        printList("Doctors", p -> p instanceof Doctor);
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

    private void printList(String title, java.util.function.Predicate<Person> filter) {
        var filtered = people.stream().filter(filter).toList();
        if (filtered.isEmpty()) {
            System.out.println("No " + title.toLowerCase() + ".");
            return;
        }
        System.out.println("--- " + title + " ---");
        for (int i = 0; i < filtered.size(); i++) {
            System.out.println((i + 1) + ". " + filtered.get(i));
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
        if (!people.isEmpty()) {
            var doctor = people.stream()
                    .filter(p -> p instanceof Doctor)
                    .map(p -> (Doctor) p)
                    .findFirst();
            doctor.ifPresent(d -> {
                System.out.print("Treatable: ");
                d.treatPatient();
                System.out.println(d.getTreatmentInfo());
            });
        }
    }
}
