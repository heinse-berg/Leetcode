package com.leetcodecards.bin.search.practice;

import java.util.*;

public class Peak {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1, mid;

        while(l < r) {
            mid = l + (r - l)/2;
            if(nums.length - 1 < mid+1)
                break;
            else if(nums[mid] > nums[mid+1])
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        Peak abc = new Peak();
        System.out.println(abc.findPeakElement(new int[] {1,2,3}));
        System.out.println(abc.findPeakElement(new int[] {1,2,3,4,5}));
        System.out.println(abc.findPeakElement(new int[] {4,3,2,1}));
        System.out.println(abc.findPeakElement(new int[] {4,3,2,1,0}));
        System.out.println(abc.findPeakElement(new int[] {4,3,2,1,0}));
        System.out.println(abc.findPeakElement(new int[] {1,2,3,1,2,3,4,5,6,7,4,3}));
        System.out.println(abc.findPeakElement(new int[] {2,1}));
        System.out.println(abc.findPeakElement(new int[] {0,1}));
    }
}
