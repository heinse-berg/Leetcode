package com.leetcodecards.greedy;

import java.util.*;

public class MaxSwap {

    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int[] buckets = new int[10];
        for(int i = 0; i < array.length; i++) {
            buckets[array[i]-'0'] = i;
        }

        for(int i = 0; i < array.length; i++) {
            for(int j = 9; j >= 0 &&  (j > array[i]-'0'); j--) {
                if(buckets[j] > i) {
                    char c = array[i];
                    array[i] = array[buckets[j]];
                    array[buckets[j]] = c;
                    return Integer.parseInt(new String(array));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaxSwap abc = new MaxSwap();
        System.out.println(abc.maximumSwap(98368));
    }
}
