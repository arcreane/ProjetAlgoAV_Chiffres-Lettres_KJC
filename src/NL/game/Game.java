package NL.game;

//import NL.game.logic.Letters;

import NL.game.logic.Numbers;
import NL.game.logic.Letters;

import static NL.game.Menu.numberPlates;
import static NL.game.logic.Letters.*;

public class Game {
    int rounds = 0;

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


        //for (int turn = 1; turn <= 3; turn++) {

            // First loop for gameLoop
            Letters game1 = new Letters();
            Numbers number1 = new Numbers();
            do {
                new Letters();
                new Numbers();
                // LETTERS GAME
                //-------- loop for getting 10 characters ----------
                loopForChoosingVowelOrConsonant(game1);
                //-------------------------------
                game1.loopWordsDictionary();
                //-----------------------------
                getDataWordForEachUser(game1);

                // --------------------------------------------------------

                // NUMBER GAME
                System.out.println("numberGame");
                // AFFICHE MENU
                userInteraction.displayNumbersMenu();
                // INPUT UTILISATEUR
                numberGame();



                rounds++;
                System.out.println(rounds);
            } while (rounds < 3);


            // TEST-----------------------------------------

//            //loop on words of dictionnary
//            for (String word : dictionaryArray ){
//                if ( word.length() <= listSortedCharacters.size() ) {
//                    ArrayList<String> temp = new ArrayList<String>(listSortedCharacters) ;
//                    if (canBeWritten(temp, word))
//                        wordsCanBeWritten.add(word) ;
//                }
//            }
//            System.out.println("words can be written with these characters :  "+ wordsCanBeWritten) ;


                // ----------- getting each word from each user ------------------






            //game1.test(players);


//            Numbers game2 = new Numbers();
//            game2.test();



        }
//    }

        public void playerVSPlayer () {
            for (int p = 0; p <= 1; p++) {
                userInteraction.askUsername();
                String playerName = userInteraction.getUserChoice();
                players[p] = new User(playerName);
            }
        }

        public void playerVSAI () {
            userInteraction.askUsername();
            String playerName = userInteraction.getUserChoice();
            players[0] = new User(playerName);
            players[1] = new User("AI");
        }

        public void exit () {
            System.exit(0);
        }





    public void loopForChoosingVowelOrConsonant(Letters game) {
        for (int turn = 1; turn <= 5; turn++) {
            userInteraction.askUserOneVowelOrKonsonant();
            game.creatingRandomCharsFromAskingEachPlayer((userInteraction.getStr()));
            userInteraction.askUserTwoVowelOrKonsonant();
            game.creatingRandomCharsFromAskingEachPlayer((userInteraction.getStr()));
        }
    }

    public void getDataWordForEachUser(Letters game) {
        //game1.cloneList();
        //listSortedLetters = clonedListSortedLetters;
        System.out.println(listSortedCharacters);
        game.getCreatedWordByUserOne(userInteraction.getStr());
        //game1.cloneList();
        //listSortedLetters = clonedListSortedLetters;
        System.out.println(listSortedCharacters);
        game.getCreatedWordByUserTwo(userInteraction.getStr());
        game.checkLenghtOfWord();
        System.out.println(game.countUserOne + " user one");
        System.out.println(game.countUserTwo + " user two");


    }

    public void numberGame(){
        int binary = 0;
        int plates = 1;
        while (plates <= 6) {
            userInteraction.displaySelectOption(binary++);
            int rank = userInteraction.getUserChoice(numberPlates.length);
            plates += menu.managePlateChoice(rank, this);
        }
        userInteraction.displayPlates(Numbers.plates);
        int random = Numbers.utilsRand(100, 999);
        System.out.println(random);

    }
}
