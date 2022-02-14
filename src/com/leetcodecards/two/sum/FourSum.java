package com.leetcodecards.two.sum;

import java.util.*;

public class FourSum {
    List<List<Integer>> ans = new LinkedList<>();
    int[] nums;
    int n;

    public void twoSum(int l, int r, int target, int i, int j) {
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum == target) {
                ans.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                while(l < n && nums[l] == nums[l-1]) {
                    l++;
                }
            }
            else if(sum < target)
                l++;
            else
                r--;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        n = nums.length;
        this.nums = nums;

        for(int i = 0; i < n; i++) {
            if(i == 0 || (nums[i] != nums[i-1])) {
                for(int j = i+1; j < n; j++) {
                    if(j == i+ 1 || nums[j] != nums[j-1]) {
                        twoSum(j+1, n-1, (target - nums[i] - nums[j]), i, j);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FourSum abc = new FourSum();
        System.out.println(abc.fourSum(new int[] {0,0,0,0,0}, 0));
    }//[1,0,-1,0,-2,2]
}
