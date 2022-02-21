package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MinCostClimbing {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length, i;
        int[] dp = new int[length+1];

        for(i = 2; i  <= length; i++) {
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }

        return dp[length];
    }

    int[] cost;
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int dp(int i) {
        if(i < 2)
            return 0;

        if(!memo.containsKey(i))
            memo.put(i, Math.min(dp(i-1) + cost[i-1], dp(i-2) + cost[i-2]));

        return memo.get(i);
    }

    public int minCostClimbingStairsTopDownDP(int[] cost) {
        this.cost = cost;
        return dp(cost.length);
    }

    public static void main(String[] args) {
        MinCostClimbing abc = new MinCostClimbing();
        System.out.println(abc.minCostClimbingStairsTopDownDP(new int[] {10, 15, 20}));
        System.out.println(abc.minCostClimbingStairs(new int[] {10, 15, 20}));
    }
}
