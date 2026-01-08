package HOSPITAL;

public class Person {


    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
        this(1, "Unknown");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return "Person";
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Name='" + name + "'";
    }
}
