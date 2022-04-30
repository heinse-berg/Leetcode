package com.leetcodecards.recursion2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    LinkedList<List<Integer>> ans = new LinkedList<>();
    int[] nums;
    int n;

    public void backtrack(int index, LinkedList<Integer> curr) {

        ans.addLast(new ArrayList<>(curr));

        for(int i = index; i < n; i++) {
            curr.addLast(nums[i]);
            backtrack(i+1, curr);
            curr.removeLast();
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums; this.n = nums.length;
        backtrack(0, new LinkedList<>());
        return ans;
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
        System.out.println(abc.subsets(new int[] {0,1,2}));
    }
}
