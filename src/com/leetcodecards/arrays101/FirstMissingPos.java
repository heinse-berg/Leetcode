package com.leetcodecards.arrays101;

import java.util.*;

public class FirstMissingPos {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] list = new int[n+1];
        System.arraycopy(nums, 0, list, 1, n);
        boolean one = false;

        for(int i = 1; i < n+1; i++) {
            if(list[i] <= 0 || list[i] >= n) {
                list[i] = n+1;
            }
            else if(list[i] == 1)
                one = true;
        }

        if(!one)
            return 1;

        for(int i = 1; i < n+1; i++) {
            int index = Math.abs(list[i]);

            if(index < n+1) {
                if(list[index] > 0)
                    list[index] = list[index] * -1;
            }
        }

        for(int i = 1; i < n+1; i++) {
            if(list[i] > 0)
                return i;
        }

        return 1;
    }

    public static void main(String[] args) {
        FirstMissingPos abc = new FirstMissingPos();
        System.out.println(abc.firstMissingPositive(new int[] {1,2,3,4,5,6,7,8}));
    }
}
