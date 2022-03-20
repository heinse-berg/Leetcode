package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class CombinationSum4 {

    int ans = 0, n;

    public void backtrack(LinkedList<Integer> list, int currSum, int[] nums, int target, int index) {
        if(currSum == target) {
            ans++;
            System.out.println(list);
            return;
        }

        if(currSum > target)
            return;

        for(int i = index; i < n; i++) {
            list.addLast(nums[i]);
            currSum += nums[i];
            backtrack(list, currSum, nums, target, i);
            currSum -= nums[i];
            list.removeLast();
        }
    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        backtrack(new LinkedList<>(), 0, nums, target, 0);
        return ans;
    }

    public static void main(String[] args) {
        CombinationSum4 abc = new CombinationSum4();
        abc.combinationSum4(new int[] {1,2,3}, 4);
        System.out.println();
    }
}
