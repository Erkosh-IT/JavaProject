package HOSPITAL;

public class Doctor extends Person implements Treatable {
    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, String specialization, int experienceYears) {
        super(id, name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public Doctor() {
        this(1, "Unknown", "General", 0);
    }

    public String getSpecialization() { return specialization; }
    public int getExperienceYears() { return experienceYears; }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) throw new IllegalArgumentException("Specialization cannot be empty");
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) throw new IllegalArgumentException("Experience cannot be negative");
        this.experienceYears = experienceYears;
    }

    public boolean isExperienced() { return experienceYears >= 10; }

    @Override
    public String getRole() { return "Doctor"; }

    @Override
    public void performDuty() {
        System.out.println("Doctor " + getName() + " is conducting appointment");
    }

    @Override
    public void treatPatient() {
        System.out.println("Doctor " + getName() + " is treating patient");
    }

    @Override
    public String getTreatmentInfo() {
        return "Specialization: " + specialization + ", Experience: " + experienceYears + " years";
    }

    @Override
    public String toString() {
        return getRole() + " {" + super.toString() + ", specialization='" + specialization + "', experienceYears=" + experienceYears + "}";
    }
}
