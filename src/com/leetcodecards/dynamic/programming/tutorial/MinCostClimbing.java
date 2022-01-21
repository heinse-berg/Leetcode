package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MinCostClimbing {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length, i;
        int[] dp = new int[length+1];
        dp[2] = Math.min(cost[0], cost[1]);

        for(i = 3; i  <= length; i++) {
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }

        return dp[length];
    }

    public static void main(String[] args) {
        MinCostClimbing abc = new MinCostClimbing();
        System.out.println(abc.minCostClimbingStairs(new int[] {10, 15, 20}));
    }
}
