package NL.game;

import NL.game.logic.Numbers;

public class Menu {

    public static final String[] mainOptions = new String[]{"Play", "Exit"};
    public static final String[] subOptions = new String[]{"Player vs AI", "Player vs Player"};
    public static final String[] numberPlates = new String[] {"Rang 1", "Rang 2", "Rang 3"};

    public String getWelcomeMsg() {
        return
                """
                             _   _                 _                          ___            _        _          _   _               \s
                            | \\ | |               | |                        / _ \\          | |      | |        | | | |              \s
                            |  \\| |_   _ _ __ ___ | |__   ___ _ __ ___      / /_\\ \\_ __   __| |      | |     ___| |_| |_ ___ _ __ ___\s
                            | . ` | | | | '_ ` _ \\| '_ \\ / _ \\ '__/ __|     |  _  | '_ \\ / _` |      | |    / _ \\ __| __/ _ \\ '__/ __|
                            | |\\  | |_| | | | | | | |_) |  __/ |  \\__ \\     | | | | | | | (_| |      | |___|  __/ |_| ||  __/ |  \\__ \\
                            \\_| \\_/\\__,_|_| |_| |_|_.__/ \\___|_|  |___/     \\_| |_/_| |_|\\__,_|      \\_____/\\___|\\__|\\__\\___|_|  |___/                                                                                                                          \s                                                                                                                        \s
                                        
                                        
                        Welcome to the numbers and letters game !
                        The game will start soon..
                        """;
    }

    public void manageMainChoice(int choice, Game game) {
        switch (choice) {
            case 1 -> game.start();
            case 2 -> game.exit();
        }
    }

    public void manageSubChoice(int choice, Game game) {
        switch (choice) {
            case 1 -> game.playerVSAI();
            case 2 -> game.playerVSPlayer();
        }
    }

    public int managePlateChoice(int choice, Game game) {
        int len = 0;
        switch (choice) {
            case 1 -> len = Numbers.rank1.size();
            case 2 -> len = Numbers.rank2.size();
            case 3 -> len = Numbers.rank3.size();
            default -> {}
        }
        
        if(len == 0) {
            game.userInteraction.emptyPlates("rank " + choice);
            return 0;
        }
        else game.numbers.addPlates(game.numbers.setPlates(choice));
        
        return 1;
    }
}
