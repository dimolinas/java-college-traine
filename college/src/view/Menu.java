package view;


import controller.College;

public class Menu {
    public static void showOptions(){
        System.out.println("---------------------Welcome To GloUniversity--------------");
        System.out.println("1. Show Professors");
        System.out.println("2. Show Courses");
        System.out.println("3. Create Student");
        System.out.println("4. Create Class");
        System.out.println("5. Show Classes By Student");
        System.out.println("6. Exit");
        System.out.println("-------------------------------------------------------");

        System.out.print("Input: ");
        int option = Utils.readInteger();

        switch (option){
            case 1:{
                College.showProfessors();
                Menu.showOptions();
                break;
            }
            case 2:{
                College.showCourses();
                break;
            }
            case 3: {
                showOptions();
            }
            case 4:{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Please Enter A Valid Option");
                showOptions();
            }
        }
    }

}
