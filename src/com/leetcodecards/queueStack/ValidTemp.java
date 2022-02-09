package com.leetcodecards.queueStack;

import java.util.*;

public class ValidTemp {

    public int[] dailyTemperatures(int[] t) {
        int n = t.length, j = 0;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int k : t) {
            while (!stack.isEmpty() && k > stack.peek()) {
                ans[j++] = stack.pop();
            }
            stack.push(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        ValidTemp abc = new ValidTemp();
        System.out.println();
    }
}
