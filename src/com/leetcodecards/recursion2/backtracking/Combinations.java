package com.leetcodecards.recursion2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    int n, k;
    List<List<Integer>> res = new ArrayList<>();

    public void combineUtil(int first, LinkedList<Integer> curr) {
        if(curr.size() == k) {
            res.add(new LinkedList<>(curr));
        }

        for(int i = first; i < n+1; i++) {
            curr.add(i);
            combineUtil(i+1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n; this.k = k;
        LinkedList<Integer> curr = new LinkedList<>();
        combineUtil(1, curr);
        return res;
    }

    public static void main(String[] args) {
        Combinations abc = new Combinations();
        System.out.println(abc.combine(5, 3));
    }
}
