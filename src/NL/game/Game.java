package NL.game;

import NL.game.logic.Letters;
import NL.game.logic.Numbers;

import static NL.game.logic.Letters.letters;

public class Game {

    UserInteraction userInteraction = new UserInteraction();
    Menu menu = new Menu();
    User[] players = new User[2];

    public void gameWelcome() {
        userInteraction.display(menu.getWelcomeMsg());
        gameMenu();
    }

    public void gameMenu() {
        userInteraction.displayMainMenu(Menu.mainOptions);
        int choice = userInteraction.getUserChoice(Menu.mainOptions.length);
        menu.manageMainChoice(choice, this);
    }

    public void start() {
        userInteraction.displaySubMenu(Menu.subOptions);
        int choice = userInteraction.getUserChoice(Menu.subOptions.length);
        menu.manageSubChoice(choice, this);

        Letters game1 = new Letters();
        for(int turn = 1; turn <= 5; turn++) {


            userInteraction.askUserOneVowelOrKonsonant();
            game1.checkTypeOfLetter((userInteraction.getStr()));
            userInteraction.askUserTwoVowelOrKonsonant();
            game1.checkTypeOfLetter((userInteraction.getStr()));
        }

        System.out.println(letters);
        System.out.println("word");
        game1.wordFoundedByUserOne(userInteraction.getStr());
        System.out.println(letters);
        game1.wordFoundedByUserTwo(userInteraction.getStr());
        game1.checkLenghtOfWord();





            //game1.test(players);


//            Numbers game2 = new Numbers();
//            game2.test();

    }

    public void playerVSPlayer() {
        for(int p = 0; p <= 1; p++) {
            userInteraction.askUsername();
            String playerName = userInteraction.getUserChoice();
            players[p] = new User(playerName);
        }
    }

    public void playerVSAI() {
        userInteraction.askUsername();
        String playerName = userInteraction.getUserChoice();
        players[0] = new User(playerName);
        players[1] = new User("AI");
    }

    public void exit() {
        System.exit(0);
    }
}
