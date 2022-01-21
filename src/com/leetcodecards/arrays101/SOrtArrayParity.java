package com.leetcodecards.arrays101;

import java.util.*;

public class SOrtArrayParity {

    public int[] sortArrayByParity(int[] nums) {
        int even = -1, odd = 0, len = nums.length, temp;
        for(odd = 0; odd < len; odd++) {
            if(nums[odd] % 2 == 0) {
                if(even < len-1) {
                    even++;
                    temp = nums[even];
                    nums[even] = nums[odd];
                    nums[odd] = nums[even];
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SOrtArrayParity abc = new SOrtArrayParity();
        System.out.println(Arrays.toString(abc.sortArrayByParity(new int[] {3,1,2,4})));
    }
}
