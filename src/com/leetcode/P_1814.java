package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_1814 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i, res = 0, v, mod = (int)1e9 + 7;
        for(i = 0; i < nums.length; i++) {
            int rev = Integer.parseInt(new StringBuilder(String.valueOf(nums[i])).reverse().toString());
            v = map.getOrDefault(nums[i] - rev, 0);
            map.put(nums[i] - rev, v + 1);
            res = (res + v) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        //enter code
        int[] nums = {42, 86, 97};
        System.out.println(new P_1814().countNicePairs(nums));
    }
}
