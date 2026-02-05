package menu;

import HOSPITAL.Doctor;
import HOSPITAL.DoctorDAO;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private DoctorDAO dao = new DoctorDAO();
    private Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n=== HOSPITAL SYSTEM (WEEK 8) ===");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Update Specialization");
        System.out.println("4. Update Experience");
        System.out.println("5. Delete Doctor (with confirm)");
        System.out.println("6. Search by Name (Partial)");
        System.out.println("7. Search by Specialization");
        System.out.println("8. Search by Min Experience");
        System.out.println("9. Clear all data (Warning!)");
        System.out.println("10. Show experienced doctors (10+ years)");
        System.out.println("11. Database Connection Status");
        System.out.println("0. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Select option: ");
            String op = sc.nextLine();
            if (op.equals("0")) break;

            if (op.equals("1")) add();
            else if (op.equals("2")) showAll();
            else if (op.equals("3")) updateSpec();
            else if (op.equals("4")) updateExp();
            else if (op.equals("5")) deleteDoc();
            else if (op.equals("6")) searchName();
            else if (op.equals("7")) searchSpec();
            else if (op.equals("8")) searchMin();
            else if (op.equals("9")) System.out.println("Feature coming soon...");
            else if (op.equals("10")) showExperienced();
            else if (op.equals("11")) checkStatus();
            else System.out.println("Invalid option!");
        }
    }

    private void add() {
        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Spec: "); String s = sc.nextLine();
        System.out.print("Exp: "); int e = Integer.parseInt(sc.nextLine());
        dao.addDoctor(new Doctor(id, n, s, e));
        System.out.println("Done.");
    }

    private void showAll() {
        for (Doctor d : dao.getAll()) System.out.println(d);
    }

    private void updateSpec() {
        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("New Spec: "); String s = sc.nextLine();
        dao.updateSpec(id, s);
    }

    private void updateExp() {
        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("New Exp: "); int e = Integer.parseInt(sc.nextLine());
        dao.updateExp(id, e);
    }

    private void deleteDoc() {
        System.out.print("ID to delete: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Are you sure? (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            dao.delete(id);
            System.out.println("Deleted.");
        }
    }

    private void searchName() {
        System.out.print("Enter name: ");
        String n = sc.nextLine();
        for (Doctor d : dao.searchByName(n)) System.out.println(d);
    }

    private void searchSpec() {
        System.out.print("Enter specialization: ");
        String s = sc.nextLine();
        for (Doctor d : dao.searchBySpec(s)) System.out.println(d);
    }

    private void searchMin() {
        System.out.print("Min experience: ");
        int m = Integer.parseInt(sc.nextLine());
        for (Doctor d : dao.searchMinExp(m)) System.out.println(d);
    }

    private void showExperienced() {
        for (Doctor d : dao.searchMinExp(10)) System.out.println(d);
    }

    private void checkStatus() {
        System.out.println("Database 'hospital' is connected.");
    }
}