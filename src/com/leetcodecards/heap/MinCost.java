package com.leetcodecards.heap;

import java.util.*;

public class MinCost {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks)
            pq.add(stick);
        int cost = 0, first, second;
        while(pq.size() > 1) {
            first = pq.poll();
            second = pq.poll();
            cost += first + second;
            pq.add(first + second);
        }
        return cost;
    }

    public static void main(String[] args) {
        MinCost abc = new MinCost();
        System.out.println(abc.connectSticks(new int[] {1,8,3,5}));
    }
}
