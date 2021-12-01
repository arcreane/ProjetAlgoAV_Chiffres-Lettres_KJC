package NL.game.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Letters {
    public static List<Character> letters = new ArrayList<Character>();
    public static List<Character> checkValidityWordsForUserOne = new ArrayList<Character>();
    public static List<Character> checkValidityWordsForUserTwo = new ArrayList<Character>();
    String wordCreatedByUserOne;
    String wordCreatedByUserTwo;



    public List<Character> getLetters() {
        return letters;
    }




    public void checkTypeOfLetter(String letter) {
        String chars = "bcdfghjklmnpqrstvwxz";
        String vowels = "aeiouy";
        Random vowel = new Random();

        if (letter.equals("consonne")){
            char c = chars.charAt(vowel.nextInt(chars.length()));
            letters.add(c);
        }
        else if (letter.equals("voyelle")){
            char v = vowels.charAt(vowel.nextInt(vowels.length()));
            letters.add(v);
        }

    }

    public void wordFoundedByUserOne(String word){
        System.out.println(letters);
        wordCreatedByUserOne = (word);
        for (int i = 0; i < wordCreatedByUserOne.length(); i++){
            checkValidityWordsForUserOne.add(wordCreatedByUserOne.charAt(i));
        }

        checkValidWordForUserOne();
    }
    public void wordFoundedByUserTwo(String word) {
        System.out.println(letters);
        wordCreatedByUserTwo = (word);
        for (int i = 0; i < wordCreatedByUserTwo.length(); i++){
            checkValidityWordsForUserTwo.add(wordCreatedByUserTwo.charAt(i));
        }
        checkValidWordForUserTwo();
    }

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

    public void checkValidWordForUserOne(){
        for (int i = 0; i < wordCreatedByUserOne.length(); i++){
            //letters.size() == checkValidityWordsForUserOne.stream().distinct().count()
            if (letters.contains(checkValidityWordsForUserOne.get(i)) && checkValidityWordsForUserOne.size() < letters.size()){
                System.out.println("good");
            }
            else {
                System.out.println("nope");
            }

        }
    }

    public void checkValidWordForUserTwo(){
        for (int i = 0; i < wordCreatedByUserTwo.length(); i++){
            //letters.size() == checkValidityWordsForUserTwo.stream().distinct().count()
            if (letters.contains(checkValidityWordsForUserTwo.get(i)) && checkValidityWordsForUserTwo.size() < letters.size()){
                System.out.println("good2");
            }
            else {
                System.out.println("nope2");
            }

        }
    }


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







