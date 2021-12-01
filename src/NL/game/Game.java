package NL.game;

import NL.game.logic.Letters;
import NL.game.logic.Numbers;

public class Game {

    UserInteraction userInteraction = new UserInteraction();
    Menu menu = new Menu();
    User[] player = new User[2];

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

        for(int turn = 1; turn <= 3; turn++) {

            Letters game1 = new Letters();
            game1.test();

            Numbers game2 = new Numbers();
            game2.test();
        }
    }

    public void playerVSPlayer() {
        for(int p = 0; p <= 1; p++) {
            userInteraction.askUsername();
            String playerName = userInteraction.getUserChoice();
            player[p] = new User(playerName);
        }
    }

    public void playerVSAI() {
        userInteraction.askUsername();
        String playerName = userInteraction.getUserChoice();
        player[0] = new User(playerName);
        player[1] = new User("AI");
    }

    public void exit() {
        System.exit(0);
    }
}
