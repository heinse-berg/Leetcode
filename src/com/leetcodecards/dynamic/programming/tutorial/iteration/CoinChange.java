package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class CoinChange {

    Integer[] memo;

    public int helper(int[] coins, int remain) {
        if (remain < 0)
            return -1;
        if (remain == 0)
            return 0;

        if (memo[remain] != null)
            return memo[remain];

        int minCoins = Integer.MAX_VALUE, count;

        for (int coin : coins) {
            count = helper(coins, remain - coin);
            if (count != -1)
                minCoins = Math.min(count + 1, minCoins);
        }

        memo[remain] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        return memo[remain];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange abc = new CoinChange();
        System.out.println(abc.coinChange(new int[]{1, 2, 5}, 11));
    }
}