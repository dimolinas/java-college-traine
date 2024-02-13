package view;

import java.util.Scanner;

public class Utils {
    private static final Scanner scan = new Scanner(System.in);
    public static int readInteger(){
        int validatedInteger = 0;
        boolean isValid = false;

        while(!isValid){
            System.out.println("Please enter an integer:");
            String input = scan.nextLine();

            try {
                validatedInteger = Integer.parseInt(input);
                isValid = true;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
        return validatedInteger;
    }

    public static String readString(){
        return scan.nextLine();
    }
}
