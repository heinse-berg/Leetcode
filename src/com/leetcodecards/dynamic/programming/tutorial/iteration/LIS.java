package com.leetcodecards.dynamic.programming.tutorial.iteration;

import java.util.*;

public class LIS {

    int[] nums;
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
    }


    public static void main(String[] args) {
        LIS abc = new LIS();
        System.out.println(abc.lengthOfLIS(new int[] {4,10,4,3,8,9}));
    }
}
