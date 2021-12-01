package NL.game;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    Scanner input = new Scanner(System.in);
    int menuInput;
    String strInput;
    String str;

    public int getUserChoice(int optionsMax) {
        return menuInput = validateIntegerInput(optionsMax);
    }

    public String getUserChoice() {
        return strInput = validateStringInput();
    }

    public String getStr() {
        return str = input.nextLine();
    }

    public void display(String welcomeMsg) {
        System.out.println(welcomeMsg);
    }

    public void displayMainMenu(String[] mainOptions) {
        System.out.println(
                """

                +-------------- +\s
                |  Game Menu :  |""");

        int number = 1;
        for(String option : mainOptions) {
            System.out.println("|  " + number++ + ". " + option + " |");
        }
        System.out.println("+---------------+");
        System.out.print("Please select your option : ");
    }

    public void displaySubMenu(String[] subOptions) {
        System.out.println("\nWould you like to play against a friend or the game AI ?");

        int number = 1;
        for(String option : subOptions) {
            System.out.println("For " + option + ", please enter \"" + number++ + "\".");
        }
        System.out.print("Please select your option : ");
    }

    public void askUsername() {
        System.out.print("\nPlease enter the name of the second player : ");
    }

    public int validateIntegerInput(int optionsMax) {
        // Prevent the program from crashing if the user input is a String while waiting for an integer.
        int inputVerified;
        do {
            try {
                inputVerified = Integer.parseInt(input.nextLine());
                if (inputVerified < 1 || inputVerified > optionsMax) {
                    System.out.println(ANSI_RED + "\nThe number provided doesn't match the options [1 or 2]." +
                            "\nPlease try again.\n" + ANSI_RESET);
                    System.out.print("Please select your option : ");
                    inputVerified = -1;
                }
            } catch (NumberFormatException nfe) {
                System.out.println(ANSI_RED + "\nInvalid option format.\nPlease try again.\n" + ANSI_RESET);
                System.out.print("Please select your option : ");
                inputVerified = -1;
            }
        } while (inputVerified == -1);

        return inputVerified;
    }

    public String validateStringInput() {
        // Limit the number of characters.
        return input.nextLine();
    }
}
