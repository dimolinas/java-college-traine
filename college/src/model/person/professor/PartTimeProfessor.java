package model.person.professor;

public class PartTimeProfessor extends Professor implements SalaryCalculator {
    public PartTimeProfessor(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        setTotalSalary(getBaseSalary() * 1.1);
    }
    @Override
    public String toString() {
        return String.format(
                "| %-15s | %-20s | %-15s | %-20s |",
                "id=" + getId(),
                "name='" + getName() + "'",
                "baseSalary=" + String.format("%.2f", getBaseSalary()),
                "totalSalary=" + String.format("%.2f", getTotalSalary())
        );
    }
}
