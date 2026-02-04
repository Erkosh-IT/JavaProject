package menu;
import HOSPITAL.Doctor;
import HOSPITAL.DoctorDAO;
import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private DoctorDAO doctorDAO = new DoctorDAO();

    @Override
    public void displayMenu() {
        System.out.println("\n--- DATABASE MENU ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Update Specialization");
        System.out.println("4. Delete Doctor");
        System.out.println("5. Search by Name");
        System.out.println("6. Search by Experience (Numeric Search)");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Select: ");
            String input = scanner.nextLine();

            if (input.equals("0")) break;

            if (input.equals("1")) {
                addDoctor();
            } else if (input.equals("2")) {
                viewDoctors();
            } else if (input.equals("3")) {
                updateDoctor();
            } else if (input.equals("4")) {
                deleteDoctor();
            } else if (input.equals("5")) {
                searchDoctor();
            } else if (input.equals("6")) {
                searchByExperience();
            } else {
                System.out.println("Wrong command.");
            }
        }
    }


    private void addDoctor() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Specialization: ");
            String spec = scanner.nextLine();

            System.out.print("Experience: ");
            int exp = Integer.parseInt(scanner.nextLine());

            Doctor d = new Doctor(id, name, spec, exp);
            doctorDAO.addDoctor(d);

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    private void viewDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();

        System.out.println("\n--- LIST ---");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    private void updateDoctor() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("New Specialization: ");
        String spec = scanner.nextLine();

        doctorDAO.updateSpecialization(id, spec);
    }

    private void deleteDoctor() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        doctorDAO.deleteDoctor(id);
    }

    private void searchDoctor() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Doctor> results = doctorDAO.searchByName(name);

        System.out.println("--- FOUND ---");
        for (Doctor d : results) {
            System.out.println(d);
        }
    }
    private void searchByExperience() {
        System.out.print("Enter minimum experience years: ");
        int exp = Integer.parseInt(scanner.nextLine());
        List<Doctor> result = doctorDAO.searchByExperience(exp);
    }
}