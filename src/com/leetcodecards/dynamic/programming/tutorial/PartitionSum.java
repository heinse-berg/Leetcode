package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class PartitionSum {

    int n, sum = 0, halfSum;

    public boolean backtrack(int currSum, int index, int[] nums) {

        if(index == n)
            return false;

        if(currSum > halfSum)
            return false;

        for(int i = index; i < n; i++) {
            currSum += nums[i];
            if(currSum == halfSum)
                return true;
            if(backtrack(currSum, i+1, nums))
                return true;
            currSum -= nums[i];
        }

        return false;
    }

    public boolean canPartition(int[] nums) {

        n = nums.length;

        for(int num : nums)
            sum += num;
        halfSum = sum/2;

        if(sum % 2 != 0)
            return false;

        return backtrack(0, 0, nums);
    }

    public static void main(String[] args) {
        System.out.println(new PartitionSum().canPartition(new int[] {14,9,8,4,3,2}));
        //[14,9,8,4,3,2]
    }

}
