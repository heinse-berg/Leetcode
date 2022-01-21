package com.gfg;
import java.util.*;
//https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
public class ArrayPairGivenSum {
    boolean func(int []array, int sum) {
        HashSet<Integer> set = new HashSet<>(array.length);
        int i;
        for(i = 0; i < array.length; i++) {
            if(set.contains(sum-array[i]))
                return true;
            set.add(array[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayPairGivenSum abc = new ArrayPairGivenSum();
        int arr[] = new int[]{11, 15, 6, 8, 9, 10};
        System.out.println(abc.func(arr, 20));
    }
}
