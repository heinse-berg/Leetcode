package com.leetcodecards.two.sum;

import java.util.*;

public class ThreeSumCLosest {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0, diff = 10001;

        for(int i = 0; i < n; i++) {
            int l = i+1, r = n-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) {
                    return sum;
                }

                if(Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    ans = sum;
                }
                if(sum < target) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSumCLosest abc = new ThreeSumCLosest();
        System.out.println();
    }
}
