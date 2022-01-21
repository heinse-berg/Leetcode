package com.leetcodecards.arrays101;

import java.util.*;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, i = 0;
        int[] arr = new int[m+n];
        while(p1 < m && p2 < n) {
            if(nums1[p1] < nums2[p2])
                arr[i++] = nums1[p1++];
            else
                arr[i++] = nums2[p2++];
        }
        if(p1 == m && p2 != n)
            while(p2 < n)
                arr[i++] = nums2[p2++];
        else if(p2 == n && p1 != m)
            while(p1 < m)
                arr[i++] = nums1[p1++];
        for(; i < m+n;)
            nums1[p1++] = arr[i++];
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeSortedArrays abc = new MergeSortedArrays();
        /*
       [-1,0,0,3,3,3,0,0,0]
6
[1,2,2]
3
         */
        abc.merge(new int[] {-1,0,0,3,3,3,0,0,0}, 6, new int[] {1,2,2}, 3);
        System.out.println();
    }
}
