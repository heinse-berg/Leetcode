package com.leetcodecards.heap;

import java.util.TreeSet;

public class ContainsDupIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {

            if(set.size() == k+1)
                set.remove((long)nums[i-k-1]);

            Long floor = set.floor((long)nums[i]);
            if(floor != null && nums[i] - floor <= t)
                return true;

            Long ceil = set.ceiling((long)nums[i]);
            if(ceil != null && ceil - nums[i] <= t)
                return true;

            set.add((long)nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDupIII abc = new ContainsDupIII();
        System.out.println(abc.containsNearbyAlmostDuplicate(new int[] {1,5,9,1,5,9}, 2, 3));
        //[1,5,9,1,5,9]
        //2
        //3
    }
}
