package com.leetcodecards.hashing;

import java.util.*;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int i, len = nums.length;
        HashMap<Integer, Boolean> set = new HashMap<>();
        for(i = 0; i < len; i++) {
            if(set.get(nums[i]) != null && set.get(nums[i]))
                set.put(nums[i], false);
            set.put(nums[i], true);
        }
        for(Integer in : set.keySet())
            if(set.get(in))
                return in;
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber abc = new SingleNumber();
        System.out.println(abc.singleNumber(new int[] {4,1,2,1,2}));
    }
}
