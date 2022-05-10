package com.leetcodecards.bin.search;

import java.util.*;

public class P_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, left = 0, right = n-k;
        LinkedList<Integer> res = new LinkedList<>();

        while(left < right) {
            int mid = left + (right-left)/2;
            if(x-arr[left] <= arr[right]-x)
                right = mid-1;
            else
                left = mid+1;
        }

        while(--k > 0)
            res.addLast(left++);

        return res;
    }

    public static void main(String[] args) {
        P_658 abc = new P_658();
        System.out.println(abc.findClosestElements(new int[]{1, 1,1,10,10,10},1,9));
    }
}
