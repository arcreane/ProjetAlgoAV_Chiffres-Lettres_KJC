package NL.game;

//import NL.game.logic.Letters;
import NL.game.logic.Numbers;

public class Game {

    UserInteraction userInteraction = new UserInteraction();
    Menu menu = new Menu();
    User[] players = new User[2];
    Numbers numbers = new Numbers();

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

        userInteraction.displayNumbersMenu();

        int plates = 1;
        while(plates <= 6) {
            userInteraction.displaySelectOption();
            int rank = userInteraction.getUserChoice(Menu.numberPlates.length);
            plates += menu.managePlateChoice(rank, this);
        }
        userInteraction.displayPlates(Numbers.plates);
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
