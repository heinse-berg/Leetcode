package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/count-good-meals/
public class P1711_GoodMeals {
    public int countPairs(int[] deliciousness) {
        int count = 0, i = 0, j, mod = 1000000007;
        HashSet<Integer> powerOf2 = new HashSet<>();
        int[] pow = new int[22];
        pow[0] = 1;
        for(i = 1; i <= 21 ; i++) {
            pow[i] = pow[i-1] * 2;
        }
        HashMap<Integer, Integer> array = new HashMap<>();
        for(i = 0; i < deliciousness.length; i++) {
            array.merge(deliciousness[i], 1, Integer::sum);
        }
        for(i = 0; i < deliciousness.length; i++) {
            for(j = 0; j <= 21 ; j++) {
                if(array.get(pow[j]-deliciousness[i]) != null)
                    count += array.get(pow[j] - deliciousness[i]);
                if(pow[j]-deliciousness[i] == deliciousness[i])
                    count--;
                count = count % mod;
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        int[]arr = {32, 32, 32, 32};
        System.out.println(new P1711_GoodMeals().countPairs(arr));
    }
}
