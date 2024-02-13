package model.professor;

public class PartTimeProfessor extends Professor implements SalaryCalculator {
    public PartTimeProfessor(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public void calculateSalary() {
    }

    @Override
    public String toString() {
        return "PartTimeProfessor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                '}';
    }
}
