package NL.game;

import NL.game.logic.Letters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {
    public static ArrayList<String> dictionaryArray = new ArrayList<>();
    public static void initContent() {
        String os_path = "src/french_list.txt";

        try (BufferedReader scan = new BufferedReader(new FileReader(os_path))) {
            dictionaryArray = (ArrayList<String>) scan.lines().collect(Collectors.toList());
        } catch (IOException ignored) { }
    }
}
