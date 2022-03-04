package com.leetcodecards.arrays101;

import java.util.*;

public class NextLargerPermutation {

    public void rotate(int[] nums, int from, int n) {
        for(int i = from; i < n; i++) {

        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n-1;
        while(i > 0 && nums[i-1] >= nums[i])
            i--;
        if(i != 0)
            rotate(nums, i, n);
    }

    public static void main(String[] args) {
        NextLargerPermutation abc = new NextLargerPermutation();
        System.out.println();
    }
}
