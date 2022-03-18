package com.leetcodecards.sliding.window;

import java.util.*;

public class NextGreater {

    public void swap(int i, int j, Integer[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int buildNums(Integer[] nums, int n) {

        int ans = 0;

        for(int num : nums) {

            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10))
                return -1;
            ans = ans*10 + num;
        }

        return ans < n ? -1 : ans;
    }

    public Integer[] splitNum(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        while(n > 0) {
            list.add(n%10);
            n = n/10;
        }

        Collections.reverse(list);
        return (list).toArray(new Integer[0]);
    }

    public int nextGreaterElement(int n) {
        Integer[] nums = splitNum(n);

        int len = nums.length, i = len-1;

        while(i > 0 && nums[i-1] >= nums[i])
            i--;

        if(i != 0) {
            int j = len-1;
            while(nums[j] <= nums[i-1])
                j--;

            swap(i-1, j, nums);
        }
        reverse(i, len, nums);

        return buildNums(nums, n);
    }

    public void reverse(int i, int len, Integer[] nums) {
        int j = len-1;
        while(i < j) {
            swap(i, j, nums);
            i++; j--;
        }
    }

    public static void main(String[] args) {
        NextGreater abc = new NextGreater();
        System.out.println(abc.nextGreaterElement(1));
    }
}
