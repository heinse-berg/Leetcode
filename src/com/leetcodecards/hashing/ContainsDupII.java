package com.leetcodecards.hashing;

import java.util.*;

public class ContainsDupII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right, len = nums.length, temp;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(left < len) {
            map.put(nums[left], left);
            right = left+1;
            while(right < len && right <= left + k) {
                temp = nums[right];
                if(map.containsKey(temp) && map.get(temp) > left)
                    return true;
                else
                    map.put(temp, right);
                right++;
            }
            left++;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDupII abc = new ContainsDupII();
        System.out.println(abc.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
//[1,2,3,1,2,3]
//2
