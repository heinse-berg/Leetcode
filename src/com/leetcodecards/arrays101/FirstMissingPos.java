package com.leetcodecards.arrays101;

import java.util.*;

public class FirstMissingPos {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one = false;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1)
                one = true;
            if(nums[i] <= 0 || nums[i] >= n) {
                nums[i] = n+1;
            }

        }

        if(!one)
            return 1;

        for(int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if(a != n+1) {
                if(nums[a] > 0)
                    nums[a] = -nums[a];
            }

        }

        for(int i = 1; i < n; i++)
            if(nums[i] > 0)
                return i;

        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPos abc = new FirstMissingPos();
        System.out.println(abc.firstMissingPositive(new int[] {1,2,3,4,5,6,7,8}));
    }
}
