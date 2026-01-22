package HOSPITAL;

public class Patient extends Person{
    private int age;
    private String diagnosis;

    public Patient(int id, String name, int age, String diagnosis){
    super(id,name);
    setAge(age);
    setDiagnosis(diagnosis);
    }
    public Patient(){
        this(1, "Unknown", 0, "Not Diagnosed");
    }
    public int getAge(){
        return age;
    }
    public String getDiagnosis(){
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) throw new IllegalArgumentException("DIAGNOSIS CANNOT BE EMPTY");
        this.diagnosis = diagnosis;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("AGE CANNOT BE < 0");
        this.age = age;
    }

    public boolean isAdult(){
        return age >= 18;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public void performDuty() {
    System.out.println("Patient " + getName() + " is waiting for appointment");
    }

    @Override
    public String toString(){
        return getRole() + " {" + super.toString() + ", age=" + age + ", diagnosis='" + diagnosis + "'}";
    }
}