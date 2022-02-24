package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length, j;
        boolean[] dp = new boolean[n];

        dp[0] = nums[0] > 0;

        for(int i = 0; i < n-1; i++) {
            if(!dp[i])
                return false;
            if(nums[i] > 0) {
                for(j = i+1; j < n && j <= i + nums[i]; j++)
                    dp[j] = true;
                if(j == n)
                    return true;
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        JumpGame abc = new JumpGame();
        System.out.println(abc.canJump(new int[] {2,3,1,1,4}));
    }
}
