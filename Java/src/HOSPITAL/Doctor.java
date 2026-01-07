package HOSPITAL;

public class Doctor {

    private int id;
    private String name;
    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, String specialization, int experienceYears) {
        setId(id);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public Doctor() {
        this(1, "Unknown", "General", 0);
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
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Invalid ID. Set to 1.");
            this.id = 1;
        }
    }


    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty. Set to 'Unknown'.");
            this.name = "Unknown";
        }
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
            System.out.println("Experience cannot be negative. Set to 0.");
            this.experienceYears = 0;
        }
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
