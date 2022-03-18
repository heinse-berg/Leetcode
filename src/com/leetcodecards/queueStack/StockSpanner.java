package com.leetcodecards.queueStack;

import java.util.*;

class StockSpanner {

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int ans = 1;
        for (int a : stack) {
            if (price < a)
                break;
            ans++;
        }
        stack.addFirst(price);
        return ans;
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
