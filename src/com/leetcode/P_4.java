package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> set = new ArrayList<>();
        Arrays.stream(nums1).forEach(set::add);
        Arrays.stream(nums2).forEach(set::add);
        Collections.sort(set);
        int length = set.size();
        if(length % 2 ==0) {
            return (double) (set.get(length/2-1) + set.get(length/2)) / 2;
        }
        else
            return set.get(length/2);
    }

    public static void main(String[] args) {
        //enter code
        int[] a = new int[]{1, 1};
        int[] b = new int[]{1,2};
        System.out.println(new P_4().findMedianSortedArrays(a, b));
    }
}
