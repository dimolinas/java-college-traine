package model;

public class Student extends Person {
    private int age;

    public Student(int id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-15s | %-20s | %-3s |",
                "id=" + getId(),
                "name=" + getName(),
                "age=" + age
        );
    }
}
