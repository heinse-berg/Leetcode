package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class BuySellStockK {

    int[] prices;
    Integer[][][] memo;

    public int dp(int i, int rem, int holding) {
        if(i == prices.length || rem == 0)
            return 0;

        if(memo[i][rem][holding] != null)
            return memo[i][rem][holding];

        int ans;

        if(holding == 1) {
            ans = Math.max(dp(i+1, rem-1, 0) + prices[i],
                    dp(i+1, rem, holding));
        }

        else {
            ans = Math.max(dp(i+1, rem, 1) - prices[i],
                    dp(i+1, rem, holding));
        }

        return memo[i][rem][holding] = ans;
    }

    /*public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        memo = new Integer[prices.length][k+1][2];
        return dp(0, k, 0);
    }*/

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        int holding = 2;

        for(int i = n-1; i >= 0; i--) {
            for(int j = 1; j <= k; j++) {
                for(int h = 0; h < holding; h++) {
                    if(h == 0) {
                        dp[i][j][h] = Math.max(dp[i+1][j-1][0] + prices[i], dp[i+1][j][h]);
                    }
                    else {
                        dp[i][j][h] = Math.max(dp[i+1][j][1] - prices[i], dp[i+1][j][h]);
                    }
                }
            }
        }

        return dp[0][k][0];

    }

    public static void main(String[] args) {
        BuySellStockK abc = new BuySellStockK();
        System.out.println();
    }
}
