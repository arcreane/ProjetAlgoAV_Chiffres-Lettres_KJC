package NL.game;

import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);
    Game game = new Game();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void welcome() throws InterruptedException {
        System.out.print(
                """
                     _   _                 _                          ___            _        _          _   _               \s
                    | \\ | |               | |                        / _ \\          | |      | |        | | | |              \s
                    |  \\| |_   _ _ __ ___ | |__   ___ _ __ ___      / /_\\ \\_ __   __| |      | |     ___| |_| |_ ___ _ __ ___\s
                    | . ` | | | | '_ ` _ \\| '_ \\ / _ \\ '__/ __|     |  _  | '_ \\ / _` |      | |    / _ \\ __| __/ _ \\ '__/ __|
                    | |\\  | |_| | | | | | | |_) |  __/ |  \\__ \\     | | | | | | | (_| |      | |___|  __/ |_| ||  __/ |  \\__ \\
                    \\_| \\_/\\__,_|_| |_| |_|_.__/ \\___|_|  |___/     \\_| |_/_| |_|\\__,_|      \\_____/\\___|\\__|\\__\\___|_|  |___/                                                                                                                          \s                                                                                                                        \s
                
                
                Welcome to the numbers and letters game !
                The game will start soon..
                
                First, what is your name ? :\s"""
        );

        game.setPlayer1(input.nextLine());

        System.out.print(
                """
                
                Would you like to play against a friend or the game AI ?
                To play against a friend, please enter "1".
                To play against the game AI, please enter "2".
                """
        );

        class welcomeLocal { //Consider this a cheat to return the question I wanted.
            static int versusMode() {
                System.out.print("Your choice : ");

                int number = IntegerInput(input); //Verify if the input can be parsed to int.
                if(number == -1) return versusMode(); //If the int couldn't be parsed, return -1, so return the question.
                else if(number > 2 || number < 1) { //If the int was parsed but is not 1 or 2.
                    System.out.println(ANSI_RED + "\nThe number provided doesn't match the options [1 or 2]." +
                            "\nPlease try again.\n" + ANSI_RESET);
                    return versusMode();
                }

                return number;
            }
        }

        int number = welcomeLocal.versusMode();
        if (number == 1) {
            System.out.print("\nPlease enter the name of the second player : ");
            game.setPlayer2(input.nextLine());
        } else if (number == 2) game.setPlayer2("AI");

        System.out.println("\nInitiating the players..");
        System.out.println("PLAYER 1 : " + game.getPlayer1() + "\nPLAYER 2 : " + game.getPlayer2());
        System.out.println("\nLoading the game menu..");

        menu();
    }

    public int menu() throws InterruptedException {
        System.out.println(
            """
 
            +-------------- +\s
            |  Game Menu :  |
            |  1. Play      |
            |  2. Exit      |
            +---------------+\s
            """
        );

        System.out.print("Please select your option : ");
        int option = IntegerInput(input);
        return gameModeOptions(option);
    }

    public int gameModeOptions(int option) throws InterruptedException {
        switch (option) {
            case 1 -> System.exit(404); //Will do something.
            case 2 -> System.exit(0);
            case default -> { return menu(); }
        }

        return menu();
    }

    public static int IntegerInput(Scanner input) {
        // Prevent the program from crashing if the user input is a String while waiting for an integer.
        int inputVerified;
        try {
            inputVerified = Integer.parseInt(input.nextLine());
        }
        catch (NumberFormatException nfe) {
            System.out.println(ANSI_RED + "\nInvalid option format.\nPlease try again.\n" + ANSI_RESET);
            return -1;
        }
        return inputVerified;
    }
}
