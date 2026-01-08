package HOSPITAL;

public class Patient extends Person {

    private int age;
    private String diagnosis;

    public Patient(int id, String name, int age, String diagnosis) {
        super(id, name);
        setAge(age);
        setDiagnosis(diagnosis);
    }

    public Patient() {
        this(1, "Unknown", 0, "Not diagnosed");
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis != null && !diagnosis.trim().isEmpty()) {
            this.diagnosis = diagnosis;
        } else {
            this.diagnosis = "Not diagnosed";
        }
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String toString() {
        return getRole() + " {" +
                super.toString() +
                ", age=" + age +
                ", diagnosis='" + diagnosis + "'}";
    }
}
