package com.leetcodecards.greedy;

import java.util.*;

public class MinOperationAlternate {

    public int minimumOperations(int[] nums) {
        if(nums.length == 1)
            return 0;

        HashMap<Integer, Integer> odd = new HashMap<>();
        HashMap<Integer, Integer> even = new HashMap<>();
        int i, n = nums.length, evenMax = -1, oddMax = -1, oddMaxNo = nums[1], evenMaxNo = nums[0], ans = 0;

        for(i = 0; i < n; i++) {
            if(i%2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0)+1);
                if(evenMax < even.get(nums[i])) {
                    evenMax = even.get(nums[i]);
                    evenMaxNo = nums[i];
                }
            }
            else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0)+1);
                if(oddMax < odd.get(nums[i])) {
                    oddMax = odd.get(nums[i]);
                    oddMaxNo = nums[i];
                }
            }
        }

        if(oddMaxNo != evenMaxNo) {
            if(n%2 != 0)
                ans += n/2 + 1 - oddMax;
            else
                ans += n/2 - oddMax;
            ans += n/2 - evenMax;
        }

        else {
            int secondOdd = Integer.MIN_VALUE, secondEven = Integer.MIN_VALUE;
            for(Map.Entry<Integer, Integer> entry : odd.entrySet()) {
                if(entry.getValue() < oddMax && entry.getValue() > secondOdd)
                    secondOdd = entry.getValue();
            }
            for(Map.Entry<Integer, Integer> entry : even.entrySet()) {
                if(entry.getValue() < evenMax && entry.getValue() > secondEven)
                    secondEven = entry.getValue();
            }
            if(oddMax + evenMax == n) {
                ans += Math.min(oddMax, evenMax);
            }
            else if(oddMax > evenMax) {
                if(n%2 != 0)
                    ans += n/2 + 1 - oddMax;
                else
                    ans += n/2 - oddMax;
                ans += n/2 - secondEven;
            }
            else if(oddMax < evenMax) {
                if(n%2 != 0)
                    ans += n/2 + 1 - secondOdd;
                else
                    ans += n/2 - secondOdd;
                ans += n/2 - evenMax;
            }
            else {
                if(secondEven >= secondOdd) {
                    if(n%2 != 0)
                        ans += n/2 + 1 - secondOdd;
                    else
                        ans += n/2 - secondOdd;
                    ans += n/2 - evenMax;
                }
                else {
                    if(n%2 != 0)
                        ans += n/2 + 1 - oddMax;
                    else
                        ans += n/2 - oddMax;
                    ans += n/2 - secondEven;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinOperationAlternate abc = new MinOperationAlternate();
        System.out.println();
    }
}
