package model;

import java.util.UUID;

public class FullTimeProfessor extends Professor implements SalaryCalculator {
    private int hoursPerWeek;

    public FullTimeProfessor(UUID uuid, String name, double baseSalary, int hoursPerWeek) {
        super(uuid, name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
