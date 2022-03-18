package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class CombinationSum2 {

    HashSet<List<Integer>> ans = new HashSet<>();
    int[] c;
    int target, n;

    public void back(int index, int currSum, LinkedList<Integer> curr) {

        if(currSum == target) {
            List<Integer> l = Arrays.asList(curr.toArray(new Integer[0]));
            Collections.sort(l);
            ans.add(l);
            return;
        }

        if(currSum > target)
            return;

        for(int i = index; i < n; i++) {
            curr.add(c[i]);
            back(i+1, currSum + c[i], curr);
            curr.removeLast();
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        c = candidates; this.target = target; n = c.length;
        back(0, 0, new LinkedList<>());

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        CombinationSum2 abc = new CombinationSum2();
        System.out.println(abc.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        //[10,1,2,7,6,1,5]
        //8
    }
}
