package NL.game;

import NL.game.logic.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static NL.game.logic.Letters.getListSortedCharacters;
import static NL.game.logic.Numbers.plates;

public class UserInteraction {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int menuInput;
    String strInput;
    String str;

    public int getUserChoice(int optionsMax) {
        return menuInput = validateIntegerInput(optionsMax);
    }

    public String getUserChoice() throws IOException {
        return strInput = validateStringInput();
    }

    public String getStr() throws IOException {
        return str = input.readLine();
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
        for (String option : mainOptions) {
            System.out.println("|  " + number++ + ". " + option + "      |");
        }
        System.out.println("+---------------+");
        System.out.print("Please select your option : ");
    }

    public void displaySubMenu(String[] subOptions) {
        System.out.println("\nWould you like to play against a friend or the game AI ?");

        int number = 1;
        for (String option : subOptions) {
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

    public void displaySelectOption(String name) {
        System.out.print("\n" + name + ", please select your option : ");
    }

    public void askUsername() {
        System.out.print("\nPlease enter the name of the second player : ");
    }

    public int validateIntegerInput(int optionsMax) {
        // Prevent the program from crashing if the user input is a String while waiting for an integer.
        int inputVerified;
        do {
            try {
                inputVerified = Integer.parseInt(input.readLine());
                if (inputVerified < 1 || inputVerified > optionsMax) {
                    System.out.println(ANSI_RED + "\nThe number provided doesn't match the options [1 or " + optionsMax + "]." +
                            "\nPlease try again.\n" + ANSI_RESET);
                    System.out.print("Please select your option : ");
                    inputVerified = -1;
                }
            } catch (NumberFormatException | IOException nfe) {
                System.out.println(ANSI_RED + "\nInvalid option format.\nPlease try again.\n" + ANSI_RESET);
                System.out.print("Please select your option : ");
                inputVerified = -1;
            }
        } while (inputVerified == -1);

        return inputVerified;
    }

    public String validateStringInput() throws IOException {
        // Limit the number of characters.
        return input.readLine();
    }


    public void askUserOneVowelOrKonsonant(String player) {
        System.out.println("\n" + player + ", what type of letter do you want ?");
        System.out.print("Write a consonant or a vowel as \"c\" or \"v\" : ");
    }

    public void displayPlates(List<Integer> plates) {
        System.out.println("\nYour plates during this game will be : " + plates + "\n" +
                "The number you will need to reach will be : " + Numbers.randomNumber + "\n");
    }
    public void emptyPlates (String rank){
        System.out.println(ANSI_RED + "\nSorry but the box " + rank + " doesn't contain any more plate." + ANSI_RESET);
    }

    public void displayWhichPlayerAnswer() {
        System.out.print("If you wish to give an answer, please enter your username : ");
    }

    public void askForAnswer(String name) {
        System.out.print(name  + ", please enter your answer : ");
    }

    public void displayRound(int rounds) {
        System.out.println(
                "\n+-------------+" +
                "| ROUND : " + rounds + " |" +
                "+-------------+");
    }

    public void displayLetterGame() {
        System.out.println(
                """
                                        
                                        
                \t\s\s+----------------------------+
                \t\s\s| Letters Game is starting ! |
                \t\s\s+----------------------------+""");
    }

    public void displayNumbersGame() {
        System.out.println(
                """
                                        
                                        
                \t\s\s+----------------------------+
                \t\s\s| Numbers Game is starting ! |
                \t\s\s+----------------------------+""");
    }

    public void askAgain() {
        System.out.println(ANSI_RED + "\nThis username doesn't exist, please try again.\n" + ANSI_RESET);
    }

    public void displayGamePoint(User user1, User user2) {
        System.out.println(
                ANSI_RED + user1.getPlayer() + " has : " + user1.getPoint() + " points."+
                "\n   VS\n" +
                user2.getPlayer() + " has : " + user2.getPoint() + " points." + ANSI_RESET);
    }

    public void displayEquality() {
        System.out.println("\nUnfortunately it's a draw.");
    }

    public void displayWinner(User user) {
        System.out.println("\nWinner is " + user.getPlayer() + " !");
    }

    public void displayCharactersCollections() {
        System.out.println("\nHere's the list you will use to create the largest word you can : " + getListSortedCharacters());
    }
}