package model.professor;

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
        return "PartTimeProfessor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                ", totalSalary=" + getTotalSalary() +
                '}';
    }
}
