package com.playground;

import java.util.*;

public class QuickSelect {

    public void quickSelect(int[] nums) {
        int len = nums.length, pivotIndex = 0, pivotElement = nums[len-1], left = 0, pivotElementIndex = len-1;
        while(left < pivotElementIndex) {
            if(nums[left] <= pivotElement) {
                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[left];
                nums[left] = temp;
                pivotIndex++;
            }
            left++;
        }
        int temp = nums[pivotElementIndex];
        nums[pivotElementIndex] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSelect abc = new QuickSelect();
        abc.quickSelect(new int[] {40,10,20,30,60,70,-10,100,20,30});
        System.out.println();
    }
}
