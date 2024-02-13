package view;


import controller.College;

public class Menu {
    public static void showOptions(){
        System.out.println("---------------------------------------Welcome To GloUniversity-----------------------------------------");
        System.out.println("1. Show Professors");
        System.out.println("2. Show Courses");
        System.out.println("3. Create Student");
        System.out.println("4. Create Class");
        System.out.println("5. Show Classes By Student");
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
                College.createStudent();
                showOptions();
                break;
            }
            case 4: {
                College.createCourse();
                showOptions();
                break;
            }
            case 5: {
                College.showCoursesByStudent();
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

    public static void showCourseDetails(){
        System.out.println("0. Exit");
        System.out.println("\nSelect a course to view details (or 0 to exit): ");

        int choice = Utils.readInteger();

        if (choice == 0) {
            System.out.println("Exiting...");
            Menu.showOptions();
        }

        int index = College.getCourseIndexById(choice);

        if(index != -1){
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Course Details: " + College.getCourses().get(index).toString());
            Utils.showList(College.getCourses().get(index).getStudents());
        }else{
            System.out.println("No course found with Id: " + choice + ".");
        }
    }
}
