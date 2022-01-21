package com.leetcodecards.arrayandstring;

import java.util.*;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int i, j, max = 0;
        for(i = 0; i < nums.length; i++) {
            for(j = i; j < nums.length; j++)
                if(nums[j] != 1)
                    break;
            if(i != j && j-i > max)
                max  = j-i;
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes abc = new MaxConsecutiveOnes();
        System.out.println(abc.findMaxConsecutiveOnes(new int[] {0,1,1,1,1,0,0,1,1,1,0}));
    }
}
