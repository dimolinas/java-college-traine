package model;
import model.professor.Professor;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Course implements Identifiable {
    private int id;
    private String name;
    private String classRoom;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(int id, String name, String classRoom, Professor professor, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.classRoom = classRoom;
        this.professor = professor;
        this.students = students;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
                "| %-10s | %-30s | %-12s | %-20s |",
                "id=" + id,
                "name='" + name + "'",
                "classRoom='" + classRoom + "'",
                "professor=" + professor.getName()
        );
    }
}
