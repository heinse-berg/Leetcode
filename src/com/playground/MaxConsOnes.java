package com.playground;

import java.util.*;

public class MaxConsOnes {

    public static int maxOnes(int[] nums) {
        int i = 0, j, len = nums.length, max = Integer.MIN_VALUE;
        while (i < len) {
            j = i;
            while(j < len && (nums[j] == 1)) {
                j++;
            }
            if(j == i)
                i++;
            else {
                if(j - i > max)
                    max = j-i;
                i = j;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        MaxConsOnes abc = new MaxConsOnes();
        System.out.println(maxOnes(new int[] {1,1,0,0,1,1,1,1,0,1,1,1}));
        System.out.println(maxOnes(new int[] {1,1,0,0,1,1,1,1,1,1,1}));
        System.out.println(maxOnes(new int[] {1}));
        System.out.println(maxOnes(new int[] {0}));
        System.out.println(maxOnes(new int[] {0,0,0,0}));
        System.out.println(maxOnes(new int[] {1,1,1,0,1,1,1}));
    }
}
