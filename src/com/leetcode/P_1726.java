package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int v, res = 0, num;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                num = nums[i] * nums[j];
                v = map.getOrDefault(num, 0);
                res += v;
                map.put(num, v+1);
            }
        }
        return res*8;
    }

    public static void main(String[] args) {
        //enter code
        System.out.println(new P_1726().tupleSameProduct(new int[]{2,3,4,6,8,12}));
    }
}
