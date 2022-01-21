package com.leetcodecards.arrays101;

import java.util.*;

public class SquaresOfSorted {
    static public int[] sortedSquares(int[] nums) {
        int midIndex = 0, negIndex, len = nums.length, i = 0;
        int[] res = new int[len];

        while (midIndex < len)
            if (nums[midIndex] < 0) {
                nums[midIndex] = -nums[midIndex];
                midIndex++;
            } else break;
        negIndex = midIndex-1;
        while (negIndex >= 0 && midIndex < len) {
            if (nums[negIndex] < nums[midIndex]) {
                res[i++] = nums[negIndex] * nums[negIndex];
                negIndex--;
            } else if (nums[negIndex] == nums[midIndex]) {
                res[i++] = nums[negIndex] * nums[negIndex];
                res[i++] = nums[negIndex] * nums[negIndex];
                negIndex--;
                midIndex++;
            } else {
                res[i++] = nums[midIndex] * nums[midIndex];
                midIndex++;
            }
        }
        while (negIndex >= 0) {
            res[i++] = nums[negIndex] * nums[negIndex];
            negIndex--;
        }
        while (midIndex < len) {
            res[i++] = nums[midIndex] * nums[midIndex];
            midIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] {0,3,10})));
    }
}
