package com.playground;

import java.util.*;

public class CountStrictly {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int i = 1, len = nums.length-1, min = nums[0], max = nums[len], j = len-1;
        if(len < 2 || min == max)
            return 0;
        while(i <= len) {
            if(nums[i] > min)
                break;
            i++;
        }
        while(j >= 0) {
            if(nums[j] < max)
                break;
            j--;
        }
        return j-i+1;
    }

    public static void main(String[] args) {
        CountStrictly abc = new CountStrictly();
        System.out.println(abc.countElements(new int[] {-10000, 0, 10000}));
    }
}
