package model;

import model.Person;

import java.util.UUID;

public class Student extends Person {
    private int age;
    public Student(UUID uuid, String name, int age) {
        super(uuid, name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
