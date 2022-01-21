package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_1865 {

    static class FindSumPairs {
        int[] nums1; int[] nums2;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int value : nums1) map1.merge(value, 1, Integer::sum);
            for (int value : nums2) map2.merge(value, 1, Integer::sum);
        }

        public void add(int index, int val) {
            if(map2.get(nums2[index]) - 1 ==0)
                map2.remove(nums2[index]);
            else
                map2.merge(nums2[index], -1, Integer::sum);
            map2.merge(nums2[index] + val, 1, Integer::sum);
            nums2[index] += val;
        }

        public int count(int tot) {
            int ans = 0;

            for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                if(map2.get(tot - entry.getKey()) != null)
                    ans += (entry.getValue() * map2.get(tot - entry.getKey()));
            }

            return ans;
        }
    }

    /**
     * Your FindSumPairs object will be instantiated and called as such:
     * FindSumPairs obj = new FindSumPairs(nums1, nums2);
     * obj.add(index,val);
     * int param_2 = obj.count(tot);
     */

    public static void main(String[] args) {
        //enter code
        System.out.println();
    }
}
