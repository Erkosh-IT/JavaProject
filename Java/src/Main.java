import HOSPITAL.Appointment;
import HOSPITAL.Doctor;
import HOSPITAL.Patient;

public class Main {
    public static void main(String[] args) {

        Patient patient = new Patient(1, "John Doe", 25, "Flu");
        Doctor doctor = new Doctor(101, "Dr. Smith", "Therapist", 12);
        Appointment appointment = new Appointment(1001, "2025-01-10", "10:30", "Scheduled");

        // Print objects
        System.out.println(patient);
        System.out.println("Is adult: " + patient.isAdult());

        patient.updateDiagnosis("Recovered");
        System.out.println("Updated patient: " + patient);

        System.out.println(doctor);
        System.out.println("Experienced doctor: " + doctor.isExperienced());

        doctor.addExperience(3);
        System.out.println("Updated doctor: " + doctor);

        System.out.println(appointment);
        System.out.println("Is appointment active: " + appointment.isActive());

        appointment.cancelAppointment();
        System.out.println("Updated appointment: " + appointment);
    }
}
