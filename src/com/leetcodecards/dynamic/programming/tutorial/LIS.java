package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class LIS {

    int n;
    Integer[][] memo;

    public int dp(int[] nums, int i, int prev) {

        if(i == n)
            return 0;

        if(memo[i][prev+1] != null)
            return memo[i][prev+1];

        int ans = 0;

        if(prev == -1 || nums[i] > nums[prev])
            ans = Math.max(ans, 1 + dp(nums, i+1, i));

        ans = Math.max(ans, dp(nums, i+1, prev));

        return memo[i][prev+1] = ans;

    }

    public int lengthOfLIS(int[] nums) {

        n = nums.length;
        memo = new Integer[n][n+1];
        return dp(nums, 0, -1);
    }

    public static void main(String[] args) {
        LIS a = new LIS();
        System.out.println(a.lengthOfLIS(new int[] {0,1,0,3,2,3}));
    }
}
