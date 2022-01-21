package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        int ans = 0, prev = 0;
        for (int num : map.keySet()) {
            if(!map.containsKey(num-1)) {
                ans += num;
                prev = num;
            } else {

            }
        }
        return 1;
    }

    public static void main(String[] args) {
        DeleteEarn abc = new DeleteEarn();
        System.out.println(abc.deleteAndEarn(new int[]{5,5,10,10,11,20,22}));
    }
}
