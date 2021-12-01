package NL.game.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {

    List<String> dictionary = new ArrayList<>();

    public void initDictionary() {

        String os_path = "src/french_list";

        try (BufferedReader scan = new BufferedReader(new FileReader(os_path))) {
                dictionary = scan.lines().collect(Collectors.toList());
        } catch (IOException ignore) { }
    }
}
