package com.leetcodecards.two.sum;

import java.util.*;

public class FourSum2 {
    int ans = 0, n;
    int[] nums3, nums4;

    public void twoSum(int target) {
        int l = 0, r = n-1;
        while(l < n && r >= 0) {
            int sum = nums3[l] + nums4[r];
            if(sum == target) {
                ans++;
                l++; r--;
                while(l < n && nums3[l] == nums3[l-1]) {
                    l++;
                }
            }
            else if(sum < target)
                l++;
            else
                r--;
        }
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        n = nums1.length;
        this.nums3 = nums3; this.nums4 = nums4;

        Arrays.sort(nums1);  Arrays.sort(nums2);     Arrays.sort(nums3);    Arrays.sort(nums4);

        int i, j, k, l;
        for(i = 0; i < nums1.length; i++) {
            if(i == 0 || nums1[i] != nums1[i-1]) {
                for(j = 0; j < nums2.length; j++) {
                    if(j == 0 || nums2[j] != nums1[j-1]) {
                        twoSum(-(nums1[i] + nums2[j]));
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FourSum2 abc = new FourSum2();
        System.out.println();
    }
}
