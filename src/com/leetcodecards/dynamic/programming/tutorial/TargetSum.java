package com.leetcodecards.dynamic.programming.tutorial;

import javafx.util.Pair;

import java.util.HashMap;

public class TargetSum {

    int n;
    HashMap<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

    public int dp(int[] nums, int target, int from) {

        if(0 == target && from == n)
            return 1;

        if(from >= n)
            return 0;

        Pair<Integer, Integer> pair = new Pair<>(from, target);

        if(memo.containsKey(pair))
            return memo.get(pair);

        memo.put(pair, dp(nums, target-nums[from], from+1) + dp(nums, target+nums[from], from+1));
        return memo.get(pair);
    }

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return dp(nums, target, 0);
    }

    public static void main(String[] args) {
        TargetSum abc = new TargetSum();
        System.out.println(abc.findTargetSumWays(new int[] {1,1,1,1,1}, 3));
    }
}
