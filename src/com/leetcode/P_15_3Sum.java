package com.leetcode;

import java.util.*;

public class P_15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();

        Arrays.sort(nums);

        if((nums.length < 3) || nums[nums.length-1] < 0 || nums[0] > 0)
            return ans;

        else if(nums[0] == 0 && nums[nums.length-1] == 0)
            return Collections.singletonList(Arrays.asList(0, 0, 0));

        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                break;
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                }
                else if(currSum < 0)
                    j++;
                else
                    k--;
            }
        }

        ans.addAll(set);
        return ans;
    }

    public static void main(String[] args) {
        P_15_3Sum abc = new P_15_3Sum();
        System.out.println(abc.threeSum(new int[] {-5,-5,0,0,0,0,0,2,3,5,5}));
/*        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1,2,3));
        set.add(Arrays.asList(1,2,3));
        set.add(Arrays.asList(1,2,3));
        set.add(Arrays.asList(3,1,2));*/
        //System.out.println(set);
    }
}
