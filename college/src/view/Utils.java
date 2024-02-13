package view;

import model.Identifiable;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    public static <T> void showList(ArrayList<T> list) {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (T item : list) {
            System.out.println(item.toString());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    public static <T extends Identifiable> int getIndexById(int id, ArrayList<T> items) {
        OptionalInt indexOpt = IntStream.range(0, items.size())
                .filter(i -> items.get(i).getId() == id)
                .findFirst();
        return indexOpt.orElse(-1);
    }
}
