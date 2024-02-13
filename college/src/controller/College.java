package controller;

import model.Course;
import model.Student;
import model.professor.FullTimeProfessor;
import model.professor.PartTimeProfessor;
import model.professor.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class College {

    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Professor> professors = new ArrayList<>();

    public static void init(){

        professors.add(new FullTimeProfessor(1, "Dr. Smith", 1000, 48));
        professors.add(new FullTimeProfessor(2, "Dr. Johnson", 1000, 48));
        professors.add(new PartTimeProfessor(3, "Dr. Emily", 1000));
        professors.add(new PartTimeProfessor(4, "Dr. Brown", 1000));

        courses.add(new Course(UUID.randomUUID(), "Computer Science 101", "B101", professors.getFirst(), new ArrayList<Student>()));
        courses.add(new Course(UUID.randomUUID(), "Mathematics 202", "B102", professors.getFirst(), new ArrayList<Student>()));
        courses.add(new Course(UUID.randomUUID(), "Physics 303", "C101", professors.getFirst(), new ArrayList<Student>()));
        courses.add(new Course(UUID.randomUUID(), "Chemistry 404", "C102", professors.getFirst(), new ArrayList<Student>()));

        students.add(new Student(174545, "Alice", 20));
        students.add(new Student(2874855, "Bob", 21));
        students.add(new Student(374875, "Charlie", 22));
        students.add(new Student(4785458, "David", 23));
        students.add(new Student(57845, "Eva", 24));
        students.add(new Student(652010, "Frank", 25));
    }

    public static  void showProfessors(){
        StringBuilder sb = new StringBuilder();;
        //sb.append(String.format("%-25s %-10s %-15s", "UUID", "Balance", "Opening Date"));
        //sb.append(String.format("%-5s %-10s %-10s", "Id", "Name", "BaseSalary"));
        //System.out.println(sb.toString());

        System.out.println("-----------------------------------------------------------");
        for (Professor professor : professors) {
            System.out.println(professor.toString());
        }
        System.out.println("------------------------------------------------------------");

    }

    public static void showCourses(){
        System.out.println("-----------------------------------------------------------");
        for (Course course : courses) {
            System.out.println(course.toString());
        }
        System.out.println("------------------------------------------------------------");
    }

    public static void showStudents(){
        System.out.println("-----------------------------------------------------------");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("------------------------------------------------------------");
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
