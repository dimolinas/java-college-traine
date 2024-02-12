package model;

import model.Person;

import java.util.UUID;

public class Professor extends Person {
    private double baseSalary;
    private double totalSalary = 0;

    public Professor(UUID uuid, String name, double baseSalary) {
        super(uuid, name);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
