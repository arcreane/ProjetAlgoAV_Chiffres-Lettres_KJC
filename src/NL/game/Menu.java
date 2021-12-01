package NL.game;

public class Menu {

    public static final String[] mainOptions = new String[]{"Play", "Exit"};
    public static final String[] subOptions = new String[]{"Player vs AI", "Player vs Player"};
//    public static final String[] PlayersAnswersOptions = new String[]{"Player1", "Player2"};

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
            case 1 -> { game.start(); }
            case 2 -> { game.exit(); }
        }
    }

    public void manageSubChoice(int choice, Game game) {
        switch (choice) {
            case 1 -> { game.playerVSAI(); }
            case 2 -> { game.playerVSPlayer(); }
        }
    }
    public void manageWhichPlayerAnswer(String name,String player1,String player2, Game game) {
        System.out.println(player1);
        System.out.println(player2);
        switch (name) {
            case player1 -> game.playerAnswer(0);
            case player2 -> game.playerAnswer(1);
        }
    }
}
