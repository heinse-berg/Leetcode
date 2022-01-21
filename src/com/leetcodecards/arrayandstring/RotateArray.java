package com.leetcodecards.arrayandstring;

import java.util.*;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%(nums.length);
        if(k == 0) return;
        int i=0, j = nums.length-k;
        int[] copy = nums.clone();
        for(; i < k; i++,j++) nums[i] = copy[j];
        for(; i < nums.length;i++) nums[i] = copy[(i-k)];
    }

    public static void main(String[] args) {
        RotateArray abc = new RotateArray();
        System.out.println();
        abc.rotate(new int[] {1,2,3,4}, 2);
    }
}
