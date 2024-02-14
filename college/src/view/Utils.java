package view;

import model.Identifiable;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Utils {
    private static final Scanner scan = new Scanner(System.in);
    protected static int readInteger(){
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

    protected static String readString(){
        return scan.nextLine();
    }

    protected static <T> void showList(ArrayList<T> list) {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (T item : list) {
            System.out.println(item.toString());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    protected static <T extends Identifiable> int getIndexById(int id, ArrayList<T> items) {
        if(id <0 ) return -1;

        OptionalInt indexOpt = IntStream.range(0, items.size())
                .filter(i -> items.get(i).getId() == id)
                .findFirst();
        return indexOpt.orElse(-1);
    }

    protected static <T extends Identifiable> int newValidId(ArrayList<T> items, String itemType) {
        int id;
        while (true) {
            System.out.print("Enter " + itemType + " Id: ");
            id = Utils.readInteger();

            int existingIndex = Utils.getIndexById(id, items);
            if (existingIndex != -1) {
                System.out.println("An " + itemType + " with this Id already exists. Please enter a different Id.");
            } else {
                break;
            }
        }
        return id;
    }
}
