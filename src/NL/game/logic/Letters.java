package NL.game.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Letters {
    public static List<Character> listSortedLetters = new ArrayList<Character>();
    public static List<Character> listCharsFromUserOneWord = new ArrayList<Character>();
    public static List<Character> listCharsFromUserTwoWord = new ArrayList<Character>();
    String wordCreatedByUserOne;
    String wordCreatedByUserTwo;



    public List<Character> getLetters() {
        return listSortedLetters;
    }


// --------------------- SORT RANDOM CHARACTER (CONSONANT/VOWEL) -------------
// ---------------------- DEPENDANT FOREACH USERS CHOICE --------------------

    public void creatingRandomCharsFromAskingEachPlayer(String letter) {
        String consonants = "bcdfghjklmnpqrstvwxz";
        String vowels = "aeiouy";
        Random randomChars = new Random();

        if (letter.equals("consonne")){
            char randomConsonant = consonants.charAt(randomChars.nextInt(consonants.length()));
            listSortedLetters.add(randomConsonant);
        }
        else if (letter.equals("voyelle")){
            char randomVowel = vowels.charAt(randomChars.nextInt(vowels.length()));
            listSortedLetters.add(randomVowel);
        }

    }
    // --------------------------------------------------------------------------



    // -------------------- GET WORD CREATED FOREACH USER ------------------------

    public void getCreatedWordByUserOne(String word){
        System.out.println(listSortedLetters);
        wordCreatedByUserOne = (word);
        // Add the word entered by the userOne in a list for Each character in the word
        for (int i = 0; i < wordCreatedByUserOne.length(); i++){
            listCharsFromUserOneWord.add(wordCreatedByUserOne.charAt(i));
        }

        checkValidityWordComparedListForUserOne();
    }
    public void getCreatedWordByUserTwo(String word) {
        System.out.println(listSortedLetters);
        wordCreatedByUserTwo = (word);
        // Add the word entered by the userTwo in a list for Each character in the word
        for (int i = 0; i < wordCreatedByUserTwo.length(); i++){
            listCharsFromUserTwoWord.add(wordCreatedByUserTwo.charAt(i));
        }
        checkValidityWordComparedListForUserTwo();
    }
    // -------------------------------------------------------------------------------------

    // ----- LOOKING FOR LONGEST WORD CREATED BY USERS TO DETERMINED WINNER ---------------

    public void checkLenghtOfWord(){
        if (wordCreatedByUserOne.length() == wordCreatedByUserTwo.length()){
            System.out.println("+1 for user ONE AND TWO");
        }

        else if (wordCreatedByUserOne.length() > wordCreatedByUserTwo.length()){
            System.out.println("+1 for user ONE");
        }
        else {
            System.out.println("+1 for user 2");
        }
    }


    //----------------------- CHECKING IF CHARACTERS IN SORTED CHARACTERS LIST ----------
    // ---------------------------------------- USER ONE -------------------------------

    public void checkValidityWordComparedListForUserOne(){
        for (int i = 0; i < wordCreatedByUserOne.length(); i++){
            //letters.size() == checkValidityWordsForUserOne.stream().distinct().count()
            if (listSortedLetters.contains(listCharsFromUserOneWord.get(i)) && listCharsFromUserOneWord.size() < listSortedLetters.size()){
                System.out.println("noProblemOne");
            }
            else {
                System.out.println("1 Les caractères rentrés ne sont pas présents");
                break;
            }

        }
    }

    //----------------------- CHECKING IF CHARACTERS IN SORTED CHARACTERS LIST ----------
    // ---------------------------------------- USER TWO -------------------------------

    public void checkValidityWordComparedListForUserTwo(){
        for (int i = 0; i < wordCreatedByUserTwo.length(); i++){
            //letters.size() == checkValidityWordsForUserTwo.stream().distinct().count()
            if (listSortedLetters.contains(listCharsFromUserTwoWord.get(i)) && listCharsFromUserTwoWord.size() < listSortedLetters.size()){
                System.out.println("noProblemTwo");
            }
            else {
                System.out.println("2 Les caractères rentrés ne sont pas présents");
                break;
            }

        }
    }


    // TODO algo checking if words is TRUE
    public void checkIfWordUserOneExistsInDict(){
       // dict.contains(wordCreatedByUserOne);
    }
    public void checkIfWordUserTwoExistsInDict(){
        // dict.contains(wordCreatedByUserTwo);
    }



    //TODO AlGO AI FOR the longest word possible with characters sorted








    //------------------------------------------------------------

    public void getLetters(String str) {
        System.out.println(str);
    }
}









//---------------------- this was test area ----------------


//        for(int i = 0; i < checkValidityWords.size(); i++){
//            for (int j = 0; j < letters.size(); j++){
//                if (letters.get(j) == checkValidityWords.get(i)){
//                    checkTest.add(checkValidityWords.get(i));
//                    if (checkValidityWords.equals(letters)){
//                        System.out.println("good");
//                    }
//
//                }
//                else {
//                    System.out.println("nope");
//                }
//
//            }
//            System.out.println(checkTest);
//
//        }

//        for (int i = 0; i < wordCreatedByUserOne.length(); i++) {
//            for (int j = i; j < letters.size(); j++){
        //letters.size()
//        for (int i = 0; i <  letters.size(); i++) {
//            int j = i;
//            if (letters.get(i) != wordCreatedByUserOne.charAt(j)) {
//                System.out.println("nope");
//            } else {
//                System.out.println("yeap");
//            }



//                if (Objects.equals(letters.indexOf(letters.get(j)), wordCreatedByUserOne.charAt(i))) {
//                    System.out.println("yess");
//                }
//                else {
//                    System.out.println("nopeeeee");
//                }







