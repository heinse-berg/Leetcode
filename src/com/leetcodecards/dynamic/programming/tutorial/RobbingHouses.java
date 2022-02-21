package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class RobbingHouses {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int bottomUp(int[] houses) {
        int i, n = houses.length;
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for(i = 2; i < n; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2] + houses[i]);

        return dp[n-1];
    }

    public int dp(int i, int[] houses) {
        if(i == 0)
            return houses[0];
        if(i == 1)
            return Math.max(houses[0], houses[1]);

        if(!memo.containsKey(i))
            memo.put(i, Math.max(dp(i-2, houses) + houses[i], dp(i-1, houses)));

        return memo.get(i);
    }

    public int topDown(int[] houses) {
        return dp(houses.length-1, houses);
    }

    public static void main(String[] args) {
        RobbingHouses abc = new RobbingHouses();
        System.out.println(abc.bottomUp(new int[] {2,7,9,3,1}));
        System.out.println(abc.bottomUp(new int[] {2,1,1,2}));
        System.out.println(abc.topDown(new int[] {2,1,1,2}));
    }
}
