package NL.game;

//import NL.game.logic.Letters;

import NL.game.logic.Numbers;
import NL.game.logic.Letters;
import NL.game.logic.Timer;

import java.io.IOException;

import static NL.game.Menu.numberPlates;

public class Game {
    UserInteraction userInteraction = new UserInteraction();
    Menu menu = new Menu();
    User[] players = new User[2];
    Numbers numbers = new Numbers();

    public void gameWelcome() throws IOException {
        userInteraction.display(menu.getWelcomeMsg());
        Dictionary.initContent();
        gameMenu();
    }

    public void gameMenu() throws IOException {
        userInteraction.displayMainMenu(Menu.mainOptions);
        int choice = userInteraction.getUserChoice(Menu.mainOptions.length);
        menu.manageMainChoice(choice, this);
    }

    public void start() throws IOException {
        userInteraction.displaySubMenu(Menu.subOptions);
        int choice = userInteraction.getUserChoice(Menu.subOptions.length);
        menu.manageSubChoice(choice, this);

        int rounds = 1;

        Letters game1 = new Letters();
        do {
            new Letters();
            new Numbers();

            userInteraction.displayRound(rounds);
            userInteraction.displayGamePoint(players[0], players[1]);
            userInteraction.displayLetterGame();

            //-------- loop for getting 10 characters ----------
            loopForChoosingVowelOrConsonant(game1);
            game1.loopWordsDictionary();
            getDataWordForEachUser(game1);
            // --------------------------------------------------------

            userInteraction.displayNumbersGame();
            userInteraction.displayNumbersMenu();
            numberGame();

            rounds++;
        } while (rounds < 3);
    }

    public void playerVSPlayer () throws IOException {
        for (int p = 0; p <= 1; p++) {
            userInteraction.askUsername();
            String playerName = userInteraction.getUserChoice();
            players[p] = new User(playerName);
        }
    }

    public void playerVSAI () throws IOException {
        userInteraction.askUsername();
        String playerName = userInteraction.getUserChoice();
        players[0] = new User(playerName);
        players[1] = new User("AI");
    }

    public void whichPlayerAnswer() throws IOException {
        menu.manageWhichPlayerAnswer(players[0].getPlayer(), players[1].getPlayer(), this);
    }

    public void playerAnswer(int choice, String name) throws IOException {
        userInteraction.askForAnswer(name);
        String answer = userInteraction.getUserChoice();
        players[choice].setAnswer(answer);
    }

    public void exit () {
        System.exit(0);
    }

    public void loopForChoosingVowelOrConsonant(Letters game) throws IOException {
        for (int turn = 1; turn <= 10; turn++) {
            if ((turn % 2 == 0)) {
                userInteraction.askUserOneVowelOrKonsonant(players[0].getPlayer());
            } else {
                userInteraction.askUserOneVowelOrKonsonant(players[1].getPlayer());
            }
            game.creatingRandomCharsFromAskingEachPlayer((userInteraction.getStr()));
        }
    }

    public void getDataWordForEachUser(Letters game) throws IOException {
        userInteraction.displayCharactersCollections();

        Timer.timer(this);

        if(game.getCreatedWordByUserOne(players[0].getAnswer()) && game.getCreatedWordByUserTwo(players[1].getAnswer())) {

            if(players[0].getAnswer().length() == players[1].getAnswer().length()) {
                userInteraction.displayEquality();
            }
            else if(players[0].getAnswer().length() > players[1].getAnswer().length()) {
                userInteraction.displayWinner(players[0]);
                players[0].setPoint(1);
            }else {
                userInteraction.displayWinner(players[1]);
                players[1].setPoint(1);
            }
        } else if (game.getCreatedWordByUserOne(players[0].getAnswer())) {
            userInteraction.displayWinner(players[0]);
            players[0].setPoint(1);
        } else if (game.getCreatedWordByUserTwo(players[1].getAnswer())) {
            userInteraction.displayWinner(players[1]);
            players[1].setPoint(1);
        } else userInteraction.displayEquality();
    }

    public void numberGame() throws IOException {
        int plates = 1;
        while (plates <= 6) {
            if(plates % 2 == 0) userInteraction.displaySelectOption(players[0].getPlayer());
            else userInteraction.displaySelectOption(players[1].getPlayer());

            int rank = userInteraction.getUserChoice(numberPlates.length);
            plates += menu.managePlateChoice(rank, this);
        }

        userInteraction.displayPlates(Numbers.plates);

        Timer.timer(this);
        Numbers.setStock();
        Numbers.setStockOperation();
        Numbers.findNumber();

        int result1 = Numbers.getCalculus(players[0]);
        int result2 = Numbers.getCalculus(players[1]);
        if(Numbers.findWinner(result1, result2)) {
            userInteraction.displayWinner(players[0]);
            players[0].setPoint(1);
        } else {
            userInteraction.displayWinner(players[1]);
            players[1].setPoint(1);
        }

        Numbers.displayBestComp();
    }
}
