package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class Subsets {

    int n;
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public void combineUtil(int first, LinkedList<Integer> curr) {

        int i;
        for(i = first; i < n; i++) {
            curr.add(nums[i]);
            combineUtil(i+1, curr);
            curr.removeLast();
        }

        res.add(new LinkedList<>(curr));
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        LinkedList<Integer> curr = new LinkedList<>();
        combineUtil(0, curr);
        return res;
    }

    public static void main(String[] args) {
        Subsets abc = new Subsets();
        System.out.println(abc.subsets(new int[] {0,1,2,3,4}));
    }
}
