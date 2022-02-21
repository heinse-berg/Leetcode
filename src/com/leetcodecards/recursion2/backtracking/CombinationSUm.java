package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class CombinationSUm {

    List<List<Integer>> res = new LinkedList<>();
    int[] c;
    int n;
    int currSum;

    public void backtrack(LinkedList<Integer> curr, int target, int first) {

        if(currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        else if(target < currSum)
            return;

        for(int i = first; i < n; i++) {
            curr.add(c[i]);
            currSum += c[i];
            backtrack(curr, target, i);
            currSum -= c[i];
            curr.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.c = candidates;
        n = candidates.length;
        backtrack(new LinkedList<>(), target, 0);
        return res;
    }

    public static void main(String[] args) {
        CombinationSUm abc = new CombinationSUm();
        System.out.println(abc.combinationSum(new int[]{2,3,6,7,5}, 7));
    }
}
