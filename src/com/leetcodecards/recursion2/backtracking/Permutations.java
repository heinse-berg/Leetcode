package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class Permutations {
    LinkedList<List<Integer>> res = new LinkedList<>();
    int n;
    int[] nums;

    public void backtrack(LinkedList<Integer> curr, boolean[] visited) {
        if(res.size() == n) {
            res.addLast(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < n; i++) {

            if(!visited[i]) {
                visited[i] = true;
                curr.addLast(nums[i]);
                backtrack(curr, visited);
                curr.removeLast();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length; this.nums = nums;
        backtrack(new LinkedList<>(), new boolean[n]);
        return res;
    }

    public static void main(String[] args) {
        Permutations abc = new Permutations();
        System.out.println(abc.permute(new int[] {3,6,8,10}));
    }
}
