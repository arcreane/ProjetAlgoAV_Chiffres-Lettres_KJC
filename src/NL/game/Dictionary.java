package NL.game;

import NL.game.logic.Letters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {
    //public static List<String> dictionary = new ArrayList<>();
    public static ArrayList<String> dictionaryArray = new ArrayList<String>();
    List<Character> test = new ArrayList<Character>();

    List<String> dictionary = new ArrayList<>();

    public void initContent() {
    public static void initContent() {
        String os_path = "src/french_list.txt";

        try (BufferedReader scan = new BufferedReader(new FileReader(os_path))) {
            dictionaryArray = (ArrayList<String>) scan.lines().collect(Collectors.toList()); //dictionary
        } catch (IOException e) {
            System.out.println("Bruh");
        }
    }

    //Init the dictionary content.
//        Dictionary dict = new Dictionary();
//        dict.initContent();
    //Test the dictionary size and if the word "banane" or "rfzrfzefz" are present in the dictionary,
//        System.out.println(dict.dictionary.size());
//        System.out.println(dict.dictionary.contains("banane")); //true
//        System.out.println(dict.dictionary.contains("rfzrfzefz")); //false
}
