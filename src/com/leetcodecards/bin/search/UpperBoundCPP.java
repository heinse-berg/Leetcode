package com.leetcodecards.bin.search;

import java.util.*;

public class UpperBoundCPP {

    public int[] upperBound(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while(start < end) {
            mid = start + (end-start)/2;
            if(nums[mid] >= target)
                end = mid;
            else
                start = mid+1;
        }
        if(start == end && nums[start] >= target) {
            return new int[] {start, nums[start]};
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        UpperBoundCPP abc = new UpperBoundCPP();
        System.out.println(Arrays.toString(abc.upperBound(new int[]{5,10,40,50,70,80,100,120}, 39)));
    }
}
