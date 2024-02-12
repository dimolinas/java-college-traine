package model;

import java.util.UUID;

public class PartTimeProfessor extends Professor implements SalaryCalculator {
    public PartTimeProfessor(UUID uuid, String name, double baseSalary) {
        super(uuid, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
