package view;

import java.util.Scanner;

/**
 * Created by dashenka on 12.08.15.
 */
public class MenuView {

    private static final int START_CODE = 1;

    public int showMenuWithResult(){
        System.out.println(START_CODE + " - Start");
        System.out.println("2 - Load");
        System.out.println("3 - Settings");
        System.out.println("4 - Exit");
        System.out.print("> ");
        final Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        /*if (choice == START_CODE){
            System.out.println("Start");
        } else if (choice == 2){
            System.out.println("Load");
        } else if (choice == 3){
            System.out.println("Settings");
        } else if (choice == 4){
            System.out.println("Exit");
        } else {
            System.out.println("Really???");
        }*/

        switch (choice) {
            case START_CODE:
                System.out.println("Start");
                break;
            case 2:
                System.out.println("Load!");
                break;
            case 3:
                System.out.println("Settings");
                break;
            case 4:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("Really??");
                break;


        }
        return choice;

    }
}
