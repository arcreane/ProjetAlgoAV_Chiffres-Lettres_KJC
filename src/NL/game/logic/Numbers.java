package NL.game.logic;

import NL.game.User;

import java.util.*;

public class Numbers {
    public static ArrayList<Integer> plates = new ArrayList<>();

    public Numbers() {
        plates = new ArrayList<>();
        rank1 = new ArrayList<>()
        {{ for(int numbers = 1; numbers < 9; numbers++) { add(numbers); add(numbers); } }};

        rank2 = new ArrayList<>()
        {{ for(int numbers = 25; numbers <= 50; numbers = numbers + 25) { add(numbers); add(numbers); } }};

        rank3 = new ArrayList<>()
        {{ for(int numbers = 75; numbers <= 100; numbers = numbers + 25) { add(numbers); add(numbers); } }};
    }

    public static List<Integer> rank1 = new ArrayList<>()
    {{ for(int numbers = 1; numbers < 9; numbers++) { add(numbers); add(numbers); } }};

    public static List<Integer> rank2 = new ArrayList<>()
    {{ for(int numbers = 25; numbers <= 50; numbers = numbers + 25) { add(numbers); add(numbers); } }};

    public static List<Integer> rank3 = new ArrayList<>()
    {{ for(int numbers = 75; numbers <= 100; numbers = numbers + 25) { add(numbers); add(numbers); } }};

    public static List<Integer> stock = null;
    public static List<String> stockOperation = null;

    public static int bestCase = -1;

    public static void setStock() {
        stock = new ArrayList<>(plates);
    }

    public static void setStockOperation() {
        stockOperation = new ArrayList<>() {{
            for (Integer plate : plates) {
                add(String.valueOf(plate));
            }
        }};
    }

    public static final int randomNumber = utilsRand(100,999);

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

    public static void findNumber() {

        int target = randomNumber;

        List<Integer> allResults20 = new ArrayList<>();
        List<Integer> allResults16 = new ArrayList<>();
        List<Integer> allResults12 = new ArrayList<>();
        List<Integer> allResults8 = new ArrayList<>();
        List<Integer> allResults4 = new ArrayList<>();

        for (Integer number : plates) {
            List<Integer> temp = new ArrayList<>(plates);
            temp.remove(number);
            List<Integer> temp2 = new ArrayList<>(temp);
            getArray(number, temp, allResults20);

            temp2.remove(temp2.get(0));
            for (Integer numberList2 : allResults20) {
                getArray(numberList2, temp2, allResults16);
            }

            temp2.remove(temp2.get(0));
            for (Integer numberList3 : allResults16) {
                getArray(numberList3, temp2, allResults12);
            }

            temp2.remove(temp2.get(0));
            for (Integer numberList4 : allResults12) {
                getArray(numberList4, temp2, allResults8);
            }

            temp2.remove(temp2.get(0));
            for (Integer numberList5 : allResults8) {
                getArray(numberList5, temp2, allResults4);
            }

            allResults20.clear();
            allResults16.clear();
            allResults12.clear();
            allResults8.clear();
            allResults4.clear();

            for (int thisResult : stock) {
                boolean verify = Math.abs(target - thisResult) < Math.abs(target - bestCase);
                if (verify) bestCase = thisResult;
                if (Math.abs(target - bestCase) == 0) break;
            }
            break;
        }
    }

    public static void displayBestComp() {
        int index = stock.indexOf(bestCase);
        String operation = stockOperation.get(index);
        System.out.println("\nThe best case is : " + bestCase + " at index " + index + " and the calculation was : " + operation);
    }

    private static void getArray(Integer number, List<Integer> temp, List<Integer> integers) {
        for (int nbNumber = 0; nbNumber < temp.size(); nbNumber++) {

            Integer value = temp.get(nbNumber);
            int index = stock.indexOf(number);
            extractMethod(number, integers, value, index, stockOperation, stock);
        }
    }

    public static void extractMethod(Integer number, List<Integer> integers, Integer value, int index, List<String> stockOperation, List<Integer> stock) {
        String previousMath = stockOperation.get(index);

        for (int calculus = 0; calculus < 4; calculus++) {

            int result = 0;
            switch (calculus) {
                case 0 -> {
                    result = number * value;
                    stockOperation.add(previousMath + "*" + value);
                }
                case 1 -> {
                    if (number % value != 0) {
                        continue;
                    }
                    result = number / value;
                    stockOperation.add(previousMath + "/" + value);
                }
                case 2 -> {
                    result = number + value;
                    stockOperation.add("(" + previousMath + "+" + value + ")");
                }
                case 3 -> {
                    result = number - value;
                    stockOperation.add("(" + previousMath + "-" + value + ")");
                }
            }
            integers.add(result);
            stock.add(result);
        }
    }

    public static int utilsRand(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static int getCalculus(User game) {
        String toSplit = game.getAnswer();
        String[] inputs = toSplit.split(" ");
        int num1 = 0, num2 = 0;

        int resultTemp = 0;

        for (int i  = 0; i< inputs.length; i++){
            if (i % 2 ==0){
                num1 = Integer.parseInt(inputs[i]);
                try {
                    num2 = Integer.parseInt(inputs[i+2]);
                }
                catch (Exception e){
                    break;
                }
            }

            if (i==1){
                resultTemp = getResultTemp(inputs, num1, num2, resultTemp, i);
            }
            else {
                resultTemp = getResultTemp(inputs, resultTemp, num1, resultTemp, i);
            }
        }

        return resultTemp;
    }

    private static int getResultTemp(String[] inputs, int num1, int num2, int resultTemp, int i) {

        switch (inputs[i]) {
            case "+" -> {
                resultTemp = num1 + num2;
            }
            case "-" -> {
                resultTemp = num1 - num2;
            }
            case "*" -> {
                resultTemp = num1 * num2;
            }
            case "/" -> {
                if(num1 % num2 != 0) break;
                resultTemp = num1 / num2;
            }
        }
        return resultTemp;
    }

    public static boolean findWinner(int result1, int result2) {
        return Math.abs(randomNumber - result1) < Math.abs(randomNumber - result2);
    }
}