package NL.game.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Letters {
    public static List<Character> letters = new ArrayList<Character>();
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
            System.out.println("consonne");
        }
        else if (letter.equals("voyelle")){
            char v = vowels.charAt(vowel.nextInt(chars.length()));
            letters.add(v);
            System.out.println("voyellle");
        }
    }

    public void wordFoundedByUserOne(String word){
        System.out.println(letters);
        wordCreatedByUserOne = (word);
    }
    public void wordFoundedByUserTwo(String word) {
        System.out.println(letters);
        wordCreatedByUserTwo = (word);
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


    public void getLetters(String str) {
        System.out.println(str);
    }
}
