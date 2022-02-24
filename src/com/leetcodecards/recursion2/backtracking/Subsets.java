package com.leetcodecards.recursion2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    int n;
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public void combineUtil(int first, LinkedList<Integer> curr) {

        res.add(new LinkedList<>(curr));

        int i;
        for(i = first; i < n; i++) {
            curr.add(nums[i]);
            combineUtil(i+1, curr);
            curr.removeLast();
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        LinkedList<Integer> curr = new LinkedList<>();
        combineUtil(0, curr);
        return res;
    }

    LinkedList<List<Character>> substrings = new LinkedList<>();
    int sLength;

    public void backtrack(LinkedList<Character> curr, int first, char[] array) {
        substrings.add(new LinkedList<>(curr));

        for(int i = first; i < sLength; i++) {
            curr.add(array[i]);
            backtrack(curr, i+1, array);
            curr.removeLast();
        }
    }

    public List<List<Character>> subsets(String s) {
        sLength = s.length();
        backtrack(new LinkedList<>(), 0, s.toCharArray());
        return substrings;
    }

    public static void main(String[] args) {
        Subsets abc = new Subsets();
        System.out.println(abc.subsets("abc"));
    }
}
