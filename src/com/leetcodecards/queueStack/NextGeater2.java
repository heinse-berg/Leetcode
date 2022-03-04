package com.leetcodecards.queueStack;

import java.util.*;

public class NextGeater2 {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length, i = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for(; i < 2 * n; i++) {
            int num = nums[i%n];
            while(!stack.isEmpty() && num > nums[stack.peek()])
                ans[stack.pop()] = num;

            stack.push(i%n);
        }

        return ans;

    }

    public static void main(String[] args) {
        NextGeater2 abc = new NextGeater2();
        System.out.println(abc.nextGreaterElements(new int[] {10,20,30,60,40,20,30,20}));
    }
}
