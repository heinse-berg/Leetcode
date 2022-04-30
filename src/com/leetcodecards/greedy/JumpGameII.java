package com.leetcodecards.greedy;

import java.util.*;

public class JumpGameII {

/*    public int dp(int[] nums, int i) {

        if(i >= n-1)
            return 0;

        if(memo[i] != null)
            return memo[i];

        int ans = 10001;

        for(int j = 1; j <= nums[i]; j++)
            ans = Math.min(ans, dp(nums, i+j)+1);

        return memo[i] = ans;

    }*/

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = n-2; i >= 0; i--) {
            int localMin = Integer.MAX_VALUE;
            for ( int j = nums[i]; j > 0 ; j-- ) {
                if ( i+j < nums.length )
                    localMin = Math.min( localMin, dp[j+i] + 1);

            }
            dp[i] = localMin;

        }

        return dp[0];
    }

    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        System.out.println(j.jump(new int[] {2,3,1,1,4}));
        System.out.println();
    }

}
