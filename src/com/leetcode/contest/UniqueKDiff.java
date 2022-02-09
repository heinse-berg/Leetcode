package com.leetcode.contest;

import javafx.util.Pair;

import java.util.*;

public class UniqueKDiff {


    public int findPairs(int[] nums, int k) {

        HashMap<Integer, Integer> nos = new HashMap<>();
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();

        int ans = 0;
        for (int num : nums) {
            nos.put(num, nos.getOrDefault(num, 0) + 1);
            if(nos.get(num) == 2 && k == 0) {
                set.add(new Pair<>(num, num));
                ans++;
            }
        }

        if(k == 0)
            return ans;

        for (int num : nums) {
            Pair<Integer, Integer> p1 = new Pair<>(num, num - k);
            Pair<Integer, Integer> p2 = new Pair<>(num - k, num);
            Pair<Integer, Integer> p4 = new Pair<>(num, num + k);
            Pair<Integer, Integer> p3 = new Pair<>(num + k, num);

            if ( (nos.containsKey(num - k) && !(set.contains(p1))) || (nos.containsKey(num - k) && !set.contains(p2)) ) {
                ans++;
                set.add(p1);
                set.add(p2);
            }
            if ((nos.containsKey(num + k) && !(set.contains(p3)) || (nos.containsKey(num + k) && !set.contains(p4)) )) {
                ans++;
                set.add(p3);
                set.add(p4);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueKDiff abc = new UniqueKDiff();
        System.out.println(abc.findPairs(new int[] {1,1,1,1,1,1}, 0));
    }
}
