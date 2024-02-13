package model.professor;

public class FullTimeProfessor extends Professor implements SalaryCalculator {
    private int hoursPerWeek;

    public FullTimeProfessor(int id, String name, double baseSalary, int hoursPerWeek) {
        super(id, name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
        calculateSalary();
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public void calculateSalary() {
        setTotalSalary(getBaseSalary() * getHoursPerWeek());
        System.out.println("el");
    }

    @Override
    public String toString() {
        return String.format(
                "| %-15s | %-20s | %-15s | %-20s | %-15s |",
                "id=" + getId(),
                "name='" + getName() + "'",
                "baseSalary=" + String.format("%.2f", getBaseSalary()),
                "totalSalary=" + String.format("%.2f", getTotalSalary()),
                "hoursPerWeek=" + hoursPerWeek
        );
    }
}
