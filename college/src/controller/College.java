package controller;
import model.Course;
import model.person.student.Student;
import model.person.professor.FullTimeProfessor;
import model.person.professor.PartTimeProfessor;
import model.person.professor.Professor;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class College {

    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Professor> professors = new ArrayList<>();

    public static void init(){

        professors.add(new FullTimeProfessor(1, "Dr. Smith", 1000, 48));
        professors.add(new FullTimeProfessor(2, "Dr. Johnson", 1000, 48));
        professors.add(new PartTimeProfessor(3, "Dr. Emily", 1000));
        professors.add(new PartTimeProfessor(4, "Dr. Brown", 1000));

        students.add(new Student(174545, "Alice", 20));
        students.add(new Student(2874855, "Bob", 21));
        students.add(new Student(374875, "Charlie", 22));
        students.add(new Student(4785458, "David", 23));
        students.add(new Student(57845, "Eva", 24));
        students.add(new Student(652010, "Frank", 25));

        courses.add(new Course(87545, "Computer Science 101", "B101", professors.get(0), new ArrayList<Student>()));
        courses.add(new Course(78954, "Mathematics 202", "B102", professors.get(1), new ArrayList<Student>()));
        courses.add(new Course(78212, "Physics 303", "C101", professors.get(2), new ArrayList<Student>()));
        courses.add(new Course(14525, "Chemistry 404", "C102", professors.get(1), new ArrayList<Student>()));

        courses.get(0).getStudents().addAll(students);
        courses.get(1).getStudents().add(students.get(2));
        courses.get(1).getStudents().add(students.get(3));
        courses.get(2).getStudents().addAll(students);
        courses.get(3).getStudents().add(students.get(0));
        courses.get(3).getStudents().add(students.get(5));
    }

    public static ArrayList<Course> coursesByStudentId(int studentId){
        return getCourses()
                .parallelStream()
                .filter(course -> course
                        .getStudents()
                        .parallelStream()
                        .anyMatch(student -> student.getId()== studentId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static void setCourses(ArrayList<Course> courses) {
        College.courses = courses;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        College.students = students;
    }

    public static ArrayList<Professor> getProfessors() {
        return professors;
    }

    public static void setProfessors(ArrayList<Professor> professors) {
        College.professors = professors;
    }
}
