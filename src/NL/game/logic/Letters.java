package NL.game.logic;

import NL.game.Dictionary;

import java.util.ArrayList;
import java.util.Random;
import static NL.game.Dictionary.dictionaryArray;

public class Letters {
    public static ArrayList<String> listSortedCharacters = new ArrayList<String>();
    public static  ArrayList<String> wordsCanBeWritten = new ArrayList<String>();
    public String wordCreatedByUserOne;
    public String wordCreatedByUserTwo;
    static int countCalcDict = 0;
    public boolean correctWordUserOne;
    public boolean correctWordUserTwo;

    public static ArrayList<String> getListSortedCharacters() {
        return listSortedCharacters;
    }

    // -------- constructor for refresh all arrayList
    public Letters() {
        wordsCanBeWritten = new ArrayList<String>();
        listSortedCharacters =  new ArrayList<String>();
        // INIT DICTIONNARY For each loop HERE
        Dictionary.initContent();
        countCalcDict = 0;
    }





// --------------------- SORT RANDOM CHARACTER (CONSONANT/VOWEL) -------------


// ---------------------- DEPENDANT FOREACH USERS CHOICE --------------------

    public void creatingRandomCharsFromAskingEachPlayer(String letter) {

        String consonants = "bcdfghjklmnpqrstvwxz";
        String vowels = "aeiouy";
        Random randomChars = new Random();

        if (letter.equals("c")){
            String randomConsonant = String.valueOf(consonants.charAt(randomChars.nextInt(consonants.length())));
            listSortedCharacters.add(randomConsonant);
        }
        else if (letter.equals("v")){
            String randomVowel = String.valueOf(vowels.charAt(randomChars.nextInt(vowels.length())));
            listSortedCharacters.add(randomVowel);
        }
    }
    // --------------------------------------------------------------------------




    // -------------------- GET WORD CREATED FOREACH USER ------------------------


    // ------------- USER ONE ------------------
    public boolean getCreatedWordByUserOne(String word){
        wordCreatedByUserOne = (word);

        // add condition if word exists or no
        if (wordsCanBeWritten.contains(wordCreatedByUserOne)) {
            correctWordUserOne = true;
            return true;
        }
        else {
            correctWordUserOne = false;
            return false;
        }
    }
    //-----------------------------------------------------------------------------

    // --------- USER TWO ------------------
    public boolean getCreatedWordByUserTwo(String word) {
        wordCreatedByUserTwo = (word);

        // add condition if word exists or no
        if (wordsCanBeWritten.contains(wordCreatedByUserTwo)){
            correctWordUserTwo = true;
            return true;
        }
        else {
            correctWordUserTwo = false;
            return false;
        }
    }
    // -------------------------------------------------------------------------------------

    // ----- LOOKING FOR LONGEST WORD CREATED BY USERS TO DETERMINED WINNER ---------------

    // ------------------------------ ALGO AI ----------------------------------


    // ---------------- RETURN VALID WORDS FROM LIST OF CHARS GIVEN PRESENTS IN DICTIONARY   -------
    public static boolean canBeWritten(ArrayList<String> dictionnaryArray, String word) {
        countCalcDict++;
        while (dictionnaryArray.remove(String.valueOf(word.charAt(0))))
            if (word.length() <= 2) {
                return true;
            } else
                word = word.substring(1);
        return false;
    }
// -----------------------------------------------------------------------

    //loop on words of dictionnary
    public void loopWordsDictionary() {
        for (String word : dictionaryArray) {
            if (word.length() <= listSortedCharacters.size()) {
                ArrayList<String> temp = new ArrayList<String>(listSortedCharacters);
                if (canBeWritten(temp, word))
                    wordsCanBeWritten.add(word);
            }
        }
        //String[] arr = str.split("");
        for (int i = 0; i < wordsCanBeWritten.size() -1  ; i++){
//            String[] arr = wordsCanBeWritten.get(i).split("");
//            for(String character : arr)
//                System.out.print(character + " " + "\n");
//
            for ( int j = 0; j < listSortedCharacters.size() -1 ; j++){
                if (!wordsCanBeWritten.get(0).contains(listSortedCharacters.get(j))){
                    wordsCanBeWritten.remove(0);
                }
            }





//        for (int i = 0; i < listSortedCharacters.size() ; i++) {
//            for (int j = 0; j < wordsCanBeWritten.size() -1 ; j++) {
//                for (int letters = 0; letters < wordsCanBeWritten.get(j).length() -1; letters++) {
//                    //System.out.println(letters);
//                    //System.out.println(wordsCanBeWritten.get(j).substring(letters));
//                    //System.out.println(wordsCanBeWritten.get(j).get(letters));
//                   // System.out.println(letters.charAt(i));
//                    if (wordsCanBeWritten.get(j).substring(letters, letters +1).contains(listSortedCharacters.get(j))) {  //
//                        System.out.println(wordsCanBeWritten.get(j));
//
//
//                    }
//                }
               // System.out.println("words can be written with these characters :  " + wordsCanBeWritten);
                //for(int k = i; k < w)
//listSortedCharacters.get(i).contains(wordsCanBeWritten.get(j))
//                if (wordsCanBeWritten.get(j).substring(letters).contains(listSortedCharacters.get(i))) {  //
//                    System.out.println(wordsCanBeWritten.get(j));
//
//
//                }


            }
        }

//        for (String word : wordsCanBeWritten){
//            switch (word.length()) {
//                case 6:
//                    System.out.println(word);
//
//                case 7:
//                    System.out.println(word);
           // System.out.println("words can be written with these characters :  " + wordsCanBeWritten);
        }
//    }


//            if (word.length() >= 10){
//                System.out.println(word.length());
//            }

//        System.out.println("words can be written with these characters :  "+ wordsCanBeWritten) ;
//        }
        //System.out.println(wordsCanBeWritten.size() + " words");
        //System.out.println("words can be written with these characters :  "+ wordsCanBeWritten) ;












    //----------------------- CHECKING IF CHARACTERS IN SORTED CHARACTERS LIST ----------
    // ---------------------------------------- USER ONE -------------------------------

//    public void checkValidityWordComparedListForUserOne(){
//        for (int i = 0; i < listCharsFromUserOneWord.size()  ; i++){
//            if (listSortedCharacters.contains(listCharsFromUserOneWord.get(i)) && listCharsFromUserOneWord.size() <= listSortedCharacters.size()){
//                // repeat of chars is not finished yet
//                listSortedCharacters.remove(listCharsFromUserOneWord.get(i));
//                listCharsFromUserOneWord.remove(i);
////                System.out.println(listCharsFromUserOneWord);
//                System.out.println("noProblemOne");
////                System.out.println(listSortedLetters);
//
//            }
//            else {
//                System.out.println("1 Les caractères rentrés ne sont pas présents");
//                break;
//            }
//
//        }
//    }

    //----------------------- CHECKING IF CHARACTERS IN SORTED CHARACTERS LIST ----------
    // ---------------------------------------- USER TWO -------------------------------

//    public void checkValidityWordComparedListForUserTwo(){
//        for (int i = 0; i < listCharsFromUserTwoWord.size(); i++){
//            if (listSortedCharacters.contains(listCharsFromUserTwoWord.get(i)) && listCharsFromUserTwoWord.size() <= listSortedCharacters.size()){
//                // repeat of chars is not finished yet
//                listSortedCharacters.remove(listCharsFromUserTwoWord.get(i));
//                listCharsFromUserTwoWord.remove(i);
////                System.out.println(listCharsFromUserTwoWord);
////                System.out.println(listSortedLetters);
//                System.out.println("noProblemTwo");
//            }
//            else {
//                //System.out.println(listSortedLetters);
//                System.out.println("2 Les caractères rentrés ne sont pas présents");
//                break;
//            }
//
//        }
//    }



//    public void checkIfWordUserOneExistsInDict(String word){
//        if (Dictionary.dictionaryArray.contains(word)){
//            System.out.println("TRUE");
//        }
//        else {
//            System.out.println("false");
//        }
//    }
//
//
//    public void checkIfWordUserTwoExistsInDict(String word){
//        if (Dictionary.dictionaryArray.contains(word)){
//            System.out.println("truuuue");
//        }
//        else {
//            System.out.println("falseeee");
//        }
//    }











    //------------------------------------------------------------

//    public void getLetters(String str) {
//        System.out.println(str);
//    }
//}









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







