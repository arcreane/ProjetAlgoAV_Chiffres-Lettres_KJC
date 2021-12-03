package NL.game.logic;

import java.util.*;

public class Numbers {
    public static List<Integer> plates = new ArrayList<>();

    public Numbers() {
        plates = new ArrayList<>();
    }



    public static List<Integer> rank1 = new ArrayList<>()
    {{ for(int numbers = 1; numbers < 9; numbers++) { add(numbers); add(numbers); } }};

    public static List<Integer> rank2 = new ArrayList<>()
    {{ for(int numbers = 25; numbers <= 50; numbers = numbers + 25) { add(numbers); add(numbers); } }};

    public static List<Integer> rank3 = new ArrayList<>()
    {{ for(int numbers = 75; numbers <= 100; numbers = numbers + 25) { add(numbers); add(numbers); } }};

    int randomNumber = utilsRand(100,999);

    public void addPlates(int number) {
        plates.add(number);
    }

    public int setPlates(int number) {
        int validatedRand = -1;
        int selectedRand;

        switch (number) {
            case 1 -> {
                while(validatedRand == -1) {
                    selectedRand = rank1.get(utilsRand(0,rank1.size() -1));
                    validatedRand = utilsLimitDuplicate(selectedRand);
                }
                return validatedRand; }
            case 2 -> {
                while(validatedRand == -1) {
                    selectedRand = rank2.get(utilsRand(0, rank2.size() - 1));
                    validatedRand = utilsLimitDuplicate(selectedRand);
                }
                return validatedRand; }
            case 3 -> {
                while(validatedRand == -1) {
                    selectedRand = rank3.get(utilsRand(0,rank3.size() - 1));
                    validatedRand = utilsLimitDuplicate(selectedRand);
                }
                return validatedRand; }
        }
        return 0;
    }

    private int utilsLimitDuplicate(Integer selectedRand) {

        if      (rank1.contains(selectedRand)) rank1.remove(selectedRand);
        else if (rank2.contains(selectedRand)) rank2.remove(selectedRand);
        else if (rank3.contains(selectedRand)) rank3.remove(selectedRand);
        else return -1;

        return selectedRand;
    }

    public static int utilsRand(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
