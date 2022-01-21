package com.leetcodecards.arrayandstring;

import java.util.*;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes abc = new MoveZeroes();
        abc.moveZeroes(new int[]{1,2,3,5,0,0,0,1,2,0,0,5,6,7,0,0});
        System.out.println();
    }
}
