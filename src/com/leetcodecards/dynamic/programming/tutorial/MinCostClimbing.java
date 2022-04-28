package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MinCostClimbing {
    int[] memo;

    public int dp(int[] cost, int i) {

        if(i <= 1)
            return 0;

        if(memo[i] != -1)
            return memo[i];

        return memo[i] = Math.min(dp(cost, i-1) + cost[i-1], dp(cost, i-2) + cost[i-2]);
    }

    public int minCostClimbingStairsTopDownDP(int[] cost) {

        int n = cost.length;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(cost, n);
    }

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n+1];

        for(int i = 2; i <= n; i++)
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);

        return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbing abc = new MinCostClimbing();
        System.out.println(abc.minCostClimbingStairsTopDownDP(new int[] {10, 15, 20}));
        System.out.println(abc.minCostClimbingStairs(new int[] {10, 15, 20}));
    }
}
