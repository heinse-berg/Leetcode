package com.leetcodecards.bin.search;

public class P_162 {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1, mid;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[high])
                low = mid;
            else if(nums[low] > nums[mid])
                high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        P_162 abc = new P_162();
        System.out.println(abc.findPeakElement(new int[] {1,2,3,5,6,4}));
    }
}
