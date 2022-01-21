package com.playground;

import java.util.*;

public class MaxSumSubarray {

    public int maxSumSubarray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for(int n : nums) {
            maxEndingHere += n;
            if(maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
            if(n < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSumSubarray abc = new MaxSumSubarray();
        System.out.println(abc.maxSumSubarray(new int[] {-60, -80, -40}));
    }
}
