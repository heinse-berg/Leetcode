package com.leetcodecards.bin.binsearchtree;

public class ContainsDup {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i,j,len = nums.length,ct;
        for(i = 0; i < len-1; i++) {
            for(j = i+1; j < len && j <= i+k; j++) {
                if(Math.abs(nums[i] - nums[j]) <= t)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDup abc = new ContainsDup();
        System.out.println(abc.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1));
    }
}
