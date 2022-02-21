package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, i = 2, temp;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            set.add(num);
        }

        int[] dp = new int[set.size()];

        int first = (set.first());
        set.remove(first);
        int second = (set.first());
        set.remove(second);

        dp[0] = first * map.get(first);
        temp = second * map.get(second);
        dp[1] = second == first + 1 ? Math.max(dp[0], temp) : dp[0] + temp;

        while(!set.isEmpty()) {
            int num = set.first();
            temp = num * map.get(num);
            if(num == second+1)
                dp[i] = Math.max(dp[i-1], temp + dp[i-2]);
            else
                dp[i] = dp[i-1] + temp;
            second = num;
            set.remove(num);
            i++;
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        DeleteEarn abc = new DeleteEarn();
        System.out.println(abc.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
