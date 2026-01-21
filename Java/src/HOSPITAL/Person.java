package HOSPITAL;

public abstract class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        setId(id);
        setName(name);
    }

    public Person() {
        this(1, "Unknown");
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public abstract String getRole();
    public abstract void performDuty();

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be > 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Name='" + name + "'";
    }
}
