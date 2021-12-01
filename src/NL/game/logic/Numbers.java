package NL.game.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numbers {

    List<Integer> plates = new ArrayList<>();
    Integer[] rank1 = new Integer[] {1,2,3,4,5,6,7,8,9};
    Integer[] rank2 = new Integer[] {25,50};
    Integer[] rank3 = new Integer[] {75,100};


    public void test() {
        System.out.println("I'm the numbers game");
        // It's a test, you will need to remove it.
    }

    public void addPlates(int number) {
        plates.add(number);
    }

    public void printPlates() {
        System.out.println(plates);
    }

    public int setPlates(int number) {
        switch (number) {
            case 1 -> { return rank1[utilsRand(9)]; }
            case 2 -> { return rank2[utilsRand(1)]; }
            case 3 -> { return rank3[utilsRand(1)]; }
        }
        return 0;
    }

    private int utilsRand(int max) {
        if (0 >= max) {
            throw new IllegalArgumentException("max must be greater than 0");
        }

        Random rand = new Random();
        return rand.nextInt((max) + 1);
    }
}
