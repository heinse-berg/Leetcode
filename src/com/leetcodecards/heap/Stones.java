package com.leetcodecards.heap;

import java.util.*;

public class Stones {

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if(len == 1)
            return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int first, second;
        for(int i = 0; i < len; i++) {
            pq.add(stones[i]);
        }

        while(!pq.isEmpty() && pq.size() != 1) {
            first = pq.poll();
            second = pq.poll();
            if(first != second) {
                pq.add(first - second);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        Stones abc = new Stones();
        System.out.println(abc.lastStoneWeight(new int[] {2,2}));
    }
}
