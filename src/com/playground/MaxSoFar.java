package com.playground;

import java.util.*;

public class MaxSoFar {

    static void maxsofar(int[] nums) {
        int i, len = nums.length, maxSoFar = Integer.MIN_VALUE, temp;
        for(i = len-2; i >= 0; i--) {
            temp = nums[i];
            if(nums[i+1] >= maxSoFar) {
                maxSoFar = nums[i+1];
            }
            nums[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, temp);
        }
        nums[len-1] = -1;
    }

    public static void main(String[] args) {
        MaxSoFar abc = new MaxSoFar();
        maxsofar(new int[] {17,18,5,4,6,1});
        System.out.println();
    }
}
