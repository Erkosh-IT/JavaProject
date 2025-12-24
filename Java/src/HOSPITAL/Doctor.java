package HOSPITAL;

public class Doctor {

    private int id;
    private String name;
    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, String specialization, int experienceYears) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public Doctor() {
        this.id = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experienceYears = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    public void addExperience(int years) {
        this.experienceYears += years;
    }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', specialization='" +
                specialization + "', experienceYears=" + experienceYears + "}";
    }
}
