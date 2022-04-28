package com.leetcodecards.heap;

import java.util.*;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> lower = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
        TreeSet<Integer> greater = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
        int n = nums.length;
        double[] ans= new double[n-k+1];

        for(int i = 0; i < n; i++) {
            greater.add(i);
            lower.add(greater.pollLast());

            if (lower.size() > greater.size())
                greater.add(lower.pollFirst());


            if(lower.size() + greater.size() == k) {
                ans[i-k+1] = k % 2 == 0 ? ((double) nums[lower.first()] + (double) nums[greater.first()]) / 2 :
                        (double) nums[greater.first()];

                lower.remove(i-k+1);
                greater.remove(i-k+1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMedian abc = new SlidingWindowMedian();
        System.out.println(Arrays.toString(abc.medianSlidingWindow(new int[]{11, 11}, 2)));
    }
}
