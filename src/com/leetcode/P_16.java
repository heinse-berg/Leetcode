package com.leetcode;

import java.util.Arrays;

import static java.lang.Math.abs;

public class P_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 1, j = 2, k = 3, currSum = nums[0] + nums[1] + nums[2], currDiff, leastDiff = target - (currSum), ans = currSum;
        for(; k < nums.length; i++, j++, k++) {
            currSum = currSum - nums[i-1] + nums[k];
            currDiff = target - currSum;
            if(abs(currDiff) < leastDiff) {
                leastDiff = currDiff;
                ans = currSum;
            }
            else if(currDiff > leastDiff)
                break;
        }

        return ans;
    }

    public static void main(String[] args) {
        //enter code
        System.out.println(new P_16().threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
