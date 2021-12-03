package NL.game;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    Scanner input = new Scanner(System.in);
    int menuInput;
    String strInput;

    public int getUserChoice(int optionsMax) {
        return menuInput = validateIntegerInput(optionsMax);
    }

    public String getUserChoice() {
        return strInput = validateStringInput();
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
        System.out.print("\nPlease select your option : ");
    }

    public void displayNumbersMenu() {
        System.out.println("""

                Please select the rank number you want, you will need a total of 6 plates collectively.
                Each player will select 1 plate one after one other.
                +----------------------------------------------------------+""");

        System.out.println("For the rank 1, there are 20 plates from 1 to 10 with their corresponding duplicate.");
        System.out.println("For the rank 2, there is 2 plates of 25 and 2 plates of 50.");
        System.out.println("For the rank 3, there is 2 plates of 75 and 2 plates of 100.");
    }

    public void displaySelectOption() {
        System.out.print("\nPlease select your option : ");
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
                    System.out.println(ANSI_RED + "\nThe number provided doesn't match the options [1 or " + optionsMax + "]." +
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

    public void emptyPlates(String rank) {
        System.out.println(ANSI_RED +  "\nSorry but the box " + rank + " doesn't contain any more plate." + ANSI_RESET);
    }

    public void displayPlates(List<Integer> plates) {
        System.out.println("Your plates during this game will be : " + plates);
    }
}
