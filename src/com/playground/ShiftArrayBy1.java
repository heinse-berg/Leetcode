package com.playground;

import java.util.*;

public class ShiftArrayBy1 {

    public static void shift(int[] nums) {
        int i = nums.length-1, temp, temp1;
        for(; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        ShiftArrayBy1 abc = new ShiftArrayBy1();
        shift(new int[]{100,2,3,4,5,6,7,8,9,20,30,40});
    }
}
