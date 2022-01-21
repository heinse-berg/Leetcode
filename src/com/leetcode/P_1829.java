package com.leetcode;

import java.util.Arrays;

public class P_1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int i, xor = 0, ans[] = new int[nums.length], limit = (int) Math.pow(2, maximumBit) - 1;
        for(i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            ans[nums.length - 1 - i] = xor ^ limit;
        }
        return ans;
    }

    public static void main(String[] args) {
        //enter code
        int[] arr = {0,1,1,3};
        System.out.println(Arrays.toString(new P_1829().getMaximumXor(arr, 2)));
    }
}
