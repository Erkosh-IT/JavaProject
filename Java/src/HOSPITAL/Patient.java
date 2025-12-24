package HOSPITAL;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(int id, String name, int age, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public Patient() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
        this.diagnosis = "Not diagnosed";
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
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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

