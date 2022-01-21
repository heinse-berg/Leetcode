package com.leetcodecards.arrayandstring;

import java.util.*;

public class MinSizeSubArray {

    public int minSubArrayLen(int target, int[] nums) {
        int i, len = nums.length, ans = Integer.MAX_VALUE, sum = 0, left = 0;
        for(i = 0; i < len; i++) {
            sum += nums[i];
            while(sum >= target) {
                ans = Math.min(ans, i-left+1);
                sum -= nums[left++];
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public static void main(String[] args) {
        MinSizeSubArray abc = new MinSizeSubArray();
        System.out.println(abc.minSubArrayLen(11, new int[] {1,2,3,4,5}));
    }
}
