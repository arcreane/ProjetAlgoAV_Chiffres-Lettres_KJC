package NL.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TEST {

    public static final List<Integer> plates = new ArrayList<>() {{
        add(25); add(7); add(10); add(4); add(100); add(3);
    }};

    public static final List<String> test = new ArrayList<>() {{
        add("25"); add("7"); add("10"); add("4"); add("100"); add("3");
    }};

    public static final List<Integer> stock = new ArrayList<>(plates);
    public static final List<String> stockOperation = new ArrayList<>(test);

    public static void main(String[] args) {
        int save = -1;
        int target = 200;

        int iteration = 0;

        List<Integer> allResults20 = new ArrayList<>();
        List<Integer> allResults16 = new ArrayList<>();
        List<Integer> allResults12 = new ArrayList<>();
        List<Integer> allResults8 = new ArrayList<>();
        List<Integer> allResults4 = new ArrayList<>();

        int bestCase = -1;

        for (Integer number : plates) {
            List<Integer> temp = new ArrayList<>(plates);
            temp.remove(number);
            List<Integer> temp2 = new ArrayList<>(temp);

            System.out.println("\nThis is the : " + iteration + " iteration");
            System.out.println(temp);
            getArray(number, temp, allResults20);
            System.out.println(allResults20);
            System.out.println(stock);

            int iteration2 = 1;
            temp2.remove(temp2.get(0)); //7
            System.out.println("\nGet all 20 values : ");

            for (Integer numberList2 : allResults20) {
                System.out.println("\nThis is the : " + iteration2 + " iteration of 20 values");
                getArray(numberList2, temp2, allResults16);
                iteration2++;
            }

            int iteration3 = 1;
            temp2.remove(temp2.get(0)); //10
            System.out.println("\nGet all 16 values : ");

            for (Integer numberList3 : allResults16) {
                System.out.println("\nThis is the : " + iteration3 + " iteration of 16 values");
                getArray(numberList3, temp2, allResults12);
                iteration3++;
            }

            int iteration4 = 1;
            temp2.remove(temp2.get(0));
            System.out.println("\nGet all 12 values : ");

            for (Integer numberList4 : allResults12) {
                System.out.println("\nThis is the : " + iteration4 + " iteration of 12 values");
                getArray(numberList4, temp2, allResults8);
                iteration4++;
            }

            int iteration5 = 1;
            temp2.remove(temp2.get(0));
            System.out.println("\nGet all 8 values : ");

            for (Integer numberList5 : allResults8) {
                System.out.println("\nThis is the : " + iteration5 + " iteration of 8 values");
                getArray(numberList5, temp2, allResults4);
                iteration5++;
            }

            System.out.println("\n\nArrays: \n");
            System.out.println(allResults20);
            System.out.println(allResults16);
            System.out.println(allResults12);
            System.out.println(allResults8);
            System.out.println(allResults4);
            System.out.println(stock);
            System.out.println(stockOperation);

            allResults20.clear();
            allResults16.clear();
            allResults12.clear();
            allResults8.clear();
            allResults4.clear();

            System.out.println("\n\n Processing best result \n");
            for (int thisResult : stock) {
                int a = target - thisResult;
                int b = target - bestCase;
                System.out.println(target + "-" + thisResult + " = " + a + " vs " + target + "-" + bestCase + " = " + b);
                boolean verify = Math.abs(target - thisResult) < Math.abs(target - bestCase);
                if (verify) bestCase = thisResult;
                if(Math.abs(target - bestCase) == 0) {
                    break;
                }
            }

            int index = stock.indexOf(bestCase);
            String operation = stockOperation.get(index);
            System.out.println("\n\nThe best case is : " + bestCase + " at index " + index + " and the calculation was : " + operation);

            iteration++;
            break;
//
//            temp.remove(number); //3
//
//
//            temp.remove(number); //2
//            for (Integer numberList4 : temp) {
//                getArray(numberList4, temp, allResults8);
//            }
//
//            temp.remove(number); //1
//            for (Integer numberList5 : temp) {
//                getArray(numberList5, temp, allResults4);
//            }

//            int cases = 1;
//            for (int nbNumber = 0; nbNumber < temp.size(); nbNumber++) {
//
//                Integer value = temp.get(nbNumber);
//
//                for (int calculus = 0; calculus < 4; calculus++) {
//
//                    int result = 0;
//                    switch (calculus) {
//                        case 0 -> {
//                            if (iteration == 0) {
//                                result = number * value; //
//                                System.out.println(number + "*" + value + "=" + result + " cas : " + cases++);
//                            } else {
//                                result = bestCase * value;
//                                System.out.println(bestCase + "*" + value + "=" + result + " cas : " + cases++);
//                            }
//                        }
//                        case 1 -> {
//                            if (iteration == 0) {
//                                if (number % value != 0) {
//                                    System.out.println("Ignore cas : " + cases++);
//                                    continue;
//                                }
//                                result = number / value;
//                                System.out.println(number + "/" + value + "=" + result + " cas : " + cases++);
//                            } else {
//                                if (save % value != 0) {
//                                    System.out.println("Ignore cas : " + cases++);
//                                    continue;
//                                }
//                                result = bestCase / value;
//                                System.out.println(bestCase + "/" + value + "=" + result + " cas : " + cases++);
//                            }
//                        }
//                        case 2 -> {
//                            if (iteration == 0) {
//                                result = number + value;
//                                System.out.println(number + "+" + value + "=" + result + " cas : " + cases++);
//                            } else {
//                                result = bestCase + value;
//                                System.out.println(bestCase + "+" + value + "=" + result + " cas : " + cases++);
//                            }
//                        }
//                        case 3 -> {
//                            if (iteration == 0) {
//                                result = number - value;
//                                System.out.println(number + "-" + value + "=" + result + " cas : " + cases++);
//                            } else {
//                                result = bestCase - value;
//                                System.out.println(bestCase + "-" + value + "=" + result + " cas : " + cases++);
//                            }
//                        }
//                    }
//
//                    allResults.add(result);
//                    if (save == -1) {
//                        save = result;
//                    } else {
//                        boolean verify = Math.abs(target - result) < Math.abs(target - save);
//                        if (verify) save = result;
//                    }
//                }
//            }

//            System.out.println("\n\n Processing best result \n");
//            for (int thisResult : allResults) {
//                int a = target - thisResult;
//                int b = target - bestCase;
//                System.out.println(target + "-" + thisResult + " = " + a + " vs " + target + "-" + bestCase + " = " + b);
//                boolean verify = Math.abs(target - thisResult) < Math.abs(target - bestCase);
//                if (verify) bestCase = thisResult;
//            }
//
//            System.out.println("\nThe best case is " + bestCase);
//
//            allResults.clear();
//            iteration++;
        }
    }

    private static void getArray(Integer number, List<Integer> temp, List<Integer> integers) {
        int cases = 1;
        System.out.println("\n");
        for (int nbNumber = 0; nbNumber < temp.size(); nbNumber++) {

            Integer value = temp.get(nbNumber);
            int index = stock.indexOf(number);
            String previousMath = stockOperation.get(index);

            for (int calculus = 0; calculus < 4; calculus++) {

                int result = 0;
                switch (calculus) {
                    case 0 -> {
                        result = number * value; //
                        System.out.println(number + "*" + value + "=" + result + " cas : " + cases++);
                        stockOperation.add(previousMath + "*" + value);
                    }
                    case 1 -> {
                        if (number % value != 0) {
                            continue;
                        }
                        result = number / value;
                        System.out.println(number + "/" + value + "=" + result + " cas : " + cases++);
                        stockOperation.add(previousMath + "/" + value);
                    }
                    case 2 -> {
                        result = number + value;
                        System.out.println(number + "+" + value + "=" + result + " cas : " + cases++);
                        stockOperation.add("(" + previousMath + "+" + value + ")");
                    }
                    case 3 -> {
                        result = number - value;
                        System.out.println(number + "-" + value + "=" + result + " cas : " + cases++);
                        stockOperation.add("(" + previousMath + "-" + value + ")");
                    }
                }
                integers.add(result);
                stock.add(result);
            }
        }
    }
}