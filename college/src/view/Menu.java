package view;
import controller.College;
import model.Course;
import model.person.student.Student;
import model.person.professor.Professor;

import java.util.ArrayList;

public class Menu {
    public static void showOptions(){
        System.out.println("---------------------------------------Welcome To GloUniversity-----------------------------------------");
        System.out.println("1. Show Professors");
        System.out.println("2. Show Courses");
        System.out.println("3. Create Student");
        System.out.println("4. Create Courses");
        System.out.println("5. Show Courses By Student");
        System.out.println("6. Exit");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        System.out.print("Input: ");
        int option = Utils.readInteger();

        switch (option){
            case 1:{
                Utils.showList(College.getProfessors());
                Menu.showOptions();
                break;
            }
            case 2:{
                Utils.showList(College.getCourses());
                showCourseDetails();
                Menu.showOptions();
                break;
            }
            case 3: {
                createStudent();
                showOptions();
                break;
            }
            case 4: {
                createCourse();
                showOptions();
                break;
            }
            case 5: {
                Utils.showList(College.getStudents());
                showCoursesByStudent();
                showOptions();
                break;
            }
            case 6:{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Please Enter A Valid Option");
                showOptions();
            }
        }
    }


    private static void createStudent(){
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("                                         New Student                                                     ");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        int id = Utils.newValidId(College.getStudents(), "Student");
        System.out.print("Enter student name: ");
        String name = Utils.readString();

        System.out.print("Enter student age: ");
        int age = Utils.readInteger();

        Student newStudent = new Student(id, name, age);
        College.getStudents().add(newStudent);

        String moreCourses;
        do {
            Utils.showList(College.getCourses());
            System.out.print("Enter the Id of the course to enroll the student in (or -1 to finish): ");

            int courseId = Utils.readInteger();

            if (courseId == -1) break;

            int courseIndex = Utils.getIndexById(courseId, College.getCourses());

            if (courseIndex != -1) {
                College.getCourses().get(courseIndex).getStudents().add(newStudent);
                System.out.println("The student has been enrolled in the course successfully.");
            } else {
                System.out.println("No Course found with Id: " + courseId + ".");
            }

            System.out.print("Add more courses? (yes/no): ");
            moreCourses = Utils.readString();

        } while (moreCourses.equalsIgnoreCase("yes"));
    }

    private static void createCourse(){
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("                                         New Course                                                      ");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        int id = Utils.newValidId(College.getCourses(), "Course");

        System.out.print("Enter course name: ");
        String name = Utils.readString();

        System.out.print("Enter classroom: ");
        String classRoom = Utils.readString();

        System.out.println("---------------------------------------------------------------------------------------------------------");
        Utils.showList(College.getProfessors());

        int professorId;
        int professorIndex;

        while(true){
            System.out.print("Enter the id of the professor for this course: ");
            professorId = Utils.readInteger();

            professorIndex = Utils.getIndexById(professorId, College.getProfessors());
            if(professorIndex != -1){
                break;
            }else{
                System.out.println("Invalid professor Id");
            }

        }

        Professor professor = College.getProfessors().get(professorIndex);
        ArrayList<Student> students = new ArrayList<>();

        String moreStudents;
        do {
            Utils.showList(College.getStudents());
            System.out.print("Enter the Id of the student to add to this course (or -1 to finish): ");
            int studentId = Utils.readInteger();

            if (studentId == -1) break;

            int studentIndex = Utils.getIndexById(studentId, College.getStudents());

            if (studentIndex != -1) {
                students.add(College.getStudents().get(studentIndex));
            } else {
                System.out.println("No Student found with Id: " + studentId + ".");
            }

            System.out.print("Add more students? (yes/no): ");
            moreStudents = Utils.readString();

        } while (moreStudents.equalsIgnoreCase("yes"));
        College.getCourses().add(new Course(id,name, classRoom, professor,students));
    }

    private static int miniMenuOption(){
        System.out.println("0. Exit");
        System.out.println("\nInput a valid id to view details (or 0 to exit): ");

        int choice = Utils.readInteger();

        if (choice == 0) {
            System.out.println("Exiting...");
            Menu.showOptions();
        }
        return choice;
    }

    private static void showCoursesByStudent(){
        int idStudent = miniMenuOption();
        int index = Utils.getIndexById(idStudent, College.getStudents());

        if(index != -1){
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Student Details: " + College.getStudents().get(index).toString());
            Utils.showList(College.coursesByStudentId(idStudent));
        }else{
            System.out.println("No Student found with Id: " + idStudent + ".");
        }
    }

    private static void showCourseDetails(){
        int idCourse = miniMenuOption();
        int index = Utils.getIndexById(idCourse, College.getCourses());

        if(index != -1){
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Course Details: " + College.getCourses().get(index).toString());
            Utils.showList(College.getCourses().get(index).getStudents());
        }else{
            System.out.println("No course found with Id: " + idCourse + ".");
        }
    }
}
