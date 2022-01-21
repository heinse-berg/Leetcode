package com.leetcodecards.arrayandstring;

import java.util.*;

public class RemDuplicatesSorted {

    public int removeDuplicates(int[] nums) {
        int left = 0, right=0, k = 0;
        while(right < nums.length) {
            while(right < nums.length && (nums[right] == nums[left])) right++;
            nums[left++] = nums[right-1];
            k++;
            if(left < nums.length && right < nums.length) nums[left] = nums[right];
        }
        return k;
    }

    public static void main(String[] args) {
        RemDuplicatesSorted abc = new RemDuplicatesSorted();
        System.out.println(abc.removeDuplicates(new int[] {1,1,2}));
    }
}
