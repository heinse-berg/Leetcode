package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MaxScorePerformingK {

    private int[][] memo;
    private int[] nums, multipliers;
    private int n, m;

    private int dp(int i, int left) {
        if(i == m)
            return 0;

        int right = (n-1)-(i-left);

        if(memo[i][left] == 0) {
            memo[i][left] = Math.max(multipliers[i] * nums[left] + dp(i+1, left+1),
                    multipliers[i] * nums[right] + dp(i+1, left));
        }

        return memo[i][left];
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        this.n = nums.length; this.m = multipliers.length;
        this.memo = new int[m][m];
        this.nums = nums;
        this.multipliers = multipliers;
        return dp(0, 0);
    }

    public int bottomUpMaximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        int[][] dp = new int[m+1][m+1];
        int right;

        for(int i = m-1; i >= 0; i--) {
            for(int left = i; left >= 0 ; left--) {
                right = n-1 - (i-left);
                dp[i][left] = Math.max(multipliers[i] * nums[left] + dp[i + 1][left + 1],
                        multipliers[i] * nums[right] + dp[i + 1][left]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        MaxScorePerformingK abc = new MaxScorePerformingK();
        System.out.println(abc.maximumScore(new int[] {-5,8,-4,7,9}, new int[] {-7,6,4}));
    }
}
