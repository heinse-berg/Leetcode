package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class P_977 {

    public int[] sortedSquares(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> l = new LinkedList<>();
        int i, n = nums.length;
        for(i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            set.add(a);
        }
        return l.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P_977().sortedSquares(new int[] {})));
    }
}