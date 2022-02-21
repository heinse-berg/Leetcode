package com.leetcodecards.arrays101;

import java.util.*;

public class MaxConsZeros {

    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, n = nums.length, firstZ = 0, secondZ = 0, numsZ = 0, max = -1;
        for(; i < n; i++) {
            if(nums[i] == 0)
                numsZ++;
            if(nums[i] == 0 && numsZ == 1)
                secondZ = i;
            else if(numsZ == 2) {
                max = Math.max(max, i-firstZ);
                firstZ = secondZ;
                secondZ = i;
                numsZ--;
            }
        }

        if(firstZ != 0)
            i = i-1;

        max = Math.max(max, i-firstZ);
        return max;
    }

    public static void main(String[] args) {
        MaxConsZeros abc = new MaxConsZeros();
        /*System.out.println(abc.findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));
        System.out.println(abc.findMaxConsecutiveOnes(new int[] {1,0,1,1,1}));
        System.out.println(abc.findMaxConsecutiveOnes(new int[] {1,1,1,1,1}));*/
        //System.out.println(abc.findMaxConsecutiveOnes(new int[] {1,1,1,0,1,1,0,1,1,1,1,1}));
        //System.out.println(abc.findMaxConsecutiveOnes(new int[] {1,1,1,1,1,1,0,1,1,1,1,1}));
        System.out.println(abc.findMaxConsecutiveOnes(new int[] {1,1,0,1}));
        System.out.println(abc.findMaxConsecutiveOnes(new int[] {0,0,0,0,0}));
    }
}
