package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class LIS {

/*    int[] nums;
    int n;
    Integer[] memo;

    public int dp(int i) {

        int ans = 0;

        if(memo[i] != null)
            return memo[i];

        for(int j = i; j < n-1; j++) {
            if(nums[j] < nums[j+1]) {
                int count = dp(j+1)+1;
                ans = Math.max(ans, count);
            }
        }

        return memo[i] = ans;
    }

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        n = nums.length;
        memo = new Integer[n+1];

        return dp(0)+1;
    }*/

    public int lengthOfLIS(int[] nums) {

        int n = nums.length, max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LIS abc = new LIS();
        System.out.println(abc.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }
}
