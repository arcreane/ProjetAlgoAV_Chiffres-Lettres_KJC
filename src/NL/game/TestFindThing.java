package NL.game;

import java.io.*;
import java.util.*;

public class TestFindThing {

    public static final List<List<Integer>> myArrays = new ArrayList<>();

    public static void getPermutations(int[] array){
        helper(array, 0);

        System.out.println(myArrays);
    }

    private static void helper(int[] array, int pos){
        if(pos >= array.length - 1){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < array.length - 1; i++){
                temp.add(array[i]);
            }
            if(array.length > 0)
                temp.add(array[array.length - 1]);
//            System.out.println(temp);
            myArrays.add(temp);
            return;
        }

        for(int i = pos; i < array.length; i++){

            int t = array[pos];
            array[pos] = array[i];
            array[i] = t;

            helper(array, pos+1);

            t = array[pos];
            array[pos] = array[i];
            array[i] = t;
        }
    }
    public static void main(String args[]) {
        int[] numbers = {1, 9, 8, 4, 3};
        getPermutations(numbers);
    }
}