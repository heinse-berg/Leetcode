package com.leetcodecards.arrays101;

import java.util.*;

public class ThirdMaxNumber {

    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for(int num : nums) {
            if(!(num == max1 || num == max2 || num == max3))
                if(num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                }
                else if(num > max2) {
                    max3 = max2;
                    max2 = num;
                }
                else if(num > max3) {
                    max3 = num;
                }
        }
        return (int)((max3 == Long.MIN_VALUE) ? (max1 == Long.MIN_VALUE ? (max2) : max1) : max3);
    }

    public static void main(String[] args) {
        ThirdMaxNumber abc = new ThirdMaxNumber();
        System.out.println(abc.thirdMax(new int[] {3,2,1}));
        System.out.println(abc.thirdMax(new int[] {3,2,1,1,2,3,4,4,5}));
        System.out.println(abc.thirdMax(new int[] {2,1,3,4,5}));
        System.out.println(abc.thirdMax(new int[] {1,2}));
    }
}
