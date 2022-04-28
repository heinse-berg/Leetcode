package com.playground.oa.uber;

import java.util.*;

public class SE2Hyd {
    //https://leetcode.com/discuss/interview-experience/682096/Uber-or-SE-2-or-Hyderabad

    public int getPairs(int[] arr1, int[] arr2, int k) {

        TreeSet<Integer> set = new TreeSet<>();
        for(int num : arr1)
            set.add(num);

        for(int num : arr2)
            set.add(num);

        Integer[] arr = set.toArray(new Integer[0]);
        int ans = 0, left = 0, n = arr.length, right = n-1;

        while(left < right) {
            if (arr[left] + arr[right] <= k) {
                ans += right-left;
                left++;
            } else
                right--;
        }

        return ans;
    }

    public static void main(String[] args) {
        SE2Hyd abc = new SE2Hyd();
        System.out.println(abc.getPairs(new int[] {3, 4, 2, 6}, new int[] {3, 5, 7, 8}, 7));
    }
}
