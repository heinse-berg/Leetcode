package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class LongestIncreasingSubsequence {
    int[] nums; int n;

    private int helper(int i, int prevLargest) {
        if(i == n) return 0;
        int dontTake = helper(i+1, prevLargest), take = 0;
        if(nums[i] > prevLargest)
            take = (1+helper(i+1, nums[i]));
        return Math.max(take, dontTake);
    }


    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        n = nums.length;
        return helper(0, Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence abc = new LongestIncreasingSubsequence();
        System.out.println(abc.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}
