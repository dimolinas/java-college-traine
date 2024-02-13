package model;
import model.professor.Professor;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Course {
    private UUID uuid;
    private String name;
    private String classRoom;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(UUID uuid, String name, String classRoom, Professor professor, ArrayList<Student> students) {
        this.uuid = uuid;
        this.name = name;
        this.classRoom = classRoom;
        this.professor = professor;
        this.students = students;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
        return uuid.equals(course.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Course{" + "uuid=" + uuid + ", name='" + name + '\'' + ", classRoom='" + classRoom + '\'' + ", professor=" + professor.getName() + '}';
    }

}
