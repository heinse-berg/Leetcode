package com.leetcodecards.arrays101;

import java.util.*;

class NumArray {
    int[] left, right, nums;
    int n;

    public NumArray(int[] nums) {
        this.nums= nums;
        n = nums.length;
        left = new int[n];
        right = new int[n];

        int j = n-2;
        left[0] = nums[0]; right[n-1] = nums[n-1];
        for(int i = 1; i < n-2; i++, j--) {
            left[i] = left[i-1] + nums[i];
            right[j] = right[j+1] + nums[j];
        }

        if(n >= 2) {
            left[n-1] = left[n-2] + nums[n-1];
            right[0] = right[1] + nums[0];
        }

    }

    public int sumRange(int lef, int righ) {
        int l = lef > 0 ? left[lef-1] : 0;
        int r = righ < n-1 ? right[righ+1] : 0;

        return right[0] - l - r;
    }

    public static void main(String[] args) {
        NumArray a= new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(a.sumRange(0, 2));
    }
}