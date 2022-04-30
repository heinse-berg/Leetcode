package com.leetcodecards.dynamic.programming.tutorial;

public class BuySellWithCooldown {
    int n;
    int[] prices;
    Integer[][][] memo;

    public int dp(int i, int holding, int soldOnPrev) {

        if(i == n)
            return 0;

        int ans;

        if(memo[i][holding][soldOnPrev] != null)
            return memo[i][holding][soldOnPrev];

        if(soldOnPrev == 0)
            if(holding == 0)
                ans = Math.max(-prices[i] + dp(i+1, 1,0), dp(i+1, 0, 0));
            else //holding = true
                ans = Math.max(prices[i] + dp(i+1, 0, 1), dp(i+1, 1, 0));

        else
            ans = dp(i+1, holding, 0);

        return memo[i][holding][soldOnPrev] = ans;

    }

    public int maxProfit(int[] prices) {

        n = prices.length;
        this.prices = prices;
        this.memo = new Integer[n][2][2];
        return dp(0, 0, 0);
    }

}
