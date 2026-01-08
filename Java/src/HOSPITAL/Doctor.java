package HOSPITAL;

public class Doctor extends Person {

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

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            this.specialization = "General";
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String toString() {
        return getRole() + " {" +
                super.toString() +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
