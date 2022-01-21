package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class RobbingHouses {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] array;

    public int topDownHelper(int n) {
        if(n == 0)
            return array[0];
        if(n == 1)
            return Math.max(array[0], array[1]);
        if(!map.containsKey(n)) {
            map.put(n, Math.max(topDownHelper(n-1), topDownHelper(n-2) + array[n]));
        }
        return map.get(n);
    }

    public int topDown(int[] array) {
        map.clear();
        this.array = array;
        return topDownHelper(array.length-1);
    }

    public int bottomUp(int[] array) {
        int length = array.length;
        if(length == 1) return array[0];

        int[] dp = new int[length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);

        for(int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2] + array[i], dp[i-1]);
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        RobbingHouses abc = new RobbingHouses();
        System.out.println(abc.bottomUp(new int[] {2,7,9,3,1}));
        System.out.println(abc.topDown(new int[] {2,1,1,2}));
        System.out.println(abc.topDown(new int[] {2,1,1,2}));
    }
}
