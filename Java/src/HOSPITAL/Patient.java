package HOSPITAL;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(int id, String name, int age, String diagnosis) {
        setId(id);
        setName(name);
        setAge(age);
        this.diagnosis = diagnosis;
    }

    public Patient() {
        this(1, "Unknown", 0, "Not diagnosed");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
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
            System.out.println("Name cannot be empty.");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Set to 0.");
            this.age = 0;
        }
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public void updateDiagnosis(String newDiagnosis) {
        this.diagnosis = newDiagnosis;
    }
    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "', age=" + age +
                ", diagnosis='" + diagnosis + "'}";
    }
}

